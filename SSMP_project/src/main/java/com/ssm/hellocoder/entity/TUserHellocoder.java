package com.ssm.hellocoder.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (TUserHellocoder)实体类
 *
 * @author HaC
 * @since 2020-05-29 01:28:27
 */
@TableName("t_user_hellocoder")
public class TUserHellocoder implements Serializable {
    private static final long serialVersionUID = 417502814533585676L;

    private Integer id;

    private String name;

    private String description;
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}