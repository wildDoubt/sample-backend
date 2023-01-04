#!/bin/bash

File=./src/main/resources/database.properties
if [ -f "$File" ]; then
  rm -f $File
fi

read -p "데이터베이스 URL 입력: " DB_URL
read -p "데이터베이스 사용자 이름 입력: " DB_USERNAME
read -sp "데이터베이스 암호 입력: " DB_PASSWORD

echo "database.DB_URL=$DB_URL" >> ./src/main/resources/database.properties
echo "database.DB_USERNAME=$DB_USERNAME" >> ./src/main/resources/database.properties
echo "database.DB_PASSWORD=$DB_PASSWORD" >> ./src/main/resources/database.properties

./gradlew war

rm -rf /home/ec2-user/tomcat8/webapps/ROOT
rm -f /home/ec2-user/tomcat8/webapps/ROOT.war
mv build/libs/api*.war ~/tomcat8/webapps/ROOT.war