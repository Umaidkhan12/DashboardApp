# Dashboard App

A modern and attractive Android dashboard that displays a grid of project cards. Each card contains an image and title, and when clicked, it checks if the corresponding app is installed. If installed, it launches the app; otherwise, it redirects to the project's GitHub repository.

## Features

- **Material Design**: Uses `MaterialCardView`, `MaterialToolbar`, and `RecyclerView` for a clean UI.
- **Grid Layout**: Displays cards in a responsive grid layout.
- **App Launch Check**: Detects if an app is installed and opens it; otherwise, it redirects to GitHub.
- **Smooth Animations**: Includes fade-in effects on clicks.

## Requirements

- **Minimum Android Version**: API Level 21 (Lollipop)
- **Target Android Version**: API Level 30+

## Download APK

Click below to download the latest version of the app:

[![Download APK](https://img.shields.io/badge/Download-APK-blue?style=for-the-badge&logo=android)](APK/app-debug.apk)

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/DashboardApp.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle dependencies.
4. Run the project on an emulator or device.

## Usage

- Tap a card to launch the corresponding app.
- If the app is not installed, you will be redirected to its GitHub repository.
- Modify `MainActivity.kt` to update package names and GitHub links.

## Code Overview

### 1. Manifest (AndroidManifest.xml)

- Includes `<queries>` to allow package visibility for installed app checks.

### 2. MainActivity.kt

- Uses a `RecyclerView` with a `GridLayoutManager`.
- Implements click listeners to check for installed apps and handle redirection.

### 3. DashboardAdapter.kt

- Binds project data to `RecyclerView`.
- Adds animations on card click.

### 4. item_dashboard.xml

- Defines UI for each card (ImageView + TextView inside `MaterialCardView`).

## Customization

- Modify `DashboardItem` class in `MainActivity.kt` to add more projects.
- Replace images in `res/drawable/` with your own icons.
- Customize colors in `res/values/colors.xml`.

