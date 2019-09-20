package com.imooc.Controller;

import com.imooc.DataObject.ProductCategory;
import com.imooc.DataObject.ProductInfo;
import com.imooc.Service.CategoryService;
import com.imooc.Service.ProductService;
import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lxy on 2019/7/24.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1.查出所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 2.查出相应的类目
        // 精简方法（java8,lambda）
        List<Integer> cateTypeList=
        productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        //根据上架商品的类目类型来查询出类目信息
        List<ProductCategory> ProductCategoryList = categoryService.findByCategoryTypeIn(cateTypeList);
        // 3.数据的拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : ProductCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList= new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
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
