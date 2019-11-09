Instructions (Best if ran in IntelliJ):
==========================================
I have included a picture in my github proving that I get 100% branch coverage using Jacoco.

"mvn compile" works just fine and so does "mvn test", but "mvn test" does not produce the Jacoco report. I have tried every tutorial I could
find online and even tried to do what Professor showed us in class for the pom file, but I must have missed something because a report
is not produced for/by Jacoco when ran from cmd.
HOWEVER, if the testsuite is ran in IntelliJ using Jacoco for coverage, it will give 100% branch coverage.
If you don't know how to change the coverage runner to Jacoco, instructions can be found here:
https://www.jetbrains.com/help/idea/configuring-code-coverage-measurement.html
Under the "Configuring code coverage measurement options" section

It says the choices for coverage runner are EMMA and IntelliJ IDEA on the instructions, but if you are running the latest version of
IntelliJ, then Jacoco should show up as an option when you click the drop down menu.

You need to do this for the run configuration of TestSuite.java, then you should be able to click the "Run" drop down menu up top and
choose "Run 'TestSuite' with coverage", then a coverage report should be shown on the right. If you want you can click the 
"Generate Coverage Report" to get the index.html version of the report. This report says that the branch coverage is 96%, but after
clicking "default" on the index.html, I believe the missing 4% is from the test files themselves, not my actual program files we were
supposed to be testing. It shows 100% for my program files. Well, it shows n/a for my Point class because there are no branches in there.
