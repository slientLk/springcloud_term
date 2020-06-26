package cn.yqd.client.hystrix;

import cn.yqd.client.AnalysisService;
import org.springframework.stereotype.Component;

@Component
public class AnalysisServiceHystrix implements AnalysisService {
    @Override
    public String getSaleDataByMonth(String sTime, String eTime) {
        System.out.println("启动熔断器");
        return "启动熔断器";
    }

    @Override
    public String test() {
        System.out.println("进入熔断器");
        return "进入熔断器";
    }
}
