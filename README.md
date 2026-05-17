# Banking System

A console-based Java Banking System built with a clean Object-Oriented Programming architecture. The project demonstrates core banking workflows such as account management, deposits, withdrawals, transfers, loan processing, dividend distribution, savings goals, and basic administration.

This version is organized into a professional modular structure while remaining simple, beginner/intermediate friendly, and easy to extend.

## Features

- Account holder login
- View account details
- Deposit money
- Withdraw money
- Transfer money between accounts
- View transaction history
- Apply for loans
- Approve or reject loan applications
- Create and manage Tabung savings goals
- Set and distribute dividends
- Register new accounts
- Generate daily account reports
- Reset account holder passwords

## User Roles

The system supports multiple role-based workflows:

- **Account Holder**: performs banking operations, manages loans, and manages Tabung savings goals.
- **Bank Officer**: registers new account holders and views account details.
- **Loan Officer**: reviews pending loan applications and approves or rejects them.
- **Finance Officer**: sets dividend rates and distributes dividends to account holders.
- **System Admin**: generates reports and resets user passwords.

## Project Structure

```text
src/
├── Main.java
├── data/
│   └── BankingDataStore.java
├── model/
│   ├── AccountHolder.java
│   ├── BankAccount.java
│   ├── BankOfficer.java
│   ├── FinanceOfficer.java
│   ├── Loan.java
│   ├── LoanOfficer.java
│   ├── SavingsGoal.java
│   ├── SystemAdmin.java
│   ├── Transaction.java
│   └── User.java
├── service/
│   ├── AccountHolderService.java
│   ├── AdminService.java
│   ├── AuthService.java
│   ├── BankOfficerService.java
│   ├── FinanceOfficerService.java
│   └── LoanOfficerService.java
└── util/
    └── TransactionIdGenerator.java
```

## Architecture Overview

The project follows a layered OOP structure:

- `Main.java` starts the application, displays menus, handles navigation, and calls service classes.
- `model/` contains entity/data classes such as users, accounts, loans, transactions, and savings goals.
- `service/` contains business logic for banking operations, loan handling, finance operations, authentication, and administration.
- `data/` contains temporary in-memory storage using Java collections.
- `util/` contains reusable helper logic such as ID generation.

This structure keeps the console application simple while making the code easier to maintain, test, and extend.

## OOP Concepts Used

- **Encapsulation**: fields are private and accessed through getters/setters.
- **Inheritance**: role classes inherit from the base `User` class.
- **Abstraction**: common user information is shared through the `User` superclass.
- **Separation of Concerns**: models store data, services handle logic, and `Main` handles user navigation.

## How to Run

### Requirements

- Java Development Kit (JDK) 8 or newer
- Terminal, Command Prompt, or PowerShell

### Compile

From the project root:

```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java).FullName
```

### Run

```powershell
java -cp out Main
```

## Default Login Data

### Account Holders

| Name | Username | Password | Account Number | Balance |
| --- | --- | --- | --- | --- |
| MOAYED | M47 | Ma123 | ACc1221 | RM 10000 |
| AHMED | AH18 | Ah123 | ACc2112 | RM 5000 |

### Staff Roles

| Role | Username | Password |
| --- | --- | --- |
| Bank Officer | MOAYED | off123 |
| Loan Officer | OMAR | loan123 |
| Finance Officer | HOSAM | fin123 |
| System Admin | MOHAMED | admin123 |

## Future Improvements

This project is structured so it can later evolve into a Spring Boot application:

- `model/` classes can become JPA entities.
- `service/` classes can become Spring `@Service` classes.
- `data/BankingDataStore.java` can be replaced with repository classes.
- Console menus can later be replaced with REST controllers or a web interface.
- In-memory lists can later be replaced with a database.

## Notes

- This is currently a console application.
- No external frameworks or databases are used.
- Data is stored temporarily in memory and resets when the program stops.
- `SavingsGoal` represents the original Tabung feature while preserving the same user-facing workflow.
