:: Taken from Ukulele, licensed under the MIT license

@echo off
::Use the -d flag to run the bot in detached mode.

call gradlew.bat --no-daemon build
if "%1"=="-d" (start javaw -jar "build\libs\nabi.jar") else (java -jar "build\libs\nabi.jar")