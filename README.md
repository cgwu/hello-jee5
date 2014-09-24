hello-jee5
==========
java EE 5 test project

Build Command:
mvn clean package -Dmaven.test.skip

start-cgdb.bat
cd ..\data
@java -classpath ../lib/hsqldb.jar org.hsqldb.server.Server --database.1 file:cgdb --dbname.1 cgdb
