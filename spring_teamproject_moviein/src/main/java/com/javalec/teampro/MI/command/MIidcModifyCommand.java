package com.javalec.teampro.MI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIidcDao;


public class MIidcModifyCommand implements MIidcCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		System.out.println(request);
		
		
		String dNum = request.getParameter("dNum");
		String dTitle = request.getParameter("dTitle");
		String dContent = request.getParameter("dContent");
		String dRelease = request.getParameter("dRelease");
		
		MIidcDao dao = new MIidcDao();
		dao.idcmodify(dNum, dTitle, dContent, dRelease);
		
	}

}
