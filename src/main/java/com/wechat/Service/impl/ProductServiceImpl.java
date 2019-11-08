package com.wechat.service.impl;


import com.wechat.DTO.CartDTO;
import com.wechat.Enum.ProductStatusEnum;
import com.wechat.Enum.ResultEnum;
import com.wechat.Exception.SellException;
import com.wechat.dataObject.ProductInfo;
import com.wechat.repository.ProductInfoRepository;
import com.wechat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lxy on 2019/7/22.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    /**
     * 根据商品Id查出一条商品
     */
    public ProductInfo findOne(String productId) {

        return productInfoRepository.findOne(productId);
    }

    /**
     * 查出所有在架商品
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatusIn(ProductStatusEnum.UP.getCode());
    }


    /**
     * 卖家端查出全部商品，需要做分页处理
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        return productInfoRepository.findAll(pageable);
    }

    /**
     * 增加一条商品记录
     */
    @Override

    public ProductInfo save(ProductInfo productInfo) {

        return productInfoRepository.save(productInfo);
    }

    /**
     * 加库存
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

        }
    }

    /**
     * 减库存
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

        }
    }
}
