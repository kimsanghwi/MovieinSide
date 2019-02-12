package com.javalec.teampro.Main.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.DAI.dto.DAI_Dto;
import com.javalec.teampro.Main.dao.MainDao;

public class Main_DAI_P_list_Command implements Main_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MainDao dao = new MainDao();
		
		ArrayList<DAI_Dto> dtos = dao.DAI_P_movielist5();
		
		model.addAttribute("DAI_P_list", dtos);
	}

}
