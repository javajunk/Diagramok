@echo off
echo 8.2.4 PutGlue
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototype\bin Program" %~dp0TestFiles\PutGlue_in.txt %~dp0TestFiles\PutGlue_out.txt
pause