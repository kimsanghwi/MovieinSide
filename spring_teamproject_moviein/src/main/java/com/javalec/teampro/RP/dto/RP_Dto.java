package com.javalec.teampro.RP.dto;

public class RP_Dto {

	int num;
	String content;
	String writer;
	int star;
	int rgroup;
	
	public RP_Dto() {
		
	}
	
	public RP_Dto(int num, String content, String writer, int star, int rgroup) {
		super();
		this.num = num;
		this.content = content;
		this.writer = writer;
		this.star = star;
		this.rgroup = rgroup;
	}
	
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getRgroup() {
		return rgroup;
	}
	public void setRgroup(int rgroup) {
		this.rgroup = rgroup;
	}
	
	
	
	
	
	
	
	
}
