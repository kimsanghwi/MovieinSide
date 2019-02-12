package com.javalec.teampro.RP.command;


import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.RP.dao.RP_Dao;
import com.javalec.teampro.STR.dto.SDto;



public class MRP_ListCommand implements MRPCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bNum  = request.getParameter("bNum");

	RP_Dao dao = new RP_Dao();	
	SDto dtos = dao.AvgStar(bNum);
	
	
	model.addAttribute("Star", dtos);
		
	}

}
