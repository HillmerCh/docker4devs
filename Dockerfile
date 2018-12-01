FROM tomee:8-jre-8.0.0-M1-webprofile
COPY app/target/java-docke4devs.war /usr/local/tomee/webapps/
#COPY <locationofapplication>/<warfile> /usr/local/tomee/webapps/<warfile>


#FROM payara/server-full
#COPY javaee-cafe-demo.war $DEPLOY_DIR