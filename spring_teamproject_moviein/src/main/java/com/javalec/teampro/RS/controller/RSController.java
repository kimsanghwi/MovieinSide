package com.javalec.teampro.RS.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalec.teampro.Util.Constant;
import com.javalec.teampro.RS.dao.RSdao;


import com.javalec.teampro.RS.command.RSChangeCommand;
import com.javalec.teampro.RS.command.RSCommand;
import com.javalec.teampro.RS.command.RSDeleteCommand;
import com.javalec.teampro.RS.command.RSJoinCommand;
import com.javalec.teampro.RS.command.RSLoginCommand;
import com.javalec.teampro.RS.command.RSModifyCommand;
import com.javalec.teampro.RS.command.RSSessionCommand;
import com.javalec.teampro.RS.dto.RSdto;



@Controller
public class RSController {
	
	public JdbcTemplate template;
	RSCommand command;

	@Autowired // 자동으로 객체 빈이 생성되서 위에 template로 할당이 된다
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template; // 이렇게 하면 데이터베이스에 접근하기 위한 설정은 끝
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public @ResponseBody String join(HttpServletRequest request, Model model) {
		System.out.println("join");
		
		model.addAttribute("request", request);
		command = new RSJoinCommand();
		command.execute(model);
		
		return "OK";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody String login(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("login");	
		
		model.addAttribute("request", request);
		command = new RSLoginCommand();
		command.execute(model);
		
		String id = (String)session.getAttribute("id");
		
		if(id != null) {
			
			return "check";
		}
		else {
			return "c";
		}
		
		
	}
	@RequestMapping("/logout")
	public @ResponseBody String logout(HttpSession session, Model model) {
		System.out.println("logout");
		
		session.invalidate();

		
		return "OK";
	}
	
	@RequestMapping("/idcheck")
	   public @ResponseBody String idcheck(HttpServletRequest request, Model model) {
	      System.out.println("idcheck()");
	      String checkId = request.getParameter("id");
	      RSdao dao = new RSdao();
	      RSdto dto = dao.user(checkId);
	      if(checkId.equals(dto.getId())) {
	         System.out.println("중복된 아이디입니다.");
	         return "NO";
	      }else{
	         System.out.println("사용가능한 아이디입니다.");
	         model.addAttribute("dto", dto);
	         return "OK";
	      }
	   }
	
	@RequestMapping(value="/RSinfor", method=RequestMethod.GET)
	public String memberlist(HttpServletRequest request, Model model) {
		System.out.println("RSinfor");
		
		model.addAttribute("request", request);
		command = new RSSessionCommand();
		command.execute(model);
		
		return "RSinfor";
	}
	
	@RequestMapping("/RSmodify_view")
	public String RSmodify(HttpServletRequest request, Model model) {
		System.out.println("RSmodify_view");
		
		model.addAttribute("request", request);
		command = new RSSessionCommand();
		command.execute(model);
		
		return "RSmodify_view";
	}
	
	@RequestMapping(value="/RSmodify_prc", method=RequestMethod.POST)
	public String RSmodify_prc(HttpServletRequest request, Model model) {
		System.out.println("RSmodify_prc");
		
		model.addAttribute("request", request);
		command = new RSModifyCommand();
		command.execute(model);
		
		return "redirect:Main";
	}
	
	@RequestMapping(value="/RSdelete", method=RequestMethod.POST)
	public String RSdelete(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("RSdelete");
		
		model.addAttribute("request", request);
		command = new RSDeleteCommand();
		command.execute(model);
		
		
		System.out.println("Result : "+model.asMap().get("result"));
		
		return "redirect:Main";
	}
	
	@RequestMapping(value="/RSchange", method=RequestMethod.POST)
	public String RSchange(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("RSchange");
		
		model.addAttribute("request", request);
		command = new RSChangeCommand();
		command.execute(model);
		
		return "redirect:Main";
	}

}
