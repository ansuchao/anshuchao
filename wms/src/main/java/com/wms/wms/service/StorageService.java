package com.wms.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.wms.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.wms.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2023-02-08
 */
public interface StorageService extends IService<Storage> {

    IPage pageC1(IPage<Storage> page, Wrapper wrapper);
}
