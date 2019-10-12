package com.wechat.Repository;

import com.wechat.DataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lxy on 2019/7/17.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo , String> {
    /**
     * 通过商品状态来查询商品信息
     */
    List<ProductInfo> findByProductStatusIn(Integer productStatus);
}
