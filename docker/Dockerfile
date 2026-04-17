FROM 211.34.229.48:5000/was-tomcat9:1.0

# 1. server.xml만 교체 (전체 삭제 X)
COPY tomcat_conf/server.xml /usr/local/tomcat/conf/server.xml

# 2. 기본 webapps 제거
RUN rm -rf /usr/local/tomcat/webapps/*

# 3. WAR 배포 (ROOT로)
COPY app/target/appweb.war /usr/local/tomcat/webapps/appweb.war

# 4. 포트
EXPOSE 8080

# 5. 실행 (정석)
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]



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




















