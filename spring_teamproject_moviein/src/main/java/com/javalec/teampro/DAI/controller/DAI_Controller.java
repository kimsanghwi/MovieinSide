package com.javalec.teampro.DAI.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.teampro.DAI.command.DAI_Command;
import com.javalec.teampro.DAI.command.DAI_DirectorDeleteCommand;
import com.javalec.teampro.DAI.command.DAI_DirectorListCommand;
import com.javalec.teampro.DAI.command.DAI_DirectorModifyCommand;
import com.javalec.teampro.DAI.command.DAI_DirectorModifyViewCommand;
import com.javalec.teampro.DAI.command.DAI_DirectorViewCommand;
import com.javalec.teampro.DAI.command.DAI_DirectorWriteCommand;
import com.javalec.teampro.DAI.command.DAI_PeopleDeleteCommand;
import com.javalec.teampro.DAI.command.DAI_PeopleListCommand;
import com.javalec.teampro.DAI.command.DAI_PeopleModifyCommand;
import com.javalec.teampro.DAI.command.DAI_PeopleModifyViewCommand;
import com.javalec.teampro.DAI.command.DAI_PeopleViewCommand;
import com.javalec.teampro.DAI.command.DAI_PeopleWriteCommand;
import com.javalec.teampro.DAI.command.PM_RecommendDeleteCommand;
import com.javalec.teampro.DAI.command.PM_RecommendListCommand;
import com.javalec.teampro.DAI.command.PM_RecommendModifyCommand;
import com.javalec.teampro.DAI.command.PM_RecommendModifyViewCommand;
import com.javalec.teampro.DAI.command.PM_RecommendViewCommand;
import com.javalec.teampro.DAI.command.PM_RecommendWriteCommand;
import com.javalec.teampro.RP.command.MRPCommand;
import com.javalec.teampro.RP.command.R_DAI_MRP_ListCommand;
import com.javalec.teampro.RP.command.R_DAI_MRP_deleteCommand;
import com.javalec.teampro.RP.command.R_DAI_MRP_writCommand;
import com.javalec.teampro.RP.command.R_DAI_viewCommand;
import com.javalec.teampro.Util.Constant;

@Controller
public class DAI_Controller {
	
	private static final String UPLOAD_PATH = "C:\\upload_test";
	
	DAI_Command command = null;
	MRPCommand recommand;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	
	@RequestMapping("/recommend_list")
	public String recommend_list(Model model, HttpServletRequest request) {
		
		model.addAttribute("request", request);
		
		command = new PM_RecommendListCommand();
		command.execute(model);
		
		return "recommend_list";
	}
	
	@RequestMapping("/people_list")
	public String people_list(HttpServletRequest request, Model model, HttpSession session) {
		model.addAttribute("request", request);
		
	    String DpageNum = request.getParameter("DpageNum");
		String PpageNum = request.getParameter("PpageNum");
		
		session.setAttribute("DpageNum", DpageNum);
		session.setAttribute("PpageNum", PpageNum);
		
		command = new DAI_DirectorListCommand();
		command.execute(model);
		command = new DAI_PeopleListCommand();
		command.execute(model);
		
		
		return "people_list";
	}
	@RequestMapping("/director_view")
	public String director_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new DAI_DirectorViewCommand();
		command.execute(model);
		
		return "director_view";
	}
	@RequestMapping("/people_view")
	public String people_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new DAI_PeopleViewCommand();
		command.execute(model);
		
		return "people_view";
	}

	@RequestMapping("/recommend_view")
	public String recommend_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new PM_RecommendViewCommand();
		command.execute(model);
		recommand = new R_DAI_MRP_ListCommand();
		recommand.execute(model);
		recommand = new R_DAI_viewCommand();
		recommand.execute(model);
		
		return "recommend_view";
	}
	
	@RequestMapping("/reply_recommend_write")
	public String recommend_reply_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		recommand = new R_DAI_MRP_writCommand();
		recommand.execute(model);
		
		return "redirect:recommend_list";
	}
	
	@RequestMapping("/reply_recommend_delete")
	public String recommend_reply_delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		recommand = new R_DAI_MRP_deleteCommand();
		recommand.execute(model);
		
		return "redirect:recommend_list";
	}
	
	
	
	
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		
		return "write_view";
	}
	@RequestMapping("/peo_write_view")
	public String peo_write_view(Model model) {
		
		return "peo_write_view";
	}
	@RequestMapping("/dir_write_view")
	public String dir_write_view(Model model) {
		
		return "dir_write_view";
	}
	@RequestMapping(value = "requestupload1")
    public String requestupload1(MultipartHttpServletRequest mtfRequest, Model model,HttpServletRequest request) {
		Iterator<String> fileNames = mtfRequest.getFileNames();		//내가함
		String src = mtfRequest.getParameter("src");
        MultipartFile mf = mtfRequest.getFile("safeFile");
        MultipartFile mf2 = mtfRequest.getFile("safeFile2");
		
        String path = "C:\\upload_test\\";

        String originFileName = mf.getOriginalFilename(); // 원본 파일 명
        String originFileName2 = mf2.getOriginalFilename(); // 원본 파일 명
        long fileSize = mf.getSize(); // 파일 사이즈
        

        String safeFile = path + System.currentTimeMillis() + originFileName;
        String safeFile2 = path + System.currentTimeMillis() + originFileName2;
        
        model.addAttribute("safeFile",safeFile);
        model.addAttribute("safeFile2",safeFile2);
        model.addAttribute("request",request);
		command = new PM_RecommendWriteCommand();
		command.execute(model);
        
        try {
            mf.transferTo(new File(safeFile));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
        	mf2.transferTo(new File(safeFile2));
        } catch (IllegalStateException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }

        return "redirect:recommend_list";
    }
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET },value = "requestupload2")
	public String requestupload2(MultipartHttpServletRequest mtfRequest, Model model,HttpServletRequest request) {
		Iterator<String> fileNames = mtfRequest.getFileNames();		//내가함
		String src = mtfRequest.getParameter("src");
        MultipartFile mf = mtfRequest.getFile("safeFile");
		
        String path = "C:\\upload_test\\";

        String originFileName = mf.getOriginalFilename(); // 원본 파일 명
        long fileSize = mf.getSize(); // 파일 사이즈
        HttpSession session = request.getSession();
        String root_path = session.getServletContext().getRealPath("/");
        System.out.println(root_path);
        String safeFile = path + System.currentTimeMillis() + originFileName;
        
        model.addAttribute("safeFile",safeFile);
        model.addAttribute("request",request);
		command = new DAI_PeopleWriteCommand();
		command.execute(model);
        
        try {
            mf.transferTo(new File(safeFile));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return "redirect:people_list";
	}
	
	@RequestMapping(value = "requestupload3")
	public String requestupload3(MultipartHttpServletRequest mtfRequest, Model model,HttpServletRequest request) {
		Iterator<String> fileNames = mtfRequest.getFileNames();		//내가함
		String src = mtfRequest.getParameter("src");
        MultipartFile mf = mtfRequest.getFile("safeFile");
		
        String path = "C:\\upload_test\\";

        String originFileName = mf.getOriginalFilename(); // 원본 파일 명
        long fileSize = mf.getSize(); // 파일 사이즈
        

        String safeFile = path + System.currentTimeMillis() + originFileName;
        
        model.addAttribute("safeFile",safeFile);
        model.addAttribute("request",request);
		command = new DAI_DirectorWriteCommand();
		command.execute(model);
        
        try {
            mf.transferTo(new File(safeFile));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return "redirect:people_list";
	}
		
	@RequestMapping("/peo_delete")
	public String peo_delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new DAI_PeopleDeleteCommand();
		command.execute(model);
		
		return "redirect:people_list";
		
	}
	@RequestMapping("/dir_delete")
	public String dir_delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new DAI_DirectorDeleteCommand();
		command.execute(model);
		
		return "redirect:people_list";
		
	}
	@RequestMapping("/rec_delete")
	public String rec_delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new PM_RecommendDeleteCommand();
		command.execute(model);
		
		return "redirect:recommend_list";
		
	}
	
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/people_modify")
	public String peo_modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new DAI_PeopleModifyViewCommand();
		command.execute(model);
		
		return "people_modify";
	}
	@RequestMapping(value="/people_modifydata", method=RequestMethod.POST)
	public String people_modifydata(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new DAI_PeopleModifyCommand();
		command.execute(model);
		
		return "redirect:people_list";
	}
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/recommend_modify")
	public String recommend_modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new PM_RecommendModifyViewCommand();
		command.execute(model);
		
		return "recommend_modify";
	}
	@RequestMapping(value="/recommend_modifydata", method=RequestMethod.POST)
	public String recommend_modifydata(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new PM_RecommendModifyCommand();
		command.execute(model);
		
		return "redirect:recommend_list";
	}
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/director_modify")
	public String director_modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new DAI_DirectorModifyViewCommand();
		command.execute(model);
		
		return "director_modify";
	}
	@RequestMapping(value="/director_modifydata", method=RequestMethod.POST)
	public String director_modifydata(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new DAI_DirectorModifyCommand();
		command.execute(model);
		
		return "redirect:people_list";
	}
	
}
