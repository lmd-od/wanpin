package com.wanpin.cms.modules.sys.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wanpin.cms.common.persistence.Page;
import com.wanpin.cms.common.web.BaseController;
import com.wanpin.cms.modules.sys.entity.Goods;
import com.wanpin.cms.modules.sys.service.GoodsService;

/**
 * 方案Controller
 * @author MingDing.li
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/good")
public class GoodController  extends BaseController{
	@Autowired
	private GoodsService goodsService;
	
	@RequiresPermissions("sys:good:view")
	@RequestMapping(value = {"list", ""})
	public String list(Goods goods, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Goods> page = goodsService.findGoods(new Page<Goods>(request, response), goods);
        model.addAttribute("page", page);
		return "modules/sys/goodList";
	}
	
	@RequestMapping(value = "save")
	public String save(Goods good, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		return "redirect:" + adminPath + "/sys/good/list?repage";
	}
	
	@RequestMapping(value = "form")
	public String form(Goods good, Model model) {
		
		
		model.addAttribute("good", good);
		return "modules/sys/goodForm";
	}
}
