package com.twm.wali.db.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.twm.wali.db.dao.UserSimInfoDao;
import com.twm.wali.db.dto.UserSimInfo;

/**
 * JDBC DAO 實作
 */
@Repository("jdbcUserSimInfoDao")
public class UserSimInfoDaoImpl implements UserSimInfoDao {
	
	/* Log4j */
	 private static Logger log = LogManager.getLogger(UserSimInfoDaoImpl.class);

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<UserSimInfo> findUserSimInfo(UserSimInfo userSimInfo) {
		log.debug("findUserSimInfo() start.");
		
		List<UserSimInfo> resultList = new ArrayList<UserSimInfo>();
		if(userSimInfo != null && userSimInfo.getsId() != null ){
			try {	
				log.debug("Search Param: Sid="+userSimInfo.getsId());
				SqlParameterSource ps=new BeanPropertySqlParameterSource(userSimInfo); //将user实例和sql中的：xx进行对应  
				resultList = this.jdbcTemplate.query("select * from usersiminfo where sid = :sId", ps, new BeanPropertyRowMapper(UserSimInfo.class));
			} catch (DataAccessException e) {
				log.error("UserSimInfo Search Fail: "+ e.getMessage());
				e.printStackTrace();
			}
		}
		return resultList;
	}

	@Override
	public Integer addUserSimInfo(UserSimInfo userSimInfo) {
		log.debug("addUserSimInfo() start.");

		Integer resultInt = 0;
        
    	try {
    		String sql="insert into usersiminfo values(:sId,:waliId,:iccId,:myfareId,:jointSim,:isEnable,:createDate,:updateDate)";  //:后面的名称必须和物件属性名称一样   

    		log.debug("Add Param"+userSimInfo);

    		SqlParameterSource ps=new BeanPropertySqlParameterSource(userSimInfo);   
			KeyHolder keyholder=new GeneratedKeyHolder();   		//加上KeyHolder这个参数可以得到添加后主键的值  
			resultInt = jdbcTemplate.update(sql, ps,keyholder);  

			/* 查看主鍵值 */
			Number pk=keyholder.getKey();
			//Map map=keyholder.getKeys();//这样可以得到联合主键的值   
	        //keyholder.getKeyList();//这样可以得到一些主主键值，若一次添加好几条记录
			log.debug("PRIMARY KEY: "+ pk);   
			
		} catch (InvalidDataAccessApiUsageException e) {
			log.error("addUserSimInfo Add Fail: "+ e.getMessage());
			e.printStackTrace();
		} catch (DataAccessException e) {
			log.error("addUserSimInfo Add Fail: "+ e.getMessage());
			e.printStackTrace();
		}   
		
		return resultInt;
	}

}
