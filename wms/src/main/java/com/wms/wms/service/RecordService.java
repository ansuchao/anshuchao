package com.wms.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.wms.entity.Goods;
import com.wms.wms.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2023-02-10
 */
public interface RecordService extends IService<Record> {
    IPage pageC1(IPage<Record> page, Wrapper wrapper);
}
