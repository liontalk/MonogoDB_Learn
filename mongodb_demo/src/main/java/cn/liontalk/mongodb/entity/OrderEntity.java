package cn.liontalk.mongodb.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@ToString
@Document(collection="orderInfo")
public class OrderEntity {


    @Id
    private int id;

    private String orderNo;

    private String nickName;

    private BigDecimal totalPrice;


    /**
     * 购买数量
     */
    private int buyCount;

}
