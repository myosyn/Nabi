FROM eclipse-temurin:17-alpine AS builder

WORKDIR /opt/Nabi
COPY bot/gateway/build/libs/gateway.jar ./gateway.jar
ENTRYPOINT java \
    -Xmx4g \
    ./gateway.jar


