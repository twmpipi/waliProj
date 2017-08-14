package com.twm.wali.logic.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.twm.wali.db.dao.UserSimInfoDao;
import com.twm.wali.db.dto.UserSimInfo;
import com.twm.wali.logic.serveice.DoXXXService;

/**
 * XXX服務 實作
 *
 */
@Service("doXXXService")
public class DoXXXServiceImpl implements DoXXXService {

	/* Log4j */
	 private static Logger log = LogManager.getLogger(DoXXXServiceImpl.class);
	 
	@Autowired
	@Qualifier("jdbcUserSimInfoDao") // 欲使用jdbc DAO時,增加此行
	private UserSimInfoDao userSimInfoDao;
	
	
	@Override
	public List<UserSimInfo> doSearchXXX(UserSimInfo userSimInfo) {
		log.debug("doSearchXXX() start.");
		
		// ...
log.debug(">>>>>>>>>> " +this.userSimInfoDao.getClass());
		return this.userSimInfoDao.findUserSimInfo(userSimInfo);
	}

	@Override
	public boolean doAddXXX(UserSimInfo userSimInfo) {
		log.debug("doAddXXX() start.");
		
log.debug(">>>>>>>>>> " +this.userSimInfoDao.getClass());
		Integer resultInt;
		
		if(userSimInfo != null && userSimInfo.getsId() != null){
			log.debug("userSimInfo is not null and Sid ="+userSimInfo.getsId());
			
			// logic...
		
			resultInt = this.userSimInfoDao.addUserSimInfo(userSimInfo);
			log.debug("Service Insert userSimInfo " + (resultInt == 1 ? "Success." : "Fail."));

			return resultInt == 1;
		}else{
			log.warn("userSimInfo is null or Sid is null.");
			return false;
		}
	}

}
