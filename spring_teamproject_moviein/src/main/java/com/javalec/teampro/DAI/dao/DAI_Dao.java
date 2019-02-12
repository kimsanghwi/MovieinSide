package com.javalec.teampro.DAI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.teampro.DAI.dto.DAI_Dto;
import com.javalec.teampro.Util.Constant;

public class DAI_Dao {
	
	DataSource dataSource;
	
	JdbcTemplate template = null;

	
	public DAI_Dao() {
		template = Constant.template;
	}
	

	


	public Integer PTableCount() {
		
		String query = "select count(*) from DAI_people_board";
		return template.queryForInt(query);
	}
	

	public Integer DTableCount() {
		
		String query = "select count(*) from DAI_director_board";
		return template.queryForInt(query);
	}
	

	public Integer RTableCount() {
		
		String query = "select count(*) from PM_recommend_board";
		return template.queryForInt(query);
	}
	
	
	public DAI_Dto recommendView(String dAI_Id) {
		String sql = "select * from PM_recommend_board where dAI_Id = "+dAI_Id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}
	

	public DAI_Dto peopleView(String dAI_Id) {
		String sql = "select * from DAI_people_board where dAI_Id = "+dAI_Id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
		
	}
	
	
	public DAI_Dto directorView(String dAI_Id) {
		String sql = "select * from DAI_director_board where dAI_Id = "+dAI_Id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}
	
	
	public DAI_Dto peopleModifyView(String dAI_Id) {
		String sql = "select * from DAI_people_board where dAI_Id = "+dAI_Id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
		
	}
	

	public DAI_Dto recommendModifyView(String dAI_Id) {
		String sql = "select * from PM_recommend_board where dAI_Id = "+dAI_Id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
		
	}
	

	public DAI_Dto directorModifyView(String dAI_Id) {
		String sql = "select * from DAI_director_board where dAI_Id = "+dAI_Id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
		
	}
	
	
	public ArrayList<DAI_Dto> DAI_dlist(int StrRow, int EndRow) {
		String sql = "select *from(select rownum rnum, dAI_Id, dAI_Title, dAI_Content, dAI_Name, safeFile, dAI_Date, dAI_Hit from DAI_director_board order by rnum asc) where rnum between "+StrRow+" and "+EndRow+" order by rnum asc";
		return (ArrayList<DAI_Dto>) template.query(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}
	
	
	public ArrayList<DAI_Dto> DAI_list(int StrRow, int EndRow) {
		String sql = "select *from(select rownum rnum, dAI_Id, dAI_Title, dAI_Content, dAI_Name, safeFile, dAI_Date, dAI_Hit from PM_recommend_board order by rnum asc) where rnum between "+StrRow+" and "+EndRow+" order by rnum asc";;
		return (ArrayList<DAI_Dto>) template.query(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}
	
	public ArrayList<DAI_Dto> DAI_plist(int StrRow,  int EndRow) {
		String sql = "select *from(select rownum rnum, dAI_Id, dAI_Title, dAI_Content, dAI_Name, safeFile, dAI_Date, dAI_Hit from DAI_people_board order by rnum asc) where rnum between "+StrRow+" and "+EndRow+" order by rnum asc";
		return (ArrayList<DAI_Dto>) template.query(sql, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}
	
	public void requestupload1(final String dAI_Title,final String dAI_Content,final String dAI_Name,final String safeFile) {
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql ="insert into PM_recommend_board (dAI_Id,dAI_Title, dAI_Content,dAI_Name,safeFile) values (PM_recommend_board_seq.nextval, ?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,dAI_Title);
				pstmt.setString(2,dAI_Content);
				pstmt.setString(3,dAI_Name);
				pstmt.setString(4,safeFile);
				
				
				return pstmt;
			}
		});
	}
	public void requestupload2(final String dAI_Title,final String dAI_Content,final String dAI_Name,final String safeFile) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql ="insert into DAI_people_board (dAI_Id,dAI_Title, dAI_Content,dAI_Name,safeFile) values (DAI_people_board_seq.nextval, ?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,dAI_Title);
				pstmt.setString(2,dAI_Content);
				pstmt.setString(3,dAI_Name);
				pstmt.setString(4,safeFile);
				
				return pstmt;
			}
		});
	}

	public void requestupload3(final String dAI_Title, final String dAI_Content, final String dAI_Name, final String safeFile) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql ="insert into DAI_director_board (dAI_Id,dAI_Title, dAI_Content,dAI_Name,safeFile) values (DAI_director_board_seq.nextval, ?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,dAI_Title);
				pstmt.setString(2,dAI_Content);
				pstmt.setString(3,dAI_Name);
				pstmt.setString(4,safeFile);

				
				return pstmt;
			}
		});
	}
	public void peo_delete (final String dAI_Id) {
		String sql = "delete from DAI_people_board where dAI_Id=?";
		
		template.update(sql,new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dAI_Id);
			}
		});
	}
	public void dir_delete (final String dAI_Id) {
		String sql = "delete from DAI_director_board where dAI_Id=?";
		
		template.update(sql,new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dAI_Id);
			}
		});
	}
	public void rec_delete (final String dAI_Id) {
		String sql = "delete from PM_recommend_board where dAI_Id=?";
		
		template.update(sql,new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dAI_Id);
			}
		});
	}
	public void people_modify(final String dAI_Title, final String dAI_Content,final String dAI_Id) {
		String sql = "update DAI_people_board set dAI_Title=?, dAI_Content=? where dAI_Id=?";
		
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dAI_Title);
				ps.setString(2, dAI_Content);
				ps.setInt(3, Integer.parseInt(dAI_Id));
			}
		});
	}
		public void recommend_modify(final String dAI_Title, final String dAI_Content,final String dAI_Id) {
			String sql = "update PM_recommend_board set dAI_Title=?, dAI_Content=? where dAI_Id=?";
			
			template.update(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, dAI_Title);
					ps.setString(2, dAI_Content);
					ps.setInt(3, Integer.parseInt(dAI_Id));
				}
			});
	}
		public void director_modify(final String dAI_Title, final String dAI_Content,final String dAI_Id) {
			String sql = "update DAI_director_board set dAI_Title=?, dAI_Content=? where dAI_Id=?";
			
			template.update(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, dAI_Title);
					ps.setString(2, dAI_Content);
					ps.setInt(3, Integer.parseInt(dAI_Id));
				}
			});
		}
	
	
}
