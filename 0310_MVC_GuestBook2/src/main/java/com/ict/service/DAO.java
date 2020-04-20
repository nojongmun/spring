package com.ict.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// list
	public List<VO> getList(){
		List<VO> list = null;
		try {
			String sql = "select * from guestbook2 order by idx";
			list = jdbcTemplate.query(sql, new RowMapper() {
				@Override
				public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
					VO vo = new VO();
					vo.setIdx(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setSubject(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setEmail(rs.getString(5));
					vo.setPwd(rs.getString(6));
					vo.setFile_name(rs.getString(7));
					vo.setRegdate(rs.getString(8));
					return vo;
				}
			});
		} catch (Exception e) {
		}
		
		return list;
	}
	
	// insert
	public int getInsert(VO2 vo) {
		int result = 0 ;
		try {
			String sql = "insert into guestbook2 values(guestbook2_seq.nextval, ?,?,?,?,?,?,sysdate)";
			result = jdbcTemplate.update(sql, vo.getName(), vo.getSubject(), vo.getContent(), vo.getEmail(), vo.getPwd(), vo.getFile_name());
		} catch (Exception e) {
		}
		return result;
	}
	
	// onelist
	public List<VO> getOneList(String idx){
		List<VO> list = null;
		try {
			String sql = "select * from guestbook2 where idx = ?";
			list = jdbcTemplate.query(sql, new RowMapper() {
				@Override
				public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
					VO vo = new VO();
					vo.setIdx(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setSubject(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setEmail(rs.getString(5));
					vo.setPwd(rs.getString(6));
					vo.setFile_name(rs.getString(7));
					vo.setRegdate(rs.getString(8));
					return vo;
				}
			}, idx);
		} catch (Exception e) {
		}
		
		return list;
	}
	
	
	// delete
	public void getDelete(String idx) {
		String sql = "delete from guestbook2 where idx = ?";
		jdbcTemplate.update(sql, idx);
	}
	
	// update
	public int getUpdate(VO2 vo) {
		int result = 0 ;
		try {
			String sql = "update guestbook2 set name=?, subject=?, "
					+ "content=?, email=?, file_name=? where idx= ?" ;
			result = jdbcTemplate.update(sql, vo.getName(), vo.getSubject(), vo.getContent(),
					vo.getEmail(), vo.getFile_name(), vo.getIdx());
		} catch (Exception e) {
		}
		
		
		return result;
	}
}











