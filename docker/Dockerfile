# 1) 베이스 이미지
FROM 211.34.229.48:5000/appweb:20251202225313

# 2) 기존 conf 전체 삭제
RUN rm -rf /usr/local/tomcat/conf/*

# 3) server.xml 재적용
COPY tomcat_conf/server.xml /usr/local/tomcat/conf/server.xml

# 4) WAR 배포
COPY app/target/appweb.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]








