# 1️⃣ Use a lightweight Java 17 JDK image
FROM eclipse-temurin:17-jdk-alpine

# 2️⃣ Set working directory
WORKDIR /app

# 3️⃣ Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# 4️⃣ Copy the source code
COPY src ./src

# 5️⃣ Make Maven wrapper executable
RUN chmod +x mvnw

# 6️⃣ Build the JAR (skip tests to save time)
RUN ./mvnw clean package -DskipTests

# 7️⃣ Expose the port your Spring Boot app runs on
EXPOSE 8080

# 8️⃣ Start the app
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
