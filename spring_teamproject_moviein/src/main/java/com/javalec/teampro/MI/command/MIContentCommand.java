package com.javalec.teampro.MI.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIDao;
import com.javalec.teampro.MI.dto.MIDto;


public class MIContentCommand implements MICommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bNum = request.getParameter("bNum");
		
		MIDao dao = new MIDao();
		MIDto dto = dao.contentview(bNum);
		
		model.addAttribute("content_view", dto);
	}

}
