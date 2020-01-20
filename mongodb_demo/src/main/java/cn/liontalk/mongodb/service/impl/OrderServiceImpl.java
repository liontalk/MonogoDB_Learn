package cn.liontalk.mongodb.service.impl;

import cn.liontalk.mongodb.dao.OrderRepository;
import cn.liontalk.mongodb.entity.OrderEntity;
import cn.liontalk.mongodb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private MongoTemplate mongoTemplate;


    @Resource
    private OrderRepository orderRepository;

    @Override
    public OrderEntity getByOrderNo(String orderNo) {
        return orderRepository.getOrderEntityByOrderNo(orderNo);
    }

    @Override
    public OrderEntity getByOrderNoLike(String orderNo) {
        return orderRepository.getOrderEntityByOrderNo(orderNo);
    }

    @Override
    public void saveOrder(OrderEntity order) {
        orderRepository.save(order);
    }

    @Override
    public void removeOrderByOrderNo(String orderNo) {
        Query query =   new Query(new Criteria("orderNo").is(orderNo));
        mongoTemplate.remove(query,OrderEntity.class);
    }

    @Override
    public void updateOrder(OrderEntity order) {
        Query q=new Query(new Criteria("orderNo").is(order.getOrderNo()));
        Update update=new Update().set("nickName", order.getNickName());
        mongoTemplate.updateMulti(q, update, OrderEntity.class);

    }
}
