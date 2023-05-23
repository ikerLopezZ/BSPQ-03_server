@echo off
mvn clean & mvn compile & mvn datanucleus:enhance & mvn datanucleus:schema-create & mvn jetty:run
PAUSE