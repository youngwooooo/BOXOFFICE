package member.ticketing.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.ChargeVO;
import common.vo.CinemaVO;
import common.vo.MovieVO;
import common.vo.SeatVO;
import common.vo.ShowTimetableVO;
import common.vo.TheaterVO;
import common.vo.TicketingShowVO;
import common.vo.TicketingVO;
import common.vo.PaymentVO;
import member.ticketing.dao.ITicketingDao;
import member.ticketing.dao.ticketingDaoImpl;
import util.SqlMapClientFactory;

public class ticketingServiceImpl implements ITicketingService{
	
	private SqlMapClient smc;  // SqlMapClient객체 변수 선언(iBatis)
	
	// Dao객체 생성
	private ITicketingDao ticketingDao;
	
	// 싱글톤 패턴 만들기
	private static ITicketingService ticketingService;  // 자신을 담을 객체 선언(private static 인터페이스타입)
	
	
	private ticketingServiceImpl() {  // private 생성자 생성
		ticketingDao = ticketingDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();  // 생성자에 SqlMapClient객체 생성(iBatis)
	}
	
	public static ITicketingService getInstance() {  // 다른 곳에서 사용하기 위한 메서드 생성(public static 인터페이스)
		if(ticketingService == null) {
			ticketingService = new ticketingServiceImpl();  // 없다면 객체 생성
		}
		
		return ticketingService;  // 있다면 객체 리턴
	}

	@Override
	public List<TicketingVO> getTicketingInfoList(TicketingVO tkVO) {
		List<TicketingVO> ticketingInfoList = new ArrayList<TicketingVO>();
		
		try {
			ticketingInfoList = ticketingDao.getTicketingInfoList(smc, tkVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ticketingInfoList;
	}

	
	@Override
	public List<SeatVO> retrieveSeatList(String theaterCd) {
		List<SeatVO> seatList = new ArrayList<>();

		try {
			seatList = ticketingDao.retrieveSeatList(smc, theaterCd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seatList;
	}

	@Override
	public TheaterVO retrieveTheater(String theaterCd) {
		TheaterVO theaterVO = null;

		try {
			theaterVO = ticketingDao.retrieveTheater(smc, theaterCd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return theaterVO;
	}

	@Override
	public Map<String, Object> setTicketingMain() {
		Map<String, Object> mapForSetMain = new HashMap<>();
		
		try {
			List<MovieVO> movieList = ticketingDao.retrieveMovieList(smc);
			List<CinemaVO> cinemaList = ticketingDao.retrieveCinemaList(smc);
			
			mapForSetMain.put("movieList", movieList);
			mapForSetMain.put("cinemaList", cinemaList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mapForSetMain;
	}

	@Override
	public List<TicketingShowVO> retrieveTicketingShow(TicketingShowVO param) {
		List<TicketingShowVO> showList = new ArrayList<>();
		
		try {
			showList = ticketingDao.retrieveTicketingShow(smc, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return showList;
	}

	@Override
	public int retrievePrice(ChargeVO chargeVO) {
		int price = 0;
		
		try {
			price = ticketingDao.retrievePrice(smc, chargeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return price;
	}

	@Override
	public int createTicketing(Map<String, Object> ticketingInfo) {
		
		int cnt = 0;
		
		//1. 결제 테이블 데이터 추가
		String memCd = (String)ticketingInfo.get("memCd");
		String payCd = "";
		int maxPaymentCd = 0;
		
		try {
			//결제 코드 최댓값 조회
			maxPaymentCd = ticketingDao.retrieveMaxPaymentCode(smc) + 1;
			payCd = "PM";
			
			for(int i=0 ; i < 8-String.valueOf(maxPaymentCd).length(); i++) {
				payCd += "0";
			}
			payCd += String.valueOf(maxPaymentCd);
			
			Map<String, Object> paymentInfo = new HashMap<>();
			paymentInfo.put("memCd", memCd);
			paymentInfo.put("payCd", payCd);
			
			//결제 테이블에 데이터 1행 추가
			cnt = ticketingDao.createPayment(smc, paymentInfo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//2. 티켓 테이블 데이터 추가
		String showCd = (String)ticketingInfo.get("showCd");
		String totalPrice = (String)ticketingInfo.get("totalPrice");
				
		String ticketCd = "";
		int maxTicketCd = 0;
		
		try {
			//티켓 코드 최댓값 조회
			maxTicketCd = ticketingDao.retrieveMaxTicketCode(smc) + 1;
			ticketCd = "T";
			
			for(int i=0 ; i < 6-String.valueOf(maxTicketCd).length(); i++) {
				ticketCd += "0";
			}
			ticketCd += String.valueOf(maxTicketCd);
			
			Map<String, Object> ticketInfo = new HashMap<>();
			ticketInfo.put("ticketCd", ticketCd);
			ticketInfo.put("showCd", showCd);
			ticketInfo.put("payCd", payCd);
			ticketInfo.put("totalPrice", totalPrice);
			
			//티켓 테이블에 데이터 1행 추가
			cnt = ticketingDao.createTicket(smc, ticketInfo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. 티켓 상세 테이블 데이터 추가
		//좌석 테이블 SEAT_CD 컬럼 조회에 필요한 값
		String seatCd = (String)ticketingInfo.get("seatCd");
		String seatNo = (String)ticketingInfo.get("seatNo");
		String theaterCd = (String)ticketingInfo.get("theaterCd");
		//티켓 상세 테이블에 추가할 값
		String audienceTypeCd = (String)ticketingInfo.get("audienceTypeCd");
		String totalPriceStr = (String)ticketingInfo.get("totalPriceStr");
				
		try {
			
			//1. 좌석 번호(A01) 파싱
			//2. 좌석 유형(열) 파싱
			//3. 관객 유형 파싱
			//4. 티켓 가격 파싱
			String[] seatCdArr = seatCd.split(",");
			String[] seatNoArr = seatNo.split(",");
			String[] audienceTypeCdArr = audienceTypeCd.split(",");
			String[] totalPriceStrArr = totalPriceStr.split(",");
			
			String retrieveAllPaySeatList = "";
			
			for(int i=0; i<seatCdArr.length; i++) {
				if(i>0) {
					retrieveAllPaySeatList += " UNION ";
				}
				retrieveAllPaySeatList += " SELECT SEAT_CD seatCd FROM TB_SEAT "
										+ "  WHERE THEATER_CD = '" + theaterCd + "'"
										+ "    AND SEAT_NO = '" + seatCdArr[i].trim()+ "'"
										+ "    AND SEAT_TYPE_CD = '" + seatNoArr[i].trim() + "'"
										;
			}

			//좌석 테이블의 좌석 코드 받아오기
			List<SeatVO> paySeatList = ticketingDao.retrieveAllPaySeatList(smc, retrieveAllPaySeatList);
			
			String[] paySeatArr;
			paySeatArr = new String[paySeatList.size()];
			
			for(int i=0; i<paySeatList.size(); i++) {
				paySeatArr[i] = paySeatList.get(i).getSeatCd();
			}

			String sql = "INSERT INTO TB_TICKET_DETAIL (TICKET_CD, SEAT_CD, AUDIENCE_TYPE_CD, TICKET_PRICE)";
			
			for(int i=0; i<paySeatArr.length; i++) {
				if(i>0) {
					sql += "UNION ALL ";
				}
				sql += " SELECT '" + ticketCd + "', '" + paySeatArr[i].trim() + "', '" + audienceTypeCdArr[i].trim() + "', '" + totalPriceStrArr[i].trim() + "' FROM DUAL ";
			}
			
			//티켓 상세 전부 등록
			cnt = ticketingDao.createTicketAll(smc, sql);
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return cnt;
	}


}
