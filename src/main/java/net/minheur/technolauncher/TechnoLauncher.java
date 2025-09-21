package net.minheur.technolauncher;

import net.minheur.technolauncher.tabs.PotoFluxTab;
import net.minheur.technolauncher.tabs.TechnoMasteryModpackTab;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

public class TechnoLauncher {

    private final JFrame frame;

    public TechnoLauncher() {
        frame = new JFrame("TechnoLuncher");
        frame.setSize(854, 512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        addPanels();

        frame.setVisible(true);
    }

    private void addPanels() {
        JTabbedPane tabs = new JTabbedPane(JTabbedPane.LEFT);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        tabs.add("TechnoMastery", getTabPanel(TechnoMasteryModpackTab::new));
        tabs.add("PotoFlux", getTabPanel(PotoFluxTab::new));

        frame.add(tabs);
    }

    private JPanel getTabPanel(Supplier<LauncherTab> tab) {
        return tab.get().getPanel();
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
        JOptionPane.showMessageDialog(frame, "Place link to install java !"); // TODO: download & install
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