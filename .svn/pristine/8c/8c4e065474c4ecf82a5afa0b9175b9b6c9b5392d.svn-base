package admin.charge.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.CdChargeVO;
import common.vo.PagingVO;

public interface IChargeService {
	
	/**
	 * 요금 테이블 전체를 조회하기 위한 메서드  
	 * @param pagingVO 페이징 정보를 담고 있는 객체
	 * @return 전체 요금 목록
	 */
	public List<CdChargeVO> retrieveChargeList(PagingVO pagingVO);
	
	/**
	 * 요금 테이블의 전체 행 수를 알아내는 메서드
	 * @return 전체 요금 수 
	 */
	public int getTotalCnt();
	
	/**
	 * 요금 코드 정보 등록
	 * @param cdChargeVO
	 * @return
	 * @throws SQLException
	 */
	public int createCharge(CdChargeVO cdChargeVO);
	
	/**
	 * 요금 코드 정보 수정
	 * @param cdChargeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyCharge(CdChargeVO cdChargeVO);
	
	/**
	 * 요금 코드 정보 삭제
	 * @param cdChargeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteCharge(CdChargeVO cdChargeVO);
	
			
}
