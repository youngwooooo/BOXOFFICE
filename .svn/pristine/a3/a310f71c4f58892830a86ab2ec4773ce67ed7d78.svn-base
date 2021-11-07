package common.dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;

public class BaseDao {
	private SqlMapClient smc;

	protected SqlMapClient getSqlMapClient() {
		if(smc == null)
			smc = SqlMapClientFactory.getInstance();
		
		return smc;
	}
	
}
