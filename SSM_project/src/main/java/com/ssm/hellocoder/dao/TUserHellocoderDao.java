package com.ssm.hellocoder.dao;

import com.ssm.hellocoder.entity.TUserHellocoder;

/**
 * (TUserHellocoder)表数据库访问层
 *
 * @author HaC
 * @since 2020-05-29 01:28:28
 */
public interface TUserHellocoderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUserHellocoder queryById(Integer id);

}