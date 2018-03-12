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
	1. If the use selects a task currently in process, the database displays "That task has already been started at <TIMESTAMP>"

### 2. Stop Existing Task 
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To mark the timestamp at which work stopped on current session
- **Participating Actors:** Task, Interface, Database
- **Preconditions:** There is at least one active session in database.
- **Postconditions:** A session will have a stop entry added.
- **Flow of Events for Main Success Scenario**
	1. User selects "Stop Task" button
	2. A dropdown list of currently active tasks is displayed. The user selects the one they'd like to stop.
	3. After hitting submit the name of the task and the current system time is added into the database with the "start" property 
- **Flow of Events for Alternate Scenario**
	1. If there are no currently active tasks, the user is notified. The only active button is a 'Back' button.

### 3. Describe New or Existing Task
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To add useful information about a task to the database as a description
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** None
- **Postconditions:** A task with the given name and description exists.
- **Flow of Events for Main Success Scenario**
	1. User selects "Describe Task" button
	2. A dropdown list of tasks on the database is displayed. User selects one of those, or enters a new one into a text field.
	3. User types in the description they'd like to add into another text field.
	4. After hitting submit the given description is stored in the database with the given task name.
- **Flow of Events for Alternate Scenario**
	1. If a task already had a description, the program loads that description into the text field so the user can edit, append, or delete it.

### 4. Delete Existing Task
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To archive a task and remove it from the main database
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** Task to be deleted already exists
- **Postconditions:** Task no longer appears in GUI unless viewing archive.
- **Flow of Events for Main Success Scenario**
	1. User selects "Delete Task" button
	2. User selects task they would like to delete from a dropdown list that is displayed.
	3. The task is removed from the main database and moved to the archive.
- **Flow of Events for Alternate Scenario**
	1. There is a cancel button users can click instead of selecting a course to delete.
	2. If there are no tasks to delete, they can only click "Cancel" to go back to the main menu.

### 5. Rename Task
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To give an existing task a different name
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** Task to be renamed already exists
- **Postconditions:** Task is stored in database with the new name instead.
- **Flow of Events for Main Success Scenario**
	1. User selects "Rename Task" button
	2. User selects task they would like to rename from a dropdown list that is displayed.
	3. User enters the new name into a text field.
	3. The task is stored in the database under the new name.
- **Flow of Events for Alternate Scenario**
	1. There is a cancel button users can click instead of renaming.
	2. If there are no tasks to rename, they can only click "Cancel" to go back to the main menu.

### size new task or existing task

### add deadline to new or existing task
- **Related Requirements:** TODO
- **Initiating Actor:** Employee
- **Actor's Goal:** To add a deadline to a task in order to plan and prioritize.
- **Participating Actors:** Task, Interface, Database
- **Preconditions:** None
- **Postconditions:** A task with the given name and deadline exists.
- **Flow of Events for Main Success Scenario**
	1. User selects "Add Deadline" button
	2. A dropdown list of tasks on the database is displayed. User selects one of those, or enters a new one into a text field.
	3. User types into another textfield the date they'd like to set as the deadline for the task.
	4. After hitting submit the given deadline is displayed in the database with the given task name.
- **Flow of Events for Alternate Scenario**
	1. Program displays an error if the user tries to enter a deadline that is already passed.

### edit times for tasks

### view stats for tasks

# Traceability Matrix:



