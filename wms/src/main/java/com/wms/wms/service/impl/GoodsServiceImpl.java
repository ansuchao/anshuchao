package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.wms.entity.Goods;
import com.wms.wms.entity.User;
import com.wms.wms.mapper.GoodsMapper;
import com.wms.wms.mapper.UserMapper;
import com.wms.wms.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2023-02-09
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Resource
    private GoodsMapper getMapping;

    @Override
    public IPage pageC1(IPage<Goods> page, Wrapper wrapper) {
        return getMapping.pageC1(page,wrapper);
    }
}
