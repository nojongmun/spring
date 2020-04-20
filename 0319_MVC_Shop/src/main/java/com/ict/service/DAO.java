package com.ict.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<VO> getList(String category)throws Exception{
		return sqlSessionTemplate.selectList("list", category);
	}
	
	public MVO getLogin(MVO m_vo)throws Exception {
		return sqlSessionTemplate.selectOne("login", m_vo);
	}
	public VO getOneList(String idx) throws Exception {
		return sqlSessionTemplate.selectOne("onelist", idx);
	}
	public List<CVO> getCartList(String id) throws Exception{
		return sqlSessionTemplate.selectList("cartlist", id);
	}
	public CVO getCartList(String id, String p_num) throws Exception{
		CVO cvo = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("p_num", p_num);
		return sqlSessionTemplate.selectOne("p_cartlist", map);
	}
	public void getCartInsert(CVO cvo)throws Exception{
		sqlSessionTemplate.insert("cartInsert", cvo);
	}
	public void getCartUpdate(CVO cvo)throws Exception{
		sqlSessionTemplate.update("cartupdate", cvo);
	}
	public void getCartEdit(CVO cvo)throws Exception{
		sqlSessionTemplate.update("cartedit", cvo);
	}
	public void getCartDel(CVO cvo)throws Exception{
		sqlSessionTemplate.delete("cartdelete", cvo);
	}
	public int getProduct_Insert(VO vo)throws Exception{
		return sqlSessionTemplate.insert("p_insert", vo);
	}
}








