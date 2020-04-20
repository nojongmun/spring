package com.ict.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

// DB 처리하는 클래스
public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	// DB처리하는 메소드(사용방법은 jsp의 SqlSession과 같다.)
	public List<VO> getList(){
		List<VO> list = null;
		try {
			list = sqlSessionTemplate.selectList("list");
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	// insert
	public int getInsert(VO vo) {
		int result = 0 ;
		try {
			result = sqlSessionTemplate.insert("insert", vo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	//onelist
	public VO getOneList(String idx) {
		VO vo = null;
		try {
			vo = sqlSessionTemplate.selectOne("onelist", idx);
		} catch (Exception e) {
			System.out.println(e);
		}
		return vo;
	}
	
	// delete
	public void getDelete(String idx) {
		try {
			sqlSessionTemplate.delete("delete", idx);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//update 
	public void getUpdate(VO vo) {
		try {
			sqlSessionTemplate.update("update", vo);
		} catch (Exception e) {
			System.out.println(e);	
		}
	}
}





