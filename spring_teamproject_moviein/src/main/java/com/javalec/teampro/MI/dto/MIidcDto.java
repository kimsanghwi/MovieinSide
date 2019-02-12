package com.javalec.teampro.MI.dto;

import java.sql.Timestamp;

public class MIidcDto {

	private int dNum;
	private String dTitle;
	private String dContent;
	private String dRelease;
	private String safeFile;
	private String safeFile2;
	private Timestamp dDate;
	int dHit;
	
	public MIidcDto() {
		
	}

	public MIidcDto(int dNum, String dTitle, String dContent, String dRelease, int dHit, String safeFile,String safeFile2) {
		super();
		this.dNum = dNum;
		this.dTitle = dTitle;
		this.dContent = dContent;
		this.dRelease = dRelease;
		this.dHit = dHit;
		this.safeFile = safeFile;
		this.safeFile = safeFile2;
	
	}

	
	
	public Timestamp getdDate() {
		return dDate;
	}

	public void setdDate(Timestamp dDate) {
		this.dDate = dDate;
	}

	public int getdNum() {
		return dNum;
	}

	public void setdNum(int dNum) {
		this.dNum = dNum;
	}

	public String getdTitle() {
		return dTitle;
	}

	public void setdTitle(String dTitle) {
		this.dTitle = dTitle;
	}

	public String getdContent() {
		return dContent;
	}

	public void setdContent(String dContent) {
		this.dContent = dContent;
	}

	public String getdRelease() {
		return dRelease;
	}

	public void setdRelease(String dRelease) {
		this.dRelease = dRelease;
	}

	public int getdHit() {
		return dHit;
	}

	public void setdHit(int dHit) {
		this.dHit = dHit;
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



}
