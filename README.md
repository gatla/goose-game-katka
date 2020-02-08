# goose-game-katka
Java implementation of goose game kata

Implementation Description:
1. Once the Game reliases that the new position is exceeding 63, the game increases the player by 1 position.
2. The Game increases the position of player to special positions based on below game logic.
      * The game sets position to 12 when player reaches 6th position
      * The game sets postion to the sum of values of dice when user reaches "The Goose position" (i.e., 5, 9, 14, 18, 23, 27)
3. After moving the player to new posiiton game checks for Winner and if no winner is available the game proceeds till there is a player.

Steps to run the project:
1. clone the project from link : https://github.com/gatla/goose-game-katka.git
2. Navigate to ./target folder in cli and run "java -jar kata-goose-0.0.1-SNAPSHOT.jar"
Note: By default user inputs the Player names and then wehn user selects start game option, the game automatically rolls the dice, updates postion of player and checks for winner. Then process contnues till  a winner(i.e., player reaches 63 positon in board) is found.
if you want to add user's consent beofre moving to new position uncomment code between 35 to 42 and 73 to 80 and build the project using below steps.

Steps to build the project:
1. Open the project in cli and run : "mvn package -DskipTests"
2. To run follow the above steps.
