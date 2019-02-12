package com.javalec.teampro.MI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIDao;


public class MIWriteCommand implements MICommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bRelease = request.getParameter("bRelease");
		String safeFile = (String) map.get("safeFile");
		String safeFile2 = (String) map.get("safeFile2");
		
		MIDao dao = new MIDao();
		dao.MIwriter1(bTitle, bContent, bRelease, safeFile,safeFile2);
		
	}

}
