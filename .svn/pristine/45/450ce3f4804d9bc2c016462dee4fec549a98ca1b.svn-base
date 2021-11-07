package admin.cinema.dao;

import java.sql.SQLException;
import java.util.List;

import common.vo.CinemaVO;
import common.vo.CodeVO;
import common.vo.SeatVO;
import common.vo.TheaterVO;

public interface ICinemaDao {
	
	/**
	 * 극장 관리 시 필요한 코드들을 조회하는 메소드
	 * @return
	 * @throws SQLException
	 */
	public List<CodeVO> retrieveCodeList() throws SQLException;
	
	/**
	 * 극장 이름으로 코드 조회
	 * @param cinemaName
	 * @return
	 * @throws SQLException
	 */
	public String retrieveCinemaCode(String cinemaName) throws SQLException;
	
	/**
	 * 극장 코드 최댓값 추출
	 * @return
	 * @throws SQLException
	 */
	public int retrieveMaxCinemaCode() throws SQLException;
	
	/**
	 * 상영관 코드 최댓값 추출
	 * @return
	 * @throws SQLException
	 */
	public int retrieveMaxTheaterCode() throws SQLException;
	
	/**
	 * 좌석 코드 최댓값 추출
	 * @return
	 * @throws SQLException
	 */
	public int retrieveMaxSeatCode() throws SQLException;
	
	/**
	 * 극장 목록 조회
	 * @return
	 * @throws SQLException
	 */
	public List<CinemaVO> retrieveCinemaList() throws SQLException;
	
	/**
	 * 극장 조회
	 * @param cinemaCd
	 * @return
	 * @throws SQLException
	 */
	public CinemaVO retrieveCinema(String cinemaCd) throws SQLException;
	
	/**
	 * 상영관 목록 조회
	 * @param cinemaCd
	 * @return
	 * @throws SQLException
	 */
	public List<TheaterVO> retrieveTheaterList(String cinemaCd) throws SQLException;
	
	/**
	 * 상영관 조회
	 * @param theaterCd
	 * @return
	 * @throws SQLException
	 */
	public TheaterVO retrieveTheater(String theaterCd) throws SQLException;
	
	/**
	 * 상영관 개수 조회
	 * @param cinemaCd
	 * @return
	 * @throws SQLException
	 */
	public int retrieveTheaterCount(String cinemaCd) throws SQLException;
	
	/**
	 * 좌석 목록 조회
	 * @param theaterCd
	 * @return
	 * @throws SQLException
	 */
	public List<SeatVO> retrieveSeatList(String theaterCd) throws SQLException;
	
	/**
	 * 극장 등록
	 * @param cinemaVO
	 * @return
	 * @throws SQLException
	 */
	public int createCinema(CinemaVO cinemaVO) throws SQLException;
	
	/**
	 * 상영관 등록
	 * @param theaterVO
	 * @return
	 * @throws SQLException
	 */
	public int createTheater(TheaterVO theaterVO) throws SQLException;
	
	/**
	 * 좌석 등록
	 * @param seatVO
	 * @return
	 * @throws SQLException
	 */
	public int createSeat(SeatVO seatVO) throws SQLException;
	
	/**
	 * 좌석 한 번에 등록
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public int createSeatAll(String sql) throws SQLException;
	
	/**
	 * 극장 삭제
	 * @param cinemaCd
	 * @return
	 * @throws SQLException
	 */
	public int deleteCinema(String cinemaCd) throws SQLException;
	
	/**
	 * 극장 코드를 이용하여 상영관 모두 삭제
	 * @param cinemaCd
	 * @return
	 * @throws SQLException
	 */
	public int deleteTheater(String cinemaCd) throws SQLException;
	
	/**
	 * 상영관 코드를 이용하여 상영관 1개 삭제
	 * @param theaterCd
	 * @return
	 * @throws SQLException
	 */
	public int deleteTheaterByTheaterCd(String theaterCd) throws SQLException;
	
	/**
	 * 좌석 삭제
	 * @param theaterCd
	 * @return
	 * @throws SQLException
	 */
	public int deleteSeat(String theaterCd) throws SQLException;
	
	/**
	 * 좌석 사용여부 변경
	 * @param seatVO
	 * @return
	 * @throws SQLException
	 */
	public int modifySeatDeleteYn(SeatVO seatVO) throws SQLException;
	
	/**
	 * 극장 정보 수정
	 * @param cinemaVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyCinema(CinemaVO cinemaVO) throws SQLException;
	
	/**
	 * 상영관 정보 수정
	 * @param theaterVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyTheater(TheaterVO theaterVO) throws SQLException;
}
