package net.minheur.technolauncher.tabs;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class PotoFluxTab extends LauncherTab {

    @Override
    protected void setPanel() {
        PANEL.add(Box.createVerticalStrut(30));
        PANEL.add(createTitle());
        PANEL.add(Box.createVerticalStrut(20));
        PANEL.add(createDlRunButton());
    }

    private JButton createDlRunButton() {
        JButton downloadButton;

        if (getPotoFluxJar().exists()) { // set button to run mod if installed
            downloadButton = new JButton("Run PotoFlux");
            downloadButton.addActionListener(e -> {
                checkJavaAndLaunch();
            });
        } else { // else ask to download it
            downloadButton = new JButton("Download PotoFlux");
            downloadButton.addActionListener(e -> {
                dlPotoFlux();
            });
        }
        downloadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return  downloadButton;
    }

    private void dlPotoFlux() {
        int dl = JOptionPane.showConfirmDialog(null, "Voulez vous télécharger PotoFlux ?",
                "Téléchargement de PotoFlux",
                JOptionPane.OK_CANCEL_OPTION);
        if (dl == JOptionPane.YES_OPTION) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/TechnoMastery/PotoFlux/releases"));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(PANEL, "Impossible d'ouvrir la page de téléchargement de PotoFlux !");
            }
        }
    }

    private JLabel createTitle() {
        JLabel title = new JLabel("PotoFlux");
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }

    private void checkJavaAndLaunch() {
        if (!isJavaVersionSufficient()) {
            int result = JOptionPane.showConfirmDialog(null, "Java 17 ou supérieur n'est pas installé. Voulez-vous l'installer ?",
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
            if (!getPotoFluxJar().exists()) {
                JOptionPane.showMessageDialog(null, "Fichier potoflux introuvable ! Merci de signalez ceci aux admins.");
                return;
            }

            // run jar
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", getPotoFluxJar().getAbsolutePath());
            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur de lancement : " + ex.getMessage());
        }
    }

    private File getPotoFluxJar() {
        return new File("C:\\Program Files\\TechnoMastery\\PotoFlux\\PotoFlux.jar");
    }
}
