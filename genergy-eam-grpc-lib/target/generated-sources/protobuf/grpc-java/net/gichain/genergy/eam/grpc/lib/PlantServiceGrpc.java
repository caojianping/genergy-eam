package net.gichain.genergy.eam.grpc.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * 电站服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: Plant.proto")
public final class PlantServiceGrpc {

  private PlantServiceGrpc() {}

  public static final String SERVICE_NAME = "net.gichain.genergy.eam.grpc.lib.PlantService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetElectricityPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getElectricityPrice",
      requestType = net.gichain.genergy.eam.grpc.lib.AssetIdRequest.class,
      responseType = net.gichain.genergy.eam.grpc.lib.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetElectricityPriceMethod() {
    io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest, net.gichain.genergy.eam.grpc.lib.Result> getGetElectricityPriceMethod;
    if ((getGetElectricityPriceMethod = PlantServiceGrpc.getGetElectricityPriceMethod) == null) {
      synchronized (PlantServiceGrpc.class) {
        if ((getGetElectricityPriceMethod = PlantServiceGrpc.getGetElectricityPriceMethod) == null) {
          PlantServiceGrpc.getGetElectricityPriceMethod = getGetElectricityPriceMethod =
              io.grpc.MethodDescriptor.<net.gichain.genergy.eam.grpc.lib.AssetIdRequest, net.gichain.genergy.eam.grpc.lib.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getElectricityPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.AssetIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.Result.getDefaultInstance()))
              .setSchemaDescriptor(new PlantServiceMethodDescriptorSupplier("getElectricityPrice"))
              .build();
        }
      }
    }
    return getGetElectricityPriceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetPlantDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPlantDetail",
      requestType = net.gichain.genergy.eam.grpc.lib.AssetIdRequest.class,
      responseType = net.gichain.genergy.eam.grpc.lib.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetPlantDetailMethod() {
    io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest, net.gichain.genergy.eam.grpc.lib.Result> getGetPlantDetailMethod;
    if ((getGetPlantDetailMethod = PlantServiceGrpc.getGetPlantDetailMethod) == null) {
      synchronized (PlantServiceGrpc.class) {
        if ((getGetPlantDetailMethod = PlantServiceGrpc.getGetPlantDetailMethod) == null) {
          PlantServiceGrpc.getGetPlantDetailMethod = getGetPlantDetailMethod =
              io.grpc.MethodDescriptor.<net.gichain.genergy.eam.grpc.lib.AssetIdRequest, net.gichain.genergy.eam.grpc.lib.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPlantDetail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.AssetIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.Result.getDefaultInstance()))
              .setSchemaDescriptor(new PlantServiceMethodDescriptorSupplier("getPlantDetail"))
              .build();
        }
      }
    }
    return getGetPlantDetailMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlantServiceStub newStub(io.grpc.Channel channel) {
    return new PlantServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlantServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PlantServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PlantServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PlantServiceFutureStub(channel);
  }

  /**
   * <pre>
   * 电站服务
   * </pre>
   */
  public static abstract class PlantServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 获取电站上网电价
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, electricityPrice: Decimal }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", electricityPrice: 0.52 }
     * </pre>
     */
    public void getElectricityPrice(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getGetElectricityPriceMethod(), responseObserver);
    }

    /**
     * <pre>
     * 获取电站详情数据
     * 使用：马习文
     * 响应：Object&lt;{ assetId: String, more }&gt;
     * 示例：{ assetId: "123456789", more }
     * </pre>
     */
    public void getPlantDetail(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPlantDetailMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetElectricityPriceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
                net.gichain.genergy.eam.grpc.lib.Result>(
                  this, METHODID_GET_ELECTRICITY_PRICE)))
          .addMethod(
            getGetPlantDetailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
                net.gichain.genergy.eam.grpc.lib.Result>(
                  this, METHODID_GET_PLANT_DETAIL)))
          .build();
    }
  }

  /**
   * <pre>
   * 电站服务
   * </pre>
   */
  public static final class PlantServiceStub extends io.grpc.stub.AbstractStub<PlantServiceStub> {
    private PlantServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlantServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlantServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlantServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电站上网电价
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, electricityPrice: Decimal }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", electricityPrice: 0.52 }
     * </pre>
     */
    public void getElectricityPrice(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetElectricityPriceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 获取电站详情数据
     * 使用：马习文
     * 响应：Object&lt;{ assetId: String, more }&gt;
     * 示例：{ assetId: "123456789", more }
     * </pre>
     */
    public void getPlantDetail(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPlantDetailMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 电站服务
   * </pre>
   */
  public static final class PlantServiceBlockingStub extends io.grpc.stub.AbstractStub<PlantServiceBlockingStub> {
    private PlantServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlantServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlantServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlantServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电站上网电价
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, electricityPrice: Decimal }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", electricityPrice: 0.52 }
     * </pre>
     */
    public net.gichain.genergy.eam.grpc.lib.Result getElectricityPrice(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetElectricityPriceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 获取电站详情数据
     * 使用：马习文
     * 响应：Object&lt;{ assetId: String, more }&gt;
     * 示例：{ assetId: "123456789", more }
     * </pre>
     */
    public net.gichain.genergy.eam.grpc.lib.Result getPlantDetail(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPlantDetailMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 电站服务
   * </pre>
   */
  public static final class PlantServiceFutureStub extends io.grpc.stub.AbstractStub<PlantServiceFutureStub> {
    private PlantServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlantServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlantServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlantServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电站上网电价
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, electricityPrice: Decimal }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", electricityPrice: 0.52 }
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<net.gichain.genergy.eam.grpc.lib.Result> getElectricityPrice(
        net.gichain.genergy.eam.grpc.lib.AssetIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetElectricityPriceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 获取电站详情数据
     * 使用：马习文
     * 响应：Object&lt;{ assetId: String, more }&gt;
     * 示例：{ assetId: "123456789", more }
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<net.gichain.genergy.eam.grpc.lib.Result> getPlantDetail(
        net.gichain.genergy.eam.grpc.lib.AssetIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPlantDetailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ELECTRICITY_PRICE = 0;
  private static final int METHODID_GET_PLANT_DETAIL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlantServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PlantServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ELECTRICITY_PRICE:
          serviceImpl.getElectricityPrice((net.gichain.genergy.eam.grpc.lib.AssetIdRequest) request,
              (io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result>) responseObserver);
          break;
        case METHODID_GET_PLANT_DETAIL:
          serviceImpl.getPlantDetail((net.gichain.genergy.eam.grpc.lib.AssetIdRequest) request,
              (io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PlantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return net.gichain.genergy.eam.grpc.lib.Plant.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PlantService");
    }
  }

  private static final class PlantServiceFileDescriptorSupplier
      extends PlantServiceBaseDescriptorSupplier {
    PlantServiceFileDescriptorSupplier() {}
  }

  private static final class PlantServiceMethodDescriptorSupplier
      extends PlantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PlantServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PlantServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlantServiceFileDescriptorSupplier())
              .addMethod(getGetElectricityPriceMethod())
              .addMethod(getGetPlantDetailMethod())
              .build();
        }
      }
    }
    return result;
  }
}
