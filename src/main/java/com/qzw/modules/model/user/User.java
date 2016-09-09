package com.qzw.modules.model.user;

import java.util.Date;

public class User {
    private Integer id;

    private String loginName;

    private String userName;

    private String email;

    private String password;

    private String cellphone;

    private Byte sendEmail;

    private Byte sendPhone;

    private Date createTime;

    private Boolean valid;

    private Boolean flagDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public Byte getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Byte sendEmail) {
        this.sendEmail = sendEmail;
    }

    public Byte getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(Byte sendPhone) {
        this.sendPhone = sendPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}