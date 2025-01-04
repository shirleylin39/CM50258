# Coursework Specifications

## Overview
This document outlines the descrptions for the courseworks in module CM50258. Each coursework involves implementing algorithms, functions, data structures, or cryptographic techniques in different programming languages to solve specific problems.

### **Code Files**:
   - Coursework 1_1: C source file.
   - Coursework 1_2: Python script.
   - Coursework 2_1, 2_2, 2_3, 2_4: Java files.


## Coursework 1: Fundamental Algorithms and Computation

### **Coursework 1_1**: Day Counting Function in C

**Objective**: Develop a function in C to calculate the number of Mondays that fall on the 12th day of the month within a specific date range (1401–1800). The solution requires implementing logic for determining leap years and navigating calendar patterns. 

**Key Skills**: 
- Handling date-based calculations
- Efficiently iterating over long time periods
- Applying modular arithmetic to real-world scenarios

**Constraints**:
- Limited to standard libraries such as `stdio.h`, `stdlib.h`, and `math.h`.
- The program must return the result within 30 seconds of execution.

---

### **Coursework 1_2**: Polish Notation Evaluator in Python

**Objective**: Write a Python function to evaluate arithmetic expressions in Polish Notation (prefix notation). This involves parsing a list of tokens to compute a result using basic arithmetic operations (`+`, `-`, `*`, `/`) while ensuring validity and handling edge cases like division by zero.

**Key Skills**:
- Parsing and interpreting prefix arithmetic expressions
- Managing invalid input gracefully
- Implementing robust error-handling mechanisms

**Constraints**:
- Inputs are limited to operators and integers in the range [-300, 300].
- Outputs must handle truncation of integer division and invalid expressions correctly.

---

## Coursework 2: Advanced Programming and Data Structures

### **Coursework 2_1**: Text Redaction in Java

**Objective**: Implement a Java function to redact words from an input string based on a list of redactable words. Redacted words are replaced with asterisks matching their length. The function must respect case insensitivity and ensure accurate matching of standalone words.

**Key Skills**:
- String manipulation and pattern matching
- Case-insensitive comparisons
- Preserving the format and punctuation of the input text

**Challenges**:
- Avoiding partial matches (e.g., "pass" should not redact "password").
- Maintaining the capitalization of unredacted words.

---

### **Coursework 2_2**: Sorted Doubly Linked List in Java

**Objective**: Create a class to manage a sorted doubly linked list of strings, supporting operations such as adding, removing, and reordering elements. The class should allow dynamic reordering in ascending or descending alphabetical order.

**Key Skills**:
- Designing and implementing custom data structures
- Managing pointers in a doubly linked list
- Supporting dynamic sorting and efficient list operations

**Features**:
- Add, remove, or check for the presence of elements.
- Retrieve elements based on position or order.
- Reorder the list dynamically (ascending or descending).

---

### **Coursework 2_3**: Custom Sorting Algorithm in Java

**Objective**: Implement a custom sorting algorithm using a sequence of gap values derived from a given pseudocode. The class must manage a list of double values, enabling insertion, removal, and sorting in ascending order.

**Key Skills**:
- Translating pseudocode into efficient Java implementation
- Managing and updating an array dynamically
- Understanding and applying non-standard sorting algorithms

**Constraints**:
- Adhere strictly to the provided pseudocode for sorting.
- Use only the `ArrayList` class for storage.

---

### **Coursework 2_4**: Vigenère Cipher in Java

**Objective**: Implement the Vigenère cipher, a polyalphabetic substitution cipher, to encrypt text messages. The cipher uses a keyword to generate a repeating encryption pattern and operates exclusively on uppercase English letters.

**Key Skills**:
- Implementing cryptographic algorithms
- Handling text transformations and character mappings
- Generating encryption keys dynamically to match the message length

**Features**:
- Input and output restricted to uppercase English letters.
- Accurate encoding using a character-based substitution grid (Vigenère square).