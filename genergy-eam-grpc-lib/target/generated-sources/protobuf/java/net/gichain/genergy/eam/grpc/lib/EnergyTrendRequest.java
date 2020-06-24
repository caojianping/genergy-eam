// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Energy.proto

package net.gichain.genergy.eam.grpc.lib;

/**
 * Protobuf type {@code net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest}
 */
public  final class EnergyTrendRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest)
    EnergyTrendRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EnergyTrendRequest.newBuilder() to construct.
  private EnergyTrendRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EnergyTrendRequest() {
    assetId_ = 0L;
    type_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EnergyTrendRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            assetId_ = input.readInt64();
            break;
          }
          case 16: {

            type_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return net.gichain.genergy.eam.grpc.lib.Energy.internal_static_net_gichain_genergy_eam_grpc_lib_EnergyTrendRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return net.gichain.genergy.eam.grpc.lib.Energy.internal_static_net_gichain_genergy_eam_grpc_lib_EnergyTrendRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.class, net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.Builder.class);
  }

  public static final int ASSETID_FIELD_NUMBER = 1;
  private long assetId_;
  /**
   * <pre>
   * 资产编号
   * </pre>
   *
   * <code>int64 assetId = 1;</code>
   */
  public long getAssetId() {
    return assetId_;
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private int type_;
  /**
   * <pre>
   * 类型
   * </pre>
   *
   * <code>int32 type = 2;</code>
   */
  public int getType() {
    return type_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (assetId_ != 0L) {
      output.writeInt64(1, assetId_);
    }
    if (type_ != 0) {
      output.writeInt32(2, type_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (assetId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, assetId_);
    }
    if (type_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, type_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest)) {
      return super.equals(obj);
    }
    net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest other = (net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest) obj;

    boolean result = true;
    result = result && (getAssetId()
        == other.getAssetId());
    result = result && (getType()
        == other.getType());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ASSETID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getAssetId());
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest)
      net.gichain.genergy.eam.grpc.lib.EnergyTrendRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return net.gichain.genergy.eam.grpc.lib.Energy.internal_static_net_gichain_genergy_eam_grpc_lib_EnergyTrendRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return net.gichain.genergy.eam.grpc.lib.Energy.internal_static_net_gichain_genergy_eam_grpc_lib_EnergyTrendRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.class, net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.Builder.class);
    }

    // Construct using net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      assetId_ = 0L;

      type_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return net.gichain.genergy.eam.grpc.lib.Energy.internal_static_net_gichain_genergy_eam_grpc_lib_EnergyTrendRequest_descriptor;
    }

    public net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest getDefaultInstanceForType() {
      return net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.getDefaultInstance();
    }

    public net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest build() {
      net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest buildPartial() {
      net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest result = new net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest(this);
      result.assetId_ = assetId_;
      result.type_ = type_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest) {
        return mergeFrom((net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest other) {
      if (other == net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest.getDefaultInstance()) return this;
      if (other.getAssetId() != 0L) {
        setAssetId(other.getAssetId());
      }
      if (other.getType() != 0) {
        setType(other.getType());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long assetId_ ;
    /**
     * <pre>
     * 资产编号
     * </pre>
     *
     * <code>int64 assetId = 1;</code>
     */
    public long getAssetId() {
      return assetId_;
    }
    /**
     * <pre>
     * 资产编号
     * </pre>
     *
     * <code>int64 assetId = 1;</code>
     */
    public Builder setAssetId(long value) {
      
      assetId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 资产编号
     * </pre>
     *
     * <code>int64 assetId = 1;</code>
     */
    public Builder clearAssetId() {
      
      assetId_ = 0L;
      onChanged();
      return this;
    }

    private int type_ ;
    /**
     * <pre>
     * 类型
     * </pre>
     *
     * <code>int32 type = 2;</code>
     */
    public int getType() {
      return type_;
    }
    /**
     * <pre>
     * 类型
     * </pre>
     *
     * <code>int32 type = 2;</code>
     */
    public Builder setType(int value) {
      
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 类型
     * </pre>
     *
     * <code>int32 type = 2;</code>
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest)
  }

  // @@protoc_insertion_point(class_scope:net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest)
  private static final net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest();
  }

  public static net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EnergyTrendRequest>
      PARSER = new com.google.protobuf.AbstractParser<EnergyTrendRequest>() {
    public EnergyTrendRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EnergyTrendRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EnergyTrendRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EnergyTrendRequest> getParserForType() {
    return PARSER;
  }

  public net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

