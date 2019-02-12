package com.javalec.teampro.MI.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.teampro.MI.dao.MIDao;
import com.javalec.teampro.MI.dto.MIDto;


public class MIListCommand implements MICommand {

	@Override
	public void execute(Model model) {

		MIDao dao = new MIDao();
		
		ArrayList<MIDto> dtos = dao.movielist();
		model.addAttribute("movielist", dtos);
		
	}

}
