package admin.board.dao;

import java.sql.SQLException;
import java.util.List;



import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.PagingVO;
import common.vo.PostVO;

public interface IBoardDao {
	
	public List<PostVO> getAllBoardList(SqlMapClient smc) throws Exception; //조회
	
	public int insertNotice(SqlMapClient smc, PostVO pv) throws Exception; //공지등록
	
	public PostVO getBoard(SqlMapClient smc, String postCd) throws Exception; // 수정하기 위한 확인
	
	public int updateNotice(SqlMapClient smc, PostVO pv) throws Exception; //공지수정
	
	public boolean checkNotice(SqlMapClient smc, String postCd) throws Exception; //상세조회하기 위한 확인
	
	public PostVO detailNotice(SqlMapClient smc, String postCd) throws Exception; //공지 상세 조회
	
	public int deleteNotice(SqlMapClient smc, String postCd) throws Exception; // 공지 삭제
	
	public List<PostVO> getAllBoardList2(SqlMapClient smc) throws Exception; //조회
	
	public int insertEvent(SqlMapClient smc, PostVO pv) throws Exception; //공지등록

	public int getTotalCnt(SqlMapClient smc) throws Exception; //전체 게시글 수
	
	public List<PostVO> getQuestionsBoardList(SqlMapClient smc, PagingVO pagingVO) throws SQLException; // 문의사항 조회
}