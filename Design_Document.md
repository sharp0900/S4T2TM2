# S4T2TM2 Design Document
- Design Document for Task Manger of Group 2
- Group Members: Victor, Angela, Kevin, Emily
# Introduction:

[//]: # (TODO: improve introduction)

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
[//]: # (TODO: more product reviews)
- Seperate tasks into classes
- always have the selected task summary displayed
- each task has a button
- when creating a new task a new window pops up to give task details
- Simple design with sidebar

#### [trello.com](trello.com) Product Review
- Trello has a very extensive user connection platform for agile users
- Organization:
- Boards contain lists
- A board is to delineate by organization or group
- Entire contents of a board can be moved or deleted all at once
- Lists contain tasks, can be private or public
- Lists have the capibility to be shared with organizations or groups
- Tasks have a main description
- Tasks can be assigned a user of an organization
- Tasks have a 'comments' thread to act as updates
- Tasks can be color coordinated or labeled
- Tasks have due dates
- Tasks have a checklist
- Tasks have a place to add links or attachments
- Filters are used to show different views such as sort by due dates, user, label

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
[//]: # (TODO: use case diagram)
[//]: # (TODO: diagram demo)
- GUI Interface for user
- logic for handling gui inputs
- SQL database for storing GUI formatted input

# Requirements:

| Identifier| Requirement 	|
|-----------|---------------|
|REQ1	|System should keep track of time spent on a task.|
|REQ2	|System should allow users to access data about entered time logs.|
|REQ3	|System should allow manager users to modify time logs.|
|REQ4	|System should allow users to add descriptive data to their time logs.|
|REQ5	|System should allow users to give tasks a size.|
|REQ6	|System should allow users to assign a deadline to tasks.|
|REQ7	|System should allow users to sort tasks by deadline, group, or size.|
|REQ8	|System should notify user of upcoming deadlines when they start the program.|
|REQ9	|System should allow users to archive old tasks.|
|REQ10	|System should allow users to sort tasks into category.|
|REQ11	|Users should be able to edit all details of a task stored in the database.|
|REQ12	|System should provide immediate feedback whenever something is successfully added to the database.|

##User Stories
 [//]: # (TODO: put into formal user story UML diagram)
 
### manager: 
- View total time spent on project
- View statistics for users
- Can edit time entries in the database

### developer: 
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
- **Related Requirements:** REQ1, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To mark the timestamp at which work started on current session
- **Participating Actors:** Task, Interface, Database
- **Preconditions:**The task selected must not be an active task.
- **Postconditions:** A task will have been started in the database.
- **Flow of Events for Main Success Scenario**
	1. User selects "Start Task" button
	2. If they are working on a new task they enter it into a text field. Otherwise, they select the desired task from a drop down menu.
	3. After hitting submit the name of the task and the current system time is added into the database with the "start" property and the user is notified that the entry was successful.
- **Flow of Events for Alternate Scenarios**
	1. If the user selects a task currently in process, the database displays "That task has already been started at <TIMESTAMP>"
	2. If the user starts a task that already has existing start and end time, an error will be thrown to check if the name is correct and the user will be prompted to rename that task, or proceed with starting it. If a task has a description it will be shown to verify that is the correct task.

### 2. Stop Existing Task 
- **Related Requirements:** REQ1, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To mark the timestamp at which work stopped on current session
- **Participating Actors:** Task, Interface, Database
- **Preconditions:** There is at least one active session in database.
- **Postconditions:** A session will have a stop entry added.
- **Flow of Events for Main Success Scenario**
	1. User selects "Stop Task" button
	2. A dropdown list of currently active tasks is displayed. The user selects the one they'd like to stop.
	3. After hitting submit the name of the task and the current system time is added into the database with the "start" property and the user is notified that the entry was successful.
- **Flow of Events for Alternate Scenario**
	1. If there are no currently active tasks, the user is notified. The only active button is a 'Back' button.

### 3. Describe New or Existing Task
- **Related Requirements:** REQ3, REQ11, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To add useful information about a task to the database as a description
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** None
- **Postconditions:** A task with the given name and description exists.
- **Flow of Events for Main Success Scenario**
	1. User selects "Describe Task" button
	2. A dropdown list of tasks on the database is displayed. User selects one of those, or enters a new one into a text field.
	3. User types in the description they'd like to add into another text field.
	4. After hitting submit the given description is stored in the database with the given task name and the user is notified that the change was successful.
- **Flow of Events for Alternate Scenario**
	1. If a task already had a description, the program loads that description into the text field so the user can edit, append, or delete it.

### 4. Delete Existing Task
- **Related Requirements:** REQ9, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To archive a task and remove it from the main database
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** Task to be deleted already exists
- **Postconditions:** Task no longer appears in GUI unless viewing archive.
- **Flow of Events for Main Success Scenario**
	1. User selects "Delete Task" button
	2. User selects task they would like to delete from a dropdown list that is displayed.
	3. The task is removed from the main database and moved to the archive and the user is notified that the change was successful.
- **Flow of Events for Alternate Scenario**
	1. There is a cancel button users can click instead of selecting a course to delete.
	2. If there are no tasks to delete, that message will be displayed and they can only click "Cancel" to go back to the main menu.

### 5. Rename Task
- **Related Requirements:** REQ11, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To give an existing task a different name
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** Task to be renamed already exists
- **Postconditions:** Task is stored in database with the new name instead.
- **Flow of Events for Main Success Scenario**
	1. User selects "Rename Task" button
	2. User selects task they would like to rename from a dropdown list that is displayed.
	3. User enters the new name into a text field.
	3. The task is stored in the database under the new name and the user is notified that the change was successful.
- **Flow of Events for Alternate Scenario**
	1. There is a cancel button users can click instead of renaming.
	2. If there are no tasks to rename, they can only click "Cancel" to go back to the main menu.

### 6. Size New or Existing Task
- **Related Requirements:** REQ5, REQ7, REQ11, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To add useful information about a task to the database as a description
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** None
- **Postconditions:** A task with the given name and size exists.
- **Flow of Events for Main Success Scenario**
	1. User selects "Describe Task" button
	2. A dropdown list of tasks on the database is displayed. User selects one of those, or enters a new one into a text field.
	3. User types in the description they'd like to add into another text field.
	4. After hitting submit the given description is stored in the database with the given task name and the user is notified that the change was successful.
- **Flow of Events for Alternate Scenario**
	1. If a task already had a description, the program loads that description into the text field so the user can edit, append, or delete it.

### 7. Add Deadline to New or Existing Task
- **Related Requirements:** REQ7, REQ8, REQ11, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To add a deadline to a task in order to plan and prioritize.
- **Participating Actors:** Task, Interface, Database
- **Preconditions:** None
- **Postconditions:** A task with the given name and size exists.
- **Flow of Events for Main Success Scenario**
	1. User selects "Add Deadline" button
	2. A dropdown list of tasks on the database is displayed. User selects one of those, or enters a new one into a text field.
	3. User types into another textfield the date they'd like to set as the deadline for the task.
	4. After hitting submit the given deadline is displayed in the database with the given task name and the user is notified that the change was successful.
- **Flow of Events for Alternate Scenario**
	1. Program displays an error if the user tries to enter a deadline that is already passed.
	2. Selecting a task that already has a deadline will override the previous deadline with the new one.

### 8. View Stats for Tasks 
- **Related Requirements:** REQ1, REQ2, REQ4, REQ5, REQ6, REQ7, REQ9, REQ10, REQ11
- **Initiating Actor:** Developer
- **Actor's Goal:** To view stats for tasks in database
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** None
- **Postconditions:** None
- **Flow of Events for Main Success Scenario**
	1. User selects "View Tasks" button
	2. Information for all tasks in database is shown, including (if any) size, description, deadlines.
	3. Statistics including average, minimum, and maximum time are displayed for each size category.
- **Flow of Events for Alternate Scenario**
	1. If there are no tasks to display, the program displays "None." 
	2. Program cannot calculate time on tasks currently in progress.
	3. Program does not display stats for size categories that have less than 2 entries.

### 9. Edit Times for Tasks
- **Related Requirements:** REQ1, REQ3, REQ11, REQ12
- **Initiating Actor:** Manager
- **Actor's Goal:** To make corrections in database
- **Participating Actors:** TaskList, Interface, Database
- **Preconditions:** Something inaccurate exists in the database
- **Postconditions:** Database is accurate
- **Flow of Events for Main Success Scenario**
	1. User selects "Edit a Task" button
	2. A list of all logs in database is displayed.
	3. User can filter by contributing developer or task name to find the task they'd like to edit.
	4. User selects task to edit and changes the timestamp manually.
	5. This change is recorded in the database and the user is notified that the change was successful.
- **Flow of Events for Alternate Scenario**
	1. If there are no logs to display, the program displays "None." 
	2. There is a cancel button users can click instead of editing.

### 10. Classify Tasks Into a Category
- **Related Requirements:** REQ7, REQ10, REQ11, REQ12
- **Initiating Actor:** Developer
- **Actor's Goal:** To place a task into a certain group.
- **Participating Actors:** Tasklist, Interface, Database
- **Preconditions:** None
- **Postconditions:** A task is classified under a certain category.
- **Flow of Events for Main Success Scenario**
	1. User selects "Classify Task Category" button
	2. A menu will pop up and prompt the User to select a task, or multiple.
	3. User will then type in the category they wish the task to be in.
	4. When user hits apply, it will prompt the user that the category of the task has been implemented/changed.
- **Flow of Events for Alternate Scenario**
	1. If there are no tasks to display, the program displays "None." 
	2. There is a cancel button users can click instead of editing.

	### 11. Color Code Tasks
- **Related Requirements:** 
- **Initiating Actor:** Developer
- **Actor's Goal:** To color code a task, or multipule, a certin color for eaiser viewing
- **Participating Actors:** Tasklist, Interface, Database
- **Preconditions:** Task has to exist
- **Postconditions:** A task will be displayed with a certain color
- **Flow of Events for Main Success Scenario**
	1. User selects "Change Task Color" button
	2. A menu will pop up and prompt the User to select a task, or multiple.
	3. User will then select a box filled in with the colors that are avaliable, or enter in their own via hex.
	4. When user hits apply, it will prompt the user that task color has been changed.
- **Flow of Events for Alternate Scenario**
	1. If there are no tasks to display, the program displays "None." 
	2. There is a cancel button users can click instead of editing.

	### 12. Warning Prompt
- **Related Requirements:** 
- **Initiating Actor:** Developer
- **Actor's Goal:** To prompt and ask the user, when creating a task of the same name, if what they are doing is what they want to be done.
- **Participating Actors:** Tasklist, Interface, Database
- **Preconditions:** User creates a task that already exist.
- **Postconditions:** The user will either create a new task with a diffrient name, or start the task of the same name. 
- **Flow of Events for Main Success Scenario**
	1. User selects "Start Task" button
	2. A menu will prompt the user that the task already exist and ask if he\she wants to start a new task with a diffrient name instead or continue the task that already exists.
	3. The user will select either yes, they want to start a new task under a diffrient name, or no, start the existing task under said name.
- **Flow of Events for Alternate Scenario**
	1. If the user selects a task currently in process, the database displays "That task has already been started at <TIMESTAMP>"
	2. There is a cancel button users can click instead of continuing this processes.

# Traceability Matrix:

|Requirement|UC1|UC2|UC3|UC4|UC5|UC6|UC7|UC8|UC9|UC10|UC11|UC12|
|-----------|---|---|---|---|---|---|---|---|---|---|---|---|
|REQ1		| X | X |   |   |   |   |   | X | X |   |   | X |
|REQ2		|   |   |   |   |   |   |   | X |   |   |   |   |
|REQ3		|   |   |   |   |   |   |   |   | X |   |   |   |
|REQ4		|   |   | X |   |   |   |   | X |   |   |   |   |
|REQ5		|   |   |   |   |   | X |   | X |   |   |   |   |
|REQ6		|   |   |   |   |   |   |   | X |   |   |   |   |
|REQ7		|   |   |   |   |   | X | X | X |   | X | X |   |
|REQ8		|   |   |   |   |   |   | X |   |   |   |   |   |
|REQ9		|   |   |   | X |   |   |   | X |   |   |   |   |
|REQ10		|   |   |   |   |   |   |   | X |   | X |   |   |
|REQ11		|   |   | X |   | X | X | X | X | X | X |   |   |
|REQ12		| X | X | X | X | X | X | X |   | X | X | X | X |

# Actors:
|Actor|Actors Goal|Use Case Name|
|--------------|----------------------------------------------------|---------------|
|Manager          | To view total time spent on project  | UC-8  |
|Manager          | To view statistics for users | UC-8 |
|Manager          | To edit time entries in the database | UC-9  |
|Developer        | To add a task | UC-1, UC-3  |
|Developer        | To start and stop a task | UC-1  |
|Developer        | To add a description of a task | UC-3  |
|Developer        | To rename a task | UC-5  |
|Developer        | To delete a task | UC-4  |
|Developer        | To view total time spent on tasks |  UC-8 |
|Developer        | To view stats on tasks | UC-8  |
|Developer        | To give a task a size | UC-6  |
