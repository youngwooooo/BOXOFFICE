package member.ticketing.dao;

import java.sql.SQLException;
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


public class ticketingDaoImpl implements ITicketingDao {
	
	// 싱글톤 패턴 만들기
	private static ITicketingDao ticketingDao;  // 자신을 담을 객체 선언(private static 인터페이스타입)
	
	private ticketingDaoImpl() {}  // private 생성자 생성
	
	public static ITicketingDao getInstance() {  // 다른 곳에서 사용하기 위한 메서드 생성(public static 인터페이스)
		if(ticketingDao == null) {
			ticketingDao = new ticketingDaoImpl();  // 없으면 객체 생성
		}
		
		return ticketingDao;  // 있으면 객체 리턴
	}
	

	@Override
	public List<TicketingVO> getTicketingInfoList(SqlMapClient smc, TicketingVO tkVO) throws SQLException {
		
		List<TicketingVO> ticketingInfoList = smc.queryForList("ticketing.getTicketingInfoList", tkVO);
		
		return ticketingInfoList;
	}

	@Override
	public List<SeatVO> retrieveSeatList(SqlMapClient smc, String theaterCd) throws SQLException {
		return smc.queryForList("ticketing.retrieveSeatList", theaterCd);
	}
	
	@Override
	public TheaterVO retrieveTheater(SqlMapClient smc, String theaterCd) throws SQLException {
		return (TheaterVO)smc.queryForObject("ticketing.retrieveTheater", theaterCd);
	}

	@Override
	public List<MovieVO> retrieveMovieList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("ticketing.retrieveMovieList");
	}

	@Override
	public List<CinemaVO> retrieveCinemaList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("ticketing.retrieveCinemaList");
	}

	@Override
	public List<TicketingShowVO> retrieveTicketingShow(SqlMapClient smc, TicketingShowVO param) throws SQLException {
		return smc.queryForList("ticketing.retrieveTicketingShow", param);
	}

	@Override
	public int retrievePrice(SqlMapClient smc, ChargeVO chargeVO) throws SQLException {
		return (int)smc.queryForObject("ticketing.retrievePrice", chargeVO);
	}

	@Override
	public int retrieveMaxPaymentCode(SqlMapClient smc) throws SQLException {
		return (int)smc.queryForObject("ticketing.retrieveMaxPaymentCode");
	}

	@Override
	public int createPayment(SqlMapClient smc, Map<String, Object> paymentInfo) throws SQLException {
		if(smc.insert("ticketing.createPayment", paymentInfo) == null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int retrieveMaxTicketCode(SqlMapClient smc) throws SQLException {
		return (int)smc.queryForObject("ticketing.retrieveMaxTicketCode");
	}

	@Override
	public int createTicket(SqlMapClient smc, Map<String, Object> ticketInfo) throws SQLException {
		if(smc.insert("ticketing.createTicket", ticketInfo) == null) {
			return 1;
		}
		return 0;
	}

	
//	@Override
//	public int createTicketDetail(SqlMapClient smc, Map<String, Object> ticketDetailInfo) throws SQLException {
////		if(smc.insert("ticketing.createDetailTicket", ticketDetailInfo) == null) {
////			return 1;
////		}
//		return 0;
//	}
	
	
	@Override
	public List<SeatVO> retrieveAllPaySeatList(SqlMapClient smc, String retrieveAllPaySeatList) throws SQLException {
		return smc.queryForList("ticketing.retrieveAllPaySeatList", retrieveAllPaySeatList);
	}
	
	
	@Override
	public int createTicketAll(SqlMapClient smc, String sql) throws SQLException {
		return smc.insert("ticketing.createTicketAll", sql) == null ? 1 : 0;
	}
	
	

	
}
