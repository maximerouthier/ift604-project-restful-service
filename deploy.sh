#!/bin/bash

mkdir tomee/webapps/restful-service
mkdir tomee/webapps/restful-service/WEB-INF
mkdir tomee/webapps/restful-service/WEB-INF/classes

cp -R development/etc/ tomee/webapps/restful-service/WEB-INF
cp -R development/classes/ tomee/webapps/restful-service/WEB-INF/classes
