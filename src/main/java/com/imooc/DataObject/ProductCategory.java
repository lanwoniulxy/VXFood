package com.imooc.DataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lxy on 2019/7/12.
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private  Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
