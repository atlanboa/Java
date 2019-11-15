package java11.com.ssafy.news;


public class News {

	private String title;
	private String desc;
	private String link;
	
	//constructor
	public News() {}
	public News(String title, String desc, String link) {
		super();
		this.title = title;
		this.desc = desc;
		this.link = link;
	}
	
	//get set
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	//toString
	@Override
	public String toString() {
		return "News [title=" + title + ", desc=" + desc + ", link=" + link + "]";
	}


}
