package com.javalec.teampro.RP.dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.teampro.RP.dto.RP_Dto;
import com.javalec.teampro.STR.dto.SDto;
import com.javalec.teampro.Util.Constant;



public class RP_Dao {

	
DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public RP_Dao() {

		template = Constant.template;
		
	}
	
	
public SDto AvgStar(String bNum){
		String query = "select avg(star) as avgStar, rgroup from repple_present group by rgroup having rgroup = " + bNum;
		try {
		return template.queryForObject(query, new BeanPropertyRowMapper<SDto>(SDto.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
public ArrayList<RP_Dto> replyview(String rgroup) {
		String query = "select * from repple_present where rgroup = " + rgroup;
		try {
		return (ArrayList<RP_Dto>) template.query(query, new BeanPropertyRowMapper<RP_Dto>(RP_Dto.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void reply(final String content, final String writer, final String star, final String rgroup ) {
		
		String query = "insert into repple_present (num, content, writer, star, rgroup) values(repple_present_seq.nextval,?,?,?,?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, content);
				ps.setString(2, writer);
				ps.setInt(3, Integer.parseInt(star));
				ps.setInt(4, Integer.parseInt(rgroup));
				
			}
		});
	
	}
	
	public void relymodify(final String num, final String content,  final String writer, final String star) {
		
		String query = "update repple_present set content = ?,writer = ?,star = ? where num = ? ";
		template.update(query, new PreparedStatementSetter() {
			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, content);
				ps.setString(2, writer);
				ps.setInt(3, Integer.parseInt(star));
				ps.setInt(4, Integer.parseInt(num));
				
				
			}
		});
	}
	
	public void reply_delete(final String num) {
		
		String query = "delete from repple_present where num = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setInt(1, Integer.parseInt(num));
				
			}
		});
		
	}
	
	
	
/*               IDC 댓글                                   */	

	

	
	public SDto IDCAvgStar(String dNum){
		String query = "select avg(star) as avgStar, rgroup from repple_board group by rgroup having rgroup = " + dNum;
		try {
		return template.queryForObject(query, new BeanPropertyRowMapper<SDto>(SDto.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
public ArrayList<RP_Dto> IDCreplyview(String rgroup) {
		String query = "select * from repple_board where rgroup = " + rgroup;
		try {
		return (ArrayList<RP_Dto>) template.query(query, new BeanPropertyRowMapper<RP_Dto>(RP_Dto.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void IDCreply(final String content, final String writer, final String star, final String rgroup ) {
		
		String query = "insert into repple_board (num, content, writer, star, rgroup) values(repple_board_seq.nextval,?,?,?,?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, content);
				ps.setString(2, writer);
				ps.setInt(3, Integer.parseInt(star));
				ps.setInt(4, Integer.parseInt(rgroup));
				
			}
		});
	
	}
	
	public void IDCrelymodify(final String num, final String content,  final String writer, final String star) {
		
		String query = "update repple_board set content = ?,writer = ?,star = ? where num = ? ";
		template.update(query, new PreparedStatementSetter() {
			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, content);
				ps.setString(2, writer);
				ps.setInt(3, Integer.parseInt(star));
				ps.setInt(4, Integer.parseInt(num));
				
				
			}
		});
	}
	
	public void IDCreply_delete(final String num) {
		
		String query = "delete from repple_board where num = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setInt(1, Integer.parseInt(num));
				
			}
		});
		
	}
	
	
	
	
	/*               DAI R 댓글                                   */
	
	public SDto DAI_R_AvgStar(String dAI_Id){
		String query = "select avg(star) as avgStar, rgroup from repple_recommend group by rgroup having rgroup = " + dAI_Id;
		try {
		return template.queryForObject(query, new BeanPropertyRowMapper<SDto>(SDto.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
public ArrayList<RP_Dto> DAI_R_replyview(String rgroup) {
		String query = "select * from repple_recommend where rgroup = " + rgroup;
		try {
		return (ArrayList<RP_Dto>) template.query(query, new BeanPropertyRowMapper<RP_Dto>(RP_Dto.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void DAI_R_reply(final String content, final String writer, final String star, final String rgroup ) {
		
		String query = "insert into repple_recommend (num, content, writer, star, rgroup) values(repple_board_seq.nextval,?,?,?,?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, content);
				ps.setString(2, writer);
				ps.setInt(3, Integer.parseInt(star));
				ps.setInt(4, Integer.parseInt(rgroup));
				
			}
		});
	
	}
	
	public void DAI_R_relymodify(final String num, final String content,  final String writer, final String star) {
		
		String query = "update repple_recommend set content = ?,writer = ?,star = ? where num = ? ";
		template.update(query, new PreparedStatementSetter() {
			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, content);
				ps.setString(2, writer);
				ps.setInt(3, Integer.parseInt(star));
				ps.setInt(4, Integer.parseInt(num));
				
				
			}
		});
	}
	
	public void DAI_R_reply_delete(final String num) {
		
		String query = "delete from repple_recommend where num = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setInt(1, Integer.parseInt(num));
				
			}
		});
		
	}
	
	
	
	
	
	
	
	
}
