@echo off
echo 8.2.2 ControlRobot
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototipus\bin Program" %~dp0TestFiles\ControlRobot_in.txt %~dp0TestFiles\ControlRobot_out.txt
pause