# Simple ATM System in Java

## Overview
This is a basic ATM simulation program written in Java. It allows users to create bank accounts with PIN and initial balance, and perform common banking operations such as deposit, withdrawal, and balance inquiry through a console-based menu.

## Features
- Auto-generated account numbers for new accounts.
- Secure withdrawal requiring correct PIN verification.
- Deposit money into an account.
- Check current account balance.
- Supports up to 3 accounts for demonstration purposes.

## How It Works
- Users first create 3 accounts by entering a PIN and initial balance.
- Each account is assigned a unique account number (1, 2, 3).
- After account creation, a menu-driven interface allows users to:
  - Deposit funds to an account.
  - Withdraw funds (with PIN authentication).
  - Check account balance.
  - Exit the program.

## Usage

### Compile the program
```bash
javac simpleATM.java
