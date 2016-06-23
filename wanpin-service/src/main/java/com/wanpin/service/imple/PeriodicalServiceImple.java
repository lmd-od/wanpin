package com.wanpin.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wanpin.dao.PeriodicalDao;
import com.wanpin.dao.PeriodicalItemDao;
import com.wanpin.entity.Periodical;
import com.wanpin.entity.PeriodicalItem;
import com.wanpin.service.PeriodicalService;
@Service("periodicalService")
public class PeriodicalServiceImple implements PeriodicalService {
	
	@Autowired
	private PeriodicalDao periodicalDao;
	
	@Autowired
	private PeriodicalItemDao periodicalItemDao;

	@Override
	public Periodical getByPeriodicalId(Long periodicalId) throws Exception {
		if (periodicalId != null) {
			Periodical p = new Periodical();
			p.setPeriodicalId(periodicalId);
			Periodical periodical = periodicalDao.get(p);
			if (periodical != null) {
				PeriodicalItem pi = new PeriodicalItem();
				pi.setPeriodicalId(periodicalId);
				periodical.setPeriodicalItems(periodicalItemDao.findAllList(pi));
			}
			return periodical;
		}
		return null;
	}

	@Override
	public Periodical getByBelongProduct(String belongProduct) throws Exception {
		if (StringUtils.hasText(belongProduct)) {
			Periodical p = new Periodical();
			p.setBelongProduct(belongProduct);
			Periodical periodical = periodicalDao.get(p);
			if (periodical != null) {
				PeriodicalItem pi = new PeriodicalItem();
				pi.setPeriodicalId(periodical.getPeriodicalId());
				periodical.setPeriodicalItems(periodicalItemDao.findAllList(pi));
			}
			return periodical;
		}
		return null;
	}


}
