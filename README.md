# Webcam To ASCII Art
Converts Frames from webcam into ASCII Art

**Run Application**
Run the `main` method in the UnoApp class or use the following command in the terminal:

## Sample Output
https://user-images.githubusercontent.com/56058545/133916833-e04136be-e261-41a3-b500-f51ff05e4523.mp4

# How It Works
### Input Frames
Webcam Capture API from https://github.com/sarxos/webcam-capture was used to get frames from the Webcam in the form of BufferedImages

### Frame Processing
* Based on the final static variable SIZE, the number of characters for width and height is determined.
* The character displayed will be determined by the average brightness of the set of pixels which is determined by averaging the red, green, and blue values.
* The output of this will be a 2d char array.

### Output
* The 2d char array will then be the input for the display class which utilizes the Java Swing Package for a window display.


# Class Description
### `Main`
  This class contains the `main` method which contains the most basic flow of the program. It also houses the `imageToAscii` method which converts `BufferedImage` to 2D `char` array that contains ASCII characters.

### `Display`
  This is the class responsible for displaying the 2D `char` array into a window.

### `Utilities`
  This class contains various methods for easy access by the `Main` class and allows the `Main` class to be more organized.
  The static final `String SHORTSET` and `FULLSET` are two of the common ways to order brightness of ASCII Characters.
