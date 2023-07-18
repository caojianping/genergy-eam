package net.gichain.genergy.eam.grpc.server.serverservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.util.DateUtils;
import net.gichain.genergy.eam.common.util.MathUtils;
import net.gichain.genergy.eam.database.entity.PlantAssetEnergyView;
import net.gichain.genergy.eam.grpc.lib.AssetIdRequest;
import net.gichain.genergy.eam.grpc.lib.EnergyServiceGrpc;
import net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest;
import net.gichain.genergy.eam.grpc.lib.Result;
import net.gichain.genergy.eam.grpc.server.GrpcResponse;
import net.gichain.genergy.eam.grpc.server.dto.EnergyYesterdayDTO;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetEnergyViewService;
import net.gichain.genergy.vo.statistics.Movements;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@GrpcService
public class EnergyServerService extends EnergyServiceGrpc.EnergyServiceImplBase {
    @Autowired
    private IPlantAssetEnergyViewService plantAssetEnergyViewService;

    /**
     * 获取电站昨日发电量
     *
     * @param request          请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getYesterdayEnergy(AssetIdRequest request, StreamObserver<Result> responseObserver) {
        Long assetId = request.getAssetId();
        log.info(String.format("获取电站昨日发电量 assetId: %d", assetId));

        QueryWrapper<PlantAssetEnergyView> wrapper = new QueryWrapper<PlantAssetEnergyView>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("asset_id", assetId);
        Date yesterday = DateUtils.plusDays(new Date(), -1);
        map.put("date", DateUtils.dateToStr(yesterday, "yyyy-MM-dd"));
        wrapper.allEq(map);
        PlantAssetEnergyView plantAssetEnergyView = plantAssetEnergyViewService.getOne(wrapper);
        log.info(String.format("获取电站昨日发电量 view: %s", plantAssetEnergyView));

        if (plantAssetEnergyView == null) {
            GrpcResponse.failure(CodeEnum.ENERGY_INEXISTENCE, responseObserver);
        } else {
            EnergyYesterdayDTO result = EnergyYesterdayDTO.convertFromView(plantAssetEnergyView);
            log.info(String.format("获取电站昨日发电量 result: %s", result));
            GrpcResponse.success(result, responseObserver);
        }
    }

    /**
     * 获取发电量走势
     *
     * @param request          请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getEnergyTrend(EnergyTrendRequest request, StreamObserver<Result> responseObserver) {
        // type: 1日；2月；3年；
        int type = request.getType();
        Long assetId = request.getAssetId();
        log.info(String.format("获取发电量走势 assetId,type: %d %d", assetId, type));

        List<PlantAssetEnergyView> plantAssetEnergyViews = new ArrayList<>();
        if (type == 1) {
            QueryWrapper<PlantAssetEnergyView> wrapper = new QueryWrapper<PlantAssetEnergyView>();
            wrapper.eq("asset_id", assetId);
            Date date = DateUtils.plusDays(new Date(), -10);
            wrapper.ge("date", DateUtils.dateToStr(date, "yyyy-MM-dd"));
            plantAssetEnergyViews = plantAssetEnergyViewService.list(wrapper);
        } else if (type == 2) {
            Date date = DateUtils.now("yyyy-MM-01");
            for (int i = 0; i < 12; i++) {
                PlantAssetEnergyView item = new PlantAssetEnergyView();
                item.setAssetId(assetId);

                Date mockDate = DateUtils.minusMonth(date, i);
                item.setDate(mockDate);

                int month = DateUtils.getMonthOfYear(mockDate);
                if (month == 5 || month == 6 || month == 10) {
                    BigDecimal energy = new BigDecimal(randomDigit(50000, 60000));
                    item.setGridDailyEnergy(MathUtils.bigDecimalRound(energy, 2));
                } else if (month == 7 || month == 8 || month == 9) {
                    BigDecimal energy = new BigDecimal(randomDigit(60000, 70000));
                    item.setGridDailyEnergy(MathUtils.bigDecimalRound(energy, 2));
                } else {
                    BigDecimal energy = new BigDecimal(randomDigit(20000, 40000));
                    item.setGridDailyEnergy(MathUtils.bigDecimalRound(energy, 2));
                }
                plantAssetEnergyViews.add(item);
            }
        } else if (type == 3) {
            for (int i = 0; i < 3; i++) {
                PlantAssetEnergyView item = new PlantAssetEnergyView();
                item.setAssetId(assetId);
                Date date = DateUtils.strToDate((2020 - i) + "-01-01", "yyyy-MM-dd");
                item.setDate(date);
                BigDecimal energy = new BigDecimal(randomDigit(480000, 600000));
                item.setGridDailyEnergy(MathUtils.bigDecimalRound(energy, 2));
                plantAssetEnergyViews.add(item);
            }
        }
        log.info(String.format("获取发电量走势 views: %s", plantAssetEnergyViews));

        List<Movements> result = convertToMovements(type, plantAssetEnergyViews);
        GrpcResponse.success(result, responseObserver);
    }

    public static List<Movements> convertToMovements(int type, List<PlantAssetEnergyView> views) {
        return (List<Movements>) views.stream().map(view -> {
            Long date = view.getDate() == null ? null : view.getDate().getTime();
            String energy = view.getGridDailyEnergy() == null ? "" : view.getGridDailyEnergy().toString();
            Movements movements = new Movements();
            movements.setTimeStamp(date);
            movements.setEnergy(energy);
            return movements;
        }).collect(Collectors.toList());
    }

    public static float randomDigit(float min, float max) {
        return min + ((max - min) * new Random().nextFloat());
    }
}
