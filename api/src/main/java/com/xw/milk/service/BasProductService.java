package com.xw.milk.service;

import com.xw.milk.common.PageList;
import com.xw.milk.common.Paginator;
import com.xw.milk.model.BasProduct;

import java.util.List;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
public interface BasProductService extends BaseService<BasProduct> {

    List<BasProduct> getList();

    PageList getList(Paginator paginator);
}
