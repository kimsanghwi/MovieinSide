package com.javalec.teampro.Main.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javalec.teampro.DAI.dto.DAI_Dto;
import com.javalec.teampro.MI.dto.MIidcDto;
import com.javalec.teampro.Util.Constant;

public class MainDao {

	DataSource dataSource;

	JdbcTemplate template = null;

	public MainDao() {

		template = Constant.template;
	}


public ArrayList<MIidcDto> weeklymovietop5() {
	String query = "select * from(select dNum, dDate, dTitle, safeFile, RANK() OVER (order by dHit desc ) as rk from movie_introduction_board) where rk between 1 and 5";
	return (ArrayList<MIidcDto>)template.query(query, new BeanPropertyRowMapper<MIidcDto>(MIidcDto.class));
	}


public ArrayList<MIidcDto> IDCmovielist5() {
	String query = "select * from(select dNum, dDate, dTitle, safeFile, RANK() OVER (order by dNum desc ) as rk from movie_introduction_board) where rk between 1 and 5";
	return (ArrayList<MIidcDto>)template.query(query, new BeanPropertyRowMapper<MIidcDto>(MIidcDto.class));
	}


public ArrayList<DAI_Dto> RECmovielist5() {
	String query = "select * from(select dAI_Id, dAI_Date, dAI_Title, safeFile, RANK() OVER (order by dAI_Id desc ) as rk from PM_recommend_board) where rk between 1 and 5";
	return (ArrayList<DAI_Dto>)template.query(query, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}


public ArrayList<DAI_Dto> DAI_P_movielist5() {
	String query = "select * from(select dAI_Id, dAI_Date, dAI_Title, safeFile, RANK() OVER (order by dAI_Id desc ) as rk from DAI_people_board) where rk between 1 and 5";
	return (ArrayList<DAI_Dto>)template.query(query, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}


public ArrayList<DAI_Dto> DAI_D_movielist5() {
	String query = "select * from(select dAI_Id, dAI_Date, dAI_Title, safeFile, RANK() OVER (order by dAI_Id desc ) as rk from DAI_director_board) where rk between 1 and 5";
	return (ArrayList<DAI_Dto>)template.query(query, new BeanPropertyRowMapper<DAI_Dto>(DAI_Dto.class));
	}










}