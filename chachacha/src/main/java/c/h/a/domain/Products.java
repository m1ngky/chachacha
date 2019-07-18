package c.h.a.domain;

import org.springframework.web.multipart.MultipartFile;

public class Products {
	private String p_code;
	private int p_price;
	private int p_gprice;
	private int P_limit;
	private int p_count;
	private String p_name;
	private String p_sellername;
	private String p_description;
	private MultipartFile p_uploadfile;
	private String p_savefile="/image/default.png";
	private String p_originalfile ="/image/default.png";
	
	

	public MultipartFile getP_uploadfile() {
		return p_uploadfile;
	}
	public void setP_uploadfile(MultipartFile p_uploadfile) {
		this.p_uploadfile = p_uploadfile;
	}
	public String getP_savefile() {
		return p_savefile;
	}
	public void setP_savefile(String p_savefile) {
		this.p_savefile = p_savefile;
	}
	public String getP_originalfile() {
		return p_originalfile;
	}
	public void setP_originalfile(String p_originalfile) {
		this.p_originalfile = p_originalfile;
	}
	public String getP_description() {
		return p_description;
	}
	public void setP_description(String p_description) {
		this.p_description = p_description;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_gprice() {
		return p_gprice;
	}
	public void setP_gprice(int p_gprice) {
		this.p_gprice = p_gprice;
	}
	public int getP_limit() {
		return P_limit;
	}
	public void setP_limit(int p_limit) {
		P_limit = p_limit;
	}
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_sellername() {
		return p_sellername;
	}
	public void setP_sellername(String p_sellername) {
		this.p_sellername = p_sellername;
	}
	
	

}
