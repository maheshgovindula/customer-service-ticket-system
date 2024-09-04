package dao;

import java.sql.*;

import exceptions.TicketNotFoundException;

public class TicketDAO {

    public void createTicket(int customerId, String issueDescription) {
        String query = "INSERT INTO Ticket (customer_id, creation_date, issue_description, status) VALUES (?, NOW(), ?, 'Open')";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, issueDescription);
            preparedStatement.executeUpdate();

            System.out.println("Ticket created successfully.");
            System.out.println("================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      public void viewTicket(int ticketId) throws TicketNotFoundException {
        String query = "SELECT * FROM Ticket WHERE ticket_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, ticketId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Ticket ID: " + resultSet.getInt("ticket_id"));
                System.out.println("Customer ID: " + resultSet.getInt("customer_id"));
                System.out.println("Creation Date: " + resultSet.getTimestamp("creation_date"));
                System.out.println("Issue Description: " + resultSet.getString("issue_description"));
                System.out.println("Status: " + resultSet.getString("status"));
                System.out.println("================================================");
            } else {
                throw new TicketNotFoundException("Ticket with ID " + ticketId + " not found.");
            }
        } catch (TicketNotFoundException e) {
            // Handle custom exception
            System.out.println(e.getMessage());
            System.out.println("================================================");
        } catch (Exception e) {
            // Handle other exceptions (e.g., database connection issues)
            System.out.println("An error occurred while trying to view the ticket.");
            System.out.println("================================================");
        }
    }

    public void updateTicket(int ticketId, String issueDescription) {
        String query = "UPDATE Ticket SET issue_description = ? WHERE ticket_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, issueDescription);
            preparedStatement.setInt(2, ticketId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ticket updated successfully.");
                System.out.println("================================================");
            } else {
                System.out.println("Ticket not found.");

                System.out.println("================================================");
            }
        } catch (Exception e) {
            System.out.println("Eneter correct ticket id");

        }
    }

    public void deleteTicket(int ticketId) {
        String query = "DELETE FROM Ticket WHERE ticket_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, ticketId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ticket deleted successfully.");

                System.out.println("================================================");
            } else {
                System.out.println("Ticket not found.");

                System.out.println("================================================");
            }
        } catch (Exception e) {
            System.out.println("Ticket not found with matching ticketID");
        }
    }

    public void viewAllTickets() {
        String query = "SELECT * FROM Ticket";

        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Ticket ID: " + resultSet.getInt("ticket_id"));
                System.out.println("Customer ID: " + resultSet.getInt("customer_id"));
                System.out.println("Creation Date: " + resultSet.getTimestamp("creation_date"));
                System.out.println("Issue Description: " + resultSet.getString("issue_description"));
                System.out.println("Status: " + resultSet.getString("status"));
                System.out.println("================================================");
            }
        } catch (Exception e) {
            System.out.println("NO tickets found");

        }
    }
}
