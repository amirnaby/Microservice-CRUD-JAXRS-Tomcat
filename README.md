# Microservice CRUD + JAXRS + Tomcat

Libraries are places in "enterprise\web\WEB-INF\lib" folder

Set username and password of database in "common\jdbc\ConnectionProvider" in each microservice

---
After changing db user & pass and set libraries as well as tomcat, First run all 3 microservices and test them. Finally run enterprise and test services. URL of each services is as follows:
---
Insert MS: http://localhost:9991/person/save?name=%NAME%&family=%FAMILY%&phone=%PHONE%

Update MS: http://localhost:9992/person/update?id=%ID%&name=%NAME%&family=%FAMILY%&phone=%PHONE%

Select MS: http://localhost:9990/person/findOne?id=%ID%

---
Enterprise Insert: http://localhost:8080/person/save?name=%NAME%&family=%FAMILY%&phone=%PHONE%

Enterprise Update: http://localhost:9992/person/update?id=%ID%&name=%NAME%&family=%FAMILY%&phone=%PHONE%

Enterprise Select: http://localhost:8080/person/findOne?id=%ID%
