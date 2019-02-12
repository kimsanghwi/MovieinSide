package com.javalec.teampro.MI.controller;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.teampro.DAI.command.PM_RecommendWriteCommand;
import com.javalec.teampro.MI.command.MICommand;
import com.javalec.teampro.MI.command.MIContentCommand;
import com.javalec.teampro.MI.command.MIDeleteCommand;
import com.javalec.teampro.MI.command.MIListCommand;
import com.javalec.teampro.MI.command.MIModifyCommand;
import com.javalec.teampro.MI.command.MIModify_ViewCommand;
import com.javalec.teampro.MI.command.MIWriteCommand;
import com.javalec.teampro.MI.command.MIidcCommand;
import com.javalec.teampro.MI.command.MIidcContentCommand;
import com.javalec.teampro.MI.command.MIidcDeleteCommand;
import com.javalec.teampro.MI.command.MIidcListCommand;
import com.javalec.teampro.MI.command.MIidcModifyCommand;
import com.javalec.teampro.MI.command.MIidcModify_ViewCommand;
import com.javalec.teampro.MI.command.MIidcWriteCommand;
import com.javalec.teampro.RP.command.IDC_MRP_ListCommand;
import com.javalec.teampro.RP.command.IDC_MRP_viewCommand;
import com.javalec.teampro.RP.command.IDC_MRP_writCommand;
import com.javalec.teampro.RP.command.MRPCommand;
import com.javalec.teampro.RP.command.MRP_ListCommand;
import com.javalec.teampro.RP.command.MRP_deleteCommand;
import com.javalec.teampro.RP.command.MRP_modifyCommand;
import com.javalec.teampro.RP.command.MRP_viewCommand;
import com.javalec.teampro.RP.command.MRP_writCommand;
import com.javalec.teampro.Util.Constant;

@Controller
public class MIController {

	MICommand command;
	MIidcCommand idccommand;
	MRPCommand rpcommand;

	public JdbcTemplate template;

	@Autowired // 자동으로 객체 빈이 생성되서 위에 template로 할당이 된다
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template; // 이렇게 하면 데이터베이스에 접근하기 위한 설정은 끝
	}

	@RequestMapping("/MImovielist") // 게시글 목록
	public String movielist(HttpServletRequest request, Model model) {
		System.out.println("MImovielist");
		model.addAttribute("request", request);

		command = new MIListCommand();
		command.execute(model);
		idccommand = new MIidcListCommand();
		idccommand.execute(model);

		return "MImovielist";
	}

	@RequestMapping("/reply") // 댓글 작성
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply");

		model.addAttribute("request", request);
		rpcommand = new MRP_writCommand();
		rpcommand.execute(model);

		return "redirect:MImovielist";
	}

	@RequestMapping("/IDC_reply") // 댓글 작성
	public String IDC_reply(HttpServletRequest request, Model model) {
		System.out.println("IDC_reply");

		model.addAttribute("request", request);
		rpcommand = new IDC_MRP_writCommand();
		rpcommand.execute(model);

		return "redirect:MImovielist";
	}

	@RequestMapping("/MImovieview") // 게시글 상세보기
	public String movieview(HttpServletRequest request, Model model) {
		System.out.println("MImovieview");

		model.addAttribute("request", request);
		command = new MIContentCommand();
		command.execute(model);
		rpcommand = new MRP_viewCommand();
		rpcommand.execute(model);
		rpcommand = new MRP_ListCommand();
		rpcommand.execute(model);

		return "MImovieview";
	}

	@RequestMapping("/MIidcmovieview") // 게시글 상세보기
	public String idcmovieview(HttpServletRequest request, Model model) {
		System.out.println("MIidcmovieview");

		model.addAttribute("request", request);
		idccommand = new MIidcContentCommand();
		idccommand.execute(model);
		rpcommand = new IDC_MRP_viewCommand();
		rpcommand.execute(model);
		rpcommand = new IDC_MRP_ListCommand();
		rpcommand.execute(model);

		return "MIidcmovieview";
	}

	@RequestMapping("/MIwriter1_view") // 게시글 작성폼
	public String writer_view(Model model) {
		System.out.println("MIwriter1_view");

		return "MIwriter1_view";
	}

	/*
	 * @RequestMapping("/MIwriter1") // 게시글 작성 데이터 처리 public String
	 * writer1(HttpServletRequest request, Model model) {
	 * System.out.println("MIwriter1");
	 * 
	 * model.addAttribute("request", request); command = new MIWriteCommand();
	 * command.execute(model);
	 * 
	 * 
	 * return "redirect:MImovielist"; }
	 */

	@RequestMapping("/MIidcwriter1_view") // 게시글 작성 데이터 처리
	public String MIidcwriter1_view(Model model) {

		return "MIidcwriter1_view";
	}
	/*
	 * @RequestMapping("/MIidcwriter1_view") // 게시글 작성폼 public String
	 * idcwriter_view(Model model) { System.out.println("MIidcwriter1_view");
	 * 
	 * 
	 * return "MIidcwriter1_view"; }
	 */

	@RequestMapping(value = "/MImodify_view", method = RequestMethod.GET) // 게시글 수정
	public String write1_modify(HttpServletRequest request, Model model) {
		System.out.println("MImodify_view");

		model.addAttribute("request", request);
		command = new MIModify_ViewCommand();
		command.execute(model);

		return "MImodify_view";
	}

	@RequestMapping(value = "/MIidcmodify_view", method = RequestMethod.GET) // 게시글 수정
	public String idcwrite1_modify(HttpServletRequest request, Model model) {
		System.out.println("MIidcmodify_view");

		model.addAttribute("request", request);
		idccommand = new MIidcModify_ViewCommand();
		idccommand.execute(model);

		return "MIidcmodify_view";
	}

	@RequestMapping("/MImodify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("MImodify");

		model.addAttribute("request", request);
		command = new MIModifyCommand();
		command.execute(model);

		return "redirect:MImovielist";
	}

	@RequestMapping("/MIidcmodify")
	public String idcmodify(HttpServletRequest request, Model model) {
		System.out.println("MIidcmodify");

		model.addAttribute("request", request);
		idccommand = new MIidcModifyCommand();
		idccommand.execute(model);

		return "redirect:MImovielist";
	}

	@RequestMapping("MIdelete") // 게시글 삭제
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("MIdelete");

		model.addAttribute("request", request);
		command = new MIDeleteCommand();
		command.execute(model);

		return "redirect:MImovielist";
	}

	@RequestMapping("MIidcdelete") // 게시글 삭제
	public String idcdelete(HttpServletRequest request, Model model) {
		System.out.println("MIidcdelete");

		model.addAttribute("request", request);
		idccommand = new MIidcDeleteCommand();
		idccommand.execute(model);

		return "redirect:MImovielist";
	}

	@RequestMapping(value = "MIidcwriter1")
	public String MIidcwriter1(MultipartHttpServletRequest mtfRequest, Model model, HttpServletRequest request) {
		Iterator<String> fileNames = mtfRequest.getFileNames(); // 내가함
		String src = mtfRequest.getParameter("src");
		MultipartFile mf = mtfRequest.getFile("safeFile");
		MultipartFile mf2 = mtfRequest.getFile("safeFile2");

		String path = "C:\\upload_test\\";

		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		String originFileName2 = mf2.getOriginalFilename(); // 원본 파일 명
		long fileSize = mf.getSize(); // 파일 사이즈

		String safeFile = path + System.currentTimeMillis() + originFileName;
		String safeFile2 = path + System.currentTimeMillis() + originFileName2;

		model.addAttribute("safeFile", safeFile);
		model.addAttribute("safeFile2", safeFile2);
		model.addAttribute("request", request);

		idccommand = new MIidcWriteCommand();
		idccommand.execute(model);

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

		return "redirect:MImovielist ";
	}

	@RequestMapping(value = "MIwriter1")
	public String MIwriter1(MultipartHttpServletRequest mtfRequest, Model model, HttpServletRequest request) {
		Iterator<String> fileNames = mtfRequest.getFileNames(); // 내가함
		String src = mtfRequest.getParameter("src");
		MultipartFile mf = mtfRequest.getFile("safeFile");
		MultipartFile mf2 = mtfRequest.getFile("safeFile2");

		String path = "C:\\upload_test\\";

		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		String originFileName2 = mf2.getOriginalFilename(); // 원본 파일 명
		long fileSize = mf.getSize(); // 파일 사이즈

		String safeFile = path + System.currentTimeMillis() + originFileName;
		String safeFile2 = path + System.currentTimeMillis() + originFileName2;

		model.addAttribute("safeFile", safeFile);
		model.addAttribute("safeFile2", safeFile2);
		model.addAttribute("request", request);

		command = new MIWriteCommand();
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

		return "redirect:MImovielist ";
	}

	@RequestMapping("/reply_delete")
	public String reply_delete(HttpServletRequest request, Model model) {
		System.out.println("/reply_delete");

		model.addAttribute("request", request);
		rpcommand = new MRP_deleteCommand();
		rpcommand.execute(model);

		return "redirect:MImovieview";

	}

	@RequestMapping("/reply_modify")
	public String reply_modify(HttpServletRequest request, Model model) {
		System.out.println("/reply_modify");

		model.addAttribute("request", request);
		rpcommand = new MRP_modifyCommand();
		rpcommand.execute(model);

		return "redirect:MImovieview";

	}
	@RequestMapping("/map")
	public String map() {
		
		return "map";
	}

	/*
	 * @RequestMapping(value = "/community/imageUpload", method =
	 * RequestMethod.POST) public void communityImageUpload(HttpServletRequest
	 * request, HttpServletResponse response, @RequestParam MultipartFile upload) {
	 * 
	 * OutputStream out = null; PrintWriter printWriter = null;
	 * response.setCharacterEncoding("utf-8");
	 * response.setContentType("text/html;charset=utf-8");
	 * 
	 * try{
	 * 
	 * String fileName = upload.getOriginalFilename(); byte[] bytes =
	 * upload.getBytes(); String uploadPath =
	 * "C:\\study\\workspace\\spring\\movie_inside_project\\src\\main\\webapp\\resources\\photoUpload\\"
	 * + fileName;//저장경로
	 * 
	 * out = new FileOutputStream(new File(uploadPath)); out.write(bytes); String
	 * callback = request.getParameter("CKEditorFuncNum");
	 * 
	 * printWriter = response.getWriter(); String fileUrl =
	 * "/resources/photoUpload/" + fileName;//url경로
	 * 
	 * printWriter.
	 * println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
	 * + callback + ",'" + fileUrl + "','이미지를 업로드 하였습니다.'" + ")</script>");
	 * printWriter.flush();
	 * 
	 * }catch(IOException e){ e.printStackTrace(); } finally { try { if (out !=
	 * null) { out.close(); } if (printWriter != null) { printWriter.close(); } }
	 * catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * return; }
	 */
}
