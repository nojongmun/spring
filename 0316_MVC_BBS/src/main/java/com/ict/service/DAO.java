package com.ict.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

// DB 처리하는 클래스
public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// 전체 게시물의 수
	public int getTotalCount() {
		int result = 0 ;
		try {
			result = sqlSessionTemplate.selectOne("count");
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	// list
	public List<BVO> getList(int begin, int end){
		List<BVO> list = null;
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("begin", begin);
			map.put("end",end);
			list = sqlSessionTemplate.selectList("list", map);
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	// 원글 쓰기
	public int getInsert(BVO bvo) {
		int result = 0 ;
		try {
			result = sqlSessionTemplate.insert("b_insert", bvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	// 조회수 업데이트 
	public void getHit(String b_idx) {
		try {
			sqlSessionTemplate.update("hit", b_idx);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// 상세보기
	public BVO getOneList(String b_idx) {
		BVO bvo = null;
		try {
			bvo = sqlSessionTemplate.selectOne("onelist", b_idx);
		} catch (Exception e) {
			System.out.println(e);
		}		
		return bvo;
	}
	
	// 댓글가져오기
	public List<CVO> getCommList(String b_idx){
		List<CVO> c_list = null;
		try {
			c_list = sqlSessionTemplate.selectList("c_list", b_idx);
		} catch (Exception e) {
			System.out.println(e);
		}
		return c_list ;
	}
	// 댓글 쓰기
	public void getComm_Write(CVO cvo) {
		try {
			sqlSessionTemplate.insert("c_insert", cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// 댓글 삭제
	public void getComm_Delete(String c_idx) {
		try {
			sqlSessionTemplate.delete("c_delete", c_idx);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//원글 삭제
	public void getDelete(String b_idx) {
		sqlSessionTemplate.delete("delete", b_idx);
	}
	
	//원글 업데이트 
	public int getUpdate(BVO bvo) {
		int result =0 ;
		try {
			result = sqlSessionTemplate.update("update", bvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
 	}
}











