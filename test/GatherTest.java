import static org.fest.assertions.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import models.Article;

import org.junit.Ignore;
import org.junit.Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Gather
 * 
 * 1. 목록 데이터 가져오기
 * - 목록 데이터를 가져올 URL 입력
 * - html parsing
 * - new 목록
 * - 목록 데이터 render
 * 
 * 2. 목록 클릭 시 상세 가져오기
 * - 상세 URL 가져오기
 * - html parsing
 * - new 상세
 * - 상세 데이터 render
 * 
 * @author mjkim
 *
 */
public class GatherTest {
	@Test
	public void getListFromHTML() throws Exception {
		// given
		String url = "http://dna.daum.net/lens/";
		Document doc = Jsoup.connect(url).get();
		Elements els = doc.select("li.item");
		
		// when
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
		for(Article article : items){
			System.out.println(article.toString());
		}
		// then
		assertThat(items);
	}
	@Ignore @Test
	public void getDetailFromHTML() throws Exception {
		// given
		
		// when

		// then
		
	}
}
