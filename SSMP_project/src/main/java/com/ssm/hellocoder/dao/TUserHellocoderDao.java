package com.ssm.hellocoder.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssm.hellocoder.entity.TUserHellocoder;
import org.apache.ibatis.annotations.Mapper;

/**
 * (TUserHellocoder)表数据库访问层
 *
 * @author HaC
 * @since 2020-05-29 01:28:28
 */
@Mapper
public interface TUserHellocoderDao extends BaseMapper<TUserHellocoder> {

}