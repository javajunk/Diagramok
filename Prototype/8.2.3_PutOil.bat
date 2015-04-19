@echo off
echo 8.2.3 PutOil
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\PutOil_in.txt" "%~dp0TestFiles\PutOil_out.txt"
pause