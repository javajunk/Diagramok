@echo off
echo 8.2.1 Init
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\Init_in.txt" "%~dp0TestFiles\Init_out.txt"
echo 8.2.2 ControlRobot
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\ControlRobot_in.txt" "%~dp0TestFiles\ControlRobot_out.txt"
echo 8.2.3 PutOil
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\PutOil_in.txt" "%~dp0TestFiles\PutOil_out.txt"
echo 8.2.4 PutGlue
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\PutGlue_in.txt" "%~dp0TestFiles\PutGlue_out.txt"
echo 8.2.5 DisappearedGlue
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\DisappearedGlue_in.txt" "%~dp0TestFiles\DisappearedGlue_out.txt"
echo 8.2.6 DriedOil
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\DriedOil_in.txt" "%~dp0TestFiles\DriedOil_out.txt"
echo 8.2.7 FoundClosestObstacle
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\FoundClosestObstacle_in.txt" "%~dp0TestFiles\FoundClosestObstacle_out.txt"
echo 8.2.8 CleanedUpSplash
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\CleanedUpSplash_in.txt" "%~dp0TestFiles\CleanedUpSplash_out.txt"
echo 8.2.9 RobotsCrash
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\RobotsCrash_in.txt" "%~dp0TestFiles\RobotsCrash_out.txt"
echo 8.2.10 RobotLandOnOil
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\RobotLandOnOil_in.txt" "%~dp0TestFiles\RobotLandOnOil_out.txt"
echo 8.2.11 RobotLandOnGlue
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\RobotLandOnGlue_in.txt" "%~dp0TestFiles\RobotLandOnGlue_out.txt"
echo 8.2.12 EndOfGameTime
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\EndOfGameTime_in.txt" "%~dp0TestFiles\EndOfGameTime_out.txt"
echo 8.2.13 LeavedMap
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\LeavedMap_in.txt" "%~dp0TestFiles\LeavedMap_out.txt"
echo 8.2.14 LittleBotPopUp
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\LittleBotPopUp_in.txt" "%~dp0TestFiles\LittleBotPopUp_out.txt"
echo 8.2.15 Drive
java -classpath "%~dp0\PrototypeTester\bin" Program "java -classpath \"%~dp0Prototype\bin\" Program" "%~dp0TestFiles\Drive_in.txt" "%~dp0TestFiles\Drive_out.txt"
pause
