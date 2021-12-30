load("@com_github_bazelbuild_buildtools//buildifier:def.bzl", "buildifier")
load("@build_bazel_rules_nodejs//packages/typescript:index.bzl", "ts_config")


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
