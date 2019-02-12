package com.javalec.teampro.MI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.teampro.MI.dto.MIDto;
import com.javalec.teampro.Util.Constant;


public class MIDao {

	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public MIDao() {
		
		template = Constant.template;
	}
	
	public ArrayList<MIDto> movielist() {
		// ArrayList<MDto> dtos = null;
		
		String query = "select * from movie_introduction_present order by bNum desc";
		
		return (ArrayList<MIDto>)template.query(query, new BeanPropertyRowMapper<MIDto>(MIDto.class));
		// 데이터를 가져올 커맨드 객체
		
		// return dtos;
	}
	
	/*public void writer1(final String bTitle ,final String bContent ,final String bRelease) {
		// final을 붙여서 나중에 파라미터 값들이 변경되지 않도록 하지 않기 위해 사용
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into movie_introduction_present (bNum, bTitle, bContent, bRelease, bHit)" + " values (movie_introduction_present_seq.nextval, ?, ?, ?, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bTitle);
				pstmt.setString(2, bContent);
				pstmt.setString(3, bRelease);
				
				return pstmt;
			}
		});
	}*/
	
	public MIDto contentview(String strNum) {
		upHit(strNum);
		
		String query = "select * from movie_introduction_present where bNum = " + strNum;
		return template.queryForObject(query, new BeanPropertyRowMapper<MIDto>(MIDto.class));
	}
	
	public void modify(final String bNum ,final String bTitle, final String bContent, final String bRelease) {
		
		String query = "update movie_introduction_present set bTitle=?,bContent=?,bRelease=? where bNum=?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, bTitle);
				ps.setString(2, bContent);
				ps.setString(3, bRelease);
				ps.setInt(4, Integer.parseInt(bNum));
				
			}
		});
		
	}
	
	private void upHit(final String bNum) {
		
		String query = "update movie_introduction_present set bHit = bHit + 1 where bNum = ?";
		template.update(query, new PreparedStatementSetter() {
			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setInt(1, Integer.parseInt(bNum));
				
			}
		});
		
	}
	
	public void delete(final String strNum) {
		
		String query = "delete from movie_introduction_present where bNum = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setInt(1, Integer.parseInt(strNum));
				
			}
		});
		
	}
	public void MIwriter1(final String bTitle, final String bContent,final String bRelease,final String safeFile,final String safeFile2) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql ="insert into movie_introduction_present (bNum, bTitle, bContent, bRelease, safeFile,safeFile2) values (movie_introduction_present_seq.nextval, ?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,bTitle);
				pstmt.setString(2,bContent);
				pstmt.setString(3,bRelease);
				pstmt.setString(4,safeFile);
				pstmt.setString(5,safeFile2);

				
				return pstmt;
			}
		});
	}
}
