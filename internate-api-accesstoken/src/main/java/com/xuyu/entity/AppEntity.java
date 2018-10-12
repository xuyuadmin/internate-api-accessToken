package com.xuyu.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppEntity {

	private long id;
	private String appId;
	private String appName;
	private String appSecret;
	private String accessToken;
	private int isFlag;
}
