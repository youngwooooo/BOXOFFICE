package admin.cinema.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CinemaVO;
import common.vo.CodeVO;
import common.vo.SeatVO;
import common.vo.TheaterVO;

public class CinemaDaoImpl extends BaseDao implements ICinemaDao {

	private SqlMapClient smc;
	private static ICinemaDao instance;
	
	private CinemaDaoImpl() {
		smc = super.getSqlMapClient();
	}
	
	public static ICinemaDao getInstance() {
		if(instance == null) {
			instance = new CinemaDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public List<CodeVO> retrieveCodeList() throws SQLException {
		return smc.queryForList("cinema.retrieveCodeList");
	}

	@Override
	public String retrieveCinemaCode(String cinemaName) throws SQLException {
		return (String)smc.queryForObject("cinema.retrieveCinemaCode", cinemaName);
	}

	@Override
	public int retrieveMaxCinemaCode() throws SQLException {
		return (Integer)smc.queryForObject("cinema.retrieveMaxCinemaCode");
	}

	@Override
	public int retrieveMaxTheaterCode() throws SQLException {
		return (Integer)smc.queryForObject("cinema.retrieveMaxTheaterCode");
	}

	@Override
	public int retrieveMaxSeatCode() throws SQLException {
		return (Integer)smc.queryForObject("cinema.retrieveMaxSeatCode");
	}

	@Override
	public List<CinemaVO> retrieveCinemaList() throws SQLException {
		return smc.queryForList("cinema.retrieveCinemaList");
	}

	@Override
	public CinemaVO retrieveCinema(String cinemaCd) throws SQLException {
		return (CinemaVO)smc.queryForObject("cinema.retrieveCinema", cinemaCd);
	}

	@Override
	public List<TheaterVO> retrieveTheaterList(String cinemaCd) throws SQLException {
		return smc.queryForList("cinema.retrieveTheaterList", cinemaCd);
	}

	@Override
	public int retrieveTheaterCount(String cinemaCd) throws SQLException {
		return (Integer)smc.queryForObject("cinema.retrieveTheaterCount", cinemaCd);
	}

	@Override
	public List<SeatVO> retrieveSeatList(String theaterCd) throws SQLException {
		return smc.queryForList("cinema.retrieveSeatList", theaterCd);
	}

	@Override
	public int createCinema(CinemaVO cinemaVO) throws SQLException {
		return smc.insert("cinema.createCinema", cinemaVO) == null ? 1 : 0;
	}

	@Override
	public int createTheater(TheaterVO theaterVO) throws SQLException {
		return smc.insert("cinema.createTheater", theaterVO) == null ? 1 : 0;
	}

	@Override
	public int createSeat(SeatVO seatVO) throws SQLException {
		return smc.insert("cinema.createSeat", seatVO) == null ? 1 : 0;
	}

	@Override
	public int deleteCinema(String cinemaCd) throws SQLException {
		return smc.delete("cinema.deleteCinema", cinemaCd);
	}

	@Override
	public int deleteTheater(String cinemaCd) throws SQLException {
		return smc.delete("cinema.deleteTheater", cinemaCd);
	}

	@Override
	public int deleteSeat(String theaterCd) throws SQLException {
		return smc.delete("cinema.deleteSeat", theaterCd);
	}

	@Override
	public int modifySeatDeleteYn(SeatVO seatVO) throws SQLException {
		return smc.update("cinema.modifySeatDeleteYn", seatVO);
	}

	@Override
	public int createSeatAll(String sql) throws SQLException {
		return smc.insert("cinema.createSeatAll", sql) == null ? 1 : 0;
	}

	@Override
	public TheaterVO retrieveTheater(String theaterCd) throws SQLException {
		return (TheaterVO)smc.queryForObject("cinema.retrieveTheater", theaterCd);
	}

	@Override
	public int modifyCinema(CinemaVO cinemaVO) throws SQLException {
		return smc.update("cinema.modifyCinema", cinemaVO);
	}

	@Override
	public int deleteTheaterByTheaterCd(String theaterCd) throws SQLException {
		return smc.delete("cinema.deleteTheaterByTheaterCd", theaterCd);
	}

	@Override
	public int modifyTheater(TheaterVO theaterVO) throws SQLException {
		return smc.update("cinema.modifyTheater", theaterVO);
	}

}
