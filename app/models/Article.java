package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Article {
	
	public String url;
	public String title;
	public String category;
	public String publicDate;
	public Date gatherDate;
	public String blog;
	public String site;
	public String source;
	
	public Article(){}
	public Article(String url, String title, String category,
			String publicDate, String blog, String site, String source) {
		this.url = url;
		this.title = title;
		this.category = category;
		this.publicDate = publicDate;
		this.gatherDate = new Date();
		this.blog = blog;
		this.site = site;
		this.source = source;
	}
	public static String getPublicDate(String dateStr){
		if(dateStr.contains(":"))	return null;
		return null;
	}
	@Override
	public String toString() {
		return "Article [url=" + url + ", title=" + title + ", category="
				+ category + ", publicDate=" + publicDate + ", gatherDate="
				+ gatherDate + ", blog=" + blog + ", site=" + site
				+ ", source=" + source + "]";
	}
	
	public static List<Article> list(String url) throws Exception {
		Document doc = Jsoup.connect(url).get();
		Elements els = doc.select("li.item");
		
		List<Article> items = new ArrayList<Article>();
		for(Element el : els){
			items.add(new Article(
					el.select("a.article[href]").attr("href")
					, el.select("a.article").text()
					, null
					, Article.getPublicDate(el.select("span.time").text())
					, el.select("a.blog").text()
					, url
					, el.html()
					));
		}
		return items;
	}
}
