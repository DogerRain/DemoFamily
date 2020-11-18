package com.ssm.hellocoder.service;

import com.ssm.hellocoder.entity.TUserHellocoder;

/**
 * (TUserHellocoder)表服务接口
 *
 * @author HaC
 * @since 2020-05-29 01:28:29
 */
public interface TUserHellocoderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUserHellocoder queryById(Integer id);

}