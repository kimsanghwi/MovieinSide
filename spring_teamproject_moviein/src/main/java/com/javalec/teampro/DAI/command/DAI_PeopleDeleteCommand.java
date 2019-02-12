package com.javalec.teampro.DAI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.DAI.dao.DAI_Dao;

public class DAI_PeopleDeleteCommand implements DAI_Command{

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		
		String dAI_Id = request.getParameter("dAI_Id");
		DAI_Dao dao = new DAI_Dao();
		dao.peo_delete(dAI_Id);
		
	}

}
