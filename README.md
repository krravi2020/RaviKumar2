# RaviKumar2
1. This Project works in th Back end.
2 clone the project
3 give maven clean & install
4.change the DB name in WEB-INF/spring-config.xml & login credentials
5. create a table with create table Calculation(id INT NOT NULL auto_increment,input1 int,input2 int, operationType varchar(20),result int,PRIMARY KEY(id));
6. to run the Junit test cases in src/com/myrest/test/calculationTest.java 
change 
@ContextConfiguration("file:/home/ravikumar/Desktop/helloRest/WebContent/WEB-INF/spring-config.xml") accordingly.
