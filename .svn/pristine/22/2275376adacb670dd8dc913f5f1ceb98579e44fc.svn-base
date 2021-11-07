package admin.board.service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.board.dao.IBoardDao;
import admin.board.dao.BoardDaoImpl;
import common.vo.PagingVO;
import common.vo.PostVO;
import util.SqlMapClientFactory;

public class BoardServiceImpl implements IBoardService{
	
	private IBoardDao BoardDao;
	
	private static IBoardService BoardService;
	
	private SqlMapClient smc;
	
	private BoardServiceImpl() {
		BoardDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IBoardService getInstance() {
		
		if(BoardService == null) {
			BoardService = new BoardServiceImpl();
		}
		return BoardService;
	}

	@Override
	public List<PostVO> getAllBoardList(){
		
		List<PostVO> BoardList = new ArrayList<PostVO>();
		
		try {
			BoardList = BoardDao.getAllBoardList(smc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return BoardList;
	}

	@Override
	public int insertNotice(PostVO pv) {
		
		int cnt = 0;
		
		try {
			cnt = BoardDao.insertNotice(smc, pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateNotice(PostVO pv) {
		
		int cnt = 0;
		
		try {
			cnt = BoardDao.updateNotice(smc, pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkNotice(String postCd) {
		
		boolean chk = false;
		
		try {
			chk = BoardDao.checkNotice(smc, postCd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public PostVO detailNotice(String postCd) {
		
		PostVO pv = null;
		
		try {
			pv = BoardDao.detailNotice(smc, postCd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pv;
	}

	@Override
	public PostVO getBoard(String postCd) {
		
		PostVO pv = null;
		try {
			pv = BoardDao.getBoard(smc, postCd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return pv;
	}

	@Override
	public int deleteNotice(String postCd) {
		
		int cnt = 0;
		
		try {
			cnt = BoardDao.deleteNotice(smc, postCd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<PostVO> getAllBoardList2() {
		
		List<PostVO> BoardList = new ArrayList<PostVO>();
				
			try {
				BoardList = BoardDao.getAllBoardList2(smc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return BoardList;
	}

	@Override
	public int insertEvent(PostVO pv) {
		
		int cnt = 0;
		
		try {
			cnt = BoardDao.insertEvent(smc, pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int getTotalCnt() {
		
		int cnt = 0;
		
		try {
			cnt = BoardDao.getTotalCnt(smc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	//문의사항
	@Override
	public List<PostVO> getQuestionsBoardList(PagingVO pagingVO) {
		
		List<PostVO> questionsBoardList = new ArrayList<PostVO>();
		
		try {
			questionsBoardList = BoardDao.getQuestionsBoardList(smc, pagingVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return questionsBoardList;
	}
	
	
}