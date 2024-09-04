package service;

// File: src/service/ResolutionService.java

import java.util.Scanner;
import dao.ResolutionDAO;

public class ResolutionService {
    private final Scanner scanner;
    private final ResolutionDAO resolutionDAO;

    public ResolutionService(Scanner scanner) {
        this.scanner = scanner;
        this.resolutionDAO = new ResolutionDAO();
    }

    public void processResolutionOperations() {
        while (true) {
            System.out.println("Manage Resolutions");
            System.out.println("1. Resolve Ticket");
            System.out.println("2. View Resolved Tickets");
            System.out.println("3. Update Resolution");
            System.out.println("4. Delete Resolution");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    resolveTicket();
                    break;
                case 2:
                    viewResolvedTickets();
                    break;
                case 3:
                    updateResolution();
                    break;
                case 4:
                    deleteResolution();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void resolveTicket() {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Resolution Details: ");
        String resolutionDetails = scanner.nextLine();
        resolutionDAO.resolveTicket(ticketId, resolutionDetails);
    }

    private void viewResolvedTickets() {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        resolutionDAO.viewResolvedTickets(ticketId);
    }

    private void updateResolution() {
        System.out.print("Enter Resolution ID: ");
        int resolutionId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Resolution Details: ");
        String resolutionDetails = scanner.nextLine();
        resolutionDAO.updateResolution(resolutionId, resolutionDetails);
    }

    private void deleteResolution() {
        System.out.print("Enter Resolution ID: ");
        int resolutionId = scanner.nextInt();
        resolutionDAO.deleteResolution(resolutionId);
    }
}
