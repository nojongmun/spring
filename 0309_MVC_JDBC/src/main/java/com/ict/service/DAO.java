package com.ict.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	// 오라클에 접근할 수 있는 정보를 가지고 있는 클래스 
	// 쿼리를 사용할 수 있는 클래스 
	private JdbcTemplate jdbcTemplate ;
	
	public DAO() {}
	public DAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// JdbcTemplate 사용법은 select만 문법이 틀리고
	// insert, update, delete는 PreparedStatement 사용법과 같다.
	
	// 리스트 : select의 결과는 무조건 List<VO> 이다. (하나든 여러개든)
	public List<VO> getList(){
		String sql = "select * from members order by idx";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VO vo  = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getString("age"));
				vo.setAddr(rs.getString("addr"));
				return vo;
			}
		});
	}
	
	// 삽입
	// insert, delete, update는 모두 jdbcTemplate.update(sql,?대신 들어갈 데이터);
	public int getWrite(VO vo) {
		int result = 0 ;
		try {
			String sql = "insert into members values(?,?,?,?,?,?)";
			result = jdbcTemplate.update(sql,vo.getIdx(), vo.getId(), vo.getPw(),
					vo.getName(),vo.getAge(), vo.getAddr());
			
		} catch (Exception e) {
		}
		return result;
	}
	
	// 상세보기(select 조건있음)
	public List<VO> getOneList(String idx){
		String sql = "select * from members where idx = ?";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getString("age"));
				vo.setAddr(rs.getString("addr"));
				return vo;
			}
		}, idx);
	}
	
	public int getDelete(String idx) {
		int result = 0 ;
		String sql = "delete from members where idx = ?";
		result = jdbcTemplate.update(sql, idx);
		return result;
	}
}












