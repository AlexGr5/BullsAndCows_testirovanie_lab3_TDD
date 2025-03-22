# Используем базовый образ с JDK
FROM openjdk:17-jdk-slim

# Копируем JAR-файл (предположим, что gradle будет собирать jar в build/libs)
COPY build/libs/*.jar app.jar

# Устанавливаем рабочую директорию
WORKDIR /app

# Открываем порт, если нужно
EXPOSE 8080

# Команда для запуска
ENTRYPOINT ["java", "-jar", "app.jar"]
