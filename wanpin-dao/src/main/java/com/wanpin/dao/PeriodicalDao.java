package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.Periodical;

/**
 * <p>期刊dao</p>
 * @author litr 2016年6月17日
 * @version 1.0
 */
@MyBatisDao
public interface PeriodicalDao extends CrudDao<Periodical>{

}
