package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Courier;

public class CourierDAO {

    public void addCourier(Courier c) {
        String sql = "INSERT INTO courier(sender_name, receiver_name, source, destination, status) VALUES(?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getSenderName());
            ps.setString(2, c.getReceiverName());
            ps.setString(3, c.getSource());
            ps.setString(4, c.getDestination());
            ps.setString(5, c.getStatus());
            ps.executeUpdate();
            System.out.println("✅ Courier added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Courier> getAllCouriers() {
        List<Courier> list = new ArrayList<>();
        String sql = "SELECT * FROM courier ORDER BY id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Courier c = new Courier(
                    rs.getInt("id"),
                    rs.getString("sender_name"),
                    rs.getString("receiver_name"),
                    rs.getString("source"),
                    rs.getString("destination"),
                    rs.getString("status")
                );
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStatus(int id, String status) {
        String sql = "UPDATE courier SET status=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Status updated!");
            else
                System.out.println("Courier ID not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourier(int id) {
        String sql = "DELETE FROM courier WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Courier deleted!");
            else
                System.out.println("Courier ID not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

