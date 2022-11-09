package ch12.model;

public class News {
	private int aid;
	private String title;
	private String img;
	private String regDate;
	private String content;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public News(int aid, String title, String img, String regDate, String content) {
		this.aid = aid;
		this.title = title;
		this.img = img;
		this.regDate = regDate;
		this.content = content;
	}
	public News() {
	}
	
	
	
	
}
