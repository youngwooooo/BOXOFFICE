package member.ticketing.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.ChargeVO;
import common.vo.CinemaVO;
import common.vo.MovieVO;
import common.vo.SeatVO;
import common.vo.TheaterVO;
import common.vo.TicketingShowVO;
import common.vo.TicketingVO;


/**
	실제 DB와 연결해서 SQL문을 수행한 결과를 작성하여 Service에 전달하는 DAO의 Interface
 */
public interface ITicketingDao {
	
	/**
	 * DB의 MYMEMBER테이블 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param smc - SqlMapClient 객체
	 * @param pagingVO - 페이지 정보를 담고있는 객체
	 * @return MemberVO객체를 담고 있는 List객체
	 * @throws SQLException - JDBC관련 예외 객체
	 */
	public List<TicketingVO> getTicketingInfoList(SqlMapClient smc, TicketingVO tkVO) throws SQLException;	
	
	public List<SeatVO> retrieveSeatList(SqlMapClient smc, String theaterCd) throws SQLException;
	
	public TheaterVO retrieveTheater(SqlMapClient smc, String theaterCd) throws SQLException;
	
	public List<TicketingShowVO> retrieveTicketingShow(SqlMapClient smc, TicketingShowVO param) throws SQLException;
	
	public List<MovieVO> retrieveMovieList(SqlMapClient smc) throws SQLException;
	
	public List<CinemaVO> retrieveCinemaList(SqlMapClient smc) throws SQLException;
	
	public int retrievePrice(SqlMapClient smc, ChargeVO chargeVO) throws SQLException;
	
	public int retrieveMaxPaymentCode(SqlMapClient smc) throws SQLException;
	
	public int createPayment(SqlMapClient smc, Map<String, Object> paymentInfo) throws SQLException; 

	public int retrieveMaxTicketCode(SqlMapClient smc) throws SQLException;
	
	public int createTicket(SqlMapClient smc, Map<String, Object> ticketInfo) throws SQLException; 
	
	public List<SeatVO> retrieveAllPaySeatList(SqlMapClient smc, String retrieveAllPaySeatList) throws SQLException;
	
//	public int createTicketDetail(SqlMapClient smc, Map<String, Object> ticketDetailInfo) throws SQLException;
	
	public int createTicketAll(SqlMapClient smc, String sql) throws SQLException;
	

}
