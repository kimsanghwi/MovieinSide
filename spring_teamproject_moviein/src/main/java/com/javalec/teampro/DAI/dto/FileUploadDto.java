package com.javalec.teampro.DAI.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadDto {
	private String attachPath;
	private String Filename;
	private MultipartFile upload;
	private String CKEditorFuncNum;
	
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	public String getFilename() {
		return Filename;
	}
	public void setFilename(String filename) {
		Filename = filename;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}
	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}
	public FileUploadDto(String attachPath, String filename, MultipartFile upload, String cKEditorFuncNum) {
		this.attachPath = attachPath;
		Filename = filename;
		this.upload = upload;
		CKEditorFuncNum = cKEditorFuncNum;
	}
	
}
