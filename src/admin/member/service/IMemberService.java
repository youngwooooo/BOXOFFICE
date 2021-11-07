package admin.member.service;

import java.util.List;

import common.vo.DetailMemberVO;
import common.vo.MemberVO;
import common.vo.PagingVO;


/**
 * Service객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 받아온 자료를 Controller에게 보내주는 역할을 수행한다.
 * 보통 Dao의 메서드와 같은 구조를 갖는다.
 */
public interface IMemberService {
	
	/**
	 * 전체 회원 목록을 조회하기 위한 메서드
	 * @return - 전체 회원 목록
	 */
	public List<MemberVO> getAllMemberList(PagingVO pagingVO);
	
	/**
	 * 주어진 회원ID에 해당하는 회원정보 조회
	 * @param memId - 검색할 회원
	 * @return memId에 해당되는 회원정보
	 */
	public List<DetailMemberVO> getMember(String memId);
	
	/**
	 * 전체 회원수 조회
	 * @return - 전체 회원 수
	 */
	public int getTotalCnt();
	
	/**
	 * 회원정보를 검색하기 위한 메서드
	 * @param mv - 검색할 데이터를 담은 VO객체
	 * @return - 검색된 결과를 담은 List객체
	 */
	public List<MemberVO> getSearchMember(MemberVO mv);
	
	
	
}