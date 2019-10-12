package com.wechat.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wechat.DTO.OrderDTO;
import com.wechat.DataObject.OrderDetail;
import com.wechat.Enum.ResultEnum;
import com.wechat.Exception.SellException;
import com.wechat.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxy on 2019/10/6.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert (OrderForm orderForm) {

        OrderDTO orderDTO = new OrderDTO();
        Gson gson = new Gson();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换状态失败】,orderForm.getItems={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR.getMessage());
        }

        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

}
