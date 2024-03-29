package com.wechat.service;


import com.wechat.DTO.CartDTO;
import com.wechat.dataObject.ProductInfo;
import com.wechat.service.impl.ProductServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品Service
 * Created by lxy on 2019/7/22.
 */
public interface ProductService {

    ProductServiceImpl p = null;

    /**
     * 根据商品Id查出一条商品
     */
    ProductInfo findOne(String productId);

    /**
     * 买家端查出所有在架的商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 卖家端查出全部商品，需要做分页处理
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 增加一条商品记录
     */
    ProductInfo save(ProductInfo productInfo);

    //批量增加商品记录

    //加库存
    void increaseStock(List<CartDTO> cartDTO);

    //减库存
    void decreaseStock(List<CartDTO> cartDTO);

    //商品下架
    ProductInfo offSale(String productId);

    //商品上架
    ProductInfo onSale(String productId);

}
