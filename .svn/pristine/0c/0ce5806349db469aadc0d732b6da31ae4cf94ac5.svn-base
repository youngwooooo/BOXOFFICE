package admin.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.member.dao.IMemberDao;
import admin.member.dao.MemberDaoImpl;
import common.vo.DetailMemberVO;
import common.vo.MemberVO;
import common.vo.PagingVO;
import util.SqlMapClientFactory;

public class MemberServiceImpl implements IMemberService{
	
	private SqlMapClient smc;  // SqlMapClient객체 변수 선언(iBatis)
	
	// Dao객체 생성
	private IMemberDao memDao;
	
	// 싱글톤 패턴 만들기
	private static IMemberService memService;  // 자신을 담을 객체 선언(private static 인터페이스타입)
	
	
	private MemberServiceImpl() {  // private 생성자 생성
		memDao = MemberDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();  // 생성자에 SqlMapClient객체 생성(iBatis)
	}
	
	public static IMemberService getInstance() {  // 다른 곳에서 사용하기 위한 메서드 생성(public static 인터페이스)
		if(memService == null) {
			memService = new MemberServiceImpl();  // 없다면 객체 생성
		}
		
		return memService;  // 있다면 객체 리턴
	}
	

	@Override
	public List<MemberVO> getAllMemberList(PagingVO pagingVO) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			memList = memDao.getAllMemberList(smc, pagingVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memList;
	}


	@Override
	public List<DetailMemberVO> getMember(String memId) {
		List<DetailMemberVO> memDetailList = new ArrayList<DetailMemberVO>();
		try {
			memDetailList = memDao.getMember(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memDetailList;
	}

	@Override
	public int getTotalCnt() {
		int cnt = 0;
		
		try {
			cnt = memDao.getTotalCnt(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			memList = memDao.getSearchMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	
	


}
