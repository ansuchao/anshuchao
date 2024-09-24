package com.wms.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.wms.common.QueryPageParam;
import com.wms.wms.common.Result;
import com.wms.wms.entity.Goods;
import com.wms.wms.entity.Goodstype;
import com.wms.wms.entity.Goodstype;
import com.wms.wms.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/goodstype")
public class GoodstypeController {
    @Autowired
    private GoodstypeService goodstypeService;

    @PostMapping("/save")
    public Result save(@RequestBody Goodstype goodstype){
        return goodstypeService.save(goodstype)?Result.suc():Result.fail();
    }

    //更新
    @PostMapping ("/update")
    public Result update(@RequestBody Goodstype goodstype){
        return goodstypeService.updateById(goodstype)?Result.suc():Result.fail();
    }
    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id){
        return goodstypeService.removeById(id)?Result.suc():Result.fail();
    }
    @PostMapping ("/listPage")
    public Result listPageCC(@RequestBody QueryPageParam query){
       /* System.out.println("num====="+query.getPageNum());
        System.out.println("size====="+query.getPageSize());*/

        HashMap param= query.getParam();
        String  name =(String)param.get("name");

        Page<Goodstype> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Goodstype> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(Goodstype::getName,name);
        }



        //IPage result= userService.pageC(page);
        IPage result= goodstypeService.pageC1(page,lambdaQueryWrapper);
        return Result.suc(result.getRecords(),result.getTotal());
    }
    @RequestMapping("/list")
    public Result list(){

        List list = goodstypeService.lambdaQuery().list();
        return Result.suc(list);
    }
}
