# Library Management System

## Project Description
This project implements a **Library Management System** that manages books, authors, students, and staff within a library. The system provides functionalities to add, remove, and display library entities, as well as manage book rentals. It demonstrates concepts such as inheritance, encapsulation, exception handling, and user input handling in Java.

---

## Features
- **Manage Books**: Add, display, and rent books with information about title, author, publication year, and genre.
- **Manage Students**: Register students and validate their access.
- **Manage Staff**: Add and remove staff members with salary validation.
- **Factory Pattern**: Dynamically create and populate library objects (Books, Students, Staff) using a factory.
- **Robust Input Handling**: Input validation with error handling for various attributes.
- **Thread-Safe Book Rentals**: Ensures no simultaneous conflicts during book rentals.
- **Custom String Representations**: Classes like `Author`, `Student`, and `Staff` override `toString` for meaningful output.

---

## Classes and Responsibilities

### 1. **Person (Superclass)**
Represents a base class with common attributes:
- **Attributes**: `name`, `gender`, `nationalID`
- **Methods**: Getters, setters, and a generic `toString()` method.

### 2. **Author (Extends Person)**
Represents an author with a genre specialization.
- **Additional Attribute**: `genre` (e.g., Fiction, Non-Fiction)
- **Methods**: Getters, setters, and an overridden `toString()`.

### 3. **Student (Extends Person)**
Represents a student with a unique ID.
- **Additional Attribute**: `studentId`
- **Methods**: Getters, setters, and an overridden `toString()`.

### 4. **Staff (Extends Person)**
Represents a library staff member with salary validation.
- **Additional Attribute**: `salary` (minimum salary enforced)
- **Methods**: Getters, setters, and an overridden `toString()`.

### 5. **Book**
Represents a library book.
- **Attributes**: `isbn`, `year`, `title`, `type`, `publisher`, `author`
- **Validation**:
  - ISBN must be 13 characters.
  - Year must be valid and not in the future.
- **Methods**: Getters, setters, and an overridden `toString()`.

### 6. **Library**
Manages the collections of books, students, and staff.
- **Attributes**:
  - `books`: List of books in the library.
  - `students`: List of registered students.
  - `staff`: List of staff members.
- **Methods**:
  - Add, remove, and display books/students/staff.
  - Rent books in a thread-safe manner.
  - Validate student registration.

### 7. **LibraryFactory**
Uses the Factory pattern to populate the library with predefined data for:
- Books
- Students
- Staff
- All entities

### 8. **UserInputHandler**
Handles user input with robust validation:
- Retrieve specific entity details (e.g., book attributes).
- Generic input methods for different data types.

### 9. **Main**
Serves as the entry point for the program.
- Provides a user-friendly interface for managing the library.
- Guides the user through options like adding, displaying, or renting books.

---

## Setup and Usage

### Prerequisites
- Java Development Kit (JDK) installed (version 8 or higher).
- A text editor or IDE (e.g., IntelliJ, Eclipse, or VS Code).
