package member.ticketing.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.ChargeVO;
import common.vo.CinemaVO;
import common.vo.SeatVO;
import common.vo.TheaterVO;
import common.vo.TicketingShowVO;
import common.vo.TicketingVO;


/**
 * Service객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 받아온 자료를 Controller에게 보내주는 역할을 수행한다.
 * 보통 Dao의 메서드와 같은 구조를 갖는다.
 */
public interface ITicketingService {
	
	/**
	 * 전체 회원 목록을 조회하기 위한 메서드
	 * @return - 전체 회원 목록
	 */
	public List<TicketingVO> getTicketingInfoList(TicketingVO tkVO);
	
	public List<SeatVO> retrieveSeatList(String theaterCd);
	
	public TheaterVO retrieveTheater(String theaterCd);
	
	public Map<String, Object> setTicketingMain();
	
	public List<TicketingShowVO> retrieveTicketingShow(TicketingShowVO param);
	
	public int retrievePrice(ChargeVO chargeVO);
	
	public int createTicketing(Map<String, Object> ticketingInfo);
	
}