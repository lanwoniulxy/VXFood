package com.imooc.Repository;

import com.imooc.DataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lxy on 2019/7/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductCategoryRepositoryTest {
    @Autowired ProductCategoryRepository productCategoryRepository;
    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("好吃系列" , 6);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryType(){
      List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> alist = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,alist.size());
    }

}