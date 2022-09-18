FROM java:8
MAINTAINER demo
RUN mkdir -p /app/config/
ENV MYPATH /app
WORKDIR $MYPATH
ENV PARAMS="--spring.config.location=file:/app/config/application.properties"
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD target/xxl-job-admin-*.jar app.jar
EXPOSE 8080
EXPOSE 6666
EXPOSE 9999
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=6666 app.jar $PARAMS"]