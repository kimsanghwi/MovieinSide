package com.javalec.teampro.DAI.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.teampro.DAI.dao.DAI_Dao;
import com.javalec.teampro.DAI.dto.DAI_Dto;

public class DAI_DirectorListCommand implements DAI_Command{
	
	@Override
	public void execute(Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		String DpageNum = (String)session.getAttribute("DpageNum");
		
		
		
		
		int PageSize = 12;
		
		/*movielist에서 넘어오는 페이지 넘버 */
		
		
		//String PageNum = request.getParameter("dpageNum");
		//페이지번호가 없으면 1페이지의 내용이 화면에 표시
		if (DpageNum == null) 
	    {
			
		DpageNum = "1";
	    }
		
		//전체글의 수

		
		// jsp페에지 내에 보여질 넘버링 숫자를 저장
		//int number = 0; 
		
		// 현재 페이지의 수 
		int currentPage = Integer.parseInt(DpageNum);
		
		//리스트에서 가져올 게시물의 시작과 끝
		int StrRow = (currentPage - 1) * PageSize + 1;
		int EndRow = StrRow + PageSize - 1;
		
		//String dNum = request.getParameter("dNum");
		DAI_Dao dao = new DAI_Dao();
		
		
		int count = dao.DTableCount();
		System.out.println(count);
		//int count = Integer.parseInt(Count);
	
		
		/* 페이징처리 */
		
		int PageCount = count / PageSize;
		
		if(count % PageSize > 0)
		{
			PageCount ++;
		}
		if(PageCount < currentPage)
		{
			PageCount = currentPage;
		}
		
		int pageBlock = 5;
		int startPage = 1;
		
		if(currentPage % pageBlock !=0) 
		{
		startPage = (int)((currentPage)/pageBlock) * pageBlock+1;
		}
		else
		{
		startPage = ((int)(currentPage/pageBlock)-1) * pageBlock+1;	
		}
		
		int EndPage = startPage + pageBlock - 1;
		
		if(EndPage > PageCount) 
		{
			EndPage = PageCount;
		}
		if(EndPage < 0)
		{
			EndPage = 1;
		}
		
		
		
		
		

		ArrayList<DAI_Dto> dtos= dao.DAI_dlist(StrRow, EndRow);
		model.addAttribute("director_list",dtos);
		model.addAttribute("DStartPage", startPage);
		model.addAttribute("DEndPage", EndPage);
		model.addAttribute("DPageCount", PageCount);
		model.addAttribute("DPageNum", DpageNum);
		
		
	}
	
	
}
