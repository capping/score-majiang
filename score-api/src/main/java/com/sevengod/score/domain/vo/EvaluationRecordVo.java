package com.sevengod.score.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sevengod.score.model.BaseEntity;

import java.text.DecimalFormat;

public class EvaluationRecordVo extends BaseEntity {

    String[] evaluationNames = new String[] {"", "焦虑自评量表SAS", "抑郁自评量表SDS", "一般效能感量表GSES", "西雅图心绞痛量表"};

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("real_name")
    private String realName;

    private String tel;

    @JsonProperty("evaluation_id")
    private Integer evaluationId;

    @JsonProperty("evaluation_name")
    private String evaluationName;

    private Integer score;

    private String grade;

    private String data;

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

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getEvaluationName() {
        return evaluationNames[evaluationId];
    }

    public void setEvaluationName(String evaluationName) {
        this.evaluationName = evaluationName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getGrade() {
        DecimalFormat df = new DecimalFormat("0.00");
        switch (evaluationId) {
            case 1:
                if (score < 50) {
                    return "正常";
                } else if (score <= 60) {
                    return "轻度焦虑";
                } else if (score <= 70) {
                    return "中度焦虑";
                } else if (score <= 80) {
                    return "重度焦虑";
                }
            case 2:
                if (score < 53) {
                    return "正常";
                } else if (score <= 62) {
                    return "轻度焦虑";
                } else if (score <= 72) {
                    return "中度焦虑";
                } else if (score <= 80) {
                    return "重度焦虑";
                }
            case 3:
                return String.valueOf(df.format((float) score / 10));
            case 4:
                // 107 - 19 = 88
                return String.valueOf(df.format((float) (score - 19) * 100 / 88));
            default: return "";
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
