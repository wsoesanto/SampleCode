load("@com_github_bazelbuild_buildtools//buildifier:def.bzl", "buildifier")
load("@build_bazel_rules_nodejs//packages/typescript:index.bzl", "ts_config")
load("@dagger//:workspace_defs.bzl", "dagger_rules", "hilt_android_rules")

dagger_rules()

hilt_android_rules()

buildifier(
    name = "buildifier",
    exclude_patterns = [
        "./third_party/*",
    ],
)
java_library(
    name = "hilt",
    exported_plugins = [
        ":hilt_dagger_compiler",
        ":hilt_android_entry_point_processor",
        ":hilt_aggregated_deps_processor",
        ":hilt_alias_of_processor",
        ":hilt_define_component_processor",
        ":hilt_early_entry_points_processor",
        ":hilt_generates_root_input_processor",
        ":hilt_originating_element_processor",
        ":hilt_root_processor",
        ":hilt_component_tree_deps_processor",
        ":hilt_view_model_processor",
    ],
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_google_dagger_dagger",  # For Dagger APIs
        "@maven//:javax_inject_javax_inject",  # For @Inject
        "@maven//:com_google_dagger_hilt_core",
        "@maven//:javax_annotation_jsr250_api",
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
