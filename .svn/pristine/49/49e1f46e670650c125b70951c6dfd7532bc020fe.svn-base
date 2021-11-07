package member.product.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.MemberProductVO;
import common.vo.ProductVO;


/**
 * Service객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 받아온 자료를 Controller에게 보내주는 역할을 수행한다.
 * 보통 Dao의 메서드와 같은 구조를 갖는다.
 */
public interface IMemberProductService {
	

	public MemberProductVO getProductDetail(String prodCd) throws SQLException;

	public List<MemberProductVO> memberProductList() throws SQLException;
	
}