# CSD-420 Module 1 Assignment - Card Game

A JavaFX application that displays four randomly selected cards from a deck of 52 cards.

## Assignment Requirements

✅ **Displays four random cards** - The application shows 4 randomly selected cards from 1-52  
✅ **Cards stored in "cards" subdirectory** - Uses the existing `../cards/` folder with card images  
✅ **Refresh button functionality** - Button to display new random cards  
✅ **Uses Lambda Expressions** - Implemented in button handlers and stream operations  
✅ **JavaFX GUI** - Complete graphical user interface  

## Features

- **Random Card Selection**: Uses Java Streams with lambda expressions to randomly select 4 cards
- **Visual Card Display**: Shows actual card images from the cards directory
- **Refresh Functionality**: Button to get new random cards using lambda expression event handler
- **Hover Effects**: Interactive card hover effects using lambda expressions
- **Placeholder Support**: Shows placeholder cards if images are missing
- **Professional Styling**: Green background with card shadows and hover effects

## Technical Implementation

### Lambda Expressions Used:
1. **Button Click Handler**: `refreshButton.setOnAction(event -> displayRandomCards())`
2. **Stream Operations**: `cardNumbers.stream().limit(CARDS_TO_DISPLAY).forEach(this::createAndAddCardView)`
3. **Range Generation**: `IntStream.rangeClosed(1, TOTAL_CARDS).forEach(cardNumbers::add)`
4. **Mouse Event Handlers**: `cardView.setOnMouseEntered(e -> cardView.setScaleX(1.05))`

### Project Structure:
```
J_Aney/
├── src/main/java/com/csd420/cardgame/
│   └── CardGameApp.java
├── src/main/resources/
├── build.gradle
├── settings.gradle
└── README.md

../cards/
├── 1.png
├── 2.png
├── ...
└── 52.png
```

## Build and Run

### Prerequisites:
- Java 17 or higher
- Gradle (or use Gradle Wrapper if available)

### Running the Application:

#### Option 1: Using Gradle (if installed)
```bash
gradle run
```

#### Option 2: Using Java directly
```bash
# Compile the project
gradle build

# Run the application
java -cp build/libs/card-game.jar --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml com.csd420.cardgame.CardGameApp
```

#### Option 3: Using VS Code
1. Open the project in VS Code
2. Use the Run and Debug feature (F5)
3. Or use the "Run Java" button in the editor

## Assignment Details

**Course**: CSD-420 - Programming with Java  
**Module**: 1  
**Student**: Jonah Aney  
**Assignment**: JavaFX Card Display Application

### Requirements Met:
- [x] Display 4 random cards from deck of 52
- [x] Store images in "cards" sub directory  
- [x] Refresh button for new cards
- [x] Use Lambda Expressions
- [x] JavaFX implementation

## Notes

- The application looks for card images in the `../cards/` directory relative to the project
- If card images are not found, placeholder cards with suit information are displayed
- The application uses proper error handling for missing images
- All lambda expression requirements are clearly implemented and commented
