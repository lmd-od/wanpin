package com.wanpin.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wanpin.dao.SmsSendRecDao;
import com.wanpin.entity.SmsSendRec;
import com.wanpin.service.SmsSendRecService;
@Service("smsSendRecService")
public class SmsSendRecServiceImple implements SmsSendRecService {
	
	@Autowired
	private SmsSendRecDao smsSendRecDao;

	@Override
	public SmsSendRec getByMobile(String mobile) throws Exception {
		if (StringUtils.hasText(mobile)) {
			SmsSendRec rec = new SmsSendRec();
			rec.setMobile(mobile);
			return smsSendRecDao.get(rec);
		}
		return null;
	}

	@Override
	public SmsSendRec getByIp(String ip) throws Exception {
		if (StringUtils.hasText(ip)) {
			SmsSendRec rec = new SmsSendRec();
			rec.setIp(ip);
			return smsSendRecDao.get(rec);
		}
		return null;
	}

	@Override
	public void save(SmsSendRec smsSendRec) throws Exception {
		if (StringUtils.isEmpty(smsSendRec.getSendRecId())) {
			smsSendRecDao.insert(smsSendRec);
		}
		
	}

	@Override
	public void saveList(List<SmsSendRec> smsSendRecs) throws Exception {
		if (smsSendRecs != null && smsSendRecs.size() > 0) {
			for (SmsSendRec rec : smsSendRecs) {
				save(rec);
			}
		}
	}

	

}
