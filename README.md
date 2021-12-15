# bespoked_app

Bespoked is designed to be a sales tracking application for a bicycle store. It provides CRUD operations on sale related entities and also
generates a quarterly commision report.

Technologies used -
front end - ReactJS, Bootstrap
back end - Java, Spring boot
database - MySQL

##How to run the application -

1. Spring-boot

Option 1 - Via command line- 

Prerequisites - JDK and Maven should be installed on the system. JAVA_HOME environment varian=ble should point to the jdk.   
'MAVEN_HOME' environment variable should point to the maven installation.  
MySQL should be installed on the system.  

Step 1 - In MySQL database instance, create a new database called 'bespoked1';  
Step 2 - Go to folder  'Bespoked Spring Boot Project/bespoked-sales'  
Step 3 - Open command prompt. Run command 'mvn package -Dmaven.test.skip'.  
Step 4 - Above step generates a jar file inside 'target' folder in current location. Copy that jar to a folder.  
Step 5 - Considering jar location abvove, run following command - 'java -jar <jar file path> com.example.demo.SpringApplication'  

Option 2 - Via Eclipse-  

MySQL should be installed on the system.  

Step 1 - In MySQL database instance, create a new database called 'bespoked1'.  
Step 2 - Inside eclipse go to File -> Import -> Existing Maven Project. Give 'Bespoked Spring Boot Project/bespoked-sales' folder as root.  
Step 3 - Locate 'BespokedSalesApplication.java' fole. Right click ->Run As -> Spring Boot App  

2. React Application -  

Nodejs should be installed on the system.  

Step 1 - Go to folder 'Bespoked React App/bespoked.sales.web'. Open command line.  
Step 2 - Run command 'npm install'.  
Step 3 - Run command 'npm start'.  

Application will start running at http://localhost:3000/.  

##Features Completed -   
1. Generation and display fo commission report.  
2. Retrieve all flows of sales, salesperson, customer, products.  
3. Creation of sale, product, customer, salesperson.  
4. Update a salesperson.  

##Future work -  
1. Authentication flow.  
2. More flexibility in commision report.  

