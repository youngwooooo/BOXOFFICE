package member.board.service;

import java.util.List;

import common.vo.PagingVO;
import common.vo.PostVO;

public interface IBoardService {

	public List<PostVO> getAllBoardList();//조회
	
	public int insertNotice(PostVO pv); //공지등록
	
	public PostVO getBoard(String postCd);
	
	public int updateNotice(PostVO pv); //공지수정
	
	public boolean checkNotice(String postCd); //상세 조회하기 위한 확인
	
	public PostVO detailNotice(String postCd); // 공지 상세 조회
	
	public int deleteNotice(String postCd); // 공지삭제
	
	public List<PostVO> getAllBoardList2();//조회
	
	public int insertEvent(PostVO pv); //이벤트등록

	public int getTotalCnt(); //전체 게시글 수
	
	public List<PostVO> getQuestionsBoardList(PagingVO pagingVO); //문의사항 조회
}
