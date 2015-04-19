@echo off
echo 8.2.13 LeavedMap
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\LeavedMap_in.txt" "%~dp0TestFiles\LeavedMap_out.txt"
pause