package com.wms.wms.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*添加时自动插入时间和更新数据库时间*/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public  void insertFill(MetaObject metaObject){
        this.setFieldValByName("createtime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("createtime", new Date(), metaObject);
    }


}
