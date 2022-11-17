FROM openjdk:20-ea-17-slim
ADD target/demo-for-kubernetes.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT exec java -server -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app.jar
