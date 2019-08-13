package com.imooc.Repository;

import com.imooc.DataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lxy on 2019/7/12.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> cateGoryTypeList);

}
