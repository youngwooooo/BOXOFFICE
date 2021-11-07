package admin.cinema.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.cinema.dao.CinemaDaoImpl;
import admin.cinema.dao.ICinemaDao;
import common.vo.CinemaVO;
import common.vo.CodeVO;
import common.vo.SeatVO;
import common.vo.TheaterVO;

public class CinemaServiceImpl implements ICinemaService {

	private ICinemaDao cinemaDao;
	private static ICinemaService instance;
	
	private CinemaServiceImpl() {
		cinemaDao = CinemaDaoImpl.getInstance();
	}
	
	public static ICinemaService getInstance() {
		if(instance == null) {
			instance = new CinemaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public List<CodeVO> retrieveCodeList() {
		List<CodeVO> list = new ArrayList<>();
		
		try {
			list = cinemaDao.retrieveCodeList();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CinemaVO> retrieveCinemaList() {
		List<CinemaVO> cinemaList = new ArrayList<>();
		
		try {
			cinemaList = cinemaDao.retrieveCinemaList();
		
			for(CinemaVO cinemaVO : cinemaList) {
				String cinemaCd = cinemaVO.getCinemaCd();
				cinemaVO.setTheaterCount(cinemaDao.retrieveTheaterCount(cinemaCd));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cinemaList;
	}

	@Override
	public Map<String, Object> retrieveCinema(String cinemaCd) {
		Map<String, Object> cinemaInfo = new HashMap<>();
		
		try {
			CinemaVO cinemaVO = null;
			
			cinemaVO = cinemaDao.retrieveCinema(cinemaCd);
		
			cinemaInfo.put("cinemaVO", cinemaVO);
			
			List<TheaterVO> theaterVOs = cinemaDao.retrieveTheaterList(cinemaCd);
			
			cinemaInfo.put("theaterVOs", theaterVOs);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cinemaInfo;
	}

	@Override
	public List<SeatVO> retrieveSeatList(String theaterCd) {
		List<SeatVO> seatList = new ArrayList<>();

		try {
			seatList = cinemaDao.retrieveSeatList(theaterCd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seatList;
	}

	@Override
	public int createCinema(Map<String, Object> cinemaInfo) {
		CinemaVO cinemaVO = (CinemaVO)cinemaInfo.get("cinemaVO");
		TheaterVO theaterVO = (TheaterVO)cinemaInfo.get("theaterVO");
		int rows = theaterVO.getRowCount();
		int cols = theaterVO.getColCount();
		int flag = (int)cinemaInfo.get("flag");
		
		String cinemaCd = null;
		String theaterCd = null;
		
		try {
			//극장 등록 (한 번만 수행)
			if(flag == 1) {
				//극장 이름 중복 시
				String checkDupl;
					checkDupl = cinemaDao.retrieveCinemaCode(cinemaVO.getCinemaName());
				if(checkDupl != null) {
					return -1;
				}
				
				//극장 코드 최댓값 조회
				int maxCinemaCd = cinemaDao.retrieveMaxCinemaCode() + 1;
				
				//극장 코드 생성
				cinemaCd = "CN";
				for(int i=0 ; i<3-String.valueOf(maxCinemaCd).length() ; i++) {
					cinemaCd += 0;
				}
				cinemaCd += maxCinemaCd;
				
				cinemaVO.setCinemaCd(cinemaCd);
				
				cinemaDao.createCinema(cinemaVO);
			}
			
			//극장 코드 조회
			if(cinemaCd == null || cinemaCd == "") {
				cinemaCd = cinemaDao.retrieveCinemaCode(cinemaVO.getCinemaName());
			}
			
			//상영관 등록
			//상영관 코드 최댓값 조회
			int maxTheaterCd = cinemaDao.retrieveMaxTheaterCode() + 1;
			
			//상영관 코드 생성
			theaterCd = "TH";
			for(int i=0 ; i<4-String.valueOf(maxTheaterCd).length() ; i++) {
				theaterCd += 0;
			}
			theaterCd += maxTheaterCd;
			
			theaterVO.setTheaterCd(theaterCd);
			theaterVO.setCinemaCd(cinemaCd);
			
			//상영관 등록
			cinemaDao.createTheater(theaterVO);
			
			//좌석 등록 SQL문
			String sql = "INSERT INTO TB_SEAT (SEAT_CD, THEATER_CD , SEAT_NO, SEAT_TYPE_CD, DELETE_YN)";
			
			//좌석 코드 최댓값 조회
			int maxSeatCd = cinemaDao.retrieveMaxSeatCode();
			
			//좌석 등록
			for(char row='A' ; row<'A'+rows ; row++) {
				for(int col=0 ; col<cols ; col++) {
					maxSeatCd++;
					
					//좌석 코드 생성
					String seatCd = "ST";
					for(int i=0 ; i<6-String.valueOf(maxSeatCd).length() ; i++) {
						seatCd += 0;
					}
					seatCd += maxSeatCd;
					
					//좌석 번호 생성
					String seatNo = String.valueOf(row);
					
					for(int i=0 ; i<2-String.valueOf(col+1).length() ; i++) {
						seatNo += 0;
					}
					
					seatNo += (col+1);
					
					//좌석 유형
					String seatTypeCd;
					
					if(row <= 'C') {
						seatTypeCd = "01";
					} else if(row <= 'H') {
						seatTypeCd = "02";
					} else {
						seatTypeCd = "03";
					}
					
					if(!seatNo.equals("A01")) {
						sql += " UNION ALL";
					}
					
					sql += " SELECT '" + seatCd + "', '" + theaterCd + "', '" + seatNo + "', '" + seatTypeCd + "', 'N' FROM DUAL";
				}
			}
			
			//좌석 등록
			cinemaDao.createSeatAll(sql);
		
			return 1;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int deleteCinema(String cinemaCd) {
		List<TheaterVO> theaterList = new ArrayList<>();

		try {
			theaterList = cinemaDao.retrieveTheaterList(cinemaCd);
			
			//좌석 삭제
			for(TheaterVO theaterVO : theaterList) {
				cinemaDao.deleteSeat(theaterVO.getTheaterCd());
			}
			
			//상영관 삭제
			cinemaDao.deleteTheater(cinemaCd);
			
			//극장 삭제
			cinemaDao.deleteCinema(cinemaCd);
			
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public int modifySeatDeleteYn(SeatVO seatVO) {
		int count = 0;
		
		try {
			count = cinemaDao.modifySeatDeleteYn(seatVO);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyCinema(CinemaVO cinemaVO) {
		int count = 0;
		
		try {
			count = cinemaDao.modifyCinema(cinemaVO);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyTheater(TheaterVO theaterVO, String flag) {
		int count = 0;
		
		if(flag.equals("C")) {
			//상영관 새로 등록
			try {
				//상영관 코드 최댓값 조회
				int maxTheaterCd = 0;
				maxTheaterCd = cinemaDao.retrieveMaxTheaterCode() + 1;
			
				//상영관 코드 생성
				String theaterCd = "TH";
				for(int i=0 ; i<4-String.valueOf(maxTheaterCd).length() ; i++) {
					theaterCd += 0;
				}
				theaterCd += maxTheaterCd;
				
				theaterVO.setTheaterCd(theaterCd);
				
				//상영관 등록
				count = cinemaDao.createTheater(theaterVO);
				
				//좌석 등록 SQL문
				String sql = "INSERT INTO TB_SEAT (SEAT_CD, THEATER_CD , SEAT_NO, SEAT_TYPE_CD, DELETE_YN)";
				
				//좌석 등록
				int rows = theaterVO.getRowCount();
				int cols = theaterVO.getColCount();
				
				//좌석 코드 최댓값 조회
				int maxSeatCd = cinemaDao.retrieveMaxSeatCode();
				
				for(char row='A' ; row<'A'+rows ; row++) {
					for(int col=0 ; col<cols ; col++) {
						maxSeatCd++;
						
						//좌석 코드 생성
						String seatCd = "ST";
						for(int i=0 ; i<6-String.valueOf(maxSeatCd).length() ; i++) {
							seatCd += 0;
						}
						seatCd += maxSeatCd;
						
						//좌석 번호 생성
						String seatNo = String.valueOf(row);
						
						for(int i=0 ; i<2-String.valueOf(col+1).length() ; i++) {
							seatNo += 0;
						}
						
						seatNo += (col+1);
						
						//좌석 유형
						String seatTypeCd;
						
						if(row <= 'C') {
							seatTypeCd = "01";
						} else if(row <= 'H') {
							seatTypeCd = "02";
						} else {
							seatTypeCd = "03";
						}
						
						if(!seatNo.equals("A01")) {
							sql += " UNION ALL";
						}
						
						sql += " SELECT '" + seatCd + "', '" + theaterCd + "', '" + seatNo + "', '" + seatTypeCd + "', 'N' FROM DUAL";
					}
				}
				
				//좌석 등록
				cinemaDao.createSeatAll(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if(flag.equals("M")) {
			try {
				String theaterCd = theaterVO.getTheaterCd();
				
				//좌석 삭제
				cinemaDao.deleteSeat(theaterCd);
				
				count = cinemaDao.modifyTheater(theaterVO);
				
				//좌석 등록 SQL문
				String sql = "INSERT INTO TB_SEAT (SEAT_CD, THEATER_CD , SEAT_NO, SEAT_TYPE_CD, DELETE_YN)";
				
				//좌석 새로 등록
				int rows = theaterVO.getRowCount();
				int cols = theaterVO.getColCount();
				
				//좌석 코드 최댓값 조회
				int maxSeatCd = cinemaDao.retrieveMaxSeatCode();
				
				for(char row='A' ; row<'A'+rows ; row++) {
					for(int col=0 ; col<cols ; col++) {
						maxSeatCd++;
						
						//좌석 코드 생성
						String seatCd = "ST";
						for(int i=0 ; i<6-String.valueOf(maxSeatCd).length() ; i++) {
							seatCd += 0;
						}
						seatCd += maxSeatCd;
						
						//좌석 번호 생성
						String seatNo = String.valueOf(row);
						
						for(int i=0 ; i<2-String.valueOf(col+1).length() ; i++) {
							seatNo += 0;
						}
						
						seatNo += (col+1);
						
						//좌석 유형
						String seatTypeCd;
						
						if(row <= 'C') {
							seatTypeCd = "01";
						} else if(row <= 'H') {
							seatTypeCd = "02";
						} else {
							seatTypeCd = "03";
						}
						
						if(!seatNo.equals("A01")) {
							sql += " UNION ALL";
						}
						
						sql += " SELECT '" + seatCd + "', '" + theaterCd + "', '" + seatNo + "', '" + seatTypeCd + "', 'N' FROM DUAL";
					}
				}
				
				//좌석 등록
				cinemaDao.createSeatAll(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if(flag.equals("D")) {
			try {
				String theaterCd = theaterVO.getTheaterCd();
				
				//상영관 코드가 존재하면
				if(theaterCd != null || theaterCd != "") {
					//좌석 삭제
					cinemaDao.deleteSeat(theaterCd);
					
					//상영관 삭제
					count = cinemaDao.deleteTheaterByTheaterCd(theaterCd);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}

}
