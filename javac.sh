#!/bin/bash

javac -classpath development/classes:resteasy/lib/* -d development/classes \
  development/src/common/*.java \
  development/src/restfulservice/*.java \
  development/src/org/json/*.java
