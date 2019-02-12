package com.javalec.teampro.RP.command;

import java.util.ArrayList;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.RP.dao.RP_Dao;
import com.javalec.teampro.RP.dto.RP_Dto;


public class R_DAI_viewCommand implements MRPCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String rgroup  = request.getParameter("dAI_Id");
		
		RP_Dao dao = new RP_Dao();
		ArrayList<RP_Dto> dto = dao.DAI_R_replyview(rgroup);
		
		model.addAttribute("DAI_reply_view", dto);

	}

}
