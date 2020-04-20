package com.ict.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// list
	public List<VO> getList(){
		String sql = "select * from guestbook order by idx";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setPwd(rs.getString(6));
				vo.setRegdate(rs.getString(7).substring(0,10));
				return vo;
			}
		});
	}
	
	// insert 
	public int getWrite(VO vo) {
		int result = 0 ;
		String sql = "insert into guestbook values(guestbook_seq.nextval,?,?,?,?,?,sysdate)";
		result = jdbcTemplate.update(sql,vo.getName(), vo.getSubject(), vo.getContent(), vo.getEmail(), vo.getPwd());
		return result;
	}
	
	// onelist
	public List<VO> getOneList(String idx){
		String sql = "select * from guestbook where idx = ?";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setPwd(rs.getString(6));
				vo.setRegdate(rs.getString(7).substring(0,10));
				return vo;
			}
		}, idx);
	}
	
	// delete
	public void getDelete(String idx) {
		String sql = "delete from guestbook where idx = ?" ;
		jdbcTemplate.update(sql,idx);
	}
	
	//update
	public void getUpdate(VO vo) {
		String sql = "update guestbook set name=?, subject=?, content=?, email=?, pwd=? where idx=?";
		jdbcTemplate.update(sql, vo.getName(), vo.getSubject(), vo.getContent(), vo.getEmail(), vo.getPwd(), vo.getIdx());
	}
}













