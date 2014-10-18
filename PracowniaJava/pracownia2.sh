#!/bin/bash

#Compile
javac \
    src/com/pracownia2/WzorDwumianowy.java \
    src/com/pracownia2/TrojkatPascala.java \
    src/com/pracownia2/Pracownia2.java

array=(
    adasasdasda+b   1
    a-b   1
    a+b   0
    s+t   5
    s-t   5
    s-tsd   66

    a+b   67
    a*b   1
    a/b   1
    +b    1
    -a+b  1
    a+b  -1
)

#Run
for (( i = 0 ; i < ${#array[@]} ; i++ )) do

    if (( i % 2 != 0 ))    
    then
        continue
    fi
    
    java -classpath src com/pracownia2/Pracownia2 ${array[${i}]} ${array[${i}+1]}
    echo "" 

done

#Clean up
rm  src/com/pracownia2/*.class

