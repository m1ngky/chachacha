package c.h.a.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	
	private int NUM;				//글 번호
	private String id;				//작성자
	private String password;		//비밀번호
	private String category;		//종류
	private String Ccategory;		//고객센터 종류
	private int READCOUNT;			//조회수
	private String SUBJECT;			//제목
	private String CONTENT;			//내용
	private String PRICE;			//가격
	private String GPRICE;			//공동구매 가격
	private String FILEname;		//실제 저장될 파일 이름
	private String OriginalFile;	//첨부될 파일 명
	private MultipartFile uploadfile;	//업로드 파일
	private Date inputdate;			//글 작성 날짜
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
