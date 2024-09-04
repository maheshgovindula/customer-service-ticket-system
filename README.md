# customer-service-ticket-system


## Case Study Overview

This project aims to develop a console-based application using Java, MySQL, and JDBC to manage a customer service ticketing system. The application will handle ticket creation, assignment, and resolution processes within a customer service environment.

## Requirements

- **VS Code**: Integrated Development Environment (IDE) for writing and debugging Java code.
- **MySQL Workbench**: Tool for designing and managing MySQL databases.
- **JDBC MySQL Driver**: Required for connecting the Java application to the MySQL database.

## Functionalities

### 1. Ticket Creation
- **Create a New Ticket**: Allows users to create a new customer service ticket.
- **View Ticket Details**: Enables viewing of detailed information about a specific ticket.
- **Update Ticket Information**: Allows modification of existing ticket details.
- **Delete a Ticket**: Facilitates the removal of a ticket from the system.

### 2. Ticket Assignment
- **Assign a Ticket**: Assigns a customer service ticket to a representative.
- **View Assigned Tickets**: Displays a list of all assigned tickets.
- **Update Assignment Information**: Allows updating of details related to ticket assignments.
- **Delete Assignment Records**: Enables deletion of ticket assignment records.

### 3. Ticket Resolution
- **Resolve a Ticket**: Marks a customer service ticket as resolved.
- **View Resolved Tickets**: Lists all resolved tickets.
- **Update Resolution Information**: Allows updates to the resolution details of a ticket.
- **Delete Resolution Records**: Facilitates the removal of resolution records from the system.

## Database Schema

### Ticket Table
- **ticket_id**: Primary Key
- **customer_id**: Foreign Key referencing the Customer Table
- **creation_date**: Date and time when the ticket was created
- **issue_description**: Description of the issue reported by the customer
- **status**: Current status of the ticket (e.g., open, closed)

### Assignment Table
- **assignment_id**: Primary Key
- **ticket_id**: Foreign Key referencing the Ticket Table
- **representative_id**: Foreign Key referencing the Representative Table
- **assignment_date**: Date and time when the ticket was assigned
- **status**: Current status of the assignment

### Resolution Table
- **resolution_id**: Primary Key
- **ticket_id**: Foreign Key referencing the Ticket Table
- **resolution_date**: Date and time when the ticket was resolved
- **resolution_details**: Details of the resolution provided
- **status**: Current status of the resolution (e.g., resolved, unresolved)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/customer-service-ticketing-system.git
