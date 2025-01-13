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
```
### Open in Android Studio:
1. Open Android Studio and select **Open an existing project**.
2. Navigate to the cloned directory.

### Configure Firebase:
1. Add the `google-services.json` file to the `app/` directory.
2. Ensure Firebase dependencies are added in `build.gradle`.

### Run the Project:
1. Click **Run** or use the shortcut `Shift + F10`.

### Application Screenshots

Login Screen | Home Screen | Profile Screen | Move Money Screen | Interact Screen 
------------ | ------------- | ------------- | ------------- | ------------- 
![0](https://github.com/user-attachments/assets/01d9d023-a7a1-415c-a5d6-29f0b7cb2332) | ![1](https://github.com/user-attachments/assets/ccf1ff3f-8318-455d-adaa-3ed2438c3c56) | ![2](https://github.com/user-attachments/assets/d707c18b-2444-4c75-a797-d4b142545279) | ![3](https://github.com/user-attachments/assets/7dffaeff-780c-4542-b491-4192e3f9d468) | ![4](https://github.com/user-attachments/assets/451176ac-03f9-4618-af4e-40cce60c20a4) 

### Firebase Database Structure

| Database Structure | 
| ------------------ |
| ![0](https://github.com/user-attachments/assets/c6402524-0873-4f5d-ac90-4fe99727fcf9) 

## Project Structure

- **LoginActivity.java** - Handles user authentication.https://github.com/user-attachments/assets/7dffaeff-780c-4542-b491-4192e3f9d468
- **HomeActivity.java** - Displays user information post-login.
- **SessionManager.java** - Manages Shared Preferences for session persistence.
- **themes.xml** - Manages Light and Dark theme styles.
- **Firebase Database** - Stores user data securely.

## Future Improvements

- Implement **Two-Factor Authentication (2FA)** for enhanced security.
- Add **Transaction History** and **Money Transfer** features.
- Introduce **Push Notifications** for important updates.

## License

This project is for educational purposes only. All rights reserved.

Developed by Preet Ojha

For any queries, contact:  
📧 [developer.preetojha08@gmail.com](mailto:developer.preetojha08@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/developer-preet-ojha/)

