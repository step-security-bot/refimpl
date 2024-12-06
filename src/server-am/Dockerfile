FROM docker.io/library/maven:3-eclipse-temurin-21-alpine@sha256:de7f84a3d3acd245a56e09a44a99fcf9e3ca5896d9dc1a62357e266243da3836 AS build

COPY . /src
WORKDIR /src
RUN mvn -B --no-transfer-progress -DskipTests clean package -pl server-am -am

FROM docker.io/library/jetty:12-jre21-eclipse-temurin@sha256:c6e1e16ed794758de69df1aceb64f6a1065224e9abf203bbf16256c992057b56
# WARNING DO NOT CHANGE WORKDIR or set it back to what it was before
# $JETTY_BASE must be correct before starting Jetty

COPY --from=build /src/server-am/target/*.war /var/lib/jetty/webapps/ROOT.war

RUN java -jar "$JETTY_HOME/start.jar" --add-modules=ee9-deploy,ee9-jsp,ee9-jstl
