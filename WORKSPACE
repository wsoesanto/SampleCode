workspace(
    name = "SampleCode",
)

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#android_sdk_repository(
#    name = "androidsdk",  # Required. Name *must* be "androidsdk".
#     path = "/Users/willys/Library/Android/sdk",  # Optional. Can be omitted if `ANDROID_HOME` environment variable is set.
#)

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
    remote = "https://github.com/bazelbuild/rules_swift",
    tag = "0.24.0",
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
    remote = "https://github.com/bazelbuild/rules_foreign_cc",
    tag = "main",
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

<<<<<<< Updated upstream
go_register_toolchains(go_version = "1.15.5")
=======
go_register_toolchains()
>>>>>>> Stashed changes

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

git_repository(
    name = "dagger",
    branch = "master",
    remote = "https://github.com/google/dagger",
)

load("//repo/maven:deps.bzl", "maven_deps_install")

maven_deps_install()

git_repository(
    name = "rules_android",
    remote = "https://github.com/bazelbuild/rules_android",
    tag = "v0.1.1",
)

git_repository(
    name = "io_bazel_rules_kotlin_master",
    branch = "master",
    remote = "https://github.com/bazelbuild/rules_kotlin",
)

load("@io_bazel_rules_kotlin_master//src/main/starlark/release_archive:repository.bzl", "archive_repository")

archive_repository(
    name = "io_bazel_rules_kotlin",
    source_repository_name = "io_bazel_rules_kotlin_master",
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")

<<<<<<< Updated upstream
kotlin_repositories()
=======
kotlin_repositories(
    compiler_release = {
       "urls": [
           "https://github.com/JetBrains/kotlin/releases/download/v1.5.31/kotlin-compiler-1.5.31.zip",
       ],
       "sha256": "661111286f3e5ac06aaf3a9403d869d9a96a176b62b141814be626a47249fe9e",
   },
)
>>>>>>> Stashed changes

load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")

kt_register_toolchains()

git_repository(
    name = "flogger",
    remote = "https://github.com/google/flogger",
    tag = "flogger-0.7",
)

# If this needs updating the hash value in the "strip_prefix" and "urls" lines
# should be the hash of the latest Github commit for bazel-common. The "sha256"
# value should be the SHA-256 of the downloaded zip file, but if you just try
# and commit with the old value then Travis should report the expected value
# in the most recent failure in
# https://travis-ci.org/github/google/flogger/builds
http_archive(
    name = "google_bazel_common",
    sha256 = "d8aa0ef609248c2a494d5dbdd4c89ef2a527a97c5a87687e5a218eb0b77ff640",
    strip_prefix = "bazel-common-4a8d451e57fb7e1efecbf9495587a10684a19eb2",
    urls = ["https://github.com/google/bazel-common/archive/4a8d451e57fb7e1efecbf9495587a10684a19eb2.zip"],
)

load("@google_bazel_common//:workspace_defs.bzl", "google_common_workspace_rules")

#google_common_workspace_rules()

android_sdk_repository(
    name = "androidsdk",
    api_level = 32,
)

http_archive(
    name = "openjdk8",
    build_file_content = """
java_runtime(name = 'runtime', srcs =  glob(['**']), visibility = ['//visibility:public'])
exports_files(["WORKSPACE"], visibility = ["//visibility:public"])
""",
    strip_prefix = "zulu8.38.0.13-ca-jdk8.0.212-macosx_x64",
    urls = ["https://mirror.bazel.build/openjdk/azul-zulu8.38.0.13-ca-jdk8.0.212/zulu8.38.0.13-ca-jdk8.0.212-macosx_x64.tar.gz"],
)

http_archive(
    name = "openjdk11",
    build_file_content = """
java_runtime(name = 'runtime', srcs =  glob(['**']), visibility = ['//visibility:public'])
exports_files(["WORKSPACE"], visibility = ["//visibility:public"])
""",
    strip_prefix = "zulu11.31.11-ca-jdk11.0.3-macosx_x64",
    urls = ["https://mirror.bazel.build/openjdk/azul-zulu11.31.11-ca-jdk11.0.3/zulu11.31.11-ca-jdk11.0.3-macosx_x64.tar.gz"],
)

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()
<<<<<<< Updated upstream
=======

ATS_COMMIT = "8c41148e623d33ae38e1029b39576893429aede5"

http_archive(
    name = "android_test_support",
    strip_prefix = "android-test-%s" % ATS_COMMIT,
    urls = ["https://github.com/android/android-test/archive/%s.tar.gz" % ATS_COMMIT],
)
load("@android_test_support//:repo.bzl", "android_test_repositories")
android_test_repositories()
>>>>>>> Stashed changes
