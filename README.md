# BECodingChallenge

This is a spring boot program written using Java. It takes a file containing the results of each game, one per line, as shown below. It will output an ordered table using points. These points are editable in application.properties.

### To build the project and install it in your local repository

```
mvn clean install
```

### To run tests

```
mvn test
```

### To run the program

```
mvn clean spring-boot:run
```

### Example of a file with this full path

/Users/{username_placeholder}/Documents/file.txt

```
Lions 3, Snakes 3
Tarantulas 1, FC Awesome 0
Lions 1, FC Awesome 1
Tarantulas 3, Snakes 1
Lions 4, Grouches 0
```

### Input to the console

/Users/{username_placeholder}/Documents/file.txt

### Result

```
1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts
```

### Input to exit the program

```
exit
```
### Or

```
quit
```
