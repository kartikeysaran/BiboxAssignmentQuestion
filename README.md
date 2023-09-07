# Bibox Labs Assignment

This repository contains an Android application developed as part of the Bibox Labs assignment. The application allows users to create, manage, and rearrange multiple-choice questions with drag-and-drop functionality. It also supports adding multiple questions and saving the data locally.

## Task Details

### 1. Question and Multiple Answers Screen
- Create a user interface for entering questions and multiple-choice answer options.
- Initially, display a "Add Question" button to add questions, up to a maximum of eight.
- Display a "Add Option" button below each question. There can be a maximum of 8 options for a Question
- Arrange answer options in two rows, with a maximum of two options per row.

### 2. Adding Multiple Questions
- Implement an "Add Question" button that allows users to add multiple questions one after another.

### 3. Drag-and-Drop for Questions
- Enable users to rearrange the order of questions by implementing a drag-and-drop feature.
- Users should be able to click and drag a question to change its position in the list of questions.

### 4. Drag-and-Drop for Answer Options
- Implement the same drag-and-drop functionality for answer options within each question.
- Users should be able to click and drag an answer option to reorder them.

### Local Data Storage
- Store all questions and their associated answer options locally using Room.

## Implementation Details

### Technologies Used
- RecyclerView: Used for displaying questions and answer options.
- ItemTouchHelper: Utilized for implementing drag-and-drop functionality for both questions and answer options.
- Hilt: Employed for Dependency Injection.
- MVVM Architecture: Followed for structuring the application.
- Room: Used for local data storage.

## Building and Running the Application

To build and run this application, follow these steps:

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/kartikeysaran/BiboxAssignmentQuestion.git```
2. Open the project in Android Studio.
3. Build and run the application on an Android emulator or a physical Android device.

