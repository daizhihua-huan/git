package com.huanyuenwei.com.wx.controller;

import com.huanyuenwei.com.wx.util.MessageUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Component
public class WechatController {

    public String weixinPost(HttpServletRequest request) {
        String respMessage = "";
        //默认返回的文本消息类容
        String respContent = "";
        String fromUserName = "";
        String toUserName = "";
        String msgType = "";

        //xml请求解析
        Map<String, String> requestMap = null;
        try {
            requestMap = MessageUtil.pareXml(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("接收到的数据是"+requestMap);
        //发送方账号（open_id）
        fromUserName = requestMap.get("FromUserName");
        System.out.print("公众号是"+fromUserName);
        //公众账号
        toUserName = requestMap.get("ToUserName");
        //消息类型
        msgType = requestMap.get("MsgType");
        System.out.println("msgType是"+msgType);
//			String eventType = requestMap.get("Event");
        String fromContent = requestMap.get("Content");
        System.out.println("fromContent是" + fromContent);
        String userName = "";
        String eventTypeSub = requestMap.get("Event");
        System.out.println("enevt是" + eventTypeSub);

        if ((MessageUtil.REQ_MESSAGE_TYPE_EVENT).equals(msgType)) {
            // 事件类型
            String eventType = requestMap.get("Event");
            if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                // 事件KEY值，与创建自定义菜单时指定的KEY值对应
                String eventKey = requestMap.get("EventKey");
                System.out.println("enentkey是"+eventKey);
                if ("stuTravelView".equals(eventKey)) {//行程查看

                }
            }else{
                try {
                    respMessage = MessageUtil.mapToXml(requestMap);
                    System.out.println("respMessage是"+respMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
        if (fromContent != null && !fromContent.equals("")) {

        }

        //说明是开完了发票的回调函数
        if(MessageUtil.USER_AUTHORIZE_INVOICE.equalsIgnoreCase(eventTypeSub)){
            respContent = "";

//            wxAuthorizeInvoiceService.insertWxAuthorizeInvoice(requestMap,eventTypeSub);
        }

        if ((MessageUtil.EVENT_TYPE_SUBSCRIBE).equals(eventTypeSub)) { //订阅
            respContent = "";
//            AccessToken at = WeixinUtil.getAccessToken(wxServiceAppid,wxServiceSecret);
//            GzhUser gzhUser = WeixinUtil.getuser(at.getToken(), fromUserName);
//            Map<String, Object> selectunioniduser = wxLoginService.selectunioniduser(gzhUser.getUnionid());
//            if(selectunioniduser!=null){
//                String phonenum = selectunioniduser.get("PHONENUM").toString();
//                String password = selectunioniduser.get("PASSWORD").toString();
//                int i = wexinController.update_gzh_user(phonenum, password, gzhUser);
//            }

        }
        if (MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventTypeSub)) {

        }//取消订阅

        //回复文本消息

        //文本消息
			/*if(msgType.equals(MessageUtil.REQ_MESSSAGE_TYPE_TEXT)){
				Connection conn=new DBCPConnection().getConnection();
				if(conn==null){
					respContent="连接数据库失败";
				}else{
					int count =0;
					String sql="select * from crm_student_info";
			        PreparedStatement ps=conn.prepareStatement(sql);
			        ResultSet rs=ps.executeQuery();
		            while (rs.next()) {
		            	if(count>6){
		            		break;
		            	}
		                String name=rs.getString("exam_time");
		                sb.append(name).append("/n");
		                count++;
		            }
				}
				respContent=sb.toString();
				//respContent = new OpenDBConnection().selectData("select * from crm_student_info");
			}
			//图片消息
			else if(msgType.equals(MessageUtil.REQ_MESSSAGE_TYPE_IMAGE)){
				respContent = "您发送的是图片消息！";
			}

			}
			textMessage.setContent(respContent);*/
        if(respContent.equals("")){

        }else{
            respMessage = ("<xml><ToUserName><![CDATA[" + requestMap.get("FromUserName") +
                    "]]></ToUserName>" + "<FromUserName><![CDATA[" + requestMap.get("ToUserName")
                    + "]]></FromUserName><CreateTime>" + System.currentTimeMillis() + "</CreateTime>" +
                    "<MsgType><![CDATA[text]]></MsgType>" +
                    "<Content><![CDATA[" + respContent + "]]></Content></xml>");
        }
        return respMessage;
    }

}
