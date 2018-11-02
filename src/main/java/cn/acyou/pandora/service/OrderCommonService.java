package cn.acyou.pandora.service;

import cn.acyou.pandora.client.OrderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author youfang
 * @version [1.0.0, 2018-11-01 下午 04:03]
 **/
@Component
public class OrderCommonService {
    private final static Logger logger = LoggerFactory.getLogger(OrderCommonService.class);

    @Autowired
    private OrderClient orderClient;

    public String getInfoFromOrder(){
        logger.info("OrderClient ------------->");
        return orderClient.getOrder();
    }

    public String addOrderInfo(){
        logger.info("Client 添加订单 ------------->");
        return orderClient.addOrder();
    }

}
