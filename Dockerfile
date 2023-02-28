FROM eclipse-temurin:17-alpine AS builder

WORKDIR /opt/nabi
COPY build/libs/discord/discord.jar ./discord.jar
ENTRYPOINT java \
    -Xmx4g \
    nabi.jar


