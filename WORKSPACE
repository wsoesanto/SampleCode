workspace(
    name = "SampleCode",
)

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# android_sdk_repository(
#     name = "androidsdk",  # Required. Name *must* be "androidsdk".
#     path = "/Users/willys/Library/Android/sdk",  # Optional. Can be omitted if `ANDROID_HOME` environment variable is set.
# )

git_repository(
    name = "io_grpc_grpc_java",
    branch = "master",
    remote = "https://github.com/grpc/grpc-java",
)

git_repository(
    name = "com_github_grpc_grpc_kotlin",
    branch = "master",
    remote = "https://github.com/grpc/grpc-kotlin",
)

load("@com_github_grpc_grpc_kotlin//:repositories.bzl", "grpc_kt_repositories")
grpc_kt_repositories()

git_repository(
    name = "build_bazel_rules_swift",
    tag = "0.24.0",
    remote = "https://github.com/bazelbuild/rules_swift",
)

load(
    "@build_bazel_rules_swift//swift:repositories.bzl",
    "swift_rules_dependencies",
)

swift_rules_dependencies()

load(
    "@build_bazel_rules_swift//swift:extras.bzl",
    "swift_rules_extra_dependencies",
)

swift_rules_extra_dependencies()


git_repository(
    name = "rules_jvm_external",
    branch = "master",
    remote = "https://github.com/bazelbuild/rules_jvm_external",
)

git_repository(
    name = "rules_proto",
    branch = "master",
    remote = "https://github.com/bazelbuild/rules_proto",
)

git_repository(
    name = "bazel_skylib",
    remote = "https://github.com/bazelbuild/bazel-skylib",
    tag = "1.0.3",
)

git_repository(
    name = "com_google_googleapis",
    branch = "master",
    remote = "https://github.com/googleapis/googleapis",
)

load("@com_google_googleapis//:repository_rules.bzl", "switched_rules_by_language")

switched_rules_by_language(
    name = "com_google_googleapis_imports",
    cc = True,
    csharp = False,
    gapic = False,
    go = True,
    grpc = False,
    java = True,
    nodejs = False,
    php = False,
    python = True,
    ruby = False,
)

git_repository(
    name = "opencensus_proto",
    branch = "master",
    remote = "https://github.com/census-instrumentation/opencensus-proto",
    strip_prefix = "src",
)

git_repository(
    name = "com_github_cncf_udpa",
    branch = "master",
    remote = "https://github.com/cncf/udpa",
)

git_repository(
    name = "build_bazel_rules_nodejs",
    branch = "stable",
    remote = "https://github.com/bazelbuild/rules_nodejs",
)

git_repository(
    name = "com_github_nelhage_rules_boost",
    commit = "fce83babe3f6287bccb45d2df013a309fa3194b8",
    remote = "https://github.com/nelhage/rules_boost",
    shallow_since = "1591047380 -0700",
)

load("@com_github_nelhage_rules_boost//:boost/boost.bzl", "boost_deps")
boost_deps()


git_repository(
    name = "com_google_fruit",
    branch = "master",
    remote = "https://github.com/google/fruit",
    strip_prefix = "extras/bazel_root",
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_toolchains")

rules_proto_toolchains()

git_repository(
    name = "com_github_grpc_grpc_web",
    remote = "https://github.com/grpc/grpc-web",
    tag = "1.2.1",
)

load("@build_bazel_rules_nodejs//packages/labs:package.bzl", "npm_bazel_labs_dependencies")

npm_bazel_labs_dependencies()

git_repository(
    name = "abseil",
    branch = "master",
    remote = "https://github.com/abseil/abseil-cpp",
)

git_repository(
    name = "rules_pkg",
    branch = "0.2.6",
    remote = "https://github.com/bazelbuild/rules_pkg",
    strip_prefix = "pkg",
)

git_repository(
    name = "io_bazel_stardoc",
    branch = "0.4.0",
    remote = "https://github.com/bazelbuild/stardoc",
)

git_repository(
    name = "com_googlesource_gerrit_bazlets",
    branch = "stable-3.1",
    remote = "https://gerrit.googlesource.com/bazlets",
)

git_repository(
    name = "com_github_bazelbuild_buildtools",
    remote = "https://github.com/bazelbuild/buildtools",
    tag = "1.0.0",
)

git_repository(
    name = "google_bazel_common",
    branch = "master",
    remote = "https://github.com/google/bazel-common",
)

git_repository(
    name = "rules_foreign_cc",
    tag = "main",
    remote = "https://github.com/bazelbuild/rules_foreign_cc",
)

git_repository(
    name = "com_github_grpc_grpc",
    branch = "master",
    remote = "https://github.com/grpc/grpc",
)

load("@com_github_grpc_grpc//bazel:grpc_deps.bzl", "grpc_deps")

grpc_deps()


git_repository(
    name = "com_googlesource_code_re2",
    branch = "main",
    remote = "https://github.com/google/re2",
)

git_repository(
    name = "io_bazel_rules_closure",
    branch = "master",
    remote = "https://github.com/bazelbuild/rules_closure",
)

git_repository(
    name = "envoy",
    branch = "master",
    remote = "https://github.com/envoyproxy/envoy",
)

git_repository(
    name = "com_google_googletest",
    branch = "master",
    remote = "https://github.com/google/googletest",
)

git_repository(
    name = "io_bazel_rules_rust",
    branch = "main",
    remote = "https://github.com/bazelbuild/rules_rust",
)

load("//repo/maven:deps.bzl", "maven_deps_install")

maven_deps_install()

http_archive(
    name = "zlib",
    build_file = "@com_google_protobuf//: /zlib.BUILD",
    sha256 = "629380c90a77b964d896ed37163f5c3a34f6e6d897311f1df2a7016355c45eff",
    strip_prefix = "zlib-1.2.11",
    urls = ["https://github.com/madler/zlib/archive/v1.2.11.tar.gz"],
)

load("@build_bazel_rules_nodejs//:package.bzl", "rules_nodejs_dev_dependencies")

rules_nodejs_dev_dependencies()

git_repository(
    name = "build_bazel_rules_typescript",
    branch = "stable",
    remote = "https://github.com/bazelbuild/rules_nodejs",
    strip_prefix = "third_party/github.com/bazelbuild/rules_typescript",
)

# load("@build_bazel_rules_typescript//:package.bzl", "rules_typescript_dev_dependencies")

# rules_typescript_dev_dependencies()

load("@build_bazel_rules_nodejs//:index.bzl", "yarn_install")

yarn_install(
    name = "npm",
    package_json = "//:package.json",
    yarn_lock = "//:yarn.lock",
)

git_repository(
    name = "hedron_compile_commands",
    branch = "main",
    remote = "https://github.com/hedronvision/bazel-compile-commands-extractor",
)
load("@hedron_compile_commands//:workspace_setup.bzl", "hedron_compile_commands_setup")
hedron_compile_commands_setup()

git_repository(
    name = "io_bazel_rules_go",
    branch = "master",
    remote = "https://github.com/bazelbuild/rules_go",
)

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

# go_register_toolchains(version = "1.17.1")

http_archive(
    name = "com_github_gflags_gflags",
    sha256 = "34af2f15cf7367513b352bdcd2493ab14ce43692d2dcd9dfc499492966c64dcf",
    strip_prefix = "gflags-2.2.2",
    urls = ["https://github.com/gflags/gflags/archive/v2.2.2.tar.gz"],
)

http_archive(
    name = "com_github_google_glog",
    sha256 = "21bc744fb7f2fa701ee8db339ded7dce4f975d0d55837a97be7d46e8382dea5a",
    strip_prefix = "glog-0.5.0",
    urls = ["https://github.com/google/glog/archive/v0.5.0.zip"],
)

# load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

git_repository(
    name = "rules_android",
    tag = "v0.1.1",
    remote = "https://github.com/bazelbuild/rules_android",
)

git_repository(
    name = "io_bazel_rules_kotlin_master",
    branch = "master",
    remote = "https://github.com/bazelbuild/rules_kotlin",
)

load("@io_bazel_rules_kotlin_master//src/main/starlark/release_archive:repository.bzl", "archive_repository")

archive_repository(
    name = "io_bazel_rules_kotlin",
    source_repository_name = "io_bazel_rules_kotlin_master"
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
kotlin_repositories()

load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
kt_register_toolchains()