@echo off
echo 8.2.15 Drive
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\Drive_in.txt" "%~dp0TestFiles\Drive_out.txt"
pause