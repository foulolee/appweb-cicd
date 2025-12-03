# 1) Tomcat이 설치된 CentOS7 기반 이미지
FROM tomcat:9.0-jdk11-temurin

# 2) 서버 설정 복사 (Git 리포지토리의 docker/server.xml 사용)
COPY /K8s/server.xml /usr/local/tomcat/conf/server.xml

# 3) 빌드된 WAR 파일 복사
#   GitHub Actions에서 app/target/appweb.war 를 이 경로로 복사해서 빌드할 예정
COPY appweb.war /usr/local/tomcat/appweb/appweb.war

# 4) 포트 오픈 (Tomcat 디폴트 8080)
EXPOSE 8080

# 5) Tomcat 실행
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]


