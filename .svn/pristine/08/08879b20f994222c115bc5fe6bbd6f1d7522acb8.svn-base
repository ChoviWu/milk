//package com.xw.milk.controller.sms;
//
//
//import com.xw.milk.model.BasUser;
//import com.xw.milk.service.BasUserService;
//import com.xw.milk.util.SmsParamUtils;
//import jdk.nashorn.internal.ir.annotations.Reference;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//@Controller
//public class SmsController {
//
//    @Reference
//    BasUserService userService;
//
//
//    public Map smsInfo(String vaildPhoneCode,String mobile,SysNoticeType noticeType,String code){
//        String content = noticeType.getTypeContent();
//        String  randomCode = vaildPhoneCode;
//        System.out.println("您的验证码：" + randomCode);
//        content = content.replace(Constants.VALIDATECODE, randomCode);
//
//        //SmsService sms = new YiMeiSmsImpl();
//
//        Map smsMap = new HashMap();
//        smsMap.put("msgText",content);
//        smsMap.put("mobile",mobile);
//        //1是短信验证码  0是语音验证码
//        String smsResponse=smsService.sendSms(1,mobile, SmsParamUtils.replaceCode(randomCode),null,0,noticeType.getTitle(),randomCode,content,code).toString();
//
//        Map ret = new HashMap();
//        if(Integer.parseInt(smsResponse)>0){
//            ret.put("result","success");
//            ret.put("validPhoneExpiredTime",new Date());
//        }else {
//            ret.put("result","fail");
//            ret.put("message",smsResponse);
//        }
//        return ret;
//    }
//
//
//
//
//
//    //修改绑定旧手机短信
//    @ResponseBody
//    @RequestMapping(value="/mobile/user/oldModifyMobileSms")
//    public Object oldModifyMobileSms(HttpServletRequest request){
//        String vaildPhoneCode=request.getParameter("vaildPhoneCode");
//        Integer id=new Integer(request.getParameter("userId"));
//        BasUser user=userService.selectByKey(id);
//        //校验上一个验证码的时间
//        checkTempleCodeTime(user.getMobile());
//        String code = SMSType.MODIFY_MOBILE_SMS;
//        return smsInfo(vaildPhoneCode,user.getMobile(),noticeType,code);
//    }
//
//
//
//    private void checkTempleCodeTime(String mobile){
//        //获取验证码的时长  是否过期
//        SysTempcode sysTempcode = tempcodeService.getLastBymobile(mobile);
//        if (sysTempcode != null) {
//            long time = new Date().getTime() - sysTempcode.getAddtime().getTime();
//            Integer codeType = sysTempcode.getType();
//            if(codeType ==null || codeType==1){
//                exceptionService.isTrue(time >= 50000,"sms_has_send");
//            }else{
//                exceptionService.isTrue(time >= 50000,"sms_has_voice_send");
//            }
//        }
//    }
//}
