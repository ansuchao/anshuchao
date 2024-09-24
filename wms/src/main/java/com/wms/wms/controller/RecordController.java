package com.wms.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.wms.common.QueryPageParam;
import com.wms.wms.common.Result;
import com.wms.wms.entity.Goods;
import com.wms.wms.entity.Record;
import com.wms.wms.service.GoodsService;
import com.wms.wms.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RecordService recordService;
    @PostMapping("/listPage")
    public Result listPageCC(@RequestBody QueryPageParam query){
       /* System.out.println("num====="+query.getPageNum());
        System.out.println("size====="+query.getPageSize());*/

        HashMap param= query.getParam();
        String  name =(String)param.get("name");
        String  goodstype = (String)param.get("goodstype");
        String  storage = (String)param.get("storage");
        String  roleId = (String)param.get("roleId");
        String  userId = (String) param.get("userId");

        Page<Record> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        QueryWrapper<Record> queryWrapper = new QueryWrapper();
        queryWrapper.apply(" a.goods=b.id and b.storage=c.id and b.goodsType=d.id ");

        if("2".equals(roleId)){
            queryWrapper.apply(" a.userId= " +userId);
        }
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){

            queryWrapper.like("b.name",name);
        }
        if(StringUtils.isNotBlank(goodstype) && !"null".equals(goodstype)){

            queryWrapper.eq("d.id",goodstype);
        }
        if(StringUtils.isNotBlank(storage) && !"null".equals(storage)){
            queryWrapper.eq("c.id",storage);
        }

        //IPage result= userService.pageC(page);
        IPage result= recordService.pageC1(page,queryWrapper);
        return Result.suc(result.getRecords(),result.getTotal());
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Record record){
        Goods goods = goodsService.getById(record.getGoods());
        int n = record.getCount();
        //出库
        if("2".equals(record.getAction())){
            n= -n;
            record.setCount(n);
        }
        int num = goods.getCount()+n;
        goods.setCount(num);
        goodsService.updateById(goods);
        return recordService.save(record)?Result.suc():Result.fail();
    }
}
