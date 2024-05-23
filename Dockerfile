# 构建阶段
FROM maven:3.8.2-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests && ls -l /app/target

# 打包阶段
FROM openjdk:17.0.2-jdk-slim
WORKDIR /app
COPY --from=build /app/target/server-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]