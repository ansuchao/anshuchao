package com.wms.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.wms.entity.Goods;
import com.wms.wms.entity.Record;
import com.wms.wms.mapper.GoodsMapper;
import com.wms.wms.mapper.RecordMapper;
import com.wms.wms.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2023-02-10
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {
    @Resource
    private RecordMapper recordMapper;

    @Override
    public IPage pageC1(IPage<Record> page, Wrapper wrapper) {
        return recordMapper.pageC1(page,wrapper);
    }
}
