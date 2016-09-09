Установка и настройка Apache Tomcat: http://tomcat.apache.org
-------------------------------------------------------------
* Сайт http://tomcat.apache.org 
* http://tomcat.apache.org/download-80.cgi
 http://apache.cu.be/tomcat/tomcat-8/v8.5.5/bin/apache-tomcat-8.5.5.zip - скачивание Apache Tomcat
* Распаковать в папку на диске, например в D:\tomcat
* Запуск: D:\apache-tomcat-8.5.5\bin\startup.bat
* Завершение: D:\apache-tomcat-8.5.5\bin\shutdown.bat
* Открыть: http://localhost:8080 и увидеть начальную страницу
* Настройка и запуск: https://github.com/levelp/tomcat

D:\apache-tomcat-8.5.5\conf\server.xml
``` xml
    <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```




