@echo off
echo 8.2.11 RobotLandOnGlue
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototype\bin Program" %~dp0TestFiles\RobotLandOnGlue_in.txt %~dp0TestFiles\RobotLandOnGlue_out.txt
pause