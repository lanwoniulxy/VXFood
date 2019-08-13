package com.imooc.Repository;

import com.imooc.DataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lxy on 2019/8/1.
 */
public interface OrderMasterRepository extends JpaRepository<OrderDetail, String>{
    /**
     * 根据orderId查出所有订单详情
     */
    List<OrderDetail> findByOrderId(String orderId);
}
