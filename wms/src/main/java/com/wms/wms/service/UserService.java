package com.wms.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.wms.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    IPage pageC(IPage<User> page);

    IPage pageC1(IPage<User> page, Wrapper wrapper);

    List<User> listAll();
}
