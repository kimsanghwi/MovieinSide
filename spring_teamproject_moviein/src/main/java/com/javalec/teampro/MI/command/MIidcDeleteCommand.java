package com.javalec.teampro.MI.command;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIidcDao;





public class MIidcDeleteCommand implements MIidcCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String dNum = request.getParameter("dNum");
	
		MIidcDao dao = new MIidcDao();
		dao.idcdelete(dNum);
	}

}
