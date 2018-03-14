package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.xw.milk.common.PageList;
import com.xw.milk.common.Paginator;
import com.xw.milk.model.BizProduct;
import com.xw.milk.service.BasProductService;
import com.xw.milk.service.BaseServiceImpl;

import java.util.List;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */

@Service
public class BasProductServiceImpl extends BaseServiceImpl<BizProduct> implements BasProductService {


    @Override
    public PageList getListForPage(Paginator paginator) {
        PageHelper.startPage(paginator.getPageNum(), paginator.getPageSize());
        List<BizProduct> list = mapper.selectAll();
        return new PageList(list);
    }

    @Override
    public List<BizProduct> getList() {
        return mapper.selectAll();


    }
}
