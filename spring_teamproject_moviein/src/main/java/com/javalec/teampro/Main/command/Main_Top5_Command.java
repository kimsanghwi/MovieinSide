package com.javalec.teampro.Main.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dto.MIidcDto;
import com.javalec.teampro.Main.dao.MainDao;

public class Main_Top5_Command implements Main_Command {

	@Override
	public void execute(Model model) {
	
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MainDao dao = new MainDao();
		
		ArrayList<MIidcDto> dtos = dao.weeklymovietop5();
		
		model.addAttribute("TOP", dtos);

	}

}
