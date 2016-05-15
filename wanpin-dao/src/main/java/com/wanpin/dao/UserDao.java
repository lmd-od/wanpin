
package com.wanpin.dao;


import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.User;

/**
* @Description: 用户 Dao
* @author MingDingLi
* @date 2016年2月26日 上午11:41:55
 */
@MyBatisDao
public interface UserDao extends CrudDao<User>  {

}
