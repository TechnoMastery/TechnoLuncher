package net.minheur.technolauncher.tabs;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class TechnoMasteryModpackTab extends LauncherTab {

    @Override
    protected void setPanel() {
        PANEL.add(Box.createVerticalStrut(30));
        PANEL.add(createTitle());
        PANEL.add(Box.createVerticalStrut(20));
        PANEL.add(createDownloadButton());
    }

    private JLabel createTitle() {
        JLabel title = new JLabel("TechnoMastery");
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }

    private JButton createDownloadButton() {
        JButton downloadButton = new JButton("Download TechnoMastery on curseforge");
        downloadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        downloadButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.curseforge.com/minecraft/modpacks/techno-mastery"));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(PANEL, "impossible d'ouvrir CurseForge ou la page web !");
            }

        });
        return downloadButton;
    }
}
