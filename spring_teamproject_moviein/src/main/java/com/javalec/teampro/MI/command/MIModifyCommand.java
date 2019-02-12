package com.javalec.teampro.MI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIDao;

public class MIModifyCommand implements MICommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bNum = request.getParameter("bNum");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bRelease = request.getParameter("bRelease");
		
		MIDao dao = new MIDao();
		dao.modify(bNum, bTitle, bContent, bRelease);
		
	}

}
