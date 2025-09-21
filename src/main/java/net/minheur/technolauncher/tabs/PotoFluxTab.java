package net.minheur.technolauncher.tabs;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PotoFluxTab extends LauncherTab {

    @Override
    protected void setPanel() {
        // title
        JLabel title = new JLabel("PotoFlux");
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // button
        JButton downloadButton = new JButton("Download / Install PotoFlux");
        downloadButton.addActionListener(e -> {
            checkJavaAndLaunch();
        });
        downloadButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // progress bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // adds
        PANEL.add(Box.createVerticalStrut(30));
        PANEL.add(title);
        PANEL.add(Box.createVerticalStrut(20));
        PANEL.add(downloadButton);
        PANEL.add(Box.createVerticalStrut(20));
        PANEL.add(progressBar);
    }

    private void checkJavaAndLaunch() {
        if (!isJavaVersionSufficient()) {
            int result = JOptionPane.showConfirmDialog(null, "Java 21 ou supérieur n'est pas installé. Voulez-vous l'installer ?",
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
        JOptionPane.showMessageDialog(null, "Place link to install java !"); // TODO: download & install
    }

    private void launchJar() {
        try {
            File jarFile = new File("C:\\Program Files\\TechnoMastery\\potoflux\\PotoFlux.jar");
            if (!jarFile.exists()) {
                JOptionPane.showMessageDialog(null, "Fichier potoflux introuvable !");
                return;
            }

            // run jar
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarFile.getAbsolutePath());
            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur de lancement : " + ex.getMessage());
        }
    }
}
