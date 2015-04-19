@echo off
echo 8.2.1 Init
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototipus\bin Program" %~dp0TestFiles\Init_in.txt %~dp0TestFiles\Init_out.txt
pause