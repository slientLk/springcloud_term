package cn.gjj.controller;

import cn.gjj.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalysisController {
    @GetMapping("/test")
    public String test() {
        return "test...";
    }

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    /**
     * 按日统计销售情况
     * @param sTime 开始时间
     * @param eTime 结束时间
     * @return
     */
    @GetMapping("/getSaleDataByDay/{sTime}/{eTime}")
//    @RequiresPermissions(value = "按日统计分析")
    public String getSaleDataByDay(@PathVariable String sTime, @PathVariable String eTime) {
        return saleListGoodsService.getSaleDataByDay(sTime, eTime);
    }

    /**
     * 按月统计销售情况
     * @param sTime 开始时间
     * @param eTime 结束时间
     * @return
     */
    @GetMapping("/getSaleDataByMonth/{sTime}/{eTime}")
//    @RequiresPermissions(value = "按月统计分析")
    public String getSaleDataByMonth(@PathVariable String sTime, @PathVariable String eTime) {
        return saleListGoodsService.getSaleDataByMonth(sTime, eTime);
    }

}
