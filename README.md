# WikiaHomework

Instructions for running the tests from the command line (Windows)

The tests will run in parallel on Firefox and Chrome

1.	Download/clone the project.
2.	Navigate to directory of the project. Create and set a path variable named “ProjectPath” by entering following           command. Do echo command after that to check if the value that we just set is right.

      set ProjectPath=C:\pathToProjectFolder
      
      echo  %ProjectPath%

3.	Create a classpath that points to selenium and testing jar files. These files are located in the lib folder.             (WikiaHomework > lib)

4.	Run these commands to set the classpath for jars in the lib folder and binary classes in the bin folder and do an        echo to check the path has been set.


      set classpath=%ProjectPath%\bin;%ProjectPath%\Lib\*
    
      echo %classpath%

5.	Now execute the java command for TestNG as shown below.

      Java org.testng.TestNG  %ProjectPath%\testng.xml

      References:  http://qtp-automate.blogspot.mx/2011/10/running-selenium-testng-test-from.html

