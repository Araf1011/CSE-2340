import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    private int userId;
    JButton manageSchedulesButton, approveBookingsButton, logoutButton;

    public AdminDashboard(int userId) {
        this.userId = userId;
        setTitle("CSE Classroom & Lab Management - Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        manageSchedulesButton = new JButton("Manage Schedules");
        approveBookingsButton = new JButton("Approve Bookings");
        logoutButton = new JButton("Logout");
        menu.add(manageSchedulesButton);
        menu.add(approveBookingsButton);
        menu.add(logoutButton);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(248, 249, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to Admin Dashboard!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomeLabel, BorderLayout.CENTER);

        manageSchedulesButton.addActionListener(e -> {
            dispose();
            new ManageScheduleForm(userId).setVisible(true);
        });
        approveBookingsButton.addActionListener(e -> {
            dispose();
            new ApproveBookingsForm(userId).setVisible(true); // Placeholder
        });
        logoutButton.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminDashboard(1).setVisible(true));
    }
}