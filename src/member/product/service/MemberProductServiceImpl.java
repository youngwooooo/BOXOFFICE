package member.product.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.MemberProductVO;
import common.vo.ProductVO;
import member.product.dao.IMemberProductDao;
import member.product.dao.MemberProductDaoImpl;
import util.SqlMapClientFactory;

public class MemberProductServiceImpl implements IMemberProductService{
	
	private SqlMapClient smc;  // SqlMapClient객체 변수 선언(iBatis)
	
	// Dao객체 생성
	private IMemberProductDao productDao;
	
	// 싱글톤 패턴 만들기
	private static IMemberProductService productService;  // 자신을 담을 객체 선언(private static 인터페이스타입)
	
	
	private MemberProductServiceImpl() {  // private 생성자 생성
		productDao = MemberProductDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();  // 생성자에 SqlMapClient객체 생성(iBatis)
	}
	
	public static IMemberProductService getInstance() {  // 다른 곳에서 사용하기 위한 메서드 생성(public static 인터페이스)
		if(productService == null) {
			productService = new MemberProductServiceImpl();  // 없다면 객체 생성
		}
		
		return productService;  // 있다면 객체 리턴
	}

	@Override
	public MemberProductVO getProductDetail(String prodCd) {
		MemberProductVO mpdVO = null;
		try {
			mpdVO = productDao.getProductDetail(smc, prodCd);
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return mpdVO;
	}

	@Override
	public List<MemberProductVO> memberProductList() throws SQLException {
		List<MemberProductVO> memberProductList = new ArrayList<MemberProductVO>();
		try {
			memberProductList = productDao.memberProductList(smc);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memberProductList;
	}






}
