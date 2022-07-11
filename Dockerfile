FROM eclipse-temurin:18-alpine AS builder

COPY build/libs/Nabi-*-all.jar /usr/local/lib/Nabi.jar

RUN mkdir /bot



