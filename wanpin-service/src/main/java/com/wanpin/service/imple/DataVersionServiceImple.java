package com.wanpin.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wanpin.dao.DataVersionDao;
import com.wanpin.entity.DataVersion;
import com.wanpin.query.DataVersionQuery;
import com.wanpin.service.DataVersionService;
@Service("dataVersionService")
public class DataVersionServiceImple implements DataVersionService {
	
	@Autowired
	private DataVersionDao dataVersionDao;

	@Override
	public List<DataVersion> queryList(DataVersionQuery queryObject) throws Exception {
		return dataVersionDao.queryList(queryObject);
	}
	
	@Override
	public DataVersion getByDataCode(String dataCode) throws Exception {
		if (StringUtils.hasText(dataCode)) {
			DataVersion dv = new DataVersion();
			dv.setVersion(dataCode);
			return dataVersionDao.get(dv);
		}
		return null;
	}

}
