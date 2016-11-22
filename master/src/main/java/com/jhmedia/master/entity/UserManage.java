/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：UserManage.java
 * 创建时间：2016年8月1日 下午10:27:01
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.entity;

import java.io.Serializable;
/**
 * 用户Entity
 * <pre>
 * 概要: 用户实体类
 * 更新: 2016年8月1日 下午10:27:01
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class UserManage implements Serializable {
    private static final long serialVersionUID = 1567669044573577885L;

    // 用户id
    private String yhid;

    // 用户名
    private String yhm;

    // 密码
    private String mm;

    // 昵称
    private String nickname;

    // 账号类型id
    private Integer type_id;

    // 激活状态
    private Integer active_flag;

    // 删除状态
    private Integer delete_flag;

    private Integer zhlx;

    private Integer zhzt;

    public String getYhid() {
        return yhid;
    }
    public void setYhid(String yhid) {
        this.yhid = yhid;
    }
    public String getYhm() {
        return yhm;
    }
    public void setYhm(String yhm) {
        this.yhm = yhm;
    }
    public String getMm() {
        return mm;
    }
    public void setMm(String mm) {
        this.mm = mm;
    }
    public Integer getType_id() {
        return type_id;
    }
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }
    public Integer getActive_flag() {
        return active_flag;
    }
    public void setActive_flag(Integer active_flag) {
        this.active_flag = active_flag;
    }
    public Integer getDelete_flag() {
        return delete_flag;
    }
    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Integer getZhlx() {
        return zhlx;
    }
    public void setZhlx(Integer zhlx) {
        this.zhlx = zhlx;
    }
    public Integer getZhzt() {
        return zhzt;
    }
    public void setZhzt(Integer zhzt) {
        this.zhzt = zhzt;
    }

}
