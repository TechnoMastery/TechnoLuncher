package net.minheur.technolauncher;

import net.minheur.technolauncher.tabs.LauncherTab;
import net.minheur.technolauncher.tabs.PotoFluxTab;
import net.minheur.technolauncher.tabs.Tabs;
import net.minheur.technolauncher.tabs.TechnoMasteryModpackTab;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class TechnoLauncher {

    private final JFrame frame;

    public TechnoLauncher() {
        frame = new JFrame("TechnoLuncher");
        frame.setSize(854, 512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        addIcon();
        addPanels();

        frame.setVisible(true);
    }

    private void addIcon() {
        Image icon600 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/textures/main.png"))).getImage();
        List<Image> icons = new ArrayList<>();
        icons.add(icon600.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        icons.add(icon600.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        icons.add(icon600.getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        frame.setIconImages(icons);
    }

    private void addPanels() {
        JTabbedPane tabs = new JTabbedPane(JTabbedPane.LEFT);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        for (Tabs tab : Tabs.values()) {
            LauncherTab instance = tab.createInstance();
            if (instance != null) tabs.add(tab.getName(), instance.getPanel());
        }

        frame.add(tabs);
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