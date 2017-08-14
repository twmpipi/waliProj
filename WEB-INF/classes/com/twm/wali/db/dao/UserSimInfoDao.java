package com.twm.wali.db.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.twm.wali.db.dto.UserSimInfo;

/**
 *  JDBC DAO 介面
 */
public interface UserSimInfoDao {
	
	/**
	 * 查詢 UserSimInfo
	 * @param userSimInfo 查詢條件
	 * @return List<UserSimInfo> 物件列表
	 */
	public List<UserSimInfo> findUserSimInfo(UserSimInfo userSimInfo);
	
	/**
	 *  新增 UserSimInfo
	 * @param userSimInfo
	 * @return Integer 成功/失敗
	 */
	public Integer addUserSimInfo(UserSimInfo userSimInfo);

}
