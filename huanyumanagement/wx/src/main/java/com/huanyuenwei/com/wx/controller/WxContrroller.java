package com.huanyuenwei.com.wx.controller;


import com.huanyuenwei.com.wx.common.WxResult;
import com.huanyuenwei.com.wx.entity.AccessToken;
import com.huanyuenwei.com.wx.util.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/wx")
public class WxContrroller {

    @Value("${wx.smallRoutineApplid}")
    private String smallRoutineApplid;

    @Value("${wx.smallRoutineSecret}")
    private String smallRoutineSecret;

    @Autowired
    private WechatController wechatController;


    //获取用户所有信息
    @RequestMapping(value = "/decodeUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map decodeUserInfo(String encryptedData, String iv, String code) throws JSONException {
        System.out.println("encData是" + encryptedData);
        System.out.println("iv是" + iv);
        System.out.println("code是" + code);
        Map map = new HashMap();
        // 登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = smallRoutineApplid;
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = smallRoutineSecret;
        // 授权（必填）
        String grant_type = "authorization_code";
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //////////////// ////////////////
        // 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
                + grant_type;
        System.out.println("param是" + params);
        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        System.out.println("sr是" + sr);
        // 解析相应内容（转换成json对象）
        JSONObject json = new JSONObject(sr);
        // 获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        // 用户的唯一标识（openid）
        String openid = (String) json.get("openid");

        System.out.println("获取openid是" + openid);
        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");
                JSONObject userInfoJSON = new JSONObject(result);
                Map userInfo = new HashMap();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                // 解密unionId & openId;
                if (!userInfoJSON.isNull("unionId")) {
                    userInfo.put("unionId", userInfoJSON.get("unionId"));
                    System.out.print("唯一标识是" + userInfoJSON.get("unionId"));
                }
                map.put("userInfo", userInfo);
            } else {
                map.put("status", 0);
                map.put("msg", "解密失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    @RequestMapping(value = "/gettoken")
    @ResponseBody
    public WxResult gettoken( boolean flag) throws IOException {
        AccessToken at = null;
        //如果redis里有并且flag是false
        if(RedisUtil.hasKey("token")&&!flag){
            String token = RedisUtil.get("token").toString();
            at = new AccessToken();
            at.setExpiresIn(7200);
            at.setToken(token);
            return WxResult.ok(at);
        }
        try {
            at = WeixinUtil.getAccessToken(smallRoutineApplid,smallRoutineSecret);
            RedisUtil.set("token",at.getToken(), (long) 5400);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //wxTokenController.setToken(type);
        return WxResult.ok(at);
    }

    @RequestMapping(value="/wxgettoken",method = {RequestMethod.GET, RequestMethod.POST})
    public void tokenGet(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；boolean isGet = request.getMethod().toLowerCase().equals("get");
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter out = response.getWriter();
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");// 时间戳
            String nonce = request.getParameter("nonce");// 随机数
            String echostr = request.getParameter("echostr");//随机字符串
            if (SignUtil.checkSignature("hfgahfga", signature, timestamp, nonce)) {

                System.out.println("Connect the weixin server is successful.");
                response.getWriter().write(echostr);
            }else {
                System.out.println("Failed to verify the signature!");
            }
        }else{
            String respMessage = "异常消息！";
            try {
                respMessage = wechatController.weixinPost(request);
                if(respMessage!=null){
                    if(respMessage.equals("")){
                        out.write("success");
                    }else {
                        System.out.println("发送消息");
                        out.write(respMessage);
                    }
                }
//                LOGGER.info("The request completed successfully");
//                LOGGER.info("to weixin server "+respMessage);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("错误");


//                LOGGER.error("Failed to convert the message from weixin!");
            }

        }

    }

}
