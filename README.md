# Ezhuthagam (Text Editor Console Application)

## Overview
Ezhuthagam is a console-based text editor application that allows users to create, open, and manage documents. It includes user authentication features, enabling both login and signup processes. The application is built using Java and follows the Model-View-ViewModel (MVVM) architectural pattern for separation of concerns.

## Features
- **User Authentication**: Users can log in or sign up to access their documents.
- **Document Management**: Users can create new documents, open existing ones, and view a list of recent documents.
- **Responsive UI**: Console-based user interface for easy navigation.
- **Data Persistence**: User and document data is managed via a repository pattern.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher.
- IDE (like IntelliJ IDEA, Eclipse) or a simple text editor.
- Command line access to run the application.

### Installation
1. Clone the repository or download the source code.
2. Open the project in your preferred IDE or text editor.
3. Ensure all dependencies are included and configured.

### Running the Application
To run the application, execute the following command in the terminal:

```bash
java com.hari.ezhuthagam.Ezhuthagam
```

## Usage
Upon running the application, users will be presented with the following options:

- **Log In**: Existing users can log in using their credentials.
- **Sign Up**: New users can create an account by providing a username and password.

### Main Features

- **Home Screen**: After logging in, users will see options to create a new document, open an existing document, view recent documents, or log out.
- **Create New Document**: Users can create a document by entering its name.
- **Open Document**: Users can view a list of existing documents and select one to open.
- **View Recent Documents**: Users can see the documents they recently accessed.

## Code Structure

The application consists of the following main components:

- **BaseView**: An abstract class providing common functionalities for all views, such as user input handling.
- **Ezhuthagam**: The main application class that initiates the program and manages user sessions.
  
### UI Packages:
- `com.hari.ezhuthagam.ui.login`: Contains `LoginView` and `LoginViewModel` for user authentication.
- `com.hari.ezhuthagam.ui.signUp`: Contains `SignUpView` and `SignUpViewModel` for user registration.
- `com.hari.ezhuthagam.ui.home`: Contains `HomeView` and `HomeViewModel` for managing the home screen.
- `com.hari.ezhuthagam.ui.newdocument`: Contains `NewView` and `NewViewModel` for document creation.
- `com.hari.ezhuthagam.ui.open`: Contains `OpenView` and `OpenViewModel` for opening existing documents.
- `com.hari.ezhuthagam.ui.recent`: Contains `RecentsView` and `RecentsViewModel` for viewing recent documents.
