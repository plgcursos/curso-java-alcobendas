from tomcat:10.1-jdk17-temurin

# eliminar las aplicaciones de ejemplo
run rm -rf /usr/local/tomcat/webapps/*

# copiar nuestra aplicacion
copy target/J23-tienda-api.war /usr/local/tomcat/webapps/J23-tienda-api.war

expose 8080

cmd ["catalina.sh", "run"]