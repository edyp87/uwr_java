#!/bin/bash

#Compile
javac src/com/pracownia4/*.java src/narzedzia/*.java

#Run
java -classpath src com/pracownia4/Pracownia4 $@

#Clean up
rm src/com/pracownia4/*.class src/narzedzia/*.class

