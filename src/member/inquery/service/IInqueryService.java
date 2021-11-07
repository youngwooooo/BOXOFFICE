package member.inquery.service;

import common.vo.MemberVO;

public interface IInqueryService {
	public int retrieveMemberForPassword(MemberVO memberVO);
	
	public int modifyPassword(MemberVO memberVO);
}
