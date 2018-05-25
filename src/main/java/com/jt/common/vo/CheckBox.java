package com.jt.common.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/20.
 * 角色信息
 */
public class CheckBox implements Serializable {
    private static final long serialVersionUID = -8414112863730516116L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
