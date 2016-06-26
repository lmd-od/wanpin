
package com.wanpin.dao;


import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.SmsSendRec;

/**
 * <p>短信发送记录DAO</p>
 * @author litr 2016年6月24日
 * @version 1.0
 */
@MyBatisDao
public interface SmsSendRecDao extends CrudDao<SmsSendRec>  {

}
