#!/usr/bin/env bash


if [ ! -n "$1" ] ;then
    echo "you have not input a table"
    exit
else
    echo "the table you input is $1"
fi

table=$1

base_dir=$(cd `dirname $0`/..;pwd)

LOG4J=$base_dir/conf/log4j.properties
if [ -f $LOG4J ]; then
    export LOG4J_PARAMS="-Dlog4j.configuration=file:$LOG4J"
fi


jars=$base_dir/datax.utils-1.0.jar
for jar in ${base_dir}/lib/*jar
do
jars=$jars:$jar
done

#java -cp $jars $LOG4J_PARAMS  datax.utils.HiveMetaData  -k $base_dir/conf/data.keytab -p "dev@SEFON.COM" -j "jdbc:hive2://sdc1:10000/;principal=hive/sdc2@sefon.COM" -t "test1"
/usr/jdk64/jdk1.8.0_112/bin/java -cp $jars $LOG4J_PARAMS  datax.utils.HiveMetaData  -j "jdbc:hive2://sdc3:10000/defalut" -t $table
