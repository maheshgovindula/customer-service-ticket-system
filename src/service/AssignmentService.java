package service;
import java.util.Scanner;
import dao.AssignmentDAO;
import exceptions.NoTicketsAssignedException;

public class AssignmentService {
    private final Scanner scanner;
    private final AssignmentDAO assignmentDAO;

    public AssignmentService(Scanner scanner) {
        this.scanner = scanner;
        this.assignmentDAO = new AssignmentDAO();
    }

    public void processAssignmentOperations() throws NoTicketsAssignedException {
        while (true) {
            System.out.println("Manage Assignments");
            System.out.println("1. Assign Ticket");
            System.out.println("2. View Assigned Tickets");
            System.out.println("3. Update Assignment");
            System.out.println("4. Delete Assignment");
            
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    assignTicket();
                    break;
                case 2:
                    viewAssignedTickets();
                    break;
                case 3:
                    updateAssignment();
                    break;
                case 4:
                    deleteAssignment();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private void assignTicket() {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        System.out.print("Enter Representative ID: ");
        int representativeId = scanner.nextInt();


        try{
            assignmentDAO.assignTicket(ticketId, representativeId);

        }
        catch(Exception e)
        {
            System.out.println("Please check if customer exists or not");
        }
    
    }

    private void viewAssignedTickets() throws NoTicketsAssignedException {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        assignmentDAO.viewAssignedTickets(ticketId);
    }

    private void updateAssignment() {
        System.out.print("Enter Assignment ID: ");
        int assignmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Status: ");
        String status = scanner.nextLine();
        assignmentDAO.updateAssignment(assignmentId, status);
    }

    private void deleteAssignment() {
        System.out.print("Enter Assignment ID: ");
        int assignmentId = scanner.nextInt();
        assignmentDAO.deleteAssignment(assignmentId);
    }
}
