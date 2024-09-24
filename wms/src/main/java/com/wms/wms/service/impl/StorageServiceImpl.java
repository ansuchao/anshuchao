package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.wms.entity.Storage;
import com.wms.wms.entity.User;
import com.wms.wms.mapper.StorageMapper;
import com.wms.wms.mapper.UserMapper;
import com.wms.wms.service.StorageService;
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
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public IPage pageC1(IPage<Storage> page, Wrapper wrapper) {
        return storageMapper.pageC1(page,wrapper);
    }
}
