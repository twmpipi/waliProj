/**
 * @desc RestClientTest.java
 * @author  DennisTsai
 * @date  2017年8月7日
 *
 */

package com.twm.wali.rest.client;

import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import com.twm.wali.db.dto.UserSimInfo;

@Path("/waliClient")
public class RestClientTest {

	/* Log4j */
	 private static Logger log = LogManager.getLogger(RestClientTest.class);
	 
	public void queryData() {
		log.info("queryData() start.");
		ClientConfig clientConfig = new ClientConfig();

		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://localhost:8080").path("/waliProj/rest/waliServer/v1.0/get/11");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		log.debug("response status:" + response.getStatus() + ", response status Info:"+response.getStatusInfo());

		if (response.getStatus() == 200) {

			String output = response.readEntity(String.class);
			log.debug("query Success, result:" + output);

		}else{
			log.error("query fail. response.getStatus:"+response.getStatus());
		}
	}

	public void postMethod() {
		log.info("postMethod() start.");

		Client client = ClientBuilder.newClient();
		UserSimInfo simInfo = new UserSimInfo();
		simInfo.setsId(11);
		simInfo.setWaliId(9090099);
		simInfo.setIccId("999999");
		simInfo.setMyfareId("8888888");
		simInfo.setJointSim(1);
		simInfo.setIsEnable(true);
		simInfo.setCreateDate(new Date());
		simInfo.setUpdateDate(new Date());

		Response response = client.target("http://localhost:8080/waliProj/rest/waliServer/v1.0/post").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(simInfo, MediaType.APPLICATION_JSON));
//		processresponse(response); //This could be any method which processes your json response and gets you your desired data.
		log.debug("add result:"+response.readEntity(String.class));
        System.out.println(response.readEntity(String.class));

//		String result = response.readEntity(String.class);

	}

	public static void main(String[] args) {
		RestClientTest clientTest = new RestClientTest();
		clientTest.queryData();
		System.out.println("----------------------------------------------------");
		clientTest.postMethod();

//		JDBCDataSource dataSource = new JDBCDataSource();
//		dataSource.setUrl("jdbc:hsqldb:file:src/main/resources/db/dvd_library");
//		dataSource.setUser("sa");
//		dataSource.setPassword("");
//
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//		jdbcTemplate.update("INSERT INTO USERSIMINFO(SID) values(?)", 1);
//
//		Integer result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USERSIMINFO WHERE SID=?", new Object[] { 1 },
//				Integer.class);
//
//		System.out.println(">>> " + result);
	}

	// =============================================== //
	// =============== Static Area =================== //
	// =============================================== //

	// =============================================== //
	// =============== Attribute Area ================ //
	// =============================================== //

	// =============================================== //
	// =============== Construct Area ================ //
	// =============================================== //

	// =============================================== //
	// =============== Public Method Area ============ //
	// =============================================== //

	// =============================================== //
	// =============== Private Method Area =========== //
	// =============================================== //

	// =============================================== //
	// =============== Getter & Setter Area ========== //
	// =============================================== //

}
