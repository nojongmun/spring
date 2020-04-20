package com.ict.db;

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
			sqlSessionTemplate.commit();
		} catch (Exception e) {
		}
		return list;
	}
	
	public int getInsert(VO vo) {
		int result = 0 ;
		try {
			result = sqlSessionTemplate.insert("insert", vo);
			sqlSessionTemplate.commit();
		} catch (Exception e) {
		}
		return result;
	}
	
	public VO getOneList(String idx) {
		VO vo = null;
		try {
			vo = sqlSessionTemplate.selectOne("onelist", idx);	
		} catch (Exception e) {
		}
		return vo;
	}
	
	public int getDelete(String idx) {
		int result = 0 ;
		try {
			result = sqlSessionTemplate.delete("delete", idx);
		} catch (Exception e) {
		}
		return result;
	}
	
	public int getUpdate(VO vo) {
		int result = 0 ;
		try {
			result = sqlSessionTemplate.update("update", vo);
		} catch (Exception e) {
		}
		return result;
	}
}





