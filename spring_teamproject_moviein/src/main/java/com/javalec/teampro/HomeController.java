package com.javalec.teampro;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.teampro.Main.command.Main_Command;
import com.javalec.teampro.Main.command.Main_DAI_D_list_Command;
import com.javalec.teampro.Main.command.Main_DAI_P_list_Command;
import com.javalec.teampro.Main.command.Main_DAI_rec_list_Command;
import com.javalec.teampro.Main.command.Main_IDClist_Command;
import com.javalec.teampro.Main.command.Main_Top5_Command;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	Main_Command macommand;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		

		return "redirect: Main";
	}
	
	@RequestMapping("/Main")
	public String recommend_list(Model model, HttpServletRequest request) {
		
		model.addAttribute("request", request);
		
		macommand = new Main_Top5_Command();
		macommand.execute(model);
		macommand = new Main_IDClist_Command();
		macommand.execute(model);
		macommand = new Main_DAI_rec_list_Command();
		macommand.execute(model);
		macommand = new Main_DAI_P_list_Command();
		macommand.execute(model);
		macommand = new Main_DAI_D_list_Command();
		macommand.execute(model);
		
		return "Main";
	}
	
	
	
	
}
