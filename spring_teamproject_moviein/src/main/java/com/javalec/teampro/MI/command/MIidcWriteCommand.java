package com.javalec.teampro.MI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIidcDao;


public class MIidcWriteCommand implements MIidcCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String dTitle = request.getParameter("dTitle");
		String dContent = request.getParameter("dContent");
		String dRelease = request.getParameter("dRelease");
		String safeFile = (String) map.get("safeFile");
		String safeFile2 = (String) map.get("safeFile2");
		
		MIidcDao dao = new MIidcDao();
		dao.MIidcwriter1(dTitle, dContent, dRelease,safeFile,safeFile2);
		
	}

}
