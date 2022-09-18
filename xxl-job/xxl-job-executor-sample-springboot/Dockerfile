FROM java:8
MAINTAINER demo
RUN mkdir -p /data/applogs/xxl-job/jobhandler
ENV MYPATH /
WORKDIR $MYPATH
ENV PARAMS=""
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD target/xxl-job-executor-sample-springboot-*.jar /app.jar
EXPOSE 8081
EXPOSE 9999
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /app.jar $PARAMS"]