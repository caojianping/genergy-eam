// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Result.proto

package net.gichain.genergy.eam.grpc.lib;

public final class ResultOuterClass {
  private ResultOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_net_gichain_genergy_eam_grpc_lib_Result_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_net_gichain_genergy_eam_grpc_lib_Result_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Result.proto\022 net.gichain.genergy.eam." +
      "grpc.lib\032\031google/protobuf/any.proto\"U\n\006R" +
      "esult\022\014\n\004code\030\001 \001(\005\022\017\n\007success\030\002 \001(\010\022\017\n\007" +
      "message\030\003 \001(\t\022\014\n\004data\030\004 \001(\t\022\r\n\005trace\030\005 \001" +
      "(\tB\002P\001b\006proto3"
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
        }, assigner);
    internal_static_net_gichain_genergy_eam_grpc_lib_Result_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_net_gichain_genergy_eam_grpc_lib_Result_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_net_gichain_genergy_eam_grpc_lib_Result_descriptor,
        new java.lang.String[] { "Code", "Success", "Message", "Data", "Trace", });
    com.google.protobuf.AnyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
