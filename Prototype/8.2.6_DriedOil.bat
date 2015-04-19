@echo off
echo 8.2.6 DriedOil
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototype\bin Program" %~dp0TestFiles\DriedOil_in.txt %~dp0TestFiles\DriedOil_out.txt
pause