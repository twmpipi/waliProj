package com.twm.wali.logic.serveice;

import java.util.List;

import com.twm.wali.db.dto.UserSimInfo;

/**
 * XXX服務 介面
 */
public interface DoXXXService {
	
	/**
	 * XXX查詢服務
	 * @param userSimInfo 查詢條件
	 * @return List<UserSimInfo> 物件列表
	 */
	public List<UserSimInfo> doSearchXXX(UserSimInfo userSimInfo);
	
	/**
	 * XXX新增服務
	 * @param userSimInfo 新增物件
	 * @return boolean 成功/失敗
	 */
	public boolean doAddXXX(UserSimInfo userSimInfo);

}