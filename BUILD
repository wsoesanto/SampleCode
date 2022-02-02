load("@com_github_bazelbuild_buildtools//buildifier:def.bzl", "buildifier")
load("@build_bazel_rules_nodejs//packages/typescript:index.bzl", "ts_config")
load("@dagger//:workspace_defs.bzl", "dagger_rules")
load("@io_bazel_rules_kotlin//kotlin:core.bzl", "define_kt_toolchain", "kt_compiler_plugin", "kt_kotlinc_options")


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
        # "@npm//gts:gts__files",
    ],
)
