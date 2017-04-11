# README

# System Dependencies
- JDK 1.8 or later
- MySQL 5

# How To Create Database
When you connected mysql, run next command.
```
create database fifo_dev;
```

# How To Build
In projects root directory.
```
./gradlew build
```
(First running gradlew is very slowly, because it install gradle in user's home directory as hidden file.)

# How To Run This Application
In projects root directory.
```
./gradlew bootRun
```
Next, open https://localhost:8080 with your favorite web browser. 
(First running gradlew is very slowly, because it install gradle in user's home directory as hidden file.)
