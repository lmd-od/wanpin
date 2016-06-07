package com.wanpin.cms.modules.sys.web;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wanpin.cms.common.persistence.Page;
import com.wanpin.cms.common.web.BaseController;
import com.wanpin.cms.modules.sys.entity.Dict;
import com.wanpin.cms.modules.sys.entity.Goods;
import com.wanpin.cms.modules.sys.service.DictService;
import com.wanpin.cms.modules.sys.service.GoodsService;
import com.wanpin.common.exception.WanPinExceptionCommon;
import com.wanpin.common.persistence.SystemEnum;

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
	@Autowired
	private DictService dictService;
	
	@RequiresPermissions("sys:good:view")
	@RequestMapping(value = {"list", ""})
	public String list(Goods goods, HttpServletRequest request, HttpServletResponse response, Model model) {
		/** 1.方案风格字典类型  */
		Dict dictStyleReq = new Dict();
		dictStyleReq.setType(SystemEnum.WP_GOODS_STYLE);
		List<Dict> dictStyles = dictService.findList(dictStyleReq);
		
		/** 2.方案功能字典类型  */
		Dict dictFunctionReq = new Dict();
		dictFunctionReq.setType(SystemEnum.WP_GOODS_FUNCTION);
		List<Dict> dictFunctions = dictService.findList(dictFunctionReq);
		
		/** 3.方案层数字典类型  */
		Dict dictHierarchyReq = new Dict();
		dictHierarchyReq.setType(SystemEnum.WP_GOODS_FUNCTION);
		List<Dict> dictHierarchys = dictService.findList(dictHierarchyReq);
		
		/** 查询解决方案列表 */
		Page<Goods> page = goodsService.findGoods(new Page<Goods>(request, response), goods);
        model.addAttribute("page", page);
        model.addAttribute("dictStyles", dictStyles);
        model.addAttribute("dictFunctions", dictFunctions);
        model.addAttribute("dictHierarchys", dictHierarchys);
		return "modules/sys/goodList";
	}
	/**
	 * 删除解决方案
	 * @author MingDing.Li
	 * @param good
	 * @param request
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "delete")
	public String delete(Goods good, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		if(good.getGoodsId() == null || "".equals(good.getGoodsId())){
			addMessage(redirectAttributes, "删除方案失败");
		    return "redirect:" + adminPath + "/sys/good/list?repage";
		}
		try {
			goodsService.deleteGoodById(good);
			addMessage(redirectAttributes, "删除方案成功");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "删除方案失败");
		}
	    return "redirect:" + adminPath + "/sys/good/list?repage";
	}
	/**
	 * 保存解决方案
	 * @author MingDing.Li
	 * @param good
	 * @param request
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "save")
	public String save(@RequestParam("file") CommonsMultipartFile[] files, Goods good, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		/** 存储文件 */
		good.setGoodsImage(saveFile(files, request, good.getGoodsName()));
		/** 图片不能为空 */
		if(good.getGoodsImage() == null || "".equals(good.getGoodsImage())){
			addMessage(redirectAttributes, "请上传方案图片");
			return form(good, model);
		}
		try {
			goodsService.saveGoods(good);
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, e.getMessage());
			return form(good, model);
		}
		return "redirect:" + adminPath + "/sys/good/list?repage";
	}
	
	/**
	 * 存储文件返回文件路径
	 * @author MingDing.Li
	 * @param files
	 * @param request
	 * @return
	 */
	private String saveFile(CommonsMultipartFile[] files,
			HttpServletRequest request, String goodsName) {
		/* */
		goodsName = new SimpleDateFormat("yyyyMMdd").format(new Date());
		
		String images = null;//全部路径和
		/* 获取 webpps绝对路径 */
		String webapps = request.getRealPath("/").substring(0, request.getRealPath("/").indexOf(request.getContextPath()));
		
		for(int i = 0;i<files.length;i++){  
			CommonsMultipartFile file =  files[i];
			if(!file.isEmpty()){ 
				String filePath = webapps + SystemEnum.WP_FILES_IMAGES_PATH + "/" + goodsName;
				String fileName = UUID.randomUUID().toString() + file.getFileItem().getName().substring(file.getFileItem().getName().lastIndexOf("."));
				File targetFile = new File(filePath, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				
				/* 保存文件 */
				try {
					file.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					WanPinExceptionCommon.runtimeException(file.getOriginalFilename()+" 上传失败!");
				}
				
				images = images + "," + SystemEnum.WP_FILES_IMAGES_PATH + "/" + goodsName + "/" + fileName;
			}
		}
		return images.substring(5, images.length());
	}
	/**
	 * 跳转到解决方案添加表单
	 * @author MingDing.Li
	 * @param good
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "form")
	public String form(Goods good, Model model) {
		/** 1.方案风格字典类型  */
		Dict dictStyleReq = new Dict();
		dictStyleReq.setType(SystemEnum.WP_GOODS_STYLE);
		List<Dict> dictStyles = dictService.findList(dictStyleReq);
		
		/** 2.方案功能字典类型  */
		Dict dictFunctionReq = new Dict();
		dictFunctionReq.setType(SystemEnum.WP_GOODS_FUNCTION);
		List<Dict> dictFunctions = dictService.findList(dictFunctionReq);
		
		/** 3.方案层数字典类型  */
		Dict dictHierarchyReq = new Dict();
		dictHierarchyReq.setType(SystemEnum.WP_GOODS_HIERARCHY);
		List<Dict> dictHierarchys = dictService.findList(dictHierarchyReq);
		
		model.addAttribute("good", good);
		model.addAttribute("dictStyles", dictStyles);
        model.addAttribute("dictFunctions", dictFunctions);
        model.addAttribute("dictHierarchys", dictHierarchys);
		return "modules/sys/goodForm";
	}
}
