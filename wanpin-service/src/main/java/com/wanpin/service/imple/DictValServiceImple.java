package com.wanpin.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wanpin.dao.DictValDao;
import com.wanpin.entity.DictVal;
import com.wanpin.query.DictValQuery;
import com.wanpin.service.DictValService;
@Service("dictValService")
public class DictValServiceImple implements DictValService {
	
	@Autowired
	private DictValDao dictValDao;

	@Override
	public List<DictVal> queryList(String dictCode) {
		if (StringUtils.hasText(dictCode)) {
			DictValQuery queryObject = new DictValQuery();
			queryObject.setUsePage(false);
			queryObject.setIsValid(1);
			queryObject.setDictCode(dictCode);
			return dictValDao.queryList(queryObject);
		}
		return null;
	}

	@Override
	public DictVal getInfo(Long dictValId) {
		if (dictValId != null) {
			return dictValDao.get(dictValId);
		}
		return null;
	}
	
	@Override
	public void save(DictVal dictVal) {
		if (dictVal.getDictValId() == null) {
			dictValDao.insert(dictVal);
		} else {
			dictValDao.update(dictVal);
		}
	}

	@Override
	public void deleteByDictCode(String dictCode) {
		if (StringUtils.hasText(dictCode)) {
			DictVal dv = new DictVal();
			dv.setDictCode(dictCode);
			dictValDao.delete(dv);
		}
	}

	@Override
	public void deleteById(Long dictValId) {
		if (dictValId != null) {
			DictVal dv = new DictVal();
			dv.setDictValId(dictValId);
			dictValDao.delete(dv);
		}
	}

}
