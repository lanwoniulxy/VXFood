package com.wechat.Service.impl;

import com.wechat.Enum.ProductStatusEnum;
import com.wechat.dataObject.ProductInfo;
import com.wechat.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Creaed by lxy on 2019/7/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo result = productService.findOne("1");
        Assert.assertEquals("1", result.getProductId());
    }

    @Test
    public void findAll() throws Exception {
        // List<ProductInfo> result = productService.findAll();
        // Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findUpAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 2);
//        Page<ProductInfo> result = productService.findUpAll(pageRequest);
//        System.out.println(result);

    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("这苹果贼好吃");
        productInfo.setProductIcon("http://xxxcom");
        productInfo.setProductId("1");
        productInfo.setProductName("苹果");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void offSale () {
        ProductInfo result = productService.offSale("1");
        Assert.assertEquals(result.getProductStatus(), ProductStatusEnum.DOWN.getCode());
    }

    @Test
    public void onSale () {
        ProductInfo result = productService.onSale("1");
        Assert.assertEquals(result.getProductStatus(), ProductStatusEnum.UP.getCode());
    }

}