package com.wanpin.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wanpin.dao.DictDao;
import com.wanpin.entity.Dict;
import com.wanpin.query.DictQuery;
import com.wanpin.service.DictService;
import com.wanpin.service.DictValService;
@Service("dictService")
public class DictServiceImple implements DictService {
	
	@Autowired
	private DictDao dictDao;
	
	@Autowired
	private DictValService dictValService;

	@Override
	public List<Dict> queryList(DictQuery queryObject) {
		return dictDao.queryList(queryObject);
	}

	@Override
	public Dict getInfo(String dictCode) {
		if (StringUtils.hasText(dictCode)) {
			return dictDao.getInfo(dictCode);
		}
		return null;
	}

	@Override
	public void delete(String dictCode) {
		if (StringUtils.hasText(dictCode)) {
			dictValService.deleteByDictCode(dictCode);
			Dict d = new Dict();
			dictDao.delete(d);
		}
	}

}
