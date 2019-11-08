package com.wechat.service;


import com.wechat.dataObject.ProductCategory;

import java.util.List;

/**
 * Created by lxy on 2019/7/17.
 */

public interface CategoryService {


    /**
     * 根据类目Id查找类目
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查找所有类目
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目类型查找类目
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryType);


    /**
     * 增加一条商品记录
     */
    ProductCategory save(ProductCategory productCategory);


}
