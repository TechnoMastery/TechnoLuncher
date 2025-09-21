package net.minheur.technolauncher;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TechnoLauncher {

    private final JFrame frame;

    public TechnoLauncher() {
        frame = new JFrame("TechnoLuncher");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenu dans PotoFlux", SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        JButton startButton = new JButton("Lancer PotoFlux" );
        startButton.addActionListener(e -> checkJavaAndLaunch());
        frame.add(startButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void checkJavaAndLaunch() {
        if (!isJavaVersionSufficient()) {
            int result = JOptionPane.showConfirmDialog(frame,
                    "Java 21 ou supérieur n'est pas installé. Voulez-vous l'installer ?",
                    "Java manquant",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                downloadAndInstallJava();
            }
        } else {
            launchJar();
        }
    }

    private boolean isJavaVersionSufficient() {
        String version = System.getProperty("java.version");
        int major = parseMajorVersion(version);
        return major >= 17;
    }

    private int parseMajorVersion(String version) {
        if (version.startsWith("1.")) {
            return Integer.parseInt(version.split("\\.")[1]);
        } else {
            return Integer.parseInt(version.split("\\.")[0]);
        }
    }

    private void downloadAndInstallJava() {
        JOptionPane.showMessageDialog(frame, "Place link to install java !");
        // TODO: download & install
    }

    private void launchJar() {
        try {
            File jarFile = new File("C:\\Program Files\\TechnoMastery\\potoflux\\PotoFlux.jar");
            if (!jarFile.exists()) {
                JOptionPane.showMessageDialog(frame, "Fichier potoflux introuvable !");
                return;
            }

            // run jar
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarFile.getAbsolutePath());
            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur de lancement : " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TechnoLauncher::new);
    }


}