# AP1-Assignment-
Library System Code Report
Overview
This code represents a simple library management system implemented in Java. The system allows both librarians and members to interact with the library's resources. It provides functionalities such as registering and removing members, adding and removing books, issuing and returning books, tracking fines, and listing available books.

Code Structure
The code is organized into several Java classes: Library_System, HumanDatabase, and BookDatabase. Let's take a closer look at each class:

Library_System
The Library_System class represents the main application entry point.
It uses a Scanner to capture user input.
The application can be run in two modes: librarian mode and member mode.
In librarian mode, you can register and remove members, add and remove books, and view member details and available books.
In member mode, members can list available books, view their own books, issue and return books, and pay fines.
HumanDatabase
The HumanDatabase class represents a user or member of the library.
It handles member registration, removal, checking if a member exists, issuing books, returning books, tracking fines, and listing a member's books.
Members are stored in a Map called humanInfo, where each member has a name, age, phone number, member ID, fines, and a map of their issued books.
BookDatabase
The BookDatabase class represents books available in the library.
It handles adding books, removing books, and checking out books.
Books are stored in a Map called totalBooks, where each book has a name, author, number of copies, and a list of book IDs for available copies.
Functionality
Here's an overview of the core functionality provided by the code:

Member Registration and Removal:

Librarians can register new members by providing their name, age, and phone number.
Librarians can remove members from the system.
Book Management:

Librarians can add books to the library, and the system tracks the number of available copies.
Librarians can remove books from the library.
Members can view available books.
Member Actions:

Members can list available books.
Members can view the books they have issued.
Members can issue books, and the system checks if they have exceeded the limit or if the book is available.
Members can return books and calculate fines based on the return date.

Fines:

The system tracks fines for overdue books. Fines are calculated based on the return date and the number of days overdue.
Code Quality
The code demonstrates a basic library management system but has room for improvement in terms of code quality and features. Here are some considerations for further development:

Error Handling: The code should include more robust error handling to handle unexpected inputs and situations.
Documentation: Inline comments and documentation should be added to make the code more understandable and maintainable.
User Interface: Enhance the user interface for better user experience.
Database Integration: Consider integrating with a database for data persistence.
Security: Implement authentication and authorization mechanisms for user access.
Conclusion
This Java library management system provides a foundation for managing library resources and member interactions. It can serve as a starting point for further development and enhancements to create a more feature-rich and user-friendly library system.
