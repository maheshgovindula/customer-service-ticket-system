package service;

import java.util.Scanner;
import dao.TicketDAO;
import exceptions.TicketNotFoundException;

public class TicketService {
    private final Scanner scanner;
    private final TicketDAO ticketDAO;

    public TicketService(Scanner scanner) {
        this.scanner = scanner;
        this.ticketDAO = new TicketDAO();
    }

    public void processTicketOperations() throws TicketNotFoundException {
        while (true) {
            System.out.println("Manage Tickets");
            System.out.println("1. Create Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. View All Tickets");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    viewTicket();
                    break;
                case 3:
                    updateTicket();
                    break;
                case 4:
                    deleteTicket();
                    break;
                case 5:
                    return;
                case 6:
                    viewAllTickets();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createTicket() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Issue Description: ");
        String issueDescription = scanner.nextLine();
        ticketDAO.createTicket(customerId, issueDescription);
    }

    private void viewTicket() throws TicketNotFoundException {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        ticketDAO.viewTicket(ticketId);
    }

    private void updateTicket() {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Issue Description: ");
        String issueDescription = scanner.nextLine();
        ticketDAO.updateTicket(ticketId, issueDescription);
    }

    private void deleteTicket() {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        ticketDAO.deleteTicket(ticketId);
    }

    private void viewAllTickets() {
        ticketDAO.viewAllTickets();
    }
}
