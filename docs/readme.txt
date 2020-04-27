WMS Exception Handling Framework
ver 1.0

==============
 Installation
==============

STEP1: Check-out the framework-exception module from SVN and run maven build:
             
             mvn clean install -Dmaven.test.skip=true
             
       Note: you want to make sure that you build without running JUnit Test since it requires Database table to be setup.
       
STEP2: Maven will generate the DDL file that creates database table for the error table. Now open SQL Development Tool
       such as TOAD, SQL Developer, or Eclipse Database Development plugin to run the DDL files located at 
       
             /framework-exception/target/hibernate3/sql/error_table.ddl
             
STEP3: Add the framework-exception module as dependency in your maven application/service pom file:

       <dependency>
         <groupId>com.midas</groupId>
         <artifactId>framework-exception</artifactId>
         <version>0.0.1-SNAPSHOT</version>
       </dependency>   
           
STEP4: Create configuration properties file with name exception.properties with the following contents

       #Database Configuration
       jdbc.driver.class.name=org.gjt.mm.mysql.Driver
       jdbc.url=jdbc:mysql://localhost:3306/midas
       jdbc.username=midas
       jdbc.password=midas123
       #Exception Handler Pointcut Expression
       exhandler.pointcut.expression=execution(* com.suryadisoft.exception.Validator.*(..))
       
STEP5: Create log4j.xml file for logging the error. If you have already an existing one add the following contents to 
       your log4j.xml (See log4j.xml example in the test resource):
       
       <appender name="ERROR" class="org.apache.log4j.RollingFileAppender">
         <param name="MaxFileSize" value="10MB" />
         <param name="MaxBackupIndex" value="10" />
         <param name="File" value="log/error.log" />
         <layout class="org.apache.log4j.PatternLayout">
           <param name="ConversionPattern" value="%d [%t] %-5p %C - %m%n" />
         </layout>
       </appender>
  
       <logger name="com.suryadisoft.exception.handler" additivity="false">
         <level value="ERROR" />
         <appender-ref ref="ERROR" />
       </logger>
     
=======  
 USAGE
=======

STEP1: Create an Exception class that extends the CommonException class. See ValidationException.java in the test source
       as an example. Note that if you don't override the getExceptionHandlerId() method, the parent exception handler
       will handle the exception (e.g. CommonExceptionHandler). Note that any exception that is  not extended the CommonException
       will be handled by the UnknownExceptionHandler.
       
STEP2: Create an Error enum class to hold error constants used when throwing the exception. See TestError.java in the 
       test source as an example.
       
STEP3: Create an Exception Handler class that extends AbstractExceptionHandler (optional) and implement ExceptionHandler
       interface (required). Here is where you implement the exception handling procedure for each exception that you 
       want to handle. See ValidationExceptionHandler.java in the test source as an example.
       
STEP4: Create an Exception Handler Spring Annotation Configuration class to register all Exception Handler classes that 
       has been created. See TestConfig.java in the test source as an example.
       
STEP5: Import both Exception Handler Spring Annotation Configuration class and ExceptionConfig class into the Application
       Spring Annotation Configuration class. See TestConfig.java in the test source of how to import other Spring Annotation
       Configuration class into the existing one.
       
STEP6: Configure what package, class/interface, method that you want the exception handler framework to intercept when
       exception is thrown in exception.properties file (See other possible expression in the references.txt file). 
       Example is:
       
       exhandler.pointcut.expression=execution(* com.suryadisoft.exception.Validator.*(..))
       
       This means that any exception thrown by Validator class will be intercepted and handled by exception handler.
       
       If you need to intercept 2 different classes instead of intercepting in package level or particular class level,
       add the following to the exception-config.xml file in the framework-exception module java source file:
       
       <aop:config>
         <aop:aspect id="exHandlerAspect2" ref="exceptionInterceptor">
           <aop:pointcut id="exHandlerPointcut2" expression="${exhandler.pointcut.expression2}" />
           <aop:after-throwing pointcut-ref="exHandlerPointcut2" throwing="exception" method="handleException" />
         </aop:aspect>
       </aop:config>
       
STEP7: Throw your exception anywhere in your application. Since CommonException is a RuntimeException type, you don't have to
       place try-catch block in your code. However, please note that the exception handler does not swallow the exception.
       It catches the exception, handle it, but then re-throw it back. Therefore, if you don't want your web application to
       throw exception back to the client, you need try-catch it in the main class, e.g. HttpServlet class.


       
       