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
 * 发电量服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: Energy.proto")
public final class EnergyServiceGrpc {

  private EnergyServiceGrpc() {}

  public static final String SERVICE_NAME = "net.gichain.genergy.eam.grpc.lib.EnergyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetYesterdayEnergyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getYesterdayEnergy",
      requestType = net.gichain.genergy.eam.grpc.lib.AssetIdRequest.class,
      responseType = net.gichain.genergy.eam.grpc.lib.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetYesterdayEnergyMethod() {
    io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.AssetIdRequest, net.gichain.genergy.eam.grpc.lib.Result> getGetYesterdayEnergyMethod;
    if ((getGetYesterdayEnergyMethod = EnergyServiceGrpc.getGetYesterdayEnergyMethod) == null) {
      synchronized (EnergyServiceGrpc.class) {
        if ((getGetYesterdayEnergyMethod = EnergyServiceGrpc.getGetYesterdayEnergyMethod) == null) {
          EnergyServiceGrpc.getGetYesterdayEnergyMethod = getGetYesterdayEnergyMethod =
              io.grpc.MethodDescriptor.<net.gichain.genergy.eam.grpc.lib.AssetIdRequest, net.gichain.genergy.eam.grpc.lib.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getYesterdayEnergy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.AssetIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.Result.getDefaultInstance()))
              .setSchemaDescriptor(new EnergyServiceMethodDescriptorSupplier("getYesterdayEnergy"))
              .build();
        }
      }
    }
    return getGetYesterdayEnergyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetEnergyTrendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEnergyTrend",
      requestType = net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.class,
      responseType = net.gichain.genergy.eam.grpc.lib.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest,
      net.gichain.genergy.eam.grpc.lib.Result> getGetEnergyTrendMethod() {
    io.grpc.MethodDescriptor<net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest, net.gichain.genergy.eam.grpc.lib.Result> getGetEnergyTrendMethod;
    if ((getGetEnergyTrendMethod = EnergyServiceGrpc.getGetEnergyTrendMethod) == null) {
      synchronized (EnergyServiceGrpc.class) {
        if ((getGetEnergyTrendMethod = EnergyServiceGrpc.getGetEnergyTrendMethod) == null) {
          EnergyServiceGrpc.getGetEnergyTrendMethod = getGetEnergyTrendMethod =
              io.grpc.MethodDescriptor.<net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest, net.gichain.genergy.eam.grpc.lib.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getEnergyTrend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  net.gichain.genergy.eam.grpc.lib.Result.getDefaultInstance()))
              .setSchemaDescriptor(new EnergyServiceMethodDescriptorSupplier("getEnergyTrend"))
              .build();
        }
      }
    }
    return getGetEnergyTrendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnergyServiceStub newStub(io.grpc.Channel channel) {
    return new EnergyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnergyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EnergyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnergyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EnergyServiceFutureStub(channel);
  }

  /**
   * <pre>
   * 发电量服务
   * </pre>
   */
  public static abstract class EnergyServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 获取电站昨日发电量
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", energy: 15000 }
     * </pre>
     */
    public void getYesterdayEnergy(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getGetYesterdayEnergyMethod(), responseObserver);
    }

    /**
     * <pre>
     * 获取发电量走势
     * 使用：马习文
     * 响应：List&lt;{ date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：[ { date: "2020-01-01", energy: 15000 }, { date: "2020-01-02", energy: 25000 } ]
     * </pre>
     */
    public void getEnergyTrend(net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEnergyTrendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetYesterdayEnergyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                net.gichain.genergy.eam.grpc.lib.AssetIdRequest,
                net.gichain.genergy.eam.grpc.lib.Result>(
                  this, METHODID_GET_YESTERDAY_ENERGY)))
          .addMethod(
            getGetEnergyTrendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest,
                net.gichain.genergy.eam.grpc.lib.Result>(
                  this, METHODID_GET_ENERGY_TREND)))
          .build();
    }
  }

  /**
   * <pre>
   * 发电量服务
   * </pre>
   */
  public static final class EnergyServiceStub extends io.grpc.stub.AbstractStub<EnergyServiceStub> {
    private EnergyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电站昨日发电量
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", energy: 15000 }
     * </pre>
     */
    public void getYesterdayEnergy(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetYesterdayEnergyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 获取发电量走势
     * 使用：马习文
     * 响应：List&lt;{ date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：[ { date: "2020-01-01", energy: 15000 }, { date: "2020-01-02", energy: 25000 } ]
     * </pre>
     */
    public void getEnergyTrend(net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest request,
        io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEnergyTrendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 发电量服务
   * </pre>
   */
  public static final class EnergyServiceBlockingStub extends io.grpc.stub.AbstractStub<EnergyServiceBlockingStub> {
    private EnergyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电站昨日发电量
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", energy: 15000 }
     * </pre>
     */
    public net.gichain.genergy.eam.grpc.lib.Result getYesterdayEnergy(net.gichain.genergy.eam.grpc.lib.AssetIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetYesterdayEnergyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 获取发电量走势
     * 使用：马习文
     * 响应：List&lt;{ date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：[ { date: "2020-01-01", energy: 15000 }, { date: "2020-01-02", energy: 25000 } ]
     * </pre>
     */
    public net.gichain.genergy.eam.grpc.lib.Result getEnergyTrend(net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEnergyTrendMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 发电量服务
   * </pre>
   */
  public static final class EnergyServiceFutureStub extends io.grpc.stub.AbstractStub<EnergyServiceFutureStub> {
    private EnergyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 获取电站昨日发电量
     * 使用：桂朝
     * 响应：Object&lt;{ assetId: String, date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：{ assetId: "123456789", date: "2020-01-01", energy: 15000 }
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<net.gichain.genergy.eam.grpc.lib.Result> getYesterdayEnergy(
        net.gichain.genergy.eam.grpc.lib.AssetIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetYesterdayEnergyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 获取发电量走势
     * 使用：马习文
     * 响应：List&lt;{ date: String, energy: Decimal（目前取并网日发电量） }&gt;
     * 示例：[ { date: "2020-01-01", energy: 15000 }, { date: "2020-01-02", energy: 25000 } ]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<net.gichain.genergy.eam.grpc.lib.Result> getEnergyTrend(
        net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEnergyTrendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_YESTERDAY_ENERGY = 0;
  private static final int METHODID_GET_ENERGY_TREND = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnergyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnergyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_YESTERDAY_ENERGY:
          serviceImpl.getYesterdayEnergy((net.gichain.genergy.eam.grpc.lib.AssetIdRequest) request,
              (io.grpc.stub.StreamObserver<net.gichain.genergy.eam.grpc.lib.Result>) responseObserver);
          break;
        case METHODID_GET_ENERGY_TREND:
          serviceImpl.getEnergyTrend((net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest) request,
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

  private static abstract class EnergyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnergyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return net.gichain.genergy.eam.grpc.lib.Energy.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnergyService");
    }
  }

  private static final class EnergyServiceFileDescriptorSupplier
      extends EnergyServiceBaseDescriptorSupplier {
    EnergyServiceFileDescriptorSupplier() {}
  }

  private static final class EnergyServiceMethodDescriptorSupplier
      extends EnergyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnergyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnergyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnergyServiceFileDescriptorSupplier())
              .addMethod(getGetYesterdayEnergyMethod())
              .addMethod(getGetEnergyTrendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
