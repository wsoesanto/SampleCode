load("@io_bazel_rules_kotlin//kotlin:android.bzl", "kt_android_library")

kt_android_library(
    name = "activity",
    manifest = "AndroidManifest.xml",
    srcs = ["MainActivity.kt"],
    deps = [
        "@maven//:androidx_activity_activity_ktx",
        "@maven//:androidx_appcompat_appcompat",
    ],
)

android_binary(
    name = "android",
    manifest = "AndroidManifest.xml",
    deps = [
        ":activity"
    ],
)