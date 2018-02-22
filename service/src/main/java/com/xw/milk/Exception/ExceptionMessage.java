package com.xw.milk.Exception;



import java.util.HashMap;

/**
 * Created by Administrator on 2015/12/9.
 */

public class ExceptionMessage {


    public static HashMap<String,String> exceptionMessage=new HashMap<String, String>();

    static  {

        //处理用户异常信息
        exceptionMessage.put("user.login.password.password_not_correct","您输入的密码有误");
        exceptionMessage.put("user.login.username.no_such_user","您输入的用户不存在");
        //处理找回密码异常
        exceptionMessage.put("sys.user.add.user_exist","用户已存在");
        exceptionMessage.put("user.forget.user_not_exist","你输入的用户不存在");
        exceptionMessage.put("user.forget.mobile_not_exist","你输入的手机号码不存在");
        exceptionMessage.put("user.not_is_guarantee_company","此账号不是担保账号");

        //处理投资异常信息
        exceptionMessage.put("item.invest.session_out","您还未登陆，请先登陆");

        //处理用户资金异常信息

        //投标异常信息
        exceptionMessage.put("item.invest.less_min_investment","投资金额低于最低投标金额");
        exceptionMessage.put("item.invest_must_gt0","投资金额必须大于0");
        exceptionMessage.put("item.invest.amount_no_meet_coupon_amount","投资金额不满足红包使用条件");
        exceptionMessage.put("item.invest.amount_no_meet_ticket_amount","投资金额不满足加息券使用条件");
        exceptionMessage.put("item.invest.great_single_max_investment","投资金额高于单笔最高投资金额");
        exceptionMessage.put("item.invest.account_no_more_balance","没有足够的可用余额");
        exceptionMessage.put("item.great_max_investment","投标金额大于该标的最大投标金额");
        exceptionMessage.put("item.invest.item_no_more_balance","该标的可投资金额不足");
        exceptionMessage.put("item.status.not_full_complete","满标复审状态不正确");
        exceptionMessage.put("item.invest.intercept_item","项目已提前满标");
        exceptionMessage.put("item.invest.not_exist","该标不存在");
        exceptionMessage.put("sysUser.user.not_exist","系统用户不存在或密码不正确");

        exceptionMessage.put("item.invest.busy","系统繁忙");
        exceptionMessage.put("item.invest.has_invest_isnew","新手标当日已经投资过了，请明日再来");
        exceptionMessage.put("item.invest.isnew_has_first","新手标仅支持首投");
        exceptionMessage.put("item.invest.no_invest_status","项目非投资状态");
        exceptionMessage.put("item.status.not_correct","项目状态错误");


        //后台充值信息
        exceptionMessage.put("platformRecharge.amountEqualToZero","操作金额不能为0");
        exceptionMessage.put("platformRecharge.rechargeTypeValid","操作类型不存在");

        //还款信息
        exceptionMessage.put("item.repay.balance_is_not_enough","还款余额不足");
        exceptionMessage.put("item.repay.balance_is_not_item_amount","还款金额不满足项目金额");


        //处理用户异常信息
        exceptionMessage.put("user.register.randomCode.error","短信验证码输入有误");
        exceptionMessage.put("user.register.randomCode.timeout","短信验证码已经超时，请重新获取");
        exceptionMessage.put("user.randomCode.not_send","请先获取验证码");
        exceptionMessage.put("user.register.randomCode.no","请发送短信");
        exceptionMessage.put("mobileCode_not_allow_null","验证码不能为空");
        exceptionMessage.put("user.register.password.is_no","密码为空");

        //用户注册信息
        exceptionMessage.put("user.register.mobile_already_exists","该手机号已注册");
        exceptionMessage.put("user.register.mobile_no_already_exists","用户不存在");
        exceptionMessage.put("identifyCard_already_exists","该身份证已被绑定，不能重复绑定");
        exceptionMessage.put("user.register.password_already_exists","已设置密码");

        //登录
        exceptionMessage.put("user.login.username.no_such_user","您输入的用户不存在");
        exceptionMessage.put("user.login.username_or_password.error","用户名或密码错误");

        //绑定银行卡
        exceptionMessage.put("user.bank.idCard.already_exists","身份证已存在");
        exceptionMessage.put("user.bank.idCard.already_certified","已实名");
        exceptionMessage.put("user.bank.cardNo.already_exists","卡号已存在");
        exceptionMessage.put("user.bank.cardNo.is_not_correct","银行卡输入错误");
        exceptionMessage.put("user.bank.cardNo.already_certified","已绑定银行卡");
        exceptionMessage.put("user.bank.cardNo.none_exist","用户未在先锋绑卡，请核实后再试");
        exceptionMessage.put("user.bank.cardNo.is_not_choose","请选择一张银行卡");

        //提现
        exceptionMessage.put("user.cash.amount.balance_is_not_enough","余额不足，请充值后重试");
        exceptionMessage.put("user.cash.bank.no_already_certified","未绑定银行卡");

        //还款
        exceptionMessage.put("user.repay.no_repayment","不支持提前还款");
        exceptionMessage.put("user.repay.no_all_repayment","不支持提前全部还款");
        exceptionMessage.put("user.repay.no_part_repayment","不支持提前部分还款");
        exceptionMessage.put("user.repay.user.error","还款人错误");
        exceptionMessage.put("repay.status_error","还款状态错误");
        exceptionMessage.put("repay_not_exist","还款不存在");
        exceptionMessage.put("item.repay_principal_diffrent_ongoingAmount","待还金额与标的进行金额不一致");
        exceptionMessage.put("item.user.repay_no_such","用户相应标的待还记录未找到");
        exceptionMessage.put("user.account_no_such","当前用户未找到，请稍后再试");
        exceptionMessage.put("item.has_not_prepayment","标的没有对应的提前还款记录，请联系客服");
        exceptionMessage.put("repay.principal_diffrent_amount","用户所还本金与所需要待还金额不一致，请输入正确的金额");

        //发标
        exceptionMessage.put("item.first.time.error","发布时间错误");

        //自动投标
        exceptionMessage.put("item.auto.info.error","自动投标信息错误");
        exceptionMessage.put("invest.item_is_null","没有满足的项目");

        //实名
        exceptionMessage.put("user.security.already_exists","已实名");
        exceptionMessage.put("user.security.no_already_exists","未实名");
        exceptionMessage.put("user.security.not_found","实名信息未找到");

        //充值
        exceptionMessage.put("user.recharge.create_fail","创建订单失败");


        //体验金
        exceptionMessage.put("sys.experienced_gold.not_exist","此体验金不存在");
        exceptionMessage.put("sys.experienced_gold.can_not_use","体验金为不可使用状态");
        exceptionMessage.put("sys.experienced_gold.user.not_realname","未实名");
        exceptionMessage.put("sys.experienced_gold.user.not_binding_card","未绑卡");



        exceptionMessage.put("invite.invalid_invite_code","邀请码不存在");
        exceptionMessage.put("invite.user_had_bound_invite_code","用户已绑定邀请人");
        exceptionMessage.put("invite.bingding.busy","系统繁忙");
        exceptionMessage.put("invite.user_self_bound_invite_code","不能绑定自己的邀请码");
        exceptionMessage.put("invite.user_invite_user_is_user","不能互相邀请");

        exceptionMessage.put("item.repay_amount_full","项目还款金额已满");

        exceptionMessage.put("cash.sys_limit","因账户限制，无法提现");

        exceptionMessage.put("invest.auto_add_already_exists","未锁定的规则只能创建一个");

        exceptionMessage.put("item.invest.fail","投资失败");

        exceptionMessage.put("repay.already.complete","已经完成还款");

        exceptionMessage.put("raffle_ticket.num_error","抽奖券不足");
//lwx
        exceptionMessage.put("update_error","系统繁忙");
        exceptionMessage.put("update_goods.count_error","更新商品库存失败，请稍后再试");
        exceptionMessage.put("select_error","系统繁忙，查询失败");
        exceptionMessage.put("insert_error","新增失败，请核对后稍后再试");
        exceptionMessage.put("push_or_pull_fail","上/下架失败，请稍后再试");
        exceptionMessage.put("order.select_error","订单未找到");
        exceptionMessage.put("order_already_pay","订单已支付，请勿重复提交");
        exceptionMessage.put("please_binding_card_before","请先实名绑卡后再试");
        exceptionMessage.put("goods_not_enough","商品库存不足");
        exceptionMessage.put("goods_must_grater_0","商品数量不能小于1");
        exceptionMessage.put("want_exceed_remainder","超出用户限购数量，详情请联系客服咨询");
        exceptionMessage.put("sys_goods_kind_insert_error","新增商品种类失败，请稍后再试");
        exceptionMessage.put("sys_goods_kind_update_error","修改商品种类失败，请稍后再试");
        exceptionMessage.put("please_login_first","请先登录");
        exceptionMessage.put("address_already_exist","用户地址已存在，不能重复添加");
        exceptionMessage.put("grater_wait_repay","您输入金额大于待还总额，请核实金额后再试");
        exceptionMessage.put("sms_send_error","短信发送失败");
        exceptionMessage.put("params_error","参数异常");
        exceptionMessage.put("bank_already_exists","银行限额已配置，不能重复添加");
        exceptionMessage.put("pay_pass_error","交易密码错误，请核实后重试");
        exceptionMessage.put("plan_not_enough_balance","该计划剩余可购买金额不足");
        exceptionMessage.put("buy_plan_error","购买计划失败，请稍后重试");
        exceptionMessage.put("buy_plan_amount_error","购买金额错误，请核实后重试");
        exceptionMessage.put("modify_can_not_close","修改状态下无法关闭");
        exceptionMessage.put("can_not_invest_exclusive","您暂时无法投资该会员专享标");
        exceptionMessage.put("duiba_not_support_test","测试服不支持积分商城");


//lwx

        exceptionMessage.put("picture_code_error","图片验证码错误");
        exceptionMessage.put("interface_is_close","由于民泰银行系统维护，平台现暂停充值、提现、投资、绑卡等业务！亲爱滴诚宝，请稍等一下下，马上就好哦！");

        exceptionMessage.put("modify_password.old_password_error","原密码错误");
        exceptionMessage.put("user.is_not_correct_type","此用户不能后台充值提现");
        exceptionMessage.put("can_not_find_user_accout","找不到用户的账户信息");
        exceptionMessage.put("user.cash.not_correct_time","不在提现时间内");

        exceptionMessage.put("invest_password.not_exists","定向密码不存在");

        exceptionMessage.put("invest_password.password_error","定向密码错误");

        exceptionMessage.put("activity.timeout","不在活动时间内");
        exceptionMessage.put("lottery.user.already.exists","该用户已存在，请登录APP参与抽奖");
        exceptionMessage.put("auto.min_not_max","最小不能大于最大");
        exceptionMessage.put("auto.sms_not_exists","未发送短信");
        exceptionMessage.put("invest.move_vip.app_invest","移动专享，不可在pc端投资");
        exceptionMessage.put("invest.item_full.status_error","状态不正确");

        exceptionMessage.put("user_not_exsit","用户不存在");
        exceptionMessage.put("merchantId_not_match","商户号不匹配");

        exceptionMessage.put("not.repeat.click","请勿重复点击");
        exceptionMessage.put("payment.error","支付失败");

        exceptionMessage.put("invite_code.not_exists","邀请码或者手机号不存在，请核对后重试");

        exceptionMessage.put("cash_amount.less","提现金额必须大于100");
        exceptionMessage.put("cash_amount.less","提现金额必须大于100");
        exceptionMessage.put("illegal_argument","参数非法");
        exceptionMessage.put("activity_expired","活动已过期");
        exceptionMessage.put("security_before_update","请先进行实名");
        exceptionMessage.put("invest_not_exist","投资记录未找到，请核实后再试");
        exceptionMessage.put("invest_cancel_fail","取消投资失败，请稍后重试");
        exceptionMessage.put("no_such_handler","没有找到合适的处理器");


        exceptionMessage.put("sys_error","系统异常，请稍后重试");

        exceptionMessage.put("message_status_is_not_correct","消息状态错误");
        exceptionMessage.put("do_not_same_sign","今日已签到");

        exceptionMessage.put("user_not_invest_auth","请设置免密投资授权");
        exceptionMessage.put("user_not_set_risk_type","未进行用户风险评估");
        exceptionMessage.put("user.invest_more_than_max_investment","超过当前风险评估金额");
        exceptionMessage.put("user.mobile_is_not_exsit","用户未注册");
        exceptionMessage.put("tempcode_get_not_more_than_60s","一分钟后重新获取");
        exceptionMessage.put("not_support_this_bank","暂不支持该银行");
        exceptionMessage.put("not_select_bank_card","未选择银行卡");

        //Loger
        exceptionMessage.put("0043","用户未绑卡");
        exceptionMessage.put("1234","四要素校验失败");
        exceptionMessage.put("item.status_must_be_waitopen","标的状态必须为等待开放");
        exceptionMessage.put("sms_has_send","短信已经发送，请勿重新获取");
        exceptionMessage.put("payment_password_can_not_be_null","交易密码不能为空");
        exceptionMessage.put("payment_password_must_be_six_number","交易密码必须为六位");
        exceptionMessage.put("payment_password_error","密码错误");
        exceptionMessage.put("payment_password_not_set","请先设置交易密码");
        exceptionMessage.put("excel_export_is_max","导出数据量过大");
        exceptionMessage.put("invite_user_can_not_be_self","邀请人不能为本人");
        exceptionMessage.put("10001","商户不存在");
        exceptionMessage.put("10003","解密失败");
        exceptionMessage.put("10002","解密不匹配");
        exceptionMessage.put("10004","实名信息不匹配");

        //ChoviWu
        exceptionMessage.put("already_wx_openId","请勿重新绑定");
        exceptionMessage.put("openId_is_none","请在微信端登录");
        exceptionMessage.put("userId_is_none","过期，请重新登录");
        exceptionMessage.put("ticket_rule_is_dateBy","规则已失效");
        exceptionMessage.put("is_allow_following","不合法的访问");
        exceptionMessage.put("user.type_not_allow_moku","该用户不是魔库导流的用户");
        exceptionMessage.put("please_input_correct_id_or_name","请输入正确的身份证号码或者姓名");
        exceptionMessage.put("set_paypassword_fail","设置交易密码失败");
        exceptionMessage.put("auto_invest_already_open","已经开启自动投标");
        exceptionMessage.put("auto_invest_amount_not_empty","自动投标金额不能为空");
        exceptionMessage.put("please_write_auto_invest_info","请填写并补全自动投标信息");
        exceptionMessage.put("user.phone_is_none","参数为空");
        exceptionMessage.put("user.item_type_is_not_none","项目类型不能为空");
        exceptionMessage.put("user.phone_is_empty","手机号为空");
        exceptionMessage.put("itemCycle_is_not_null","不可修改");
        exceptionMessage.put("user.state_is_none","用户未注册汇诚金服");
        exceptionMessage.put("user.security.is_not_find","用户实名信息不存在");
        exceptionMessage.put("register_fail","注册失败");
        exceptionMessage.put("user.referer_is_not_moku","用户不是魔库注册");
    }



}
