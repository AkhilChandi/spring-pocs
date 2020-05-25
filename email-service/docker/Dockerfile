FROM java:8

MAINTAINER akhil.ch055@gamil.com

ADD docker/startup.sh /
RUN mkdir -p /etc/conf/email-service/

ADD src/main/resources/logback-spring.xml /etc/conf/email-service/logback-spring.xml

EXPOSE 8080
# run the application
#CMD [""]
ENTRYPOINT ["sh", "/startup.sh"]

# add the jar file
ADD target/email-service.jar email-service.jar