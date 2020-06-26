package cn.yqd.client;

import cn.yqd.client.hystrix.AnalysisServiceHystrix;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "analysis", fallback = AnalysisServiceHystrix.class)
public interface AnalysisService {

//    @RequestLine("GET /getSaleDataByMonth/{sTime}/{eTime}")
//    @GetMapping("/getSaleDataByMonth/{sTime}/{eTime}")
    @RequestMapping(value = "/getSaleDataByMonth/{sTime}/{eTime}", method = RequestMethod.GET)
    String getSaleDataByMonth(@PathVariable("sTime") String sTime, @PathVariable("eTime") String eTime);

    @GetMapping(value = "/test")
    String test();

}
