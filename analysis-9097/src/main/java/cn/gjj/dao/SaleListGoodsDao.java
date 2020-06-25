package cn.gjj.dao;

import com.inventory.entity.SaleData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleListGoodsDao {

    List<SaleData> getSaleDataByDay(@Param("sTime") String sTime, @Param("eTime") String eTime);

    List<SaleData> getSaleDataByMonth(@Param("sTime") String sTime,@Param("eTime") String eTime);

}
