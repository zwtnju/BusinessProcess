package com.example.demo.entity;

import java.sql.Timestamp;

public class PrivateTransaction {
    private Integer bpId;  //流程实例id
    private Integer transId;  //当前tx的标识id
    private String privateDescription;  //交易内容

    public PrivateTransaction(Integer bpId, Integer transId, String privateDescription) {
        this.bpId = bpId;
        this.transId = transId;
        this.privateDescription = privateDescription;
    }

    public Integer getBpId() {
        return bpId;
    }

    public void setBpId(Integer bpId) {
        this.bpId = bpId;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getPrivateDescription() {
        return privateDescription;
    }

    public void setPrivateDescription(String privateDescription) {
        this.privateDescription = privateDescription;
    }
}
