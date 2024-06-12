# Usa una imagen base de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación Spring Boot (asegúrate de ajustar el nombre del archivo JAR según tu proyecto)
COPY target/System-0.0.1-SNAPSHOT.jar system.jar

# Expone el puerto en el que se ejecutará tu aplicación Spring Boot (ajusta según sea necesario)
EXPOSE 4001

# Comando para ejecutar la aplicación Spring Boot dentro del contenedor
CMD ["java", "-jar", "system.jar"]
