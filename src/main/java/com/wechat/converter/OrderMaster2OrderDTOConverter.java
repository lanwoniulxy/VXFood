package com.wechat.converter;

import com.wechat.DTO.OrderDTO;
import com.wechat.dataObject.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lxy on 2019/10/5.
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO conver(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> conver(List<OrderMaster> orderMasterList) {

        return orderMasterList.stream()
                .map(e -> conver(e))
                .collect(Collectors.toList());

    }
}
