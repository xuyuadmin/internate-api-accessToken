/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.xuyu.apicontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xuyu.base.BaseApiService;
import com.xuyu.base.ResponseBase;

@RestController
@RequestMapping("/openApi")
public class MemberController extends BaseApiService {

	@RequestMapping("/getUser")
	public ResponseBase getUser() {
		return setResultSuccess("获取会员信息接口");
	}
}
