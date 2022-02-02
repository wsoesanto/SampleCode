load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@dagger//:workspace_defs.bzl", "DAGGER_ARTIFACTS", "DAGGER_REPOSITORIES", "HILT_ANDROID_ARTIFACTS")

_MAVEN_DEPS = [
    # keep sorted
    "org.apache.beam:beam-sdks-java-core:2.35.0",
    "antlr:antlr:2.7.7",
    "aopalliance:aopalliance:1.0",
    "args4j:args4j:2.33",
    "com.fasterxml.jackson.core:jackson-core:2.10.3",
    "com.github.albfernandez:juniversalchardet:2.0.0",
    "com.github.ben-manes.caffeine:caffeine:2.8.0",
    "com.github.ben-manes.caffeine:guava:2.8.1",
    "com.github.rholder:guava-retrying:2.0.0",
    "com.google.api.grpc:proto-google-common-protos:1.17.0",
    "com.google.auto:auto-common:1.0",
    "com.google.auto.factory:auto-factory:1.0-beta8",
    "com.google.auto.service:auto-service:1.0-rc5",
    "com.google.auto.service:auto-service-annotations:1.0-rc5",
    "com.google.auto.value:auto-value:1.6",
    "com.google.auto.value:auto-value-annotations:1.6",
    "com.google.code.findbugs:jsr305:3.0.2",
    "com.google.code.gson:gson:2.8.5",
    "com.google.common.html.types:types:1.0.8",
    "com.google.devtools.ksp:symbol-processing-api:1.5.30-1.0.0",
    "com.google.errorprone:error_prone_annotations:2.10.0",
    "com.google.errorprone:error_prone_check_api:2.10.0",
    "com.google.errorprone:error_prone_core:2.10.0",
    "com.google.errorprone:javac:9+181-r4173-1",
    "com.google.errorprone:javac-shaded:9+181-r4173-1",
    "com.google.flogger:flogger-log4j-backend:0.4",
    "com.google.googlejavaformat:google-java-format:1.7",
    "com.google.guava:failureaccess:1.0.1",
    "com.google.guava:guava:30.1.1-jre",
    "com.google.guava:guava-beta-checker:1.0",
    "com.google.inject.extensions:guice-assistedinject:4.2.2",
    "com.google.inject.extensions:guice-servlet:4.2.2",
    "com.google.inject:guice:4.2.2",
    "com.google.instrumentation:instrumentation-api:0.4.3",
    "com.google.re2j:re2j:1.5",
    "com.google.template:soy:2019-10-08",
    "com.google.testing.compile:compile-testing:0.19",
    "com.google.truth:truth:1.1.3",
    "com.googlecode.javaewah:JavaEWAH:1.1.6",
    "com.googlecode.prolog-cafe:prolog-compiler:1.4.3",
    "com.googlecode.prolog-cafe:prolog-io:1.4.3",
    "com.googlecode.prolog-cafe:prolog-runtime:1.4.3",
    "com.ibm.icu:icu4j:57.1",
    "com.jcraft:jsch:0.1.54",
    "com.jcraft:jzlib:1.1.3",
    "com.opencsv:opencsv:5.5.2",
    "com.ryanharter.auto.value:auto-value-gson-extension:1.3.0",
    "com.ryanharter.auto.value:auto-value-gson-factory:1.3.0",
    "com.ryanharter.auto.value:auto-value-gson-runtime:1.3.0",
    "com.squareup:javapoet:1.12.1",
    "com.squareup:kotlinpoet:1.6.0",
    "com.squareup.okhttp3:okhttp:4.4.1",
    "com.squareup.okio:okio:3.0.0",
    "com.squareup.okio:okio-jvm:3.0.0",
    "com.vladsch.flexmark:flexmark:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-abbreviation:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-anchorlink:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-autolink:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-definition:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-emoji:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-escaped-character:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-footnotes:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-gfm-issues:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-gfm-strikethrough:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-gfm-tables:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-gfm-tasklist:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-gfm-users:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-ins:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-jekyll-front-matter:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-superscript:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-tables:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-toc:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-typographic:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-wikilink:0.34.18",
    "com.vladsch.flexmark:flexmark-ext-yaml-front-matter:0.34.18",
    "com.vladsch.flexmark:flexmark-formatter:0.34.18",
    "com.vladsch.flexmark:flexmark-html-parser:0.34.18",
    "com.vladsch.flexmark:flexmark-profile-pegdown:0.34.18",
    "com.vladsch.flexmark:flexmark-util:0.34.18",
    "commons-codec:commons-codec:1.10",
    "commons-dbcp:commons-dbcp:1.4",
    "commons-lang:commons-lang:2.6",
    "commons-net:commons-net:3.6",
    "commons-pool:commons-pool:1.5.5",
    "commons-validator:commons-validator:1.6",
    "de.siegmar:fastcsv:2.1.0",
    "de.skuzzle:semantic-version:2.1.0",
    "dk.brics:automaton:1.12-1",
    "eu.medsea.mimeutil:mime-util:2.1.3",
    "io.dropwizard.metrics:metrics-core:4.1.5",
    "io.grpc:grpc-context:1.43.2",
    "io.grpc:grpc-netty:1.43.2",
    "org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.2.1",
    "io.netty:netty-all:4.1.65.Final",
    "io.opentelemetry.instrumentation:opentelemetry-grpc-1.6:1.9.0-alpha",
    "io.opentelemetry.javaagent.instrumentation:opentelemetry-javaagent-grpc-1.5:0.14.0",
    "io.opentelemetry:opentelemetry-api:1.9.1",
    "io.opentelemetry:opentelemetry-api-common:0.13.1",
    "io.opentelemetry:opentelemetry-bom:1.9.1",
    "io.opentelemetry:opentelemetry-context:1.10.0",
    "io.opentelemetry:opentelemetry-exporters-logging:0.9.1",
    "io.opentelemetry:opentelemetry-exporters-otlp:0.9.1",
    "io.opentelemetry:opentelemetry-extension-kotlin:1.9.1",
    "io.opentelemetry:opentelemetry-sdk:1.9.1",
    "io.opentelemetry:opentelemetry-sdk-trace:1.9.1",
    "io.opentracing.contrib:opentracing-rxjava-3:0.1.4",
    "io.opentracing:opentracing-api:0.33.0",
    "io.opentracing:opentracing-impl:0.21.0",
    "io.opentracing:opentracing-impl-java8:0.16.0",
    "io.opentracing:opentracing-mock:0.33.0",
    "io.opentracing:opentracing-noop:0.33.0",
    "io.opentracing:opentracing-util:0.33.0",
    "io.reactivex.rxjava3:rxjava:3.0.7",
    "javax.annotation:javax.annotation-api:1.2",
    "javax.annotation:jsr250-api:1.0",
    "javax.enterprise:cdi-api:2.0",
    "javax.inject:javax.inject:1",
    "junit:junit:4.12",
    "net.i2p.crypto:eddsa:0.3.0",
    "net.logstash.log4j:jsonevent-layout:1.7",
    "net.ltgt.gradle.incap:incap:0.2",
    "net.ltgt.gradle.incap:incap-processor:0.2",
    "net.minidev:json-smart:1.1.1",
    "org.antlr:antlr:3.5.2",
    "org.antlr:antlr-runtime:3.5.2",
    "org.antlr:stringtemplate:4.0.2",
    "org.apache.ant:ant:1.10.7",
    "org.apache.ant:ant-launcher:1.10.7",
    "org.apache.commons:commons-compress:1.18",
    "org.apache.commons:commons-lang3:3.8.1",
    "org.apache.commons:commons-text:1.2",
    "org.apache.httpcomponents:fluent-hc:4.4.1",
    "org.apache.httpcomponents:httpclient:4.4.1",
    "org.apache.httpcomponents:httpcore:4.4.1",
    "org.apache.james:apache-mime4j-core:0.8.1",
    "org.apache.james:apache-mime4j-dom:0.8.1",
    "org.apache.logging.log4j:log4j-core:2.17.1",
    "org.apache.lucene:lucene-analyzers-common:6.6.5",
    "org.apache.lucene:lucene-backward-codecs:6.6.5",
    "org.apache.lucene:lucene-core:8.8.2",
    "org.apache.lucene:lucene-misc:8.8.2",
    "org.apache.lucene:lucene-queryparser:8.8.2",
    "org.apache.maven:maven-artifact:3.6.3",
    "org.apache.maven:maven-model:3.8.1",
    "org.apache.maven:maven-plugin-api:3.8.1",
    "org.apache.mina:mina-core:2.0.21",
    "org.apache.sshd:sshd-common:2.3.0",
    "org.apache.sshd:sshd-core:2.3.0",
    "org.apache.sshd:sshd-mina:2.3.0",
    "org.apache.tomcat:annotations-api:6.0.53",
    "org.apache.tomcat:tomcat-annotations-api:10.0.6",
    "org.apache.tomcat:tomcat-servlet-api:8.5.23",
    "com.google.firebase:firebase-admin:8.1.0",
    "com.google.auth:google-auth-library-credentials:1.4.0",
    "com.google.auth:google-auth-library-oauth2-http:1.4.0",
    "com.google.cloud:google-cloud-firestore:3.0.10",
    "com.google.api:api-common:2.1.3",
    "org.bouncycastle:bcpg-jdk15on:1.61",
    "org.bouncycastle:bcpkix-jdk15on:1.61",
    "org.bouncycastle:bcprov-jdk15on:1.61",
    "org.checkerframework:checker-compat-qual:2.5.5",
    "org.checkerframework:checker-qual:2.5.5",
    "org.codehaus.mojo:animal-sniffer-annotations:1.18",
    "org.codehaus.plexus:plexus-classworlds:2.6.0",
    "org.codehaus.plexus:plexus-component-annotations:2.1.0",
    "org.codehaus.plexus:plexus-utils:3.3.0",
    "org.eclipse.sisu:org.eclipse.sisu.inject:0.3.4",
    "org.eclipse.sisu:org.eclipse.sisu.plexus:0.3.4",
    "org.hamcrest:hamcrest-library:1.3",
    "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.0",
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0",
    "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.5.0",
    "org.jetbrains.kotlinx:kotlinx-coroutines-debug:1.5.0",
    "org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.3.0",
    "com.google.flogger:flogger-log4j2-backend:0.7.4",
    "com.google.j2objc:j2objc-annotations:1.3",
    "com.google.protobuf:protobuf-kotlin:3.17.0-rc-2",
    "org.apache.logging.log4j:log4j-slf4j-impl:2.17.1",
    "org.jsoup:jsoup:1.9.2",
    "org.nibor.autolink:autolink:0.7.0",
    "org.ow2.asm:asm:7.2",
    "org.ow2.asm:asm-analysis:7.2",
    "org.ow2.asm:asm-commons:7.2",
    "org.ow2.asm:asm-tree:7.2",
    "org.ow2.asm:asm-util:7.2",
    "org.pantsbuild:jarjar:1.7.2",
    "org.slf4j:jcl-over-slf4j:1.7.26",
    "org.slf4j:log4j-over-slf4j:1.7.26",
    "org.slf4j:slf4j-api:1.7.26",
    "org.slf4j:slf4j-ext:1.7.26",
    "org.tukaani:xz:1.8",
] + DAGGER_ARTIFACTS + HILT_ANDROID_ARTIFACTS

def _get_bazel_maven_target_name(name):
    return name.rpartition(":")[0].replace("-", "_").replace(".", "_").replace(":", "_")

def get_bazel_maven_target_names():
    return [_get_bazel_maven_target_name(dep) for dep in _MAVEN_DEPS]

def maven_deps_install():
    maven_install(
        artifacts = _MAVEN_DEPS,
        repositories = [
            "https://repo1.maven.org/maven2",
            "https://maven.google.com",
            "https://jcenter.bintray.com/",  # Lint has one trove4j dependency in jCenter
            "https://gerrit-maven.storage.googleapis.com",
            "https://jcenter.bintray.com/",
            "https://mvnrepository.com",
        ] + DAGGER_REPOSITORIES,
    )


    for dep in _MAVEN_DEPS:
        native.bind(
            name = "%s" % dep.split(":")[1],
            actual = "@maven//:%s" % _get_bazel_maven_target_name(dep),
        )

    for name in get_bazel_maven_target_names():
        if name not in native.existing_rules():
            native.new_local_repository(
                name = "%s" % name,
                build_file_content = """package(
    default_visibility = ["//visibility:public"],
)
java_library(
    name = "jar",
    exports = ["@maven//:%s"]
)

java_library(
    name = "%s",
    exports = ["@maven//:%s"]
)
                """ % (name, name, name),
                path = "repo/maven",
                workspace_file = "WORKSPACE",
            )
