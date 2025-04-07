# Data Structures Assignment

## Overview

This project implements custom versions of basic data structures in Java without relying on most of the utilities from `java.util.*` (except for `Iterator`). The project includes:

- **MyArrayList:** a custom implementation of an array list.
- **MyLinkedList:** a custom implementation of a doubly-linked list with built-in loop prevention.
- **MyStack:** a stack built upon MyArrayList.
- **MyQueue:** a queue built upon MyLinkedList.
- **MyMinHeap:** a min-heap constructed using MyArrayList.

## Project Structure


DataStructuresAssignment/idea


## How to build and run

1. **Building the Project:**  
   Open the project in IntelliJ IDEA. The IDE will automatically handle the project setup. Alternatively, you can compile the project via the command line using `javac`.

2. **Running Tests:**  
   The project includes tests (either through a `main` method or a testing framework like JUnit) to verify the functionality of each data structure. Use IntelliJ’s test runner or run the tests from the command line.

## Git and GitHub Usage

- **Local Repository:**  
  The project is tracked using Git. Regular commits have been made to capture the development progress.

- **Remote Repository:**  
  The project is also pushed to GitHub for version control. Use Git commands (`commit`, `push`, etc.) to manage your changes.

- **Commit Guidelines:**  
  Each commit message is descriptive and covers specific changes. For example:
    - "Initial commit: Project setup with README and .gitignore"
    - "Implement basic MyArrayList structure"
    - "Add tests for MyLinkedList"
    - "Implement MyStack based on MyArrayList"
    - etc.

## Implementation Details

- **MyArrayList:**  
  A dynamic array that supports standard list operations.

- **MyLinkedList:**  
  A doubly-linked list designed to avoid cyclic references, ensuring efficient insertions and removals.

- **MyStack:**  
  A stack implementation that utilizes MyArrayList for fast access to the top element.

- **MyQueue:**  
  A queue implementation using MyLinkedList to allow efficient enqueue and dequeue operations.

- **MyMinHeap:**  
  A min-heap built using an array-based structure (MyArrayList), supporting efficient extraction of the minimum element.

## Additional Information

- **Element Comparison:**  
  Elements are compared either using generics with the constraint `T extends Comparable<T>` or by passing a custom `Comparator` to sorting methods.

- **Documentation:**  
  Inline comments within the source code explain the design and implementation choices in detail.

## Conclusion

This project aims to deepen the understanding of fundamental data structures while reinforcing best practices in version control using Git and GitHub.
