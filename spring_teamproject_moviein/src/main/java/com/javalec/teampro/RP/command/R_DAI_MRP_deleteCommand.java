package com.javalec.teampro.RP.command;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.RP.dao.RP_Dao;



public class R_DAI_MRP_deleteCommand implements MRPCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String num = request.getParameter("num");
		String dAI_Id = request.getParameter("dAI_Id");
		model.addAttribute("dAI_Id", dAI_Id);
		
		RP_Dao dao = new RP_Dao();
		dao.DAI_R_reply_delete(num);
		
		
	}

}
