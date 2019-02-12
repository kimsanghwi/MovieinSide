package com.javalec.teampro.DAI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.DAI.dao.DAI_Dao;
import com.javalec.teampro.DAI.dto.DAI_Dto;

public class DAI_PeopleViewCommand implements DAI_Command{
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object>map = model.asMap();
		HttpServletRequest request= (HttpServletRequest) map.get("request");
		String dAI_Id = request.getParameter("dAI_Id");
		
		DAI_Dao dao = new DAI_Dao();
		DAI_Dto dto = dao.peopleView(dAI_Id);
		
		model.addAttribute("people_view",dto);
	}
}
