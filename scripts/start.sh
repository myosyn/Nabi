#!/usr/bin/env sh

#Taken from Ukulele, licensed under the MIT License.
echo "Building current files, please wait"
./gradlew --no-daemon build
cd `dirname "$0"`

echo "Starting the bot....."
java -jar "build/libs/nabi.jar"