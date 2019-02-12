package com.javalec.teampro.MI.command;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIDao;





public class MIDeleteCommand implements MICommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bNum = request.getParameter("bNum");
	
		MIDao dao = new MIDao();
		dao.delete(bNum);
	}

}
