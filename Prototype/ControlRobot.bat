@echo off
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototipus\bin Program" %~dp0\TestFiles\ControlRobot_in.txt %~dp0\TestFiles\ControlRobot_out.txt
pause