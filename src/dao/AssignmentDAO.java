package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentDAO {

    public void assignTicket(int ticketId, int representativeId) {
        String query = "INSERT INTO Assignment (ticket_id, representative_id, assignment_date, status) VALUES (?, ?, NOW(), 'Assigned')";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, ticketId);
            preparedStatement.setInt(2, representativeId);
            preparedStatement.executeUpdate();

            System.out.println("Ticket assigned successfully.");
            System.out.println("================================================");

        } catch (Exception e) {
            System.out.println("please check if representative exists or not");
            System.out.println("================================================");
        }
    }

    public void viewAssignedTickets(int ticketId) {
        String query = "SELECT * FROM Assignment WHERE ticket_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, ticketId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Assignment ID: " + resultSet.getInt("assignment_id"));
                System.out.println("Ticket ID: " + resultSet.getInt("ticket_id"));
                System.out.println("Representative ID: " + resultSet.getInt("representative_id"));
                System.out.println("Assignment Date: " + resultSet.getTimestamp("assignment_date"));
                System.out.println("Status: " + resultSet.getString("status"));

                System.out.println("================================================");
            }
        } catch (Exception e) {
            System.out.println("No Tickets Assigned");

        }
    }

    public void updateAssignment(int assignmentId, String status) {
        String query = "UPDATE Assignment SET status = ? WHERE assignment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, assignmentId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Assignment updated successfully.");
                System.out.println("================================================");
            } else {
                System.out.println("Assignment not found.");
                System.out.println("================================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAssignment(int assignmentId) {
        String query = "DELETE FROM Assignment WHERE assignment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, assignmentId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Assignment deleted successfully.");
                System.out.println("================================================");
            } else {
                System.out.println("Assignment not found.");
                System.out.println("================================================");
            }
        } catch (Exception e) {
            System.out.println("Assignment not found to delete");
        }
    }
}
