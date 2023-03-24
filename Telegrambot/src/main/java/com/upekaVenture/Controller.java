package com.upekaVenture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Controller {
	
	@Autowired
	private RestTemplate restTem;

//	@GetMapping("/a")
	public void getData() {
		Data data = restTem.getForObject(
				"https://script.googleusercontent.com/macros/echo?user_content_key=t8R1oTCRZcHPhFnVlkaKR6eFp2GHDD8zO4FZ8mRJpufheqkc126oW2c37iYxT5y5rC7QJy4th_EvvL7gF7ThC-JXyR4YSv6Nm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnGbYC2CNf3dpr8KozQOdOw6si8O2NR6jmjvnUiWtCCNtIh4abtbP6yqqSiVrpc3FHmPz4VVp2dIMU81vRPKlGKr-sw-A6lAJvNz9Jw9Md8uu&lib=MSGFH7C6CvbWwVIA1YgIdGoySpgIVWerd",
				Data.class);

		NewsData d = data.getNewsData();
		System.out.println("== 333  ");
		for (String s : d.getUrlOfImage()) {
			System.out.println(s);
		}
		System.out.println("== ");
		System.out.println("== ");
		for (String s : d.getUrlOfNews()) {
			System.out.println(s);
		}
	}

}
