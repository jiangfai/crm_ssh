package day0802;

import java.io.InputStream;
import java.net.URL;

import com.alibaba.fastjson.JSON;

public class Test01 {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://api.tianapi.com/social/?key=772a81a51ae5c780251b1f98ea431b84&num=20");
		InputStream inputStream = url.openStream();
		byte[] buffer = new byte[inputStream.available()];
		inputStream.read(buffer);
		String string = new String(buffer, "utf-8");
		NewsDTO dto = JSON.parseObject(string, NewsDTO.class);
		for (News news: dto.getNewslist()) {
			System.out.println(news.getTitle());
			System.out.println(news.getCtime());
		}
	}
}
