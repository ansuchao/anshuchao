package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.wms.entity.Goodstype;
import com.wms.wms.entity.Storage;
import com.wms.wms.mapper.GoodstypeMapper;
import com.wms.wms.mapper.StorageMapper;
import com.wms.wms.service.GoodstypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2023-02-08
 */
@Service
public class GoodstypeServiceImpl extends ServiceImpl<GoodstypeMapper, Goodstype> implements GoodstypeService {
    @Resource
    private GoodstypeMapper goodstypeMapper;
    @Override
    public IPage pageC1(IPage<Goodstype> page, Wrapper wrapper) {
        return goodstypeMapper.pageC1(page,wrapper);
    }
}
