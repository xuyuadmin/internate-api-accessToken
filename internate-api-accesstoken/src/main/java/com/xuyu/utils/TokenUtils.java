package com.xuyu.utils;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;

public class TokenUtils {

	@RequestMapping("/getToken")
	public static String getAccessToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
