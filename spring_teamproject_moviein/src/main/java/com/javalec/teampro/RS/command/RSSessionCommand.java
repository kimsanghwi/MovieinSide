package com.javalec.teampro.RS.command;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.teampro.RS.dao.RSdao;

import com.javalec.teampro.RS.dto.RSdto;

public class RSSessionCommand implements RSCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		RSdao dao = new RSdao();
		RSdto dto = dao.myinfor(id);
		
		model.addAttribute("member", dto);
		
	}

}
