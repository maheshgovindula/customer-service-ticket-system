package dao;

import java.sql.*;

import exceptions.ResolvedTicketNotFoundException;

public class ResolutionDAO {

    public void resolveTicket(int ticketId, String resolutionDetails) {
        String query = "INSERT INTO Resolution (ticket_id, resolution_date, resolution_details, status) VALUES (?, NOW(), ?, 'Resolved')";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, ticketId);
            preparedStatement.setString(2, resolutionDetails);
            preparedStatement.executeUpdate();

            System.out.println("Ticket resolved successfully.");
            System.out.println("================================================");
        } catch (Exception e) {
            System.out.println("No tickets found to resolve");
           
        }
    }

      public void viewResolvedTickets(int ticketId) throws ResolvedTicketNotFoundException {
        String query = "SELECT * FROM Resolution WHERE ticket_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, ticketId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                // No resolved tickets found, throw custom exception
                throw new ResolvedTicketNotFoundException("No resolved tickets found for Ticket ID " + ticketId + ".");
            }

            while (resultSet.next()) {
                System.out.println("Resolution ID: " + resultSet.getInt("resolution_id"));
                System.out.println("Ticket ID: " + resultSet.getInt("ticket_id"));
                System.out.println("Resolution Date: " + resultSet.getTimestamp("resolution_date"));
                System.out.println("Resolution Details: " + resultSet.getString("resolution_details"));
                System.out.println("Status: " + resultSet.getString("status"));
                System.out.println("================================================");
            }
        } catch (ResolvedTicketNotFoundException e) {
            // Handle custom exception
            System.out.println(e.getMessage());
            System.out.println("================================================");
        } catch (Exception e) {
            // Handle other exceptions (e.g., database connection issues)
            System.out.println("An error occurred while trying to view resolved tickets.");
            System.out.println("================================================");
        }
    }

    public void updateResolution(int resolutionId, String resolutionDetails) {
        String query = "UPDATE Resolution SET resolution_details = ? WHERE resolution_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, resolutionDetails);
            preparedStatement.setInt(2, resolutionId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Resolution updated successfully.");
                System.out.println("================================================");
            } else {
                System.out.println("Resolution not found.");
                System.out.println("================================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteResolution(int resolutionId) {
        String query = "DELETE FROM Resolution WHERE resolution_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, resolutionId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Resolution deleted successfully.");

                System.out.println("================================================");
            } else {
                System.out.println("Resolution not found.");

                System.out.println("================================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
