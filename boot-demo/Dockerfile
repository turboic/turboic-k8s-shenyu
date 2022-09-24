FROM java:8
MAINTAINER demo@test.io
ENV MYPATH /
WORKDIR $MYPATH
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} boot-demo.jar
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
EXPOSE 12306
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","boot-demo.jar"]