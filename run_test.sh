#!/bin/bash

# Compile the Application
javac -cp src/ src/App.java
echo -e "\nCompilation successful!\n"
# Run the application
java -cp src/ App sample_input=./sample_input/input.txt

# Clean up of all the .class file from the recent compilation
echo -e "\nCleaning up..."
find . -type f -name "*.class" -delete
echo -e "Clean up successful!\n"