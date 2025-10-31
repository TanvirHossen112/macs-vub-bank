# macs-vub-bank

## 📄 Project Description

This repository contains the source code for a programming assignment developed as part of the **Master of Applied Computer Science (MACS)** program at the **Vrije Universiteit Brussel (VUB)**.

The project is an implementation of a basic **Bank System** developed using the Java programming language.

## ✨ Features

While the exact requirements of the assignment are not explicitly listed, this banking application is designed to include core functionalities typical of a command-line-based system:

* **Account Management:** Create new customer accounts and view account details.
* **Financial Transactions:** Perform standard bank operations:
    * **Deposit** money into an account.
    * **Withdraw** money from an account (with balance checks).
* **Balance Inquiry:** Check the current balance of any account.
* **Data Handling:** Manage and persist account and transaction data (implementation details depend on the assignment, e.g., using in-memory objects or basic file I/O).

## 🛠️ Technologies Used

| Technology | Description |
| :--- | :--- |
| **Java** | The primary programming language used for the application logic. |
| **IntelliJ IDEA** | The project setup with the `Bank.iml` and `.idea` folders suggests it was developed using IntelliJ IDEA. |

## 🚀 Setup and Running

To run this project locally, you will need a Java Development Kit and an IDE or command line access.

### Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher.
* **Git:** To clone the repository.
* **IDE (Recommended):** IntelliJ IDEA is recommended for the easiest setup due to the included configuration files.

### Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/TanvirHossen112/macs-vub-bank.git](https://github.com/TanvirHossen112/macs-vub-bank.git)
    cd macs-vub-bank
    ```

2.  **Open the Project:**
    * **IntelliJ IDEA:** Open the project directory (`macs-vub-bank`) directly. The IDE should automatically recognize the Java project structure and load the dependencies from the `Bank.iml` file.
    * **Other IDEs (e.g., Eclipse, VS Code):** Import the project as an existing Java project and ensure the `src` folder is marked as the Source Root.

### Running the Application

1.  Locate the main class within the `src` directory (e.g., a file containing the `public static void main(String[] args)` method).
2.  Run the application using your IDE's run command.

**Alternatively, to run from the command line (adjusting paths as necessary):**

```bash
# Compile all Java files in the src directory
javac -d out src/*.java 

# Run the main class (Replace 'MainClass' with the actual name of your main class file)
java -cp out MainClass

