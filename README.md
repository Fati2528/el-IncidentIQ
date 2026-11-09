IncidentIQ – IT Incident Triage Console

Project Overview

IncidentIQ is a Java-based console application designed to register, classify, and prioritize IT incidents.

It collects incident details, calculates priority scores based on impact and urgency, identifies major incidents, and generates an operational summary.

Features

- Register multiple IT incidents.
- Validate user input.
- Collect incident title, service, and description.
- Record affected users.
- Classify incident impact and urgency.
- Calculate incident priority scores.
- Assign priority levels from P1 to P4.
- Display recommended response targets.
- Detect major incidents.
- Generate an operational summary.

Priority Calculation

The priority score is calculated using:

Priority Score = (Impact × 2) + (Urgency × 2)

Priority levels:

Score| Priority| Response Target
13–16| P1 – Critical| 1 hour
9–12| P2 – High| 4 hours
5–8| P3 – Medium| 8 hours
4| P4 – Low| 24 hours

Major Incident Detection

An incident is identified as a major incident when:

- Impact level is 4 (Critical).
- At least 50 users are affected.

Both conditions must be satisfied.

Technologies Used

- Java
- Scanner class
- Variables and data types
- If-else statements
- Switch-case
- Loops
- Operators
- User-defined methods
- String methods
- Input validation

How to Run

1. Install Java JDK.

2. Download or clone this repository.

3. Open the project folder in Command Prompt.

4. Compile the program:
   
   "javac Main.java"

5. Run the program:
   
   "java Main"

Project Files

- "Main.java" – Main Java source code.
- "README.md" – Project documentation.
- "Test-case.md" – Test cases and expected results.
- "Sample-output.txt" – Sample program execution.

Learning Objectives

This project demonstrates the practical application of Java programming concepts, including conditional statements, loops, operators, String methods, input validation, and user-defined methods.

Author

Fatima Nawab
