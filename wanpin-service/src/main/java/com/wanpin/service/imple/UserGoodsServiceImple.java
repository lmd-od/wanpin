package com.wanpin.service.imple;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanpin.dao.UserGoodsDao;
import com.wanpin.entity.UserGoods;
import com.wanpin.query.UserGoodsQuery;
import com.wanpin.service.UserGoodsService;
import com.wanpin.vo.GoodsVO;
@Service("userGoodsService")
public class UserGoodsServiceImple implements UserGoodsService {
	
	@Autowired
	private UserGoodsDao userGoodsDao;

	@Override
	public List<GoodsVO> queryUserGoods(UserGoodsQuery queryObject) throws Exception {
		return userGoodsDao.queryUserGoods(queryObject);
	}
	
	@Override
	public UserGoods getByUserIdAndGoodsId(Long userId, Long goodsId) throws Exception {
		if (userId != null && goodsId != null) {
			UserGoods userGoods = new UserGoods();
			userGoods.setUserId(userId);
			userGoods.setGoodsId(goodsId);
			return userGoodsDao.get(userGoods);
		}
		return null;
		
	}

	@Override
	public void save(UserGoods userGoods) throws Exception {
		if (userGoods != null && userGoods.getUserGoodsId() == null) {
			userGoods.setCollectTime(new Date());
			userGoodsDao.insert(userGoods);
		}
	}

	@Override
	public void deleteByUserGoodsIds(Long... userGoodsIds) throws Exception {
		if (userGoodsIds != null && userGoodsIds.length > 0) {
			UserGoods userGoods = new UserGoods();
			for (Long userGoodsId : userGoodsIds) {
				userGoods.setUserGoodsId(userGoodsId);
				userGoodsDao.delete(userGoods);
			}
		}
	}

	@Override
	public void deleteByUserIdAndGoodsIds(Long userId, Long... goodsIds) throws Exception {
		if (userId == null && (goodsIds == null || goodsIds.length == 0)) {
			return;
		}
		
		UserGoods userGoods = new UserGoods();
		userGoods.setUserId(userId);
		if (goodsIds != null && goodsIds.length > 0) {
			for (Long goodsId : goodsIds) {
				userGoods.setGoodsId(goodsId);
				userGoodsDao.delete(userGoods);
			}
		} else {
			userGoodsDao.delete(userGoods);
		}
	}

}
