package com.twm.wali.rest.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.twm.wali.db.dto.UserSimInfo;
import com.twm.wali.logic.serveice.DoXXXService;



@Path("/waliServer")
@Scope("singleton")
public class RestWaliServer {
	
	/* Log4j */
	 private static Logger log = LogManager.getLogger(RestWaliServer.class);

	@Autowired
	private  DoXXXService doXXXService;
	
//    @Autowired
//    private NamedParameterJdbcTemplate jdbcTemplate;

    @GET  //标注方法对应的HTTP请求类型
    @Path("/v1.0/get/{sid}")  //标注方法的相对路径
    @Produces(MediaType.APPLICATION_JSON) //标注返回的MIME媒体类型
    @Consumes(MediaType.APPLICATION_JSON)
    public List<UserSimInfo> getUserSimInfo(@PathParam("sid") String sid) {
    	log.info("getUserSimInfo() start.");
    	
    	List<UserSimInfo> result = new ArrayList<UserSimInfo>();
    	
    	UserSimInfo userSimInfo = new UserSimInfo(); 	// 查詢物件
    	userSimInfo.setsId(Integer.parseInt(sid));
    	
    	result = this.doXXXService.doSearchXXX(userSimInfo);
    	log.debug("result="+result);

        return result;
    }
    //请求地址：http://localhost:8080/waliProj/rest/waliServer/v1.0/get/1
    //返回数据：[{"createDate":"2017-05-07T00:00:00+08:00","iccId":"00000001","isEnable":false,"jointSim":0,"sId":1,"updateDate":"2017-08-07T00:00:00+08:00","waliId":1000}]

    @POST
    @Path("/v1.0/post")
    @Produces(MediaType.APPLICATION_JSON) //标注返回的MIME媒体类型
    public void AddUserSimInfo(String jsonObj){
    	log.info("AddUserSimInfo() start.");
    	UserSimInfo paramUserSimInfo;	// 參數物件
    	Gson gson = new Gson();			// 建立Gson物件
    	
    	Boolean result = false;
    	try {
    		paramUserSimInfo = gson.fromJson(jsonObj, UserSimInfo.class);	// json轉換成參數物件
    		result = this.doXXXService.doAddXXX(paramUserSimInfo);
    		
		} catch (JsonSyntaxException e) {
			log.error("gson format error! jsonObj=" + jsonObj);
			e.printStackTrace();
		}

        log.debug("post method Insert result: "+result);
    	
      //请求地址：http://localhost:8080/waliProj/rest/waliServer/v1.0/post
    	
    }
    
    
//    @GET
//    @Path("/user/{param}")
//    public String userInfo1(@PathParam("param")
//    String userName) {
//        String str = demoService.say();
//        return str + userName;
//    }
//    //请求地址：http://localhost:8080/jersey_spring/rest/hello/user/lixue
//    //返回数据：Hello Jerseylixue
//
//    public void setDemoService(DemoService demoService) {
//        this.demoService = demoService;
//    }

    //@Consumes，标注可接受请求的MIME媒体类型
    //@PathParam，@QueryParam，@HeaderParam，@CookieParam，@MatrixParam，@FormParam
    //分别标注方法的参数来自于HTTP请求的不同位置.
    //例如@PathParam来自于URL的路径，
    //@QueryParam来自于URL的查询参数，
    //@CookieParam来自于HTTP请求的Cookie。
    
    
    
    public static void main(String[] args) {
		
    	String json = "{'createDate':'2017-05-27T00:00:00+08:00','iccId':'00000010','isEnable':false,'jointSim':1,'sId':10,'updateDate':'2017-08-07T00:00:00+08:00','waliId':1009}";
    	
    	Gson gson = new Gson();
    	UserSimInfo info = gson.fromJson(json, UserSimInfo.class);
    	System.out.println(info);
    	
    }
    	
    
    
    

}