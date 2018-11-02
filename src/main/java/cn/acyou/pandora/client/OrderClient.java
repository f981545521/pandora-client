package cn.acyou.pandora.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author youfang
 * @version [1.0.0, 2018-11-01 下午 04:01]
 **/
@FeignClient(name = "service-order")
public interface OrderClient {

    @RequestMapping(value = "/info/getOrder", method = RequestMethod.POST)
    public String getOrder();

    @RequestMapping(value = "/info/addOrder", method = RequestMethod.GET)
    public String addOrder();

}
