package com.xw.milk.model.VO;

import com.xw.milk.model.BasUser;

import java.io.Serializable;

/**
 * Created by ChoviWu on 2018/02/23
 * Description:
 */

public class BasUserVO  extends BasUser implements Serializable {

    private String nickName;

    private Integer groupId;

    private String headImgUrl;

    private String remark;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
