package com.wechat.Service.impl;

import com.wechat.DataObject.ProductCategory;
import com.wechat.Repository.ProductCategoryRepository;
import com.wechat.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lxy on 2019/7/17.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 根据类目编号查找类目
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {

        return repository.findOne(categoryId);
    }

    /**
     * 查找所有类目
     */
    @Override
    public List<ProductCategory> findAll() {

        return repository.findAll();
    }

    /**
     * 根据类目类型查找类目
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryType) {
        return repository.findByCategoryTypeIn(CategoryType);
    }

    /**
     * 增加一条记录
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
