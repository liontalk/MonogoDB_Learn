package cn.liontalk.mongodb.dao;

import cn.liontalk.mongodb.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Integer> {


    OrderEntity getOrderEntityByOrderNo(String orderNo);


    OrderEntity getByOrderNoLike(String orderNo);


}
