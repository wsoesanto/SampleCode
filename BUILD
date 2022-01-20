load("@com_github_bazelbuild_buildtools//buildifier:def.bzl", "buildifier")
load("@build_bazel_rules_nodejs//packages/typescript:index.bzl", "ts_config")
load("@dagger//:workspace_defs.bzl", "dagger_rules")
load("@io_bazel_rules_kotlin//kotlin:core.bzl", "define_kt_toolchain", "kt_compiler_plugin", "kt_javac_options", "kt_kotlinc_options")

dagger_rules()

buildifier(
    name = "buildifier",
    exclude_patterns = [
        "./third_party/*",
    ],
)

ts_config(
    name = "tsconfig",
    src = "tsconfig.json",
    visibility = [
        "//visibility:public",
    ],
    deps = [
        "@npm//gts:gts__files",
    ],
)

filegroup(
    name = "gitignore",
    srcs = glob(["third_party/*/.gitgignore"]),
)

kt_kotlinc_options(
    name = "kt_kotlinc_options",
)

kt_javac_options(
    name = "kt_javac_options",
)

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.4",
    experimental_use_abi_jars = False,
    javac_options = "//:kt_javac_options",
    jvm_target = "1.8",
    kotlinc_options = "//:kt_kotlinc_options",
    language_version = "1.4",
)
