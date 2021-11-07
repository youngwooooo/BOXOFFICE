package member.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.MemberProductVO;
import common.vo.ProductVO;


public class MemberProductDaoImpl implements IMemberProductDao {
	
	// 싱글톤 패턴 만들기
	private static IMemberProductDao productDao;  // 자신을 담을 객체 선언(private static 인터페이스타입)
	
	private MemberProductDaoImpl() {}  // private 생성자 생성
	
	public static IMemberProductDao getInstance() {  // 다른 곳에서 사용하기 위한 메서드 생성(public static 인터페이스)
		if(productDao == null) {
			productDao = new MemberProductDaoImpl();  // 없으면 객체 생성
		}
		
		return productDao;  // 있으면 객체 리턴
	}
	
	@Override
	public MemberProductVO getProductDetail(SqlMapClient smc, String prodCd) throws SQLException {
		return (MemberProductVO) smc.queryForObject("memberProduct.getProductDetail", prodCd);
	}

	@Override
	public List<MemberProductVO> memberProductList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("memberProduct.memberProductList");
	}

	
}
