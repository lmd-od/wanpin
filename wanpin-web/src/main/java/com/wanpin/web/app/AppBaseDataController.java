package com.wanpin.web.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.utils.WanpinUtils;
import com.wanpin.entity.DataVersion;
import com.wanpin.entity.Periodical;
import com.wanpin.entity.PeriodicalItem;
import com.wanpin.service.DataVersionService;
import com.wanpin.service.PeriodicalService;
import com.wanpin.web.BaseController;

@Controller
@RequestMapping("${appAdminPath}/basedata")
public class AppBaseDataController extends BaseController {
	
	@Autowired
	private DataVersionService dataVersionService;
	
	@Autowired
	private PeriodicalService periodicalService;

	/**
	 * <p>获取基础数据版本</p>
	 * @author litr 2016年6月17日
	 * @param dataCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getVersion${urlSuffix}")
	@ResponseBody
	public Object getVersion(String dataCode)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			if (StringUtils.hasText(dataCode)) {
				DataVersion dataVersion = dataVersionService.getByDataCode(dataCode.toUpperCase());
				if (dataVersion == null) {
					WanpinUtils.organizeData(model, StatusCodes.INVALID_PARAMETER);
				} else {
					data.put("version", dataVersion.getVersion());
					WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
				}
			} else {
				List<DataVersion> dataVersions = dataVersionService.queryList(null);
				data.put("dataVersions", dataVersions);
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
				// return dataVersions;
			}
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>获取期刊数据</p>
	 * @author litr 2016年6月17日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getPeriodicals${urlSuffix}")
	@ResponseBody
	public Object getPeriodicals(String belongProduct)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(belongProduct)) {
				WanpinUtils.organizeData(model, StatusCodes.MUST_PARAMETER_NULL);
			} else {
				Periodical periodical = periodicalService.getByBelongProduct("20");
				if (periodical != null) {
					List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
					for (PeriodicalItem pi : periodical.getPeriodicalItems()) {
						Map<String, Object> item = new HashMap<String, Object>();
						item.put("imgUrl", WanpinUtils.IMG_PREFIX+pi.getImgUrl());
						item.put("detailsUrl", pi.getDetailsUrl());
						// WanpinUtils.removeMapValueIsNull(item);
						items.add(item);
					}
					data.put("periodicalItems", items);
					WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
				} else {
					WanpinUtils.organizeData(model, StatusCodes.PERIODICAL_NULL);
				}
			}
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>获取所有基础数据</p>
	 * @author litr 2016年6月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getBaseData${urlSuffix}")
	@ResponseBody
	public Object getBaseData()throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			// 方案风格(欧式/中式等)
			List<Map<String, Object>> goodsStyle = new ArrayList<Map<String, Object>>();
			Map<String, Object> s1 = new HashMap<String, Object>();
			s1.put("value", "1000");
			s1.put("label", "中式");
			Map<String, Object> s2 = new HashMap<String, Object>();
			s2.put("value", "1001");
			s2.put("label", "欧式");
			goodsStyle.add(s1);
			goodsStyle.add(s2);
			// 方案功能(工业/农用/居住等)
			List<Map<String, Object>> goodsFunction = new ArrayList<Map<String, Object>>();
			Map<String, Object> f1 = new HashMap<String, Object>();
			f1.put("value", "2000");
			f1.put("label", "居住");
			Map<String, Object> f2 = new HashMap<String, Object>();
			f2.put("value", "2001");
			f2.put("label", "公用");
			Map<String, Object> f3 = new HashMap<String, Object>();
			f3.put("value", "2002");
			f3.put("label", "工业");
			Map<String, Object> f4 = new HashMap<String, Object>();
			f4.put("value", "2003");
			f4.put("label", "农业");
			goodsFunction.add(f1);
			goodsFunction.add(f2);
			goodsFunction.add(f3);
			goodsFunction.add(f4);
			// 方案层数(底层/中层/高层)
			List<Map<String, Object>> goodsHierarchy = new ArrayList<Map<String, Object>>();
			Map<String, Object> h1 = new HashMap<String, Object>();
			h1.put("value", "3000");
			h1.put("label", "底层");
			Map<String, Object> h2 = new HashMap<String, Object>();
			h2.put("value", "3001");
			h2.put("label", "中层");
			Map<String, Object> h3 = new HashMap<String, Object>();
			h3.put("value", "3002");
			h3.put("label", "高层");
			goodsHierarchy.add(h1);
			goodsHierarchy.add(h2);
			goodsHierarchy.add(h3);
			// 性别
			List<Map<String, Object>> sex = new ArrayList<Map<String, Object>>();
			Map<String, Object> sex1 = new HashMap<String, Object>();
			sex1.put("value", "0");
			sex1.put("label", "男");
			Map<String, Object> sex2 = new HashMap<String, Object>();
			sex2.put("value", "1");
			sex2.put("label", "女");
			Map<String, Object> sex3 = new HashMap<String, Object>();
			sex3.put("value", "2");
			sex3.put("label", "保密");
			sex.add(sex1);
			sex.add(sex2);
			sex.add(sex3);
			// 国别
			List<Map<String, Object>> country = new ArrayList<Map<String, Object>>();
			Map<String, Object> c1 = new HashMap<String, Object>();
			c1.put("value", "CHN");
			c1.put("label", "中国");
			Map<String, Object> c7 = new HashMap<String, Object>();
			c7.put("value", "GBR");
			c7.put("label", "英国");
			Map<String, Object> c2 = new HashMap<String, Object>();
			c2.put("value", "USA");
			c2.put("label", "美国");
			Map<String, Object> c3 = new HashMap<String, Object>();
			c3.put("value", "FRA");
			c3.put("label", "法国");
			Map<String, Object> c4 = new HashMap<String, Object>();
			c4.put("value", "DEU");
			c4.put("label", "德国");
			Map<String, Object> c5 = new HashMap<String, Object>();
			c5.put("value", "ITA");
			c5.put("label", "意大利");
			Map<String, Object> c6 = new HashMap<String, Object>();
			c6.put("value", "THA");
			c6.put("label", "泰国");
			Map<String, Object> c8 = new HashMap<String, Object>();
			c8.put("value", "AUS");
			c8.put("label", "澳大利亚");
			Map<String, Object> c9 = new HashMap<String, Object>();
			c9.put("value", "POL");
			c9.put("label", "波兰");
			Map<String, Object> c10 = new HashMap<String, Object>();
			c10.put("value", "CYP");
			c10.put("label", "塞浦路斯");
			country.add(c1);
			country.add(c2);
			country.add(c3);
			country.add(c4);
			country.add(c5);
			country.add(c6);
			country.add(c7);
			country.add(c8);
			country.add(c9);
			country.add(c10);
			// 学历
			List<Map<String, Object>> education = new ArrayList<Map<String, Object>>();
			Map<String, Object> e1 = new HashMap<String, Object>();
			e1.put("value", "1");
			e1.put("label", "初中及以下");
			Map<String, Object> e2 = new HashMap<String, Object>();
			e2.put("value", "2");
			e2.put("label", "高中");
			Map<String, Object> e3 = new HashMap<String, Object>();
			e3.put("value", "3");
			e3.put("label", "中技");
			Map<String, Object> e4 = new HashMap<String, Object>();
			e4.put("value", "4");
			e4.put("label", "中专");
			Map<String, Object> e5 = new HashMap<String, Object>();
			e5.put("value", "5");
			e5.put("label", "大专");
			Map<String, Object> e6 = new HashMap<String, Object>();
			e6.put("value", "6");
			e6.put("label", "本科");
			Map<String, Object> e7 = new HashMap<String, Object>();
			e7.put("value", "7");
			e7.put("label", "硕士");
			Map<String, Object> e8 = new HashMap<String, Object>();
			e8.put("value", "-1");
			e8.put("label", "MBA");
			Map<String, Object> e9 = new HashMap<String, Object>();
			e9.put("value", "8");
			e9.put("label", "博士");
			education.add(e1);
			education.add(e2);
			education.add(e3);
			education.add(e4);
			education.add(e5);
			education.add(e6);
			education.add(e7);
			education.add(e8);
			education.add(e9);
			data.put("goodsStyle", goodsStyle);
			data.put("goodsFunction", goodsFunction);
			data.put("goodsHierarchy", goodsHierarchy);
			data.put("sex", sex);
			data.put("country", country);
			data.put("education", education);
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>方案商城或引擎搜索页分类</p>
	 * @author litr 2016年8月1日
	 * @param place
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getSearch${urlSuffix}")
	@ResponseBody
	public Object getSearch(@RequestParam Integer place)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			// 方案风格(欧式/中式等)
			List<Map<String, Object>> goodsStyle = new ArrayList<Map<String, Object>>();
			Map<String, Object> s0 = new HashMap<String, Object>();
			s0.put("value", "");
			s0.put("label", "全部");
			Map<String, Object> s1 = new HashMap<String, Object>();
			s1.put("value", "1000");
			s1.put("label", "中式");
			Map<String, Object> s2 = new HashMap<String, Object>();
			s2.put("value", "1001");
			s2.put("label", "欧式");
			goodsStyle.add(s0);
			goodsStyle.add(s1);
			goodsStyle.add(s2);
			// 方案功能(工业/农用/居住等)
			List<Map<String, Object>> goodsFunction = new ArrayList<Map<String, Object>>();
			Map<String, Object> f0 = new HashMap<String, Object>();
			f0.put("value", "");
			f0.put("label", "全部");
			Map<String, Object> f1 = new HashMap<String, Object>();
			f1.put("value", "2000");
			f1.put("label", "居住");
			Map<String, Object> f2 = new HashMap<String, Object>();
			f2.put("value", "2001");
			f2.put("label", "公用");
			Map<String, Object> f3 = new HashMap<String, Object>();
			f3.put("value", "2002");
			f3.put("label", "工业");
			Map<String, Object> f4 = new HashMap<String, Object>();
			f4.put("value", "2003");
			f4.put("label", "农业");
			goodsFunction.add(f0);
			goodsFunction.add(f1);
			goodsFunction.add(f2);
			goodsFunction.add(f3);
			goodsFunction.add(f4);
			// 方案层数(底层/中层/高层)
			List<Map<String, Object>> goodsHierarchy = new ArrayList<Map<String, Object>>();
			Map<String, Object> h1 = new HashMap<String, Object>();
			h1.put("value", "3000");
			h1.put("label", "底层");
			Map<String, Object> h2 = new HashMap<String, Object>();
			h2.put("value", "3001");
			h2.put("label", "中层");
			Map<String, Object> h3 = new HashMap<String, Object>();
			h3.put("value", "3002");
			h3.put("label", "高层");
			goodsHierarchy.add(h1);
			goodsHierarchy.add(h2);
			goodsHierarchy.add(h3);
			// 国别
			List<Map<String, Object>> country = new ArrayList<Map<String, Object>>();
			Map<String, Object> c1 = new HashMap<String, Object>();
			c1.put("value", "CHN");
			c1.put("label", "中国");
			Map<String, Object> c7 = new HashMap<String, Object>();
			c7.put("value", "GBR");
			c7.put("label", "英国");
			Map<String, Object> c2 = new HashMap<String, Object>();
			c2.put("value", "USA");
			c2.put("label", "美国");
			Map<String, Object> c3 = new HashMap<String, Object>();
			c3.put("value", "FRA");
			c3.put("label", "法国");
			Map<String, Object> c4 = new HashMap<String, Object>();
			c4.put("value", "DEU");
			c4.put("label", "德国");
			Map<String, Object> c5 = new HashMap<String, Object>();
			c5.put("value", "ITA");
			c5.put("label", "意大利");
			Map<String, Object> c6 = new HashMap<String, Object>();
			c6.put("value", "THA");
			c6.put("label", "泰国");
			Map<String, Object> c8 = new HashMap<String, Object>();
			c8.put("value", "AUS");
			c8.put("label", "澳大利亚");
			Map<String, Object> c9 = new HashMap<String, Object>();
			c9.put("value", "POL");
			c9.put("label", "波兰");
			Map<String, Object> c10 = new HashMap<String, Object>();
			c10.put("value", "CYP");
			c10.put("label", "塞浦路斯");
			country.add(c1);
			country.add(c2);
			country.add(c3);
			country.add(c4);
			country.add(c5);
			country.add(c6);
			country.add(c7);
			country.add(c8);
			country.add(c9);
			country.add(c10);
			Map<String, Object> data1 = new HashMap<String, Object>();
			Map<String, Object> data2 = new HashMap<String, Object>();
			Map<String, Object> data3 = new HashMap<String, Object>();
			Map<String, Object> data4 = new HashMap<String, Object>();
			data1.put("name", "风格");
			data1.put("param", "goodsStyle");
			data1.put("values", goodsStyle);
			data2.put("name", "功能");
			data2.put("param", "goodsFunction");
			data2.put("values", goodsFunction);
			data3.put("name", "层数");
			data3.put("param", "goodsHierarchy");
			data3.put("values", goodsHierarchy);
			data4.put("name", "国别");
			data4.put("param", "countryCode");
			data4.put("values", country);
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			dataList.add(data1);
			dataList.add(data2);
			dataList.add(data3);
			dataList.add(data4);
			data.put("dataList", dataList);
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
			// WanpinUtils.organizeData(model, StatusCodes.SUCCESS, dataList);
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
}
