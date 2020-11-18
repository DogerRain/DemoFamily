package com.ssm.hellocoder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssm.hellocoder.dao.TUserHellocoderDao;
import com.ssm.hellocoder.entity.TUserHellocoder;
import com.ssm.hellocoder.service.TUserHellocoderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUserHellocoder)表服务实现类
 *
 * @author HaC
 * @since 2020-05-29 01:28:29
 */
@Service("tUserHellocoderService")
public class TUserHellocoderServiceImpl implements TUserHellocoderService {
    @Resource
    private TUserHellocoderDao tUserHellocoderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUserHellocoder queryById(Integer id) {
        TUserHellocoder tUserHellocoder = new TUserHellocoder();
//        tUserHellocoder = tUserHellocoderDao.selectOne(new QueryWrapper<TUserHellocoder>().lambda().eq(TUserHellocoder::getId, id).isNotNull(TUserHellocoder::getId));
        tUserHellocoder = tUserHellocoderDao.selectOne(new QueryWrapper<TUserHellocoder>().eq("id", id).isNotNull("id"));
//        List<TUserHellocoder> tUserHellocoderList = tUserHellocoderDao.selectList(new QueryWrapper<TUserHellocoder>().eq("id", id).isNotNull("id"));
        return tUserHellocoder;

    }
}