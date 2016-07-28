package com.wanpin.service;

import java.util.List;

import com.wanpin.entity.UserGoods;
import com.wanpin.query.UserGoodsQuery;
import com.wanpin.vo.GoodsVO;

public interface UserGoodsService {

	public List<GoodsVO> queryUserGoods(UserGoodsQuery queryObject) throws Exception;
	
	/**
	 * <p>通过用户ID和方案ID查询收藏信息</p>
	 * @author litr 2016年6月8日
	 * @param userId 用户ID
	 * @param goodsId 方案ID
	 * @throws Exception
	 */
	public UserGoods getByUserIdAndGoodsId(Long userId,Long goodsId) throws Exception;
	
	/**
	 * <p>保存用户收藏信息</p>
	 * @author litr 2016年6月8日
	 * @param userGoods
	 * @throws Exception
	 */
	public void save(UserGoods userGoods) throws Exception;
	
	/**
	 * <p>通过收藏ID删除用户收藏信息</p>
	 * @author litr 2016年6月8日
	 * @param userGoodsIds
	 * @throws Exception
	 */
	public void deleteByUserGoodsIds(Long... userGoodsIds) throws Exception;
	
	/**
	 * <p>通过用户ID或方案ID数组删除收藏信息</p>
	 * @author litr 2016年6月8日
	 * @param userId 用户ID
	 * @param goodsIds 方案ID可变数组
	 * @throws Exception
	 */
	public void deleteByUserIdAndGoodsIds(Long userId,Long... goodsIds) throws Exception;
	
}
