// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ChunkService.proto

package com.gaian.grpc;

public final class ChunkService {
  private ChunkService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_gaian_grpc_GetChunkRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_gaian_grpc_GetChunkRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_gaian_grpc_GetChunkResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_gaian_grpc_GetChunkResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022ChunkService.proto\022\016com.gaian.grpc\"#\n\017" +
      "GetChunkRequest\022\020\n\010filePath\030\001 \001(\t\" \n\020Get" +
      "ChunkResponse\022\014\n\004data\030\001 \001(\0142`\n\017GetChunkS" +
      "ervice\022M\n\010getChunk\022\037.com.gaian.grpc.GetC" +
      "hunkRequest\032 .com.gaian.grpc.GetChunkRes" +
      "ponseB\002P\001b\006proto3"
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
        }, assigner);
    internal_static_com_gaian_grpc_GetChunkRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_gaian_grpc_GetChunkRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_gaian_grpc_GetChunkRequest_descriptor,
        new String[] { "FilePath", });
    internal_static_com_gaian_grpc_GetChunkResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_gaian_grpc_GetChunkResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_gaian_grpc_GetChunkResponse_descriptor,
        new String[] { "Data", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
