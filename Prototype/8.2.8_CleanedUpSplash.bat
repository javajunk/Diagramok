@echo off
echo 8.2.8 CleanedUpSplash
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\CleanedUpSplash_in.txt" "%~dp0TestFiles\CleanedUpSplash_out.txt"
pause