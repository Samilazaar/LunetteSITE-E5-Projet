import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class saav {
    private static JFrame frame;
    private static JTextField nomField;
    private static JTextField numeroField;
    private static JTextArea descriptionArea;
    private static DefaultTableModel tableModel;
    private static JTable clientTable;
    private static JLabel dateTimeLabel;
    private static Connection connection;


    public static void main(String[] args) {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:8889/LunetteSITE";
        String utilisateur = "root";
        String motDePasse = "new";
        

       

        try {
            // Établir une connexion à la base de données
            connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            if (connection != null) {
                System.out.println("Connexion à la base de données réussie.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données.");
            return; // Quitter le programme si la connexion échoue
        }

        // Créer la fenêtre principale de l'application
        frame = new JFrame("Service Après-Vente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(new Color(245, 245, 220)); // Fond beige
        JPanel logoPanel = new JPanel();

        // Chargez votre image de logo (assurez-vous que l'image est dans le même
        // répertoire que votre code ou spécifiez le chemin complet)
        ImageIcon logoIcon = new ImageIcon("shopping.jpeg");
        JLabel logoLabel = new JLabel(logoIcon);

        // Ajoutez votre logo à votre JPanel
        logoPanel.add(logoLabel);

        // Ajoutez votre JPanel à la position NORTH (en haut) de votre JFrame
        frame.add(logoPanel, BorderLayout.NORTH);

        // Créez un gestionnaire de mise en page FlowLayout avec des marges
        FlowLayout logoLayout = new FlowLayout(FlowLayout.LEFT, 10, 10); // Les valeurs 10, 10 sont les marges

        // Appliquez le gestionnaire de mise en page au JPanel
        logoPanel.setLayout(logoLayout);

        // Créer un panneau principal pour organiser les composants
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 220)); // Fond beige

        // Créer un panneau supérieur pour le formulaire
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(11, 3, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Formulaire de SAV"));
        formPanel.setBackground(new Color(245, 245, 220)); // Fond beige

        // Ajouter des composants pour le formulaire
        JLabel nomLabel = new JLabel("Nom du client:");
        nomField = new JTextField(20); // 20 colonnes de large

        JLabel numeroLabel = new JLabel("Numéro de téléphone:");
        numeroField = new JTextField(20); // 20 colonnes de large

        JLabel descriptionLabel = new JLabel("Description du problème:");
        descriptionArea = new JTextArea(1, 20); // 2 lignes visibles et 20 colonnes de large
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);

        // Ajouter les composants au panneau du formulaire
        formPanel.add(nomLabel);
        formPanel.add(nomField);
        formPanel.add(numeroLabel);
        formPanel.add(numeroField);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionArea);

        // Créer un bouton "Soumettre"
        JButton soumettreButton = new JButton("Soumettre");
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

                // Insérer les données dans la base de données
                try {
                    String insertQuery = "INSERT INTO demandes_sav (nomClient, numeroTelephone, descriptionProbleme) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, nomField.getText());
                    preparedStatement.setString(2, numeroClient);
                    preparedStatement.setString(3, descriptionProbleme);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    JOptionPane.showMessageDialog(frame,
                            "Demande de SAV soumise avec succès et insérée dans la base de données.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame,
                            "Erreur lors de l'insertion des données dans la base de données.");
                }
            }
        });

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
        // Créer un panneau pour le tableau avec un titre
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

                JOptionPane.showMessageDialog(frame, "Demande de SAV soumise avec succès.");
            }
        });
        JButton modifierButton = new JButton("Modifier");
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int selectedRow = clientTable.getSelectedRow();
                if (selectedRow >= 0) { 
                    String newNomClient = nomField.getText();
                    String newNumeroClient = numeroField.getText();
                    String newDescriptionProbleme = descriptionArea.getText();

                    // Mettez à jour les données du client dans le modèle du tableau
                    tableModel.setValueAt(newNomClient, selectedRow, 0);
                    tableModel.setValueAt(newNumeroClient, selectedRow, 1);
                    tableModel.setValueAt(newDescriptionProbleme, selectedRow, 2);

                    // Réinitialisez les champs après la modification
                    nomField.setText("");
                    numeroField.setText("");
                    descriptionArea.setText("");

                    JOptionPane.showMessageDialog(frame, "Client modifié avec succès.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un client à modifier dans le tableau.");
                }
            }
        });
        formPanel.add(modifierButton);

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

        // Ajouter le panneau du formulaireh en aut, le panneau du tableau au centre, le
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
