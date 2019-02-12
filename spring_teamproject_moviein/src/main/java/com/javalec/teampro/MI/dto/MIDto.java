package com.javalec.teampro.MI.dto;

import java.sql.Timestamp;

public class MIDto {

	private int bNum;
	private String bTitle;
	private String bContent;
	private String bRelease;
	private String safeFile;
	private String safeFile2;
	private Timestamp bDate;
	
	int bHit;
	
	public MIDto() {
		
	}

	public MIDto(int bNum, String bTitle, String bContent, String bRelease, int bHit, String safeFile, String safeFile2) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bRelease = bRelease;
		this.bHit = bHit;
		this.safeFile = safeFile;
		this.safeFile2 = safeFile2;
	

	}

	


	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public String getbRelease() {
		return bRelease;
	}

	public void setbRelease(String bRelease) {
		this.bRelease = bRelease;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
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
