package com.wanpin.common.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
/**
 * 日期转换器
 * <p>作为<code>org.springframework.core.convert.converter.Converter</code>接口的实现类。
 *    主要用于SpringMVC中，将请求参数中的日期字符串转化为<code>java.util.Date</code>类型。也可以作为日期转换工具类来使用。
 * </p>
 * <p><code>patterns:</code>用来指定可转换的日期格式集合。
 *    转换器会遍历<code>patterns</code>，找出与待转换的字符串能够精确匹配的格式进行转换。
 * </p>
 * @author litr 2016年5月31日
 * @version 1.0
 */
public class DateConverter implements Converter<String, Date> {

	private final String LONG_DATA_FMT = "yyyy-MM-dd HH:mm:ss";
	private final String SHORT_DATA_FMT = "yyyy-MM-dd";

	private String[] patterns = new String[] { LONG_DATA_FMT, SHORT_DATA_FMT };

	public Date convert(String text) {
		Date date = null;
		try {
			date = parseText(text);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return date;
	}

	private Date parseText(String text) throws IllegalArgumentException {
		if (!StringUtils.hasText(text))
			return null;
		Date date = null;
		for (String pattern : patterns) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			dateFormat.setLenient(false);
			try {
				date = dateFormat.parse(text);
				break;
			} catch (ParseException e) {
				continue;
			}
		}
		if (date == null) {
			throw new IllegalArgumentException("解析日期失败：无法将待转换的字符串(" + text + ")转换为日期类型！");
		}
		return date;
	}

	public void setPatterns(String[] patterns) {
		this.patterns = patterns;
	}

}
