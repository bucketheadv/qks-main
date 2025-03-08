#!/usr/bin/env sh

# uber-jar是生成可直接通过java -jar启动的jar文件
mvn clean package -DskipTests -U -Dquarkus.package.type=uber-jar