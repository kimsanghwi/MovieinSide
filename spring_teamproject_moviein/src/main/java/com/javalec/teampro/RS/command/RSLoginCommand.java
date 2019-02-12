package com.javalec.teampro.RS.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.teampro.RS.dao.RSdao;

public class RSLoginCommand implements RSCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		RSdao dao = new RSdao();
		String lpassword=dao.login(id);

		if(password.equals(lpassword)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			
			
		}
		
	}

}
