FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8
VOLUME /tmp
ADD target/cloud-eureka-server-1.0-SNAPSHOT.jar cloud-eureka-server.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /cloud-eureka-server.jar --server.port=8761