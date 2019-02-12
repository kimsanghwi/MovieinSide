package com.javalec.teampro.DAI.dto;

import java.sql.Timestamp;

public class DAI_Dto {
	int dAI_Id;
	String dAI_Name;
	String dAI_Title;
	String dAI_Content;
	String safeFile;
	String safeFile2;
	Timestamp dAI_Date;
	int dAI_Hit;
	
	
	public int getdAI_Id() {
		return dAI_Id;
	}


	public void setdAI_Id(int dAI_Id) {
		this.dAI_Id = dAI_Id;
	}


	public String getdAI_Name() {
		return dAI_Name;
	}


	public void setdAI_Name(String dAI_Name) {
		this.dAI_Name = dAI_Name;
	}


	public String getdAI_Title() {
		return dAI_Title;
	}


	public void setdAI_Title(String dAI_Title) {
		this.dAI_Title = dAI_Title;
	}


	public String getdAI_Content() {
		return dAI_Content;
	}


	public void setdAI_Content(String dAI_Content) {
		this.dAI_Content = dAI_Content;
	}


	public String getSafeFile() {
		return safeFile;
	}


	public void setSafeFile(String safeFile) {
		this.safeFile = safeFile;
	}

	public String getSafeFile2() {
		return safeFile2;
	}

	public void setSafeFile2(String safeFile2) {
		this.safeFile2 = safeFile2;
	}


	public Timestamp getdAI_Date() {
		return dAI_Date;
	}


	public void setdAI_Date(Timestamp dAI_Date) {
		this.dAI_Date = dAI_Date;
	}


	public int getdAI_Hit() {
		return dAI_Hit;
	}


	public void setdAI_Hit(int dAI_Hit) {
		this.dAI_Hit = dAI_Hit;
	}


	public DAI_Dto() {
		
	}


	public DAI_Dto(int dAI_Id, String dAI_Name, String dAI_Title, String dAI_Content, String safeFile,String safeFile2,
			Timestamp dAI_Date, int dAI_Hit) {
		this.dAI_Id = dAI_Id;
		this.dAI_Name = dAI_Name;
		this.dAI_Title = dAI_Title;
		this.dAI_Content = dAI_Content;
		this.safeFile = safeFile;
		this.safeFile2 = safeFile2;
		this.dAI_Date = dAI_Date;
		this.dAI_Hit = dAI_Hit;
	}
	
	
}
