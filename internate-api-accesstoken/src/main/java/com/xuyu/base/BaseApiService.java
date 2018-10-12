package com.xuyu.base;

import org.springframework.stereotype.Component;

import com.xuyu.utils.Constants;

@Component
public class BaseApiService {

	//通用封装
	public ResponseBase setResult(Integer code,String msg,Object data) {
		return new ResponseBase(code,msg,data);
	}
	//封装细分
	//返回成功msg，没有data值
	public ResponseBase setResultSuccess(String msg) {
		return setResult(Constants.HTTP_RES_CODE_200,msg,null);
	}
	// 返回success，沒有data值
	public ResponseBase setResultSuccess() {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
	}
	// 返回success，可以传data值
	public ResponseBase setResultSuccessData(Object data) {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
	}
	//返回success，可以传code，data
	public ResponseBase setResultSuccessData(Integer code, Object data) {
		return setResult(code, Constants.HTTP_RES_CODE_200_VALUE, data);
	}
	// 返回错误，可以传错误信息msg
	public ResponseBase setResultError(String msg) {
		return setResult(Constants.HTTP_RES_CODE_500, msg, null);
	}
	//返回错误信息可以传code，msg
	public ResponseBase setResultError(Integer code, String msg) {
		return setResult(code, msg, null);
	}

}
