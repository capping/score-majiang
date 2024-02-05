package com.sevengod.score.domain.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sevengod.score.model.BaseEntity;

public class SportsRecordVo extends BaseEntity {

    String[] typeNames = new String[] {"", "走路", "慢跑"};

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("real_name")
    private String realName;

    private String tel;

    private Integer type;

    private String typeName;

    private String data;

    @JsonProperty("sport_run")
    private float sportRun;

    @JsonProperty("sport_time")
    private String sportTime;

    @JsonProperty("sport_speed")
    private String sportSpeed;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeNames[getType()];
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getSportRun() {
        if (data == null || data.length() == 0 || "null".equals(data.toLowerCase())) {
            return 0.0F;
        }
        JSONObject jsonObject = JSON.parseObject(data);
        return jsonObject.getFloat("sportRun");
    }

    public String getSportTime() {
        if (data == null || data.length() == 0 || "null".equals(data.toLowerCase())) {
            return "";
        }
        JSONObject jsonObject = JSON.parseObject(data);
        return jsonObject.getString("sportTime");
    }

    public String getSportSpeed() {
        if (data == null || data.length() == 0 || "null".equals(data.toLowerCase())) {
            return "";
        }
        JSONObject jsonObject = JSON.parseObject(data);
        return jsonObject.getString("sportSpeed");
    }
}
