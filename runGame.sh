#!/bin/bash

./gradlew clean install

./halite -s 42 -d "30 30" "java -cp build/classes/main org.rebaze.halite.MyBot" "java -cp build/classes/main org.rebaze.halite.RandomBot"
