package com.xuyu.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xuyu.base.BaseApiService;
import com.xuyu.utils.BaseRedisService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("all")
//验证AccessToken 是否正确
@Component
public class AccessTokenInterceptor extends BaseApiService implements HandlerInterceptor{

	@Autowired
	private BaseRedisService baseRedisService;
	// 返回错误提示
	public void resultError(String errorMsg, HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.write(new JSONObject().toJSONString(setResultError(errorMsg)));
	}

	/**
	 * 进入controller层拦截请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("---------------------开始进入请求地址拦截----------------------------");
		String accessToken = request.getParameter("accesstoken");
		//判断accessToken是否为空
		if (StringUtils.isEmpty(accessToken)) {
			// 参数Token accessToken
			resultError(" this is parameter accessToken null ", response);
			return false;
		}
		String appId = (String) baseRedisService.getString(accessToken);
		if (StringUtils.isEmpty(appId)) {
			// accessToken 已经失效!
			resultError(" this is  accessToken Invalid ", response);
			return false;
		}
		// 正常执行业务逻辑...
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception e) throws Exception {
		log.info("---------------视图渲染之后的操作---------------");
	}


}
