package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.2"
				+ "/tvbsfb/feed?fileds=id,name,reactions.type(WOW).limit(0).summary(total_count),since=1480579915&until=1480752715"
				+ "EAACEdEose0cBAMbQxYZCOKplOl2KP6kJ1MPatV0NkT6sH6zZCNdcC4qZA8Ii64ZC28T45KWo0v4RKJAk1bFcZAZBwFfKLkX5LohZBc9lZA04rKI4rbzzGDgsp4OB7B2CBP68nWwu5bQ8YlG6IRMTMVlS2xXZCofZAKfwbrX9mvUUwn4AZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String name = data.select("name").text();




			// FIXIT
			String reactions = "";


			output += name + "," + name + "\n";
		}

		System.out.println( output );
	} 
}
