// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Result.proto

package net.gichain.genergy.eam.grpc.lib;

/**
 * Protobuf type {@code net.gichain.genergy.eam.grpc.lib.Result}
 */
public  final class Result extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:net.gichain.genergy.eam.grpc.lib.Result)
    ResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Result.newBuilder() to construct.
  private Result(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Result() {
    code_ = 0;
    success_ = false;
    message_ = "";
    data_ = "";
    trace_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Result(
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

            code_ = input.readInt32();
            break;
          }
          case 16: {

            success_ = input.readBool();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            data_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            trace_ = s;
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
    return net.gichain.genergy.eam.grpc.lib.ResultOuterClass.internal_static_net_gichain_genergy_eam_grpc_lib_Result_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return net.gichain.genergy.eam.grpc.lib.ResultOuterClass.internal_static_net_gichain_genergy_eam_grpc_lib_Result_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            net.gichain.genergy.eam.grpc.lib.Result.class, net.gichain.genergy.eam.grpc.lib.Result.Builder.class);
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private int code_;
  /**
   * <pre>
   * 响应码：0成功；其他失败；
   * </pre>
   *
   * <code>int32 code = 1;</code>
   */
  public int getCode() {
    return code_;
  }

  public static final int SUCCESS_FIELD_NUMBER = 2;
  private boolean success_;
  /**
   * <pre>
   * 是否成功：true成功；false失败；
   * </pre>
   *
   * <code>bool success = 2;</code>
   */
  public boolean getSuccess() {
    return success_;
  }

  public static final int MESSAGE_FIELD_NUMBER = 3;
  private volatile java.lang.Object message_;
  /**
   * <pre>
   * 响应消息
   * </pre>
   *
   * <code>string message = 3;</code>
   */
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 响应消息
   * </pre>
   *
   * <code>string message = 3;</code>
   */
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATA_FIELD_NUMBER = 4;
  private volatile java.lang.Object data_;
  /**
   * <pre>
   * 响应数据
   * </pre>
   *
   * <code>string data = 4;</code>
   */
  public java.lang.String getData() {
    java.lang.Object ref = data_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      data_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 响应数据
   * </pre>
   *
   * <code>string data = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDataBytes() {
    java.lang.Object ref = data_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      data_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TRACE_FIELD_NUMBER = 5;
  private volatile java.lang.Object trace_;
  /**
   * <pre>
   * 响应堆栈
   * </pre>
   *
   * <code>string trace = 5;</code>
   */
  public java.lang.String getTrace() {
    java.lang.Object ref = trace_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      trace_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 响应堆栈
   * </pre>
   *
   * <code>string trace = 5;</code>
   */
  public com.google.protobuf.ByteString
      getTraceBytes() {
    java.lang.Object ref = trace_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      trace_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (code_ != 0) {
      output.writeInt32(1, code_);
    }
    if (success_ != false) {
      output.writeBool(2, success_);
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, message_);
    }
    if (!getDataBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, data_);
    }
    if (!getTraceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, trace_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, code_);
    }
    if (success_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, success_);
    }
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, message_);
    }
    if (!getDataBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, data_);
    }
    if (!getTraceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, trace_);
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
    if (!(obj instanceof net.gichain.genergy.eam.grpc.lib.Result)) {
      return super.equals(obj);
    }
    net.gichain.genergy.eam.grpc.lib.Result other = (net.gichain.genergy.eam.grpc.lib.Result) obj;

    boolean result = true;
    result = result && (getCode()
        == other.getCode());
    result = result && (getSuccess()
        == other.getSuccess());
    result = result && getMessage()
        .equals(other.getMessage());
    result = result && getData()
        .equals(other.getData());
    result = result && getTrace()
        .equals(other.getTrace());
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
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode();
    hash = (37 * hash) + SUCCESS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getSuccess());
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (37 * hash) + TRACE_FIELD_NUMBER;
    hash = (53 * hash) + getTrace().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static net.gichain.genergy.eam.grpc.lib.Result parseFrom(
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
  public static Builder newBuilder(net.gichain.genergy.eam.grpc.lib.Result prototype) {
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
   * Protobuf type {@code net.gichain.genergy.eam.grpc.lib.Result}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:net.gichain.genergy.eam.grpc.lib.Result)
      net.gichain.genergy.eam.grpc.lib.ResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return net.gichain.genergy.eam.grpc.lib.ResultOuterClass.internal_static_net_gichain_genergy_eam_grpc_lib_Result_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return net.gichain.genergy.eam.grpc.lib.ResultOuterClass.internal_static_net_gichain_genergy_eam_grpc_lib_Result_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              net.gichain.genergy.eam.grpc.lib.Result.class, net.gichain.genergy.eam.grpc.lib.Result.Builder.class);
    }

    // Construct using net.gichain.genergy.eam.grpc.lib.Result.newBuilder()
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
      code_ = 0;

      success_ = false;

      message_ = "";

      data_ = "";

      trace_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return net.gichain.genergy.eam.grpc.lib.ResultOuterClass.internal_static_net_gichain_genergy_eam_grpc_lib_Result_descriptor;
    }

    public net.gichain.genergy.eam.grpc.lib.Result getDefaultInstanceForType() {
      return net.gichain.genergy.eam.grpc.lib.Result.getDefaultInstance();
    }

    public net.gichain.genergy.eam.grpc.lib.Result build() {
      net.gichain.genergy.eam.grpc.lib.Result result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public net.gichain.genergy.eam.grpc.lib.Result buildPartial() {
      net.gichain.genergy.eam.grpc.lib.Result result = new net.gichain.genergy.eam.grpc.lib.Result(this);
      result.code_ = code_;
      result.success_ = success_;
      result.message_ = message_;
      result.data_ = data_;
      result.trace_ = trace_;
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
      if (other instanceof net.gichain.genergy.eam.grpc.lib.Result) {
        return mergeFrom((net.gichain.genergy.eam.grpc.lib.Result)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(net.gichain.genergy.eam.grpc.lib.Result other) {
      if (other == net.gichain.genergy.eam.grpc.lib.Result.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (other.getSuccess() != false) {
        setSuccess(other.getSuccess());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (!other.getData().isEmpty()) {
        data_ = other.data_;
        onChanged();
      }
      if (!other.getTrace().isEmpty()) {
        trace_ = other.trace_;
        onChanged();
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
      net.gichain.genergy.eam.grpc.lib.Result parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (net.gichain.genergy.eam.grpc.lib.Result) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int code_ ;
    /**
     * <pre>
     * 响应码：0成功；其他失败；
     * </pre>
     *
     * <code>int32 code = 1;</code>
     */
    public int getCode() {
      return code_;
    }
    /**
     * <pre>
     * 响应码：0成功；其他失败；
     * </pre>
     *
     * <code>int32 code = 1;</code>
     */
    public Builder setCode(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 响应码：0成功；其他失败；
     * </pre>
     *
     * <code>int32 code = 1;</code>
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }

    private boolean success_ ;
    /**
     * <pre>
     * 是否成功：true成功；false失败；
     * </pre>
     *
     * <code>bool success = 2;</code>
     */
    public boolean getSuccess() {
      return success_;
    }
    /**
     * <pre>
     * 是否成功：true成功；false失败；
     * </pre>
     *
     * <code>bool success = 2;</code>
     */
    public Builder setSuccess(boolean value) {
      
      success_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 是否成功：true成功；false失败；
     * </pre>
     *
     * <code>bool success = 2;</code>
     */
    public Builder clearSuccess() {
      
      success_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <pre>
     * 响应消息
     * </pre>
     *
     * <code>string message = 3;</code>
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 响应消息
     * </pre>
     *
     * <code>string message = 3;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 响应消息
     * </pre>
     *
     * <code>string message = 3;</code>
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 响应消息
     * </pre>
     *
     * <code>string message = 3;</code>
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 响应消息
     * </pre>
     *
     * <code>string message = 3;</code>
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object data_ = "";
    /**
     * <pre>
     * 响应数据
     * </pre>
     *
     * <code>string data = 4;</code>
     */
    public java.lang.String getData() {
      java.lang.Object ref = data_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        data_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 响应数据
     * </pre>
     *
     * <code>string data = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDataBytes() {
      java.lang.Object ref = data_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        data_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 响应数据
     * </pre>
     *
     * <code>string data = 4;</code>
     */
    public Builder setData(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 响应数据
     * </pre>
     *
     * <code>string data = 4;</code>
     */
    public Builder clearData() {
      
      data_ = getDefaultInstance().getData();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 响应数据
     * </pre>
     *
     * <code>string data = 4;</code>
     */
    public Builder setDataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      data_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object trace_ = "";
    /**
     * <pre>
     * 响应堆栈
     * </pre>
     *
     * <code>string trace = 5;</code>
     */
    public java.lang.String getTrace() {
      java.lang.Object ref = trace_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        trace_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 响应堆栈
     * </pre>
     *
     * <code>string trace = 5;</code>
     */
    public com.google.protobuf.ByteString
        getTraceBytes() {
      java.lang.Object ref = trace_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        trace_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 响应堆栈
     * </pre>
     *
     * <code>string trace = 5;</code>
     */
    public Builder setTrace(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      trace_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 响应堆栈
     * </pre>
     *
     * <code>string trace = 5;</code>
     */
    public Builder clearTrace() {
      
      trace_ = getDefaultInstance().getTrace();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 响应堆栈
     * </pre>
     *
     * <code>string trace = 5;</code>
     */
    public Builder setTraceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      trace_ = value;
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


    // @@protoc_insertion_point(builder_scope:net.gichain.genergy.eam.grpc.lib.Result)
  }

  // @@protoc_insertion_point(class_scope:net.gichain.genergy.eam.grpc.lib.Result)
  private static final net.gichain.genergy.eam.grpc.lib.Result DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new net.gichain.genergy.eam.grpc.lib.Result();
  }

  public static net.gichain.genergy.eam.grpc.lib.Result getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Result>
      PARSER = new com.google.protobuf.AbstractParser<Result>() {
    public Result parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Result(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Result> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Result> getParserForType() {
    return PARSER;
  }

  public net.gichain.genergy.eam.grpc.lib.Result getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
