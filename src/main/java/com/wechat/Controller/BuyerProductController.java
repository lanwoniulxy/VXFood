package com.wechat.controller;


import com.wechat.VO.ProductInfoVO;
import com.wechat.VO.ProductVO;
import com.wechat.VO.ResultVO;
import com.wechat.dataObject.ProductCategory;
import com.wechat.dataObject.ProductInfo;
import com.wechat.service.CategoryService;
import com.wechat.service.ProductService;
import com.wechat.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家端商品模块
 * Created by lxy on 2019/7/24.
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1.查出所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 2.查出上架商品中都有哪些类目类型
        // 精简方法（java8,lambda）
        List<Integer> cateTypeList =
                productInfoList.stream()
                        .map(e -> e.getCategoryType())
                        .collect(Collectors.toList());
        // 3.根据上架商品的类目类型来查询出类目数据
        List<ProductCategory> ProductCategoryList = categoryService.findByCategoryTypeIn(cateTypeList);
        // 4.数据的拼装  将类目数据遍历一遍，遍历的每一次将属于该类目的商品数据拿出来
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : ProductCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.succes(productVOList);

    }

}
