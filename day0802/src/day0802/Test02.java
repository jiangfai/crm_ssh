package day0802;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class Test02 {

	public static void main(String[] args) throws Exception {
		HttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://api.tianapi.com/social/?key=772a81a51ae5c780251b1f98ea431b84&num=20");
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		String jsonString = EntityUtils.toString(entity, "utf-8");
		// System.out.println(jsonString);
		NewsDTO dto = JSON.parseObject(jsonString, NewsDTO.class);
		for (News news: dto.getNewslist()) {
			System.out.println(news.getTitle());
			System.out.println(news.getCtime());
		}
	}
}
