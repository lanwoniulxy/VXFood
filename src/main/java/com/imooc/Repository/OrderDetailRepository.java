package com.imooc.Repository;

import com.imooc.DataObject.OrderDetail;
import com.imooc.DataObject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lxy on 2019/8/1.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{

    /**
     * 根据openId查出所有Id
     */
    List<OrderDetail> findByOrderId(String orderId);


}
