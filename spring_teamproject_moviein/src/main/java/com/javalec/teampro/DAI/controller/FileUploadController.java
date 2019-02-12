package com.javalec.teampro.DAI.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	/*
	 * @RequestMapping("/ckeditorImageUpload") public String
	 * procFileUpload(FileUploadDto fileUploadDto,HttpServletRequest request, Model
	 * model) { HttpSession session = request.getSession(); String root_path =
	 * session.getServletContext().getRealPath("/"); String attach_path =
	 * "resources/img/ckeditor/";
	 * 
	 * MultipartFile upload = fileUploadDto.getUpload(); String filename = "";
	 * String CKEditorFuncNum = "";
	 * 
	 * if (upload != null) { filename = upload.getOriginalFilename();
	 * fileUploadDto.setFilename(filename); CKEditorFuncNum =
	 * fileUploadDto.getCKEditorFuncNum(); try { File file = new File(root_path +
	 * attach_path + filename); System.out.println(root_path + attach_path +
	 * filename); upload.transferTo(file); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 * 
	 * String file_path = attach_path + filename; model.addAttribute("file_path",
	 * file_path); model.addAttribute("CKEditorFuncNum", CKEditorFuncNum); return
	 * "editor"; } }
	 */

	@RequestMapping(value = "/community/imageUpload/", method = { RequestMethod.POST, RequestMethod.GET })
	public void communityImageUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam MultipartFile upload) {

		OutputStream out = null;
		PrintWriter printWriter = null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			HttpSession session = request.getSession();
			String root_path = session.getServletContext().getRealPath("/");
			
			System.out.println(root_path);
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			/*String uploadPath = "\\resources\\community\\imageUpload\\" + fileName;*/
			String uploadPath = root_path + "resources\\community\\imageUpload\\" + fileName;
			
			System.out.println("uploadpath : "+uploadPath);
			out = new FileOutputStream(new File(uploadPath));
			out.write(bytes);
			String callback = request.getParameter("CKEditorFuncNum");
			printWriter = response.getWriter();
			
			String fileUrl = "resources\\\\community\\\\imageUpload\\\\" + fileName;
			System.out.println("fileurl : "+fileUrl);
			printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",'" + fileUrl + "','이미지를 업로드 하였습니다.'" + ")</script>");
			printWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}
}

/*
 * @RequestMapping(method =RequestMethod.POST,value="/fileUpload.do") public
 * String fileUpload(@ModelAttribute("FileUploadDto")FileUploadDto
 * fileuploadDto, HttpServletRequest request, Model model) { HttpSession session
 * = request.getSession(); String rootPath =
 * session.getServletContext().getRealPath("/"); String attachPath = "upload/";
 * 
 * System.out.println("attachPath"+attachPath);
 * System.out.println("rootPath"+rootPath);
 * System.out.println("session"+session); MultipartFile upload =
 * fileuploadDto.getUpload(); String filename = ""; String CKEditorFunNum = "";
 * 
 * if(upload != null) { filename = upload.getOriginalFilename();
 * fileuploadDto.setFilename(filename); CKEditorFunNum =
 * fileuploadDto.getCKEditorFuncNum(); try { File file = new File(rootPath+
 * attachPath + filename); upload.transferTo(file); } catch (Exception e) {
 * e.printStackTrace(); } } model.addAttribute("filePath",attachPath +
 * filename); model.addAttribute("CKEditorFuncNum",CKEditorFunNum);
 * 
 * System.out.println("CKEditorFuncNum"+CKEditorFunNum); return "write_view"; }
 */
