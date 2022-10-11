Environment setup:
##################

1) Eclipse ID, install cucumber and maven pluggins in the IDE.
2) Install Maven and JDK 
3) SETUP environment variables for JAVA_HOME and MAVEN_HOME

Opening a project from GITHUB Repository:
#########################################

1) Copy the GitHub URL of the repository to the clipboard
2) Open Eclipse and choose Import –> Projects from Git (with smart import)
3) Choose the Clone URI option in the Git import wizard and click Next
4) Confirm the URI, Host and Repository path parameters and click Next
5) Choose the Git branches to clone from the remote repository and click Next
6) Confirm the Directory into which the repository will be cloned and click Next
7) Choose the Maven project to import into Eclipse from GitHub and click Finish


Running the project in local:
#############################

Once the project is loaded, 

1) Click on Project > Update Maven Project.
2) Navigate to src/test/java/Runner folder
3) Open the TestRunner.java file > Right click > Run as Feature file

Building and Running the project in CI/CD Jenkins pipeline:
###########################################################

1) Create a local setup for Jenkins as http://localhost:8080/.
2) Go to Manage Jenkins > Manage Pluggins > Cucumber reports plugin, GIT plugin (add all necessary pluggins)
3) Restart Jenkins
4) Go to Manage Jenkins > Global Tool Configuration: Add Maven config, GIT config and Save
5) Go to Dashboard > New Item > Enter the job name > Select Maven Project > Click ok
6) You can see the job in the dashboard
7) Select the job > Configure > Add Git repo link to download it from the GIT file
8) Enter the location of POM.xml
9) Do custom setting for other features such as Post build actions to generate report, or send email when failure etc.
10) Click on Build now to run the project from Jenkins.
