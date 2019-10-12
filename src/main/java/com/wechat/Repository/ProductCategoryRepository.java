package com.wechat.Repository;

import com.wechat.DataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lxy on 2019/7/12.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 根据类目类型查出类目
     * @param cateGoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> cateGoryTypeList);

}
