@echo off
echo 8.2.9 RobotsCrash
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\RobotsCrash_in.txt" "%~dp0TestFiles\RobotsCrash_out.txt"
pause