import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class sav {
    private static JFrame frame;
    private static JTextField nomField;
    private static JTextField numeroField;
    private static JTextArea descriptionArea;
    private static DefaultTableModel tableModel;
    private static JTable clientTable;
    private static JLabel dateTimeLabel;

    public static void main(String[] args) {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:8889/LunetteSITE";
        String utilisateur = "new";
        String motDePasse = "new";

        Connection connection = null;
        try {
            // Établir une connexion à la base de données
            connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            if (connection != null) {
                System.out.println("Connexion à la base de données réussie.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données.");
        }

        // Le reste de votre code

        // Créer la fenêtre principale de l'application
        frame = new JFrame("Service Après-Vente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(new Color(245, 245, 220)); // Fond beige

        // Créer un panneau principal pour organiser les composants
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 220)); // Fond beige

        // Créer un panneau supérieur pour le formulaire
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Formulaire de SAV"));
        formPanel.setBackground(new Color(245, 245, 220)); // Fond beige

        // Ajouter des composants pour le formulaire
        JLabel nomLabel = new JLabel("Nom du client:");
        nomField = new JTextField();
        JLabel numeroLabel = new JLabel("Numéro de téléphone:");
        numeroField = new JTextField();
        JLabel descriptionLabel = new JLabel("Description du problème:");
        descriptionArea = new JTextArea();

        // Ajouter les composants au panneau du formulaire
        formPanel.add(nomLabel);
        formPanel.add(nomField);
        formPanel.add(numeroLabel);
        formPanel.add(numeroField);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionArea);

        // Créer un bouton "Soumettre"
        JButton soumettreButton = new JButton("Soumettre");

        // Créer un modèle de tableau pour stocker les données des clients et de leurs
        // plaintes
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nom du client");
        tableModel.addColumn("Numéro de téléphone");
        tableModel.addColumn("Description du problème");

        // Créer le tableau en utilisant le modèle
        clientTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(clientTable);

        // Ajouter le tableau à un panneau séparé avec un titre
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Liste des Demandes de SAV"));
        tablePanel.setBackground(new Color(245, 245, 220)); // Fond beige
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Modifier l'action du bouton "Soumettre" pour ajouter une entrée au tableau
        soumettreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomClient = nomField.getText();
                String numeroClient = numeroField.getText();
                String descriptionProbleme = descriptionArea.getText();

                // Ajouter les données dans le modèle du tableau
                Object[] rowData = { nomClient, numeroClient, descriptionProbleme };
                tableModel.addRow(rowData);

                // Réinitialiser les champs après la soumission
                nomField.setText("");
                numeroField.setText("");
                descriptionArea.setText("");

                JOptionPane.showMessageDialog(frame, "Demande de SAV soumise avec succès.");
            }
        });

        // Créer un bouton "Supprimer"
        JButton supprimerButton = new JButton("Supprimer");
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = clientTable.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(frame, "Demande de SAV supprimée avec succès.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une demande de SAV à supprimer.");
                }
            }
        });

        // Ajouter les boutons "Soumettre" et "Supprimer" au panneau du formulaire
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(soumettreButton);
        buttonPanel.add(supprimerButton);

        // Ajouter un JLabel pour afficher la date et l'heure
        dateTimeLabel = new JLabel();
        updateDateTimeLabel(); // Mettre à jour l'étiquette avec la date et l'heure actuelles
        JPanel dateTimePanel = new JPanel();
        dateTimePanel.add(dateTimeLabel);
        dateTimePanel.setBackground(new Color(245, 245, 220)); // Fond beige

        // Utiliser un Timer pour mettre à jour l'étiquette de la date et de l'heure
        // chaque seconde
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDateTimeLabel();
            }
        });
        timer.start();

        // Ajouter le panneau du formulaire en haut, le panneau du tableau au centre, le
        // panneau des boutons en bas, et le panneau de la date et de l'heure en haut
        mainPanel.add(dateTimePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.WEST);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajouter le panneau principal à la fenêtre
        frame.add(mainPanel);

        // Centrer la fenêtre sur l'écran
        frame.setLocationRelativeTo(null);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }

    // Méthode pour mettre à jour l'étiquette de la date et de l'heure
    private static void updateDateTimeLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateTime = dateFormat.format(new Date());
        dateTimeLabel.setText("Date et Heure : " + dateTime);
    }
}
