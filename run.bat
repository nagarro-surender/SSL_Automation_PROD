echo "test"
E:
cd C:\Client Projects\ShoppersStop
javac -d bin -cp "libs/*;" src/pageObjects/*.java src/appModules/*.java  src/Utility/*.java src/testCases/*.java
pause
java -cp bin;libs/* org.testng.TestNG testng.xml