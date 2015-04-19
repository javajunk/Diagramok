@echo off
echo 8.2.14 LittleBotPopUp
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\LittleBotPopUp_in.txt" "%~dp0TestFiles\LittleBotPopUp_out.txt"
pause