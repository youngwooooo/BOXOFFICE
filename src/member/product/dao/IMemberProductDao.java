package member.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.MemberProductVO;
import common.vo.ProductVO;


/**
	실제 DB와 연결해서 SQL문을 수행한 결과를 작성하여 Service에 전달하는 DAO의 Interface
 */
public interface IMemberProductDao {
	
	public MemberProductVO getProductDetail(SqlMapClient smc, String prodCd) throws SQLException;	
	
	public List<MemberProductVO> memberProductList(SqlMapClient smc) throws SQLException;
	
	
}
