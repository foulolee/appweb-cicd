# 1) 베이스 이미지만 내 레지스트리 이미지로 변경
FROM 211.34.229.48:5000/tomcat:latest

# 2) 기존 conf 삭제 + 새 server.xml 적용
#RUN rm -rf /usr/local/tomcat/conf/*
#COPY tomcat_conf/* /usr/local/tomcat/conf/server.xml

# 3) 기본 webapps 삭제 후 새 WAR 배포
RUN rm -rf /usr/local/tomcat/webapps/*
COPY appweb.war /usr/local/tomcat/webapps/ROOT.war

# 4) 포트 오픈
EXPOSE 8080

# 5) Tomcat 실행
CMD ["/bin/bash", "-c", "/usr/local/tomcat/bin/catalina.sh start && tail -f /usr/local/tomcat/logs/catalina.out"]




# 1) Tomcat이 설치된 기본 이미지
#FROM tomcat:9.0-jdk11-temurin

# 2) 기존 conf 삭제 + 새 server.xml 적용 (원하신 대로)
#RUN rm -rf /usr/local/tomcat/conf/*
#COPY tomcat_conf/server.xml /usr/local/tomcat/conf/server.xml

# 3) 기본 webapps 삭제 후 새 WAR 배포
#RUN rm -rf /usr/local/tomcat/webapps/*
#COPY appweb.war /usr/local/tomcat/webapps/ROOT.war

# 4) 포트 오픈
#EXPOSE 8080

# 5) Tomcat 실행
#CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]















