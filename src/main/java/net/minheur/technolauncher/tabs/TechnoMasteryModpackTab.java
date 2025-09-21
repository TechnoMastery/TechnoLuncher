package net.minheur.technolauncher.tabs;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class TechnoMasteryModpackTab extends LauncherTab {

    @Override
    protected void setPanel() {
        // title
        JLabel title = new JLabel("TechnoMastery");
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // button
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

        // adds
        PANEL.add(Box.createVerticalStrut(30));
        PANEL.add(title);
        PANEL.add(Box.createVerticalStrut(20));
        PANEL.add(downloadButton);
    }
}
