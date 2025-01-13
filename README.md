# Bank Android Application

## Overview

This is a fully functional Bank Android Application developed in Android Studio using Java and the latest version of Gradle. The app uses Firebase Cloud Database for secure data storage and retrieval. It features modern UI design with support for both Light and Dark themes, adapting automatically to the user's mobile preference.

## Features

- **User Authentication**: Secure login system by validating username and password with Firebase.
- **User Data Management**: Fetches and displays user details (Full Name, Username, Password, Mobile Number, Email, Card Details, Balance) after successful login.
- **Session Persistence**: Utilizes Shared Preferences to store user details locally, ensuring user data persists even after closing the app until logout.
- **Dynamic Theme Support**: Automatically switches between Light and Dark themes based on system settings.
- **Modern UI**: Clean and intuitive design for seamless user experience.

## Application Flow

### Login Activity:

- Users enter their username and password.
- Credentials are verified with Firebase Cloud Database.
- On successful authentication, the app navigates to the Home Screen Activity.

### Home Screen Activity:

- Fetches and displays user details linked to the authenticated account.
- Details such as Full Name, Username, Mobile Number, Email, Card Details, and Balance are shown.
- User details are stored in Shared Preferences for session persistence.

### Session Management:

- If the app is closed and reopened, the user remains logged in until they manually log out.
- Shared Preferences eliminate redundant database calls, improving performance.

## Technologies Used

- **Programming Language**: Java
- **IDE**: Android Studio
- **Build Tool**: Latest Gradle
- **Database**: Firebase Cloud Database
- **Local Storage**: Shared Preferences
- **UI/UX**: Modern design with Light/Dark theme support

## Installation and Setup

### Clone the repository:

```bash
git clone <repository-url>
