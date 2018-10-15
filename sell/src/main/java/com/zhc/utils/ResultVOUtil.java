package com.zhc.utils;

import com.zhc.viewobject.ResultViewObject;

/**
 * @author zhangchi02
 * @date 2018年9月30日
 */
public class ResultVOUtil {

	public static ResultViewObject success(Object object) {
		ResultViewObject resultVO = new ResultViewObject();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
	
	public static ResultViewObject success() {
		return success(null);
	}
	
	public static ResultViewObject error(Integer code,String msg) {
		ResultViewObject resultVO = new ResultViewObject();
		resultVO.setCode(code);
		resultVO.setMsg(msg);
		return resultVO;
	}
}
