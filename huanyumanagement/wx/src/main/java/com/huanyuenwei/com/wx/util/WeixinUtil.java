package com.huanyuenwei.com.wx.util;

import com.huanyuenwei.com.wx.entity.AccessToken;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class WeixinUtil {
//	private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);  
	// 获取access_token的接口地址（GET） 限200（次/天）  
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//                                                 https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET

	public final String requestUrl =              "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 菜单创建（POST） 限100（次/天）  
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	//公众号获取用户信息接口
	public static String user_message_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";



	/**
	 * 小程序获取token
	 * @param

	 * @throws IOException
	 */
	public static AccessToken smallgetToken(String wxServiceAppid, String wxServiceSecret) throws JSONException {
		String requestUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+wxServiceAppid+"&secret="+wxServiceSecret;
		String result=HttpRequest.sendGet(requestUrl, "GET");
		JSONObject jsonResult = new JSONObject(result);
		System.out.println(jsonResult);
		if(jsonResult!=null){
			String access_token=jsonResult.getString("access_token");
			System.out.println(access_token);
			AccessToken accessToken = new AccessToken();
			accessToken.setToken(access_token);
			accessToken.setExpiresIn(7200);
			return accessToken;
		}else{
			return null;
		}
	}


    /** 
	 * 获取access_token 
	 *  
	 * @param appid 凭证 
	 * @param appsecret 密钥 
	 * @return 
	 */  
	public static AccessToken getAccessToken(String appid, String appsecret) throws JSONException {
	    AccessToken accessToken = null;
	  
	    String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		String resutlt = HttpRequest.sendGet(requestUrl, "");
		JSONObject jsonObject = new JSONObject(resutlt);
		// 如果请求成功
	    if (null != jsonObject) {  
	        try {  
	            accessToken = new AccessToken();
	            accessToken.setToken(jsonObject.getString("access_token"));  
	            accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
	            
	        } catch (Exception e) {
	            accessToken = null;  
	            // 获取token失败  
	            System.out.println("获取token失败 errcode:"+jsonObject.getInt("errcode")+"errmsg:"+jsonObject.getString("errmsg"));
//	            log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
	        }  
	    }  
	    return accessToken;  
	}


}
