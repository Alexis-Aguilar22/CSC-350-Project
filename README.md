# CSC-350-Project
##Sprint 1
– Are you in a Group?

No

– What programming language are you selecting? Which version?

Java 25.0.1

– Do you have your GitHub account set up?

Yes

– Do you have a public repository for your Project?

Yes

– What is the link to your GitHub repository?

https://github.com/Alexis-Aguilar22/CSC-350-Project.git

– Do you have a “Hello World” program that compiles and runs?

Yes

– Where is the entry point to your project? (src/main/Main.java for
example)
 src/main/Main.java

## Sprint 2

For my project I would like to use to the console to create a Pokemon inspired turn-based battle game written in Java.

The player fights an enemy in a loop where they can choose actions such as attacking or healing. The enemy automatically attacks back after each turn.

### Planned Features
- Starter Pokemon selection
- Basic battle system
- Health tracking
- Single move (Tackle)

For my libraries I plan on using the Java Standard Library (Scanner, Random)

So far I have created and implemented my core classes: Player, Move, Pokemon, GameManager.
A functional game loop was created.
User input will be handled through the console.

## Sprint 3

### Design Patterns Implemented

#### Strategy Pattern
Implemented through the MoveStrategy interface and TackleMove class. Pokemon objects delegate attack behavior to a move strategy.

#### Factory Pattern
Implemented through PokemonFactory. Pokemon creation is centralized and GameManager does not directly instantiate Pokemon objects.

### Planned Final Submission

The final project will demonstrate a turn-based Pokemon-inspired battle system. Players will select a starter Pokemon and battle wild Pokemon using multiple attack strategies. The project will demonstrate six design patterns while maintaining a modular and extensible architecture.

### Problems Encountered

Refactoring the original battle system to use interfaces required modifying the attack system and Pokemon construction process. Additional abstraction was added to reduce tight coupling between classes.


## Final Submission
This project is a console-based Pokemon inspired turn based game written in Java. The player enters their name,
 selects a starter pokemon, and can then start battle different pokemon they encounter. Through battling their pokemon gains experience points and can level up, eventually learning a new move.
Players can choose to visit a pokemon center to fully heal after battling.
When the player ends the game they are given their final statistics.

#### Design Patterns used


1. Singleton Pattern
   The Singleton pattern is implemented through the GameManager class. Only one GameManager instance exists during program execution, providing centralized control of the game flow.
2. Factory Pattern
   The Factory pattern is implemented through PokemonFactory. Pokemon objects are created through factory methods instead of being instantiated directly throughout the application.
3. Strategy Pattern
   The Strategy pattern is implemented through the MoveStrategy interface and move classes such as TackleMove, EmberMove, WaterGunMove, and VineWhipMove. Pokemon can change attack behavior without modifying the Pokemon class itself.
4. Command Pattern
   The Command pattern is implemented through the BattleCommand interface and concrete commands such as AttackCommand and HealCommand. Battle actions are encapsulated as command objects.
5. Observer Pattern
   The Observer pattern is implemented through BattleObserver and ConsoleBattleObserver. Pokemon notify observers whenever important battle events occur, such as taking damage, healing, gaining experience, or leveling up.
6. State Pattern
   The State pattern is implemented through the BattleState interface and concrete states including PlayerTurnState, EnemyTurnState, and GameOverState. The game tracks and displays the current battle state during execution.
