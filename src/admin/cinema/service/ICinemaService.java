package admin.cinema.service;

import java.util.List;
import java.util.Map;

import common.vo.CinemaVO;
import common.vo.CodeVO;
import common.vo.SeatVO;
import common.vo.TheaterVO;

public interface ICinemaService {
	/**
	 * 극장 관리 시 필요한 코드들을 조회하는 메소드
	 * @return
	 */
	public List<CodeVO> retrieveCodeList();
	
	/**
	 * 극장 목록 조회
	 * @return
	 */
	public List<CinemaVO> retrieveCinemaList();
	
	/**
	 * 극장 상세 조회
	 * @param cinemaCd
	 * @return
	 */
	public Map<String, Object> retrieveCinema(String cinemaCd);
	
	/**
	 * 상영관 별 좌석 조회
	 * @param theaterCd
	 * @return
	 */
	public List<SeatVO> retrieveSeatList(String theaterCd);
	
	/**
	 * 극장 등록
	 * @param cinemaInfo
	 * @return
	 */
	public int createCinema(Map<String, Object> cinemaInfo);
	
	/**
	 * 극장 삭제
	 * @param cinemaCd
	 * @return
	 */
	public int deleteCinema(String cinemaCd);
	
	/**
	 * 좌석 사용여부 변경
	 * @param seatVO
	 * @return
	 */
	public int modifySeatDeleteYn(SeatVO seatVO);
	
	/**
	 * 극장 수정
	 * @param cinemaVO
	 * @return
	 */
	public int modifyCinema(CinemaVO cinemaVO);
	
	/**
	 * 극장 상영관 수정
	 * @param theater
	 * @param flag
	 * @return
	 */
	public int modifyTheater(TheaterVO theaterVO, String flag);
}
