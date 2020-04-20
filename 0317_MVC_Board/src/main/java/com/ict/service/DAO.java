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
	
	// 전체 게시물의 수
	public int getTotalCount() throws Exception {
		return sqlSessionTemplate.selectOne("totalCount");
	}
	
	// 리스트
	public List<VO> getList(int begin, int end)throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("list", map);
	}
	
	// 원글 삽입
	public int getInsert(VO vo) throws Exception {
		return sqlSessionTemplate.insert("insert", vo);
	}
	
	// hit 업데이트
	public void getHitUpdate(String idx) throws Exception{
		sqlSessionTemplate.update("hit", idx);
	}
	
	// 상세보기
	public VO getOneList(String idx) throws Exception{
		return sqlSessionTemplate.selectOne("onelist", idx);
	}
	
	// levUp
	public int getLevUp(Map<String, Integer> map) throws Exception {
		return sqlSessionTemplate.update("levup", map);
	}
	
	// 댓글 삽입
	public int getAnsInsert(VO vo) throws Exception {
		return sqlSessionTemplate.insert("ans_insert", vo);
	}
	
	// 삭제
	public void getDelete(String idx) throws Exception{
		sqlSessionTemplate.delete("delete", idx);
	}
	
	// 업데이트
	public int getUpdate(VO vo) throws Exception{
		return sqlSessionTemplate.update("update", vo);
	}
}








