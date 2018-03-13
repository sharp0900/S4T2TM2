# S4T2TM2 Design Document
- Design Document for Task Manger of Group 2
- Group Members: Victor, Angela, Kevin, Emily
# Introduction:

## GUI: will open up the program to more users
- Agile development is not limited to just programmers. A GUI would make interfacing with the program easier for artists, designers, managers, and so on.
- Limiting the format in which users can enter data makes it easier to check for valid input and check for errors.


### Customer: 
- This program is intended for individuals or teams working in an AGILE development environment.


### Reasons for using program: 
- Out program is intended to be a tool that is useful for managing tasks while being very simple and easy to use.

### Interface would have: 
- all possible options display, feedback, **view settings**

# Product Reviews: (Good ideas from other Task Managing Software)
- Seperate tasks into classes
- always have the selected task summary displayed
- each task has a button
- when creating a new task a new window pops up to give task details
- Simple design with sidebar

# Project Overview:
### What is the same?
- Previous use cases will remain present in future sprints. IE, start, stop, rename, delete, describe, summary, and size will still be functions
### What is different?
- We are adding a GUI built in Java to increase user accessibility
- We are adding new use cases, including the ability to add a deadline
- It will be possible to view projects in terms of sprints
- Manager users will be able to edit the log through the GUI
- An SQL database will be used to store task data instead of a txt file.
- Comprehensive feedback from program **notifications**

# Project Architecture:
- GUI Interface for user
- logic for handling gui inputs
- SQL database for storing GUI formatted input

# Requirements:
##User Stories

### two users: 
- manager and employee
- 
### manager: 
- View total time spent on project
- View statistics for users
- Can edit time entries in the database

### employee: 
- Can add tasks
- Can start and stop tasks
- Can add descriptions of tasks
- Can rename tasks
- Can delete tasks
- Can view total time spent on tasks
- Can view stats on tasks
- Can give a task a size

## Use Cases:
### 1. Start New Task 
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To mark the timestamp at which work started on current session
- **Participating Actors:** Task, Interface, Database
- **Preconditions:**The task selected must not be an active task.
- **Postconditions:** A task will have been started in the database.
- **Flow of Events for Main Success Scenario**
	1. User selects "Start Task" button
	2. If they are working on a new task they enter it into a text field. Otherwise, they select the desired task from a drop down menu.
	3. After hitting submit the name of the task and the current system time is added into the database with the "start" property 
- **Flow of Events for Alternate Scenarios**
	1. If the use selects a task currently in process, the database displays "That task has already been started at TIMESTAMP"

### 2. Stop Existing Task 
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To mark the timestamp at which work stopped on current session
- **Participating Actors:** Task, Interface, Database
- **Preconditions:** There is at least one active session in database.
- **Postconditions:** A session will have a stop entry added.
- **Flow of Events for Main Success Scenario**
	1. User selects "Stop Task" button
	2. A dropdown list of currently active tasks 
	3. After hitting submit the name of the task and the current system time is added into the database with the "start" property 
- **Flow of Events for Alternate Scenario**
	1. There are no currently active tasks. Only active button is a 'Back' button.

### describe new or existing task

### delete existing task

### rename existing task

### size new task or existing task

# Traceability Matrix:

# Pre Conditions & Post Conditions:


