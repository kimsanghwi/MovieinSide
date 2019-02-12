package com.javalec.teampro.RS.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.teampro.RS.dao.RSdao;

public class RSChangeCommand implements RSCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("password");
		String newpasswd = request.getParameter("newpassword");
		String newrepasswd = request.getParameter("newrepassword");
		
		RSdao dao = new RSdao();
		String dbpasswd = dao.login(id);
		
		if(passwd.equals(dbpasswd)) {
			if(newpasswd.equals(newrepasswd)) {
			dao.change(id, newpasswd);
			model.addAttribute("change", 1);
			session.invalidate();
			}else {
				model.addAttribute("change", -1);
			}
		}else {
			model.addAttribute("change", 0);
		}

	}

}
