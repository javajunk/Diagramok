@echo off
echo 8.2.10 RobotLandOnOil
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\RobotLandOnOil_in.txt" "%~dp0TestFiles\RobotLandOnOil_out.txt"
pause