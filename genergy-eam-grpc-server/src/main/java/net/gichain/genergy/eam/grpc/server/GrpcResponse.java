package net.gichain.genergy.eam.grpc.server;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.util.UUIDUtils;
import net.gichain.genergy.eam.grpc.lib.Result;
import io.grpc.stub.StreamObserver;

@Slf4j
public class GrpcResponse {
    public static void success(Object object, StreamObserver<Result> responseObserver) {
        CodeEnum codeEnum = CodeEnum.SUCCESS;
        Result result = Result.newBuilder()
                .setSuccess(true)
                .setCode(codeEnum.getCode())
                .setMessage(codeEnum.getMessage())
                .setData(object == null ? "" : JSON.toJSONString(object))
                .setTrace(UUIDUtils.randomUUID())
                .build();
        log.info(String.format("GrpcResponse.success result: %s", result));
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    public static void failure(CodeEnum codeEnum, StreamObserver<Result> responseObserver) {
        Result result = Result.newBuilder()
                .setSuccess(false)
                .setCode(codeEnum.getCode())
                .setMessage(codeEnum.getMessage())
                .setData("")
                .setTrace(UUIDUtils.randomUUID())
                .build();
        log.info(String.format("GrpcResponse.failure result: %s", result));
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
