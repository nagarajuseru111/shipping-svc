FROM openjdk:11
LABEL maintainer="com.naga"
ADD target/shipping-app-demo.jar shipping-app-demo.jar
ENTRYPOINT [ "java", "-jar",  "/shipping-app-demo.jar"]
