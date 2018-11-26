package com.webup.soa.web;

import java.util.Date;


import com.webup.soa.utils.DateUtils;
import com.webup.soa.utils.JsonResultUtil;
import com.webup.soa.base.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/common/date")
public class DateController {
	
	private Logger logger = LoggerFactory.getLogger(DateController.class);

	@ResponseBody
	@RequestMapping(value = "/getCurrentDatetime")
	public JsonResult<String> getCurrentDatetime(@RequestParam(value = "pattern", required = false) String pattern) {
		try {
			return JsonResultUtil.createJsonResult(DateUtils.formatCurrentDate(pattern));
		} catch (Exception e) {
			logger.error("获取日期失败", e);
			return JsonResultUtil.createJsonResult(null, false);
		}
	}

	
	@ResponseBody
	@RequestMapping(value = "/getCurDate")
	public JsonResult<Date> getCurDate() {
		try {
			return JsonResultUtil.createJsonResult(DateUtils.currentDate());
		} catch (Exception e) {
			logger.error("获取日期失败", e);
			return JsonResultUtil.createJsonResult(null, false);
		}
	}
}
