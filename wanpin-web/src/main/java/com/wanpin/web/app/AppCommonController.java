package com.wanpin.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wanpin.web.BaseController;

@Controller
@RequestMapping("${appAdminPath}/common")
public class AppCommonController extends BaseController {
	
	@RequestMapping(value = "job${urlSuffix}")
	public ModelAndView view() throws Exception {
		return new ModelAndView("app/common/job_list");
	}
	
}
