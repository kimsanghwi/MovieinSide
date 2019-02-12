package com.javalec.teampro.DAI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.DAI.dao.DAI_Dao;

public class PM_RecommendModifyCommand implements DAI_Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request= (HttpServletRequest) map.get("request");
		
		String dAI_Id = request.getParameter("dAI_Id");
		String dAI_Title = request.getParameter("dAI_Title");
		String dAI_Content = request.getParameter("dAI_Content");
		System.out.println(dAI_Title);
		System.out.println(dAI_Content);
		System.out.println(dAI_Id);
		
		DAI_Dao dao = new DAI_Dao();
		dao.recommend_modify(dAI_Title,dAI_Content,dAI_Id);
		
	}

}
