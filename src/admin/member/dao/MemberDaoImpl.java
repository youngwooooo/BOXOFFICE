package admin.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.DetailMemberVO;
import common.vo.MemberVO;
import common.vo.PagingVO;


public class MemberDaoImpl implements IMemberDao {
	
	// 싱글톤 패턴 만들기
	private static IMemberDao memDao;  // 자신을 담을 객체 선언(private static 인터페이스타입)
	
	private MemberDaoImpl() {}  // private 생성자 생성
	
	public static IMemberDao getInstance() {  // 다른 곳에서 사용하기 위한 메서드 생성(public static 인터페이스)
		if(memDao == null) {
			memDao = new MemberDaoImpl();  // 없으면 객체 생성
		}
		
		return memDao;  // 있으면 객체 리턴
	}
	

	@Override
	public List<MemberVO> getAllMemberList(SqlMapClient smc, PagingVO pagingVO) throws SQLException {
		
		List<MemberVO> memList = smc.queryForList("member.getMemberAllList", pagingVO);
		
		return memList;
	}

	

	@Override
	public List<DetailMemberVO> getMember(SqlMapClient smc, String memId) throws SQLException {
		List<DetailMemberVO> memDetailList = smc.queryForList("member.getMember", memId);
		return memDetailList;
	}

	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int) smc.queryForObject("member.getTotalCnt");
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		List<MemberVO> memList = smc.queryForList("member.getSearchMember", mv);
		
		return memList;
	}

	
}
