package com.javalec.teampro.RS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.teampro.RS.dto.RSdto;
import com.javalec.teampro.Util.Constant;

public class RSdao {

	JdbcTemplate template = null;
	
	public RSdao() {
		
		template = Constant.template;
		
	}
	
	public void join(final String id, final String password, final String name, final String birth, final String postcode, final String address, final String address2, final String tel, final String email, final String gender, final String genre) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				String sql="insert into RSmember (id, password, name, birth, postcode, address, address2, tel, email, gender, genre) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, id);
				ps.setString(2, password);
				ps.setString(3, name);
				ps.setString(4, birth);
				ps.setString(5, postcode);
				ps.setString(6, address);
				ps.setString(7, address2);
				ps.setString(8, tel);
				ps.setString(9, email);
				ps.setString(10, gender);
				ps.setString(11, genre);
				
				return ps;
			}
		});
		
	}
	
	public String login(String id) {
		
		String query = "select password from RSmember where id='" + id +"'";
	
		return (String)template.queryForObject(query, String.class);
		
	}
	
	public RSdto user(String id) {	/* 중복체크 */
		String query = "select * from RSmember where id ='" + id + "'";
		RSdto dto = new RSdto();
		try {
			
			dto = template.queryForObject(query, new BeanPropertyRowMapper<RSdto>(RSdto.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
		
	}
	
	public RSdto myinfor(String id) {
		
		String query = "select * from Rsmember where id = '" + id + "'" ;
		
		return template.queryForObject(query, new BeanPropertyRowMapper<RSdto>(RSdto.class));
	}
	
	public void modify(final String id, final String name, final String birth, final String postcode, final String address, final String address2, final String tel, final String email, final String genre) {
		
		String query = "update RSmember set name=?, birth=?, postcode=?, address=?, address2=?, tel=?, email=?, genre=? WHERE id = ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, name);
				ps.setString(2, birth);
				ps.setString(3, postcode);
				ps.setString(4, address);
				ps.setString(5, address2);
				ps.setString(6, tel);
				ps.setString(7, email);
				ps.setString(8, genre);
				ps.setString(9, id);
				
			}
		});
		
	}
	
	public void delete(final String id) {
		
		String query = "delete  from RSmember where id = ? ";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, id);
				
			}
		});
		
	}
	
	public void change(final String id ,final String newpassword) {
		
		String query = "update RSmember set password = ? where id = ? ";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, newpassword);
				ps.setString(2, id);
				
			}
		});
	}
}
