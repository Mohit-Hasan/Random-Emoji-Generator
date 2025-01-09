# Random Emoji Generator

This is a basic multi-threaded **Random Emoji Generator** built for Android. The app displays random emojis at different positions on the screen with random sizes. The score is incremented each time an emoji is displayed, and it is updated in real-time on the user interface.

## Features
- **Multi-threading**: Utilizes threads for continuous emoji rendering at a set interval.
- **Dynamic Score Updates**: Score increments as emojis are drawn, with real-time updates on the screen.
- **Random Emoji Generation**: Display different emojis randomly, along with random sizes.
- **Interactive UI**: Start and stop the emoji rendering with buttons.
- **Persistence**: Score is updated live as emojis appear.

## Screenshots

<div align="center">
  <img src="https://raw.githubusercontent.com/Mohit-Hasan/Random-Emoji-Generator/refs/heads/main/repo_assets/Screenshot_20250110_035657.png" alt="Screenshot 1" width="300" />
  <img src="https://raw.githubusercontent.com/Mohit-Hasan/Random-Emoji-Generator/refs/heads/main/repo_assets/Screenshot_20250110_035716.png" alt="Screenshot 2" width="300" />
  <img src="https://raw.githubusercontent.com/Mohit-Hasan/Random-Emoji-Generator/refs/heads/main/repo_assets/Screenshot_20250110_035732.png" alt="Screenshot 3" width="300" />
</div>


## How It Works

1. **Random Emoji Generation**: The app randomly picks an emoji from a list and renders it on the screen at random positions. Each emoji has a random size.
2. **Multi-threading**: The rendering of emojis happens in a background thread, ensuring smooth performance even with multiple emojis being drawn.
3. **Score Tracking**: Every time an emoji is drawn, the score increments. The score is displayed in real-time at the top of the screen.

## Getting Started

### Prerequisites
Make sure you have the following installed:
- **Android Studio** (for building and running the app)
- **Java** (for the code)
- **Android Emulator/Device** (to test the app)

### Installation

1. Clone this repository to your local machine:
    ```bash
    git clone https://github.com/Mohit-Hasan/Random-Emoji-Generator.git
    ```

2. Open the project in **Android Studio**.

3. Build and run the app on an emulator or a physical device.

### Usage
- **Start/Stop Emoji Generation**: Tap the "Start" button to begin generating random emojis. Tap the "Stop" button to stop the emoji generation.
- **Score**: The score increases each time an emoji is displayed, and the updated score will be shown in real-time at the top.

## Demo Video at YouTube

Watch a quick demo of the app in action:  
[![Demo Video](https://img.youtube.com/vi/z6atDo9T9Fg/0.jpg)](https://www.youtube.com/watch?v=z6atDo9T9Fg)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
