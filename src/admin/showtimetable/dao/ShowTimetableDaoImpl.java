package admin.showtimetable.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.ShowTimetableVO;

public class ShowTimetableDaoImpl extends BaseDao implements IShowTimetableDao {

	private static IShowTimetableDao instance;
	
	private ShowTimetableDaoImpl() {

	}
	
	public static IShowTimetableDao getInstance() {
		if(instance == null) {
			instance = new ShowTimetableDaoImpl();
		}
		
		return instance;
	}

	//좌석 리스트 전체 조회
	@Override
	public List<ShowTimetableVO> retrieveShowTimetableList(SqlMapClient smc, ShowTimetableVO showVO) throws SQLException {
		return smc.queryForList("showtimetable.retrieveShowTimetableList", showVO);
	}

	//좌석 유형 전체 개수
	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("showtimetable.getTotalCnt");
		
		return cnt;
	}

	//코드 존재 여부 확인
	@Override
	public ShowTimetableVO retrieveShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException {
		return (ShowTimetableVO)smc.queryForObject("showtimetable.retrieveShowTimetable", showTimetableVO);
	}

	//코드 최대값
	@Override
	public String retrieveMaxShowTimetableCode(SqlMapClient smc) throws SQLException {
		if((String)smc.queryForObject("showtimetable.retrieveMaxShowTimetableCode") == null) {
			return "1";
		}
		return (String)smc.queryForObject("showtimetable.retrieveMaxShowTimetableCode");
	}

	//등록
	@Override
	public int createShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException {
		if(smc.insert("showtimetable.createShowTimetable", showTimetableVO) == null) {
			return 1;
		}
		return 0;
	}

	//수정
	@Override
	public int modifyShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException {
		return smc.update("showtimetable.modifyShowTimetable", showTimetableVO);
	}

	//삭제
	@Override
	public int deleteShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException {
		return smc.update("showtimetable.deleteShowTimetable", showTimetableVO);
	}


}
