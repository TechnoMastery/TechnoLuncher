package net.minheur.technolauncher.tabs;

import net.minheur.technolauncher.TechnoLauncher;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class HomeTab extends LauncherTab{
    @Override
    protected void setPanel() {
        PANEL.add(Box.createVerticalStrut(30));
        PANEL.add(createTitle());
        PANEL.add(Box.createVerticalStrut(20));
        PANEL.add(createVersionInfo());
        PANEL.add(Box.createVerticalStrut(10));
        PANEL.add(createVersionCheckButton());
    }

    private JButton createVersionCheckButton() {
        JButton vCheckBtn = new JButton("Pages de téléchargements");
        vCheckBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        vCheckBtn.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/TechnoMastery/TechnoLuncher/releases"));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(PANEL, "Impossible d'ouvrir la pages des téléchargements !");
            }
        });
        return vCheckBtn;
    }

    private JLabel createVersionInfo() {
        JLabel versionInfo = new JLabel("You are actually on TechnoLauncher " + TechnoLauncher.props.version);
        versionInfo.setFont(new Font("Consolas", Font.PLAIN, 15));
        versionInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return versionInfo;
    }

    private JLabel createTitle() {
        JLabel title = new JLabel("TechnoLauncher - Home");
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }
}
