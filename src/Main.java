
import java.util.Scanner;

import service.AssignmentService;
import service.ResolutionService;
import service.TicketService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketService ticketService = new TicketService(scanner);
        AssignmentService assignmentService = new AssignmentService(scanner);
        ResolutionService resolutionService = new ResolutionService(scanner);

        while (true) {
            System.out.println("Customer Service Ticketing System");
            System.out.println("1. Manage Tickets");
            System.out.println("2. Manage Assignments");
            System.out.println("3. Manage Resolutions");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ticketService.processTicketOperations();
                    break;
                case 2:
                    assignmentService.processAssignmentOperations();
                    break;
                case 3:
                    resolutionService.processResolutionOperations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
