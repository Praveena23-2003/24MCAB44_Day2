**Day2 <24MCAB44> Maven Project**

Overview:

This project covers multiple Java programming tasks as part of Day 2 assignment:

Maven Setup:

Created a Maven project named Day2<regno>.

Added dependencies for Apache Log4j SLF4J Binding and Apache Commons CLI to enable logging and command-line parsing capabilities.


Library Management System:

Designed using inheritance with a base class Book and subclasses FictionBook and NonFictionBook.

Demonstrates object-oriented concepts like inheritance and polymorphism.


Banking System Simulation:

Allows users to create accounts, deposit, withdraw, and check balances.

Integrates with MongoDB to persist account data.

Implements exception handling to gracefully manage invalid operations such as:

Overdrafts (withdrawals exceeding balance)

Negative or zero transaction amounts

Non-existent accounts

Invalid input types (e.g., entering text when number expected)


Technologies Used:-

Java (JDK 11+)

Maven (dependency and build management)

MongoDB (for data persistence)

Apache Log4j (logging framework)

Apache Commons CLI (command-line interface parsing)


Key Highlights:-

Robust error handling ensures program stability and user-friendly feedback.

Object-oriented design for easy extension and maintenance.

MongoDB usage demonstrates real-world database integration in Java projects.


How to Run:-

Ensure MongoDB is running locally.

Build and run using Maven commands, selecting between library or banking system as main class.

This project demonstrates foundational skills in Java development, project management with Maven, use of external libraries, database interaction, and error management.
