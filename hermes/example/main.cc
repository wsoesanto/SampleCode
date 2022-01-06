#include <iostream>

#include <grpcpp/ext/proto_server_reflection_plugin.h>
#include <grpcpp/grpcpp.h>
#include <grpcpp/health_check_service_interface.h>
#include <glog/logging.h>
#include <gflags/gflags.h>

#include "hermes/example/hello_world_service.pb.h"
#include "hermes/example/hello_world_service.grpc.pb.h"

class ServiceImpl final : public hermes::example::HelloWorldService::Service {
public:
    grpc::Status SayHello(grpc::ServerContext* context, const hermes::example::SayHelloRequest* req, hermes::example::SayHelloResponse* res) override {
        // LOG(INFO) << "Getting called";
        hermes::example::SayHelloResponse response;
        response.set_name("Muahaha");
        *res = response;
        return grpc::Status::OK;
    }
};

int main(int argc, char* argv[]) {
    gflags::ParseCommandLineFlags(&argc, &argv, true);
    google::InitGoogleLogging(argv[0]);
    grpc::ServerBuilder server_builder;
    grpc::EnableDefaultHealthCheckService(true);
    server_builder.AddListeningPort("localhost:9090", grpc::InsecureServerCredentials());

    ServiceImpl service_impl;
    server_builder.RegisterService(&service_impl);
    auto server = server_builder.BuildAndStart();
    LOG(INFO) << "Waiting for it to be closed.";
    server->Wait();
    return 0;
}
