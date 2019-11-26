package com.wechat.controller;

import com.wechat.DTO.OrderDTO;
import com.wechat.Enum.ResultEnum;
import com.wechat.Exception.SellException;
import com.wechat.VO.ResultVO;
import com.wechat.converter.OrderForm2OrderDTOConverter;
import com.wechat.form.OrderForm;
import com.wechat.service.BuyerService;
import com.wechat.service.OrderService;
import com.wechat.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家端订单模块
 * Created by lxy on 2019/10/6.
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确,orderForm{}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】订单详情为空,orderDTO.getOrderDetailList={}", orderDTO.getOrderDetailList());
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", result.getOrderId());

        return ResultVOUtil.succes(hashMap);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam(value = "openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("【查看订单列表】openid为空");
            //throw new SellException();
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        Page<OrderDTO> result = orderService.findList(openid, new PageRequest(page, size));

        return ResultVOUtil.succes(result.getContent());
    }

    //查询订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam(value = "openid") String openid,
                                     @RequestParam(value = "orderId") String orderId) {

        if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)) {
            log.error("【查询订单详情】参数为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO result = buyerService.findOrderOne(openid, orderId);

        return ResultVOUtil.succes(result);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam(value = "openid") String openid,
                                     @RequestParam(value = "orderId") String orderId) {

        OrderDTO orderDTO = buyerService.cancel(openid, orderId);
        return ResultVOUtil.succes();
    }

}
