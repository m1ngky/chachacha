package c.h.a.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	
	private int NUM;				//�� ��ȣ
	private String id;				//�ۼ���
	private String password;		//��й�ȣ
	private String category;		//����
	private String Ccategory;		//������ ����
	private int READCOUNT;			//��ȸ��
	private String SUBJECT;			//����
	private String CONTENT;			//����
	private String PRICE;			//����
	private String GPRICE;			//�������� ����
	private String FILEname;		//���� ����� ���� �̸�
	private String OriginalFile;	//÷�ε� ���� ��
	private MultipartFile uploadfile;	//���ε� ����
	private Date inputdate;			//�� �ۼ� ��¥
	public int getNUM() {
		return NUM;
	}
	public void setNUM(int nUM) {
		NUM = nUM;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCcategory() {
		return Ccategory;
	}
	public void setCcategory(String ccategory) {
		Ccategory = ccategory;
	}
	
	public int getREADCOUNT() {
		return READCOUNT;
	}
	
	public void setREADCOUNT(int rEADCOUNT) {
		READCOUNT = rEADCOUNT;
	}
	
	public String getSUBJECT() {
		return SUBJECT;
	}
	
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}
	public String getGPRICE() {
		return GPRICE;
	}
	public void setGPRICE(String gPRICE) {
		GPRICE = gPRICE;
	}
	public String getFILEname() {
		return FILEname;
	}
	public void setFILEname(String fILEname) {
		FILEname = fILEname;
	}
	public String getOriginalFile() {
		return OriginalFile;
	}
	public void setOriginalFile(String originalFile) {
		OriginalFile = originalFile;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
	
	
}
