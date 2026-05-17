<<<<<<< HEAD
Cinema-Ticket-Reservation-System Topic: Cinema Ticket Reservation System (C++)

A console-based Cinema Ticket Reservation System written in C++. This system allows users to register, log in, view movies, book tickets with seat selection, cancel tickets, and search or sort movies. Admins can add movies and view all booked tickets.

This project demonstrates arrays, sorting algorithms, file handling, input validation, and object-oriented programming.

📌 Features

a. User registration & login

b. Movie listing

c. Movie searching

d. Movie sorting (Title, Price, Duration)

e. Ticket booking with seat selection (0–9)

f. Ticket cancellation

g. Admin movie management

h. File persistence for users and movies

i. Safe integer/double input validation

👤 User Features

-> Create an account (stored in users.txt)

-> Log in with username/password

-> View all movies

-> Search movies by title

Sort movies by:

1. Title (Selection Sort)

2. Price (Bubble Sort)

3. Duration (Insertion Sort)

-> Book tickets with seat selection (0–9)

-> Cancel previously booked tickets

-> View user-specific ticket history

🛠Admin Features

-> View movies

-> Add new movies (saved in movies.txt)

-> Sort movies

-> Search movies by title

-> View all tickets booked by all users

🗂 Data Storage 
i. movies.txt

Each movie is stored as:

=> MovieID Title Genre Duration Price

ii. users.txt

Each user is stored as:

=> username password

Seats are stored in memory only.

📚 Concepts Used

Classes & Objects

Structs

Linked List

Arrays (Static)

File Input/Output

Sorting Algorithms

Searching

Menu-driven program design

Input validation (readInt(), readDouble())

📁 Project Structure |-- main.cpp |-- movies.txt |-- users.txt |-- README.md

🚀 How to Run

Clone the repository git clone https://github.com/Moayed8728/Cinema-Ticket-Reservation-System.git

Compile g++ *.cpp -o cinema

Run ./cinema

🖼 Preview
   CINEMA SYSTEM        
============================

Login
Create Account
Exit
👨‍ Author

Moayed

Cinema Ticket Reservation System A simple console-based Cinema Ticket Reservation System written in C++. The system allows users to create an account, log in, view movies, select seats, book tickets, cancel tickets, search & sort movies, and lets admins manage movie data. C++ Coursework Project
=======
Banking Management System in Java

A role-based banking management system implemented in Java. This project simulates real-world banking operations and supports multiple user roles with distinct functionalities.

Features:

Account Holder: View account details, deposit/withdraw funds, transfer money, manage personal Tabung (savings goals), apply for loans, and track transaction history.

Bank Officer: Register new accounts and view account details.

Loan Officer: Approve or reject loans and disburse approved amounts.

Finance Officer: Set dividend rates and distribute dividends to account holders.

System Admin: Generate daily reports and reset user passwords.

Core Components:

User hierarchy with AccountHolder, BankOfficer, LoanOfficer, FinanceOfficer, and SystemAdmin.

BankAccount for managing balances and transactions.

Transaction for logging financial activities.

Tabung for goal-based savings management.

Loan for loan applications and processing.

Technologies:

Java SE

Object-Oriented Programming (OOP) concepts: inheritance, abstraction, encapsulation

Usage:
Run Main.java to start the console-based menu system and interact with the banking application according to your role.
>>>>>>> 4b95454cbc0c14febc623683ff102d6a5b05b511
