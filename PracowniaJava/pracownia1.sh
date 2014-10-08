#!/bin/bash

#Compile
javac src/com/pracownia1/LiczbySlownie.java src/com/pracownia1/Pracownia1.java

array=(
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 30 40 50 60 70 80 90 100 200 1000 2000
    28
    42
    842
    312
    12459413
    -2147483648
    2147483647
    12354
    1254
    985412
    68423385
    5135123
    -2147483649
    2147483648
    ass
    21.1
    1.0
)


#Run
for i in "${array[@]}"
do
     printf "%11s : " $i
    java  -classpath src com/pracownia1/Pracownia1 $i
done

