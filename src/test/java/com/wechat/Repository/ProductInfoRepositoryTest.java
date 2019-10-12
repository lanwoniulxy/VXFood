package com.wechat.Repository;

import com.wechat.DataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lxy on 2019/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("这苹果贼好吃");
        productInfo.setProductIcon("http://xxxcom");
        productInfo.setProductId("1");
        productInfo.setProductName("苹果");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatusIn() throws Exception {
        List<ProductInfo> result = repository.findByProductStatusIn(0);
        Assert.assertNotEquals(0,result.size());
    }

}