FROM java:8
MAINTAINER demo@test.io
VOLUME /tmp
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} boot-demo-2.7.2.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 9299
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","boot-demo-2.7.2.jar"]
