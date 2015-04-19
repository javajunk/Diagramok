@echo off
echo 8.2.11 ControlRobot
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototype\bin Program" %~dp0TestFiles\ControlRobot_in.txt %~dp0TestFiles\ControlRobot_out.txt
pause