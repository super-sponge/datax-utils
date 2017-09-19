##
## 编译
    mvn package
## 部署
    tar -zxf datax.utils-1.0-job.tar.gz
## 使用
    查看参数
    ./jobcreate.sh -h
    ./jobcreate.sh -f ../data/hive.json -b 4096 -t table1 -o ./joboracle.json
    ./jobcreate.sh -f ../data/hive.json -r ../data/oracle.json -k /etc/security/keytabs/hive.service.keytab -p hive/xj2@EXAMPLE.COM -b 4096 -t YX_DXX_TEST1 -c -o ./joboracle.json

