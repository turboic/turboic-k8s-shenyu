FROM java:8
MAINTAINER demo@test.io
ENV MYPATH /
WORKDIR $MYPATH
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} boot-demo.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 12306
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","boot-demo.jar"]