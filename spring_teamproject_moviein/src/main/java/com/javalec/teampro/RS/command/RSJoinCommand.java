package com.javalec.teampro.RS.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.RS.dao.RSdao;

public class RSJoinCommand implements RSCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String genre = request.getParameter("genre");
		
		RSdao dao = new RSdao();
		dao.join(id, password, name, birth, postcode, address, address2, tel, email, gender, genre);
		
	}

}
