Selenium with Cucumber
---------------------------------

What is Cucumber?                               
Cucumber is an open source tool that supports Behavior Driven Development (BDD) framework. It provides the facility to write tests in a human readable language called Gherkin. 
Selenium executes UI tests while Cucumber does acceptance testing.
___________________________________
What is Gherkin?                                  
Gherkin uses a set of special keywords to give structure and meaning to executable specifications.                        
Primary Gherkin keywords are:   
1. Feature
2. Scenario / Scenario Outline
3. Given, When, Then, And, But
4. Background
5. Examples 
___________________________________________ 

Junit is being used to validate the tests.
___________________________________________

Requirements:
1. Java Version 11
2. Maven Version 3.*
3. Git
___________________________________________

Steps to Install:
1. git clone in Root directory of the system.
2. cd selenium-cucumber
3. mvn clean install -> may take some time for the first time.
_____________________________________________
Note - For running test cases in Linux or Mac, make sure to add specific executable driver and change the path of executable driver in /Utils/Driver file. No change required for running test cases in Windows.
