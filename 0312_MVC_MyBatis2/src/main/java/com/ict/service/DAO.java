package com.ict.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<VO> getList(){
		List<VO> list = null;
		try {
			list = sqlSessionTemplate.selectList("list");
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public int getInsert(VO vo) {
		int result = 0 ;
		try {
			result = sqlSessionTemplate.insert("insert", vo);
		} catch (Exception e) {
			System.out.println(e);	
		}
		return result ;
	}
	
	public VO getOneList(String idx) {
		VO vo = null;
		try {
			vo = sqlSessionTemplate.selectOne("onelist", idx);
		} catch (Exception e) {
			System.out.println(e);
		}
		return vo;
	}
	
	public void getDelete(String idx) {
		try {
			sqlSessionTemplate.delete("delete", idx);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int getUpdate(VO vo) {
		int result = 0;
		try {
			result = sqlSessionTemplate.update("update", vo);
		} catch (Exception e) {
		}
		return result;
	}
}









