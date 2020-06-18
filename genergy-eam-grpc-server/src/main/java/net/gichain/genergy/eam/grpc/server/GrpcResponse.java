package net.gichain.genergy.eam.grpc.server;

import com.alibaba.fastjson.JSON;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.grpc.lib.Result;
import io.grpc.stub.StreamObserver;

public class GrpcResponse {
    public static void success(Object object, StreamObserver<Result> responseObserver) {
        CodeEnum codeEnum = CodeEnum.SUCCESS;
        Result result = Result.newBuilder()
                .setCode(codeEnum.getCode())
                .setMessage(codeEnum.getMessage())
                .setData(JSON.toJSONString(object))
                .build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    public static void failure(CodeEnum codeEnum, StreamObserver<Result> responseObserver) {
        Result result = Result.newBuilder()
                .setCode(codeEnum.getCode())
                .setMessage(codeEnum.getMessage())
                .setData(null)
                .build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
