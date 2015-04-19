@echo off
echo 8.2.12 EndOfGameTime
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototype\bin Program" %~dp0TestFiles\EndOfGameTime_in.txt %~dp0TestFiles\EndOfGameTime_out.txt
pause