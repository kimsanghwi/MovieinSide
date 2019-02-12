package com.javalec.teampro.RP.command;



import java.util.Map;



import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.RP.dao.RP_Dao;




public class MRP_modifyCommand implements MRPCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String num  = request.getParameter("num");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String star = request.getParameter("star");
		String bNum = request.getParameter("bNum");
		model.addAttribute("bNum",bNum);
		
		RP_Dao dao = new RP_Dao();
		dao.relymodify(num, content, writer, star );
		
	

	}

}
