package com.javalec.teampro.RP.command;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.RP.dao.RP_Dao;



public class R_DAI_MRP_writCommand implements MRPCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
	
		
		
		
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String star = request.getParameter("star");
		String rgroup = request.getParameter("rgroup");
	
		
		RP_Dao dao = new RP_Dao();
		dao.DAI_R_reply(content, writer, star, rgroup);

	}

}
