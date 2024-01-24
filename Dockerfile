FROM gradle:7-jdk11 AS compilar

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle buildFatJar --no-daemon
