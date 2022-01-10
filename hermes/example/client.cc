#include <grpcpp/support/status.h>
#include <grpcpp/support/sync_stream.h>
#include <iostream>

#include <grpcpp/channel.h>
#include <grpcpp/client_context.h>
#include <grpcpp/create_channel.h>
#include <grpcpp/security/credentials.h>
#include <grpcpp/ext/proto_server_reflection_plugin.h>
#include <grpcpp/grpcpp.h>
#include <grpcpp/health_check_service_interface.h>
#include <glog/logging.h>
#include <gflags/gflags.h>

#include "hermes/example/hello_world_service.pb.h"
#include "hermes/example/hello_world_service.grpc.pb.h"

int main(int argc, char* argv[]) {
    gflags::ParseCommandLineFlags(&argc, &argv, true);
    google::InitGoogleLogging(argv[0]);
    
    // grpc::ServerBuilder server_builder;
    // grpc::EnableDefaultHealthCheckService(true);
    auto service = hermes::example::HelloWorldService::Stub(grpc::CreateChannel("localhost:8080", grpc::InsecureChannelCredentials()));

    grpc::ClientContext context;
    hermes::example::SayHelloRequest request;
    hermes::example::SayHelloResponse response;
    grpc::Status code = service.SayHello(&context, request, &response);
    LOG(INFO) << code.error_code() << " " << response.DebugString() << " " << code.error_message();

    // ServiceImpl service_impl;
    // server_builder.RegisterService(&service_impl);
    // auto server = server_builder.BuildAndStart();
    // LOG(INFO) << "Waiting for it to be closed.";
    // server->Wait();
    return 0;
}
