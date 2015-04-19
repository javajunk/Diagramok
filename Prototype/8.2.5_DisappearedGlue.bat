@echo off
echo 8.2.5 DisappearedGlue
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath %~dp0Prototype\bin Program" %~dp0TestFiles\DisappearedGlue_in.txt %~dp0TestFiles\DisappearedGlue_out.txt
pause