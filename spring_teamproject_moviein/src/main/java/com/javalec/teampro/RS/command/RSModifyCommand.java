package com.javalec.teampro.RS.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.RS.dao.RSdao;

public class RSModifyCommand implements RSCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String postcode = request.getParameter("mopostcode");
		String address = request.getParameter("moaddress");
		String address2 = request.getParameter("moaddress2");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String genre = request.getParameter("genre");
		
		 
		RSdao dao = new RSdao();
		dao.modify(id, name, birth, postcode,  address, address2, tel, email, genre);

	}

}
