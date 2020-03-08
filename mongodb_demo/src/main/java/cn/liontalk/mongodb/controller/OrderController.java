package cn.liontalk.mongodb.controller;

import cn.liontalk.mongodb.entity.OrderEntity;
import cn.liontalk.mongodb.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping(value = "/mongo")
@Api(tags = "MongoDB--使用接口")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderEntityService;


    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    @PostMapping("/saveOrderEntity")
    public String saveOrderEntity() {
        for (int i = 0; i < 100; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(1000+i);
            orderEntity.setNickName("潘玮柏" + "_" + ((int)Math.random()*1000));
            orderEntity.setOrderNo("X797468" + "_" + i);
            orderEntity.setCreateTime(new Date());
            orderEntity.setTotalPrice(new BigDecimal(4500.00));
            orderEntityService.saveOrder(orderEntity);
        }

        return "OK";
    }

    @ApiOperation(value = "通过订单ID获取用户信息", notes = "通过订单ID获取用户信息")
    @GetMapping("/getOrderByOrderNo")
    public OrderEntity getOrderByOrderNo() {
        OrderEntity orderEntity = orderEntityService.getByOrderNo("X797466");
        return orderEntity;
    }

    @ApiOperation(value = "模糊查询保存用户信息", notes = "模糊查询保存用户信息")
    @GetMapping("/getOrderByOrderNoLike")
    public OrderEntity getOrderByOrderNoLike() {
        //String cond="X797";
        //Pattern pattern=Pattern.compile("^.*"++".*$");            
        OrderEntity orderEntity = orderEntityService.getByOrderNoLike("X797");
        return orderEntity;
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @PostMapping("/removeOrderByOrderNo")
    public String removeOrderByOrderNo() {
        orderEntityService.removeOrderByOrderNo("X797468");
        return "OK";
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping("/updateOrderEntity")
    public String updateOrderEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setNickName("Justin Timberlake");
        orderEntity.setOrderNo("X797467");
        orderEntityService.updateOrder(orderEntity);
        return "OK";
    }
}
