# Stage 1: Build
FROM openjdk:21-slim as build

WORKDIR /app

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven

# Копируем файлы проекта
COPY pom.xml .
COPY src src

# Скачиваем зависимости и собираем проект
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-slim

WORKDIR /app

# Копируем JAR-файл из предыдущего этапа
COPY --from=build /app/target/*.jar app.jar

# Открываем порт
EXPOSE 8080

# Устанавливаем команду для запуска приложения
ENTRYPOINT ["java", "-Dvertx.disableDnsResolver=true", "-Djava.net.preferIPv4Stack=true", "-jar", "app.jar"]
