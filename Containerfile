FROM registry.access.redhat.com/ubi8/openjdk-17:1.14 as build

COPY --chown=jboss . /app/
RUN cd /app && ls -la && ./gradlew build

FROM registry.access.redhat.com/ubi8/openjdk-17-runtime:1.14

ENV LANGUAGE='en_US:en'
# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --from=build --chown=jboss /app/build/quarkus-app/lib/ /deployments/lib/
COPY --from=build --chown=jboss /app/build/quarkus-app/*.jar /deployments/
COPY --from=build --chown=jboss /app/build/quarkus-app/app/ /deployments/app/
COPY --from=build --chown=jboss /app/build/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"