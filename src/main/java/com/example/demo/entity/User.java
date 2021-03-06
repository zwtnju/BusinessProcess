package com.example.demo.entity;


public class User {
    private Integer userid;
    private String username;   //企业或者个人名
    private String identity;   //身份证明凭证
    private String description;  //企业简述
    private String coreBusiness; //核心业务
    private String assessment;  //资产评估
//    private String ipAddress;

    public User(Integer userid) {
        this.userid = userid;
    }
    //password是不会在别人的数据库中显示的
    //对外显示的全局表，不包含用户的秘密
    public User(Integer userid, String username, String identity, String description, String coreBusiness, String assessment) {
        this.userid = userid;
        this.username = username;
        this.identity = identity;
        this.description = description;
        this.coreBusiness = coreBusiness;
        this.assessment = assessment;
    }

    public User(String username, String identity, String description, String coreBusiness, String assessment) {
        this.username = username;
        this.identity = identity;
        this.description = description;
        this.coreBusiness = coreBusiness;
        this.assessment = assessment;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoreBusiness() {
        return coreBusiness;
    }

    public void setCoreBusiness(String coreBusiness) {
        this.coreBusiness = coreBusiness;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
//
//    public String getIpAddress() {
//        return ipAddress;
//    }
//
//    public void setIpAddress(String ipAddress) {
//        this.ipAddress = ipAddress;
//    }
}
