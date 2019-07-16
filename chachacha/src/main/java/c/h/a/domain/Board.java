package c.h.a.domain;

import org.springframework.web.multipart.MultipartFile;

public class Board {


   private int num;
   private String id;
   private String password;
   private String category;
   private String ccategory;
   private int readcount;
   private String subject;
   private String content;
   private String price;
   private String gprice;
   private MultipartFile uploadfile;
   private String filename="/image/default.png";         //첨부될 파일의 이름
   private String originalfile="/image/default.png";      //첨부될 파일의 오리지널 이름
   private String inputdate;
   
   
   public String getInputdate() {
	return inputdate;
}
public void setInputdate(String inputdate) {
	this.inputdate = inputdate;
}
public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
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
      return ccategory;
   }
   public void setCcategory(String ccategory) {
      this.ccategory = ccategory;
   }
   public int getReadcount() {
      return readcount;
   }
   public void setReadcount(int readcount) {
      this.readcount = readcount;
   }
   public String getSubject() {
      return subject;
   }
   public void setSubject(String subject) {
      this.subject = subject;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getPrice() {
      return price;
   }
   public void setPrice(String price) {
      this.price = price;
   }
   public String getGprice() {
      return gprice;
   }
   public void setGprice(String gprice) {
      this.gprice = gprice;
   }
   public MultipartFile getUploadfile() {
      return uploadfile;
   }
   public void setUploadfile(MultipartFile uploadfile) {
      this.uploadfile = uploadfile;
   }
   public String getFilename() {
      return filename;
   }
   public void setFilename(String filename) {
      this.filename = filename;
   }
   public String getOriginalfile() {
      return originalfile;
   }
   public void setOriginalfile(String originalFile) {
      this.originalfile = originalFile;
   }
   

   
   
}