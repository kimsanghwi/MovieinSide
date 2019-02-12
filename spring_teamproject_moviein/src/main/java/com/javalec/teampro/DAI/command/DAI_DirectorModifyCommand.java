package com.javalec.teampro.DAI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.DAI.dao.DAI_Dao;

public class DAI_DirectorModifyCommand implements DAI_Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request= (HttpServletRequest) map.get("request");
		
		String dAI_Id = request.getParameter("dAI_Id");
		String dAI_Title = request.getParameter("dAI_Title");
		String dAI_Content = request.getParameter("dAI_Content");
		
		DAI_Dao dao = new DAI_Dao();
		dao.director_modify(dAI_Title,dAI_Content,dAI_Id);
		
	}

}
