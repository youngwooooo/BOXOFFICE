package member.board.dao;

import java.sql.SQLException;
import java.util.List;



import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.PagingVO;
import common.vo.PostVO;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao noticeDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getInstance(){
		if(noticeDao == null) {
			noticeDao = new BoardDaoImpl();
		}
		
		return noticeDao;
	
	}	
	
	
	@Override
	public List<PostVO> getAllBoardList(SqlMapClient smc) throws Exception {
		
		List<PostVO> BoardList = 
				smc.queryForList("boardMem.getAllBoardList");
		return BoardList;
	}

	@Override
	public int insertNotice(SqlMapClient smc, PostVO pv) throws Exception {
		
		int cnt = 0;
		
		Object obj = smc.insert("boardMem.insertNotice", pv);
		
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateNotice(SqlMapClient smc, PostVO pv) throws Exception {
		
		int cnt = smc.update("boardMem.updateNotice", pv);
		
		return cnt;
		
	}

	@Override
	public boolean checkNotice(SqlMapClient smc, String postCd) throws Exception {
		
		boolean check = false;
		
		int count = (int) smc.queryForObject("boardMem.checkNotice", postCd);
		
		if(count > 0) {
			check = true;
		}
		
		return check;
	}

	@Override
	public PostVO detailNotice(SqlMapClient smc, String postCd) throws Exception {
		
		PostVO pv = (PostVO)smc.queryForObject("boardMem.detailNotice", postCd);
		
		return pv;
		
	}

	@Override
	public PostVO getBoard(SqlMapClient smc, String postCd) throws Exception {
		
		PostVO pv = (PostVO)smc.queryForObject("boardMem.getBoard", postCd);
		
		return pv;
	}

	@Override
	public int deleteNotice(SqlMapClient smc, String postCd) throws Exception {
		
		int cnt = smc.delete("boardMem.deleteNotice", postCd);
		
		return cnt;
	}

	@Override
	public List<PostVO> getAllBoardList2(SqlMapClient smc) throws Exception {
		List<PostVO> BoardList = 
				smc.queryForList("boardMem.getAllBoardList2");
		return BoardList;
	}

	@Override
	public int insertEvent(SqlMapClient smc, PostVO pv) throws Exception {
		
		int cnt = 0;
		
		Object obj = smc.insert("boardMem.insertEvent", pv);
		
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int getTotalCnt(SqlMapClient smc) throws Exception {
		
		int cnt = (int)smc.queryForObject("boardMem.getTotalCnt");
		return cnt;
	}

	// 문의사항 조회
	@Override
	public List<PostVO> getQuestionsBoardList(SqlMapClient smc, PagingVO pagingVO) throws SQLException {
		
		List<PostVO> questionsBoardList = smc.queryForList("boardMem.getQuestionsBoardList", pagingVO);
		
		return questionsBoardList;
	}


}