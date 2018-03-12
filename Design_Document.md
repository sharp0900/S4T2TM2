# S4T2TM2 Design Document
- Design Document for Task Manger of Group 2
- Group Members: Victor, Angela, Kevin, Emily
# Introduction:

## GUI: will open up the program to more users
- easier to error check
- easier to get valid input

## SQL database: 
- easier to access,store,manipulate data

### Customer: 
- Agile users, anyone can use the program

### manager: 
- has more permissions 

### employee: 
- normal access

### two users: 
- manager and employee

### Reasons for using program: 
- make it really simple and easy to use and manage tasks

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
- the options for working with a task are the same
### What is different?
- more options for task organization
- Gui interface
- Sql database
- Organization by Sprint
- Comprehensive feedback from program **notifications**

# Project Architecture:
- GUI Interface for user
- logic for handling gui inputs
- SQL database for storing GUI formatted input

# Requirements:
## Use Cases:
### 1. start new task 
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To mark the timestamp at which work started on current session
- **Participating Actors:** Task, Interface, Database
- **Preconditions:**
- **Postconditions:**
- **Flow of Events for Main Success Scenario**
	1. User selects "Start Task" button
	2. If they are working on a new task they enter it into a text field. Otherwise, they select the desired task from a drop down menu.
	3. After hitting submit the name of the task and the current system time is added into the database with the "start" property 

### 2. stop existing task

### describe new or existing task

### delete existing task

### rename existing task

### size new task or existing task

# Traceability Matrix:

# Pre Conditions & Post Conditions:


