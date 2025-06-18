# 📘 Day2 Task – Java Maven Project (24MCAB44)

This project demonstrates core Java concepts, real-world system simulation, and Maven integration through two major modules: **Library Management System** and **Banking System Simulation**.

---

## 🛠️ Project Setup

- **Project Name:** `Day2_24MCAB44`
- **Type:** Maven-based Java project
- **Dependencies Added:**
  - ✅ Apache Log4j SLF4J Binding – For logging support
  - ✅ Apache Commons CLI – For parsing command-line arguments

---

## 📚 Task 1: Library Management System

### Description:
- Models a basic library using object-oriented principles.
- Consists of:
  - `Book` (Base class)
  - `FictionBook` and `NonFictionBook` (Derived classes)

### Concepts Demonstrated:
- ✅ Inheritance
- ✅ Polymorphism
- ✅ Encapsulation

---

## 💰 Task 2: Banking System Simulation

### Features:
- Create and manage user bank accounts
- Deposit and withdraw money
- Check account balances

### Exception Handling:
Robust error management for:
- ❌ Overdrafts (insufficient funds)
- ❌ Negative/zero transaction amounts
- ❌ Invalid input types
- ❌ Access to non-existent accounts

### MongoDB Integration:
- Persists account data using **MongoDB**
- Ensures data remains available between sessions

---

## 🚀 Technologies Used

| Technology       | Purpose                             |
|------------------|-------------------------------------|
| Java (JDK 11+)   | Core language                       |
| Maven            | Build and dependency management     |
| MongoDB          | NoSQL database for banking system   |
| Log4j (SLF4J)    | Logging support                     |
| Commons CLI      | Command-line argument parsing       |

---

## 🔑 Key Highlights

- 🧩 **Modular Design** – Follows clean separation of concerns
- 🔄 **Object-Oriented Approach** – Inheritance & Polymorphism in practice
- 📦 **Maven Integration** – For building and managing dependencies
- 🔐 **Exception Handling** – Real-world error scenarios handled cleanly
- 🗃️ **Database Usage** – MongoDB for persistent storage

---

## ▶️ How to Run

1. **Start MongoDB** on your local machine.
2. **Build and Run with Maven**:
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="your.main.ClassName"
