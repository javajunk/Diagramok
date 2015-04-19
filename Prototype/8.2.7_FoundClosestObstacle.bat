@echo off
echo 8.2.7 FoundClosestObstacle
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\FoundClosestObstacle_in.txt" "%~dp0TestFiles\FoundClosestObstacle_out.txt"
pause