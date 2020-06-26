package cn.yqd.controller;

import cn.yqd.client.AnalysisService;
import cn.yqd.service.PurchaseListGoodsService;
import com.inventory.entity.PurchaseList;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    @GetMapping("/test")
    public String test() {
        return "test...";
    }

    /**
     * 添加进货单信息
     * @param purchaseList
     * @return
     */
    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer savePurchaseList(@RequestBody PurchaseList purchaseList) {

        return purchaseListGoodsService.save(purchaseList);
    }

    /**
     * 根据进货单id查询进货单商品信息
     * @param purchaseListId
     * @return
     */
    @GetMapping("/getGoodListById/{purchaseListId}")
    public Map<String, Object> getGoodListById(@PathVariable Integer purchaseListId) {
        return purchaseListGoodsService.goodsList(purchaseListId);
    }

    /**
     * 根据id删除进货单
     * @param purchaseListId
     * @return
     */
    @GetMapping("/delete/{purchaseListId}")
    public String deletePurchaseListById(@PathVariable Integer purchaseListId) {
        return purchaseListGoodsService.delete(purchaseListId);
    }

    /**
     * 进货商品统计
     * @param goodsTypeId 商品类别ID
     * @param codeOrName 编号或商品名称
     * @return
     */
    @RequestMapping("/count/{goodsTypeId}/{codeOrName}")
    public String count(@PathVariable Integer goodsTypeId, @PathVariable String codeOrName) {
        return purchaseListGoodsService.count(goodsTypeId, codeOrName);
    }

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/analysis/getMon/{stime}/{etime}")
    public String AnalysisMonth(@PathVariable String stime, @PathVariable String etime) {
        return analysisService.getSaleDataByMonth(stime, etime);
    }

    @GetMapping("/analysis")
    public String Analysis() {
        return analysisService.test();
    }

}
