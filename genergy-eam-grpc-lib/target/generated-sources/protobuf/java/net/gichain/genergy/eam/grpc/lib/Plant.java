// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Plant.proto

package net.gichain.genergy.eam.grpc.lib;

public final class Plant {
  private Plant() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013Plant.proto\022 net.gichain.genergy.eam.g" +
      "rpc.lib\032\031google/protobuf/any.proto\032\rRequ" +
      "est.proto\032\014Result.proto2\363\001\n\014PlantService" +
      "\022s\n\023getElectricityPrice\0220.net.gichain.ge" +
      "nergy.eam.grpc.lib.AssetIdRequest\032(.net." +
      "gichain.genergy.eam.grpc.lib.Result\"\000\022n\n" +
      "\016getPlantDetail\0220.net.gichain.genergy.ea" +
      "m.grpc.lib.AssetIdRequest\032(.net.gichain." +
      "genergy.eam.grpc.lib.Result\"\000B\002P\001b\006proto" +
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.AnyProto.getDescriptor(),
          net.gichain.genergy.eam.grpc.lib.Request.getDescriptor(),
          net.gichain.genergy.eam.grpc.lib.ResultOuterClass.getDescriptor(),
        }, assigner);
    com.google.protobuf.AnyProto.getDescriptor();
    net.gichain.genergy.eam.grpc.lib.Request.getDescriptor();
    net.gichain.genergy.eam.grpc.lib.ResultOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
