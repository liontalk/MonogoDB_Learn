package cn.liontalk.mongodb.service;

import cn.liontalk.mongodb.entity.OrderEntity;

public interface OrderService {

    public OrderEntity getByOrderNo(String orderNo);

    public OrderEntity getByOrderNoLike(String orderNo);

    public void saveOrder(OrderEntity order);

    public void removeOrderByOrderNo(String orderNo);

    public void updateOrder(OrderEntity order);
}
