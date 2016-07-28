package com.wanpin.web.sys;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wanpin.web.BaseController;

/**
 * <p>通用控制器</p>
 * @author litr 2016年7月21日
 * @version 1.0
 */
@Controller
@RequestMapping("")
public class CommonController extends BaseController{
	
	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("${webAdminPath}/{prefix}/{suffix}${urlSuffix}")
	public ModelAndView common(@PathVariable String prefix,@PathVariable String suffix) {
		return new ModelAndView(prefix + "/" + suffix);
	}
	
}
