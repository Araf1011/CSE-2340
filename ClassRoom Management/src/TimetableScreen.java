import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimetableScreen extends JDialog {
    private int userId;
    private int roomId;
    private String roomNumber;

    public TimetableScreen(int userId, int roomId, String roomNumber) {
        this.userId = userId;
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        setTitle("CSE Classroom & Lab Management - Timetable: " + roomNumber);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(248, 249, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JComboBox<String> viewCombo = new JComboBox<>(new String[]{"Daily", "Weekly"});
        panel.add(viewCombo, BorderLayout.NORTH);

        String[] columns = {"Day", "Start Time", "End Time", "Course"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setBackground(Color.WHITE);
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT day, start_time, end_time, course_name FROM schedules WHERE room_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("day"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getString("course_name")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading timetable: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.GRAY);
        backButton.addActionListener(e -> {
            dispose();
            new RoomDetailsScreen(userId, roomId, roomNumber, "").setVisible(true); // Type placeholder
        });
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimetableScreen(1, 1, "CSE-101").setVisible(true));
    }
}