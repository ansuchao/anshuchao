package com.wms.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.wms.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.wms.entity.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2023-02-09
 */
public interface GoodsService extends IService<Goods> {
    IPage pageC1(IPage<Goods> page, Wrapper wrapper);
}
