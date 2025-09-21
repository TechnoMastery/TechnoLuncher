package net.minheur.technolauncher.tabs;

import net.minheur.technolauncher.LauncherTab;
import net.minheur.technolauncher.Utils;

import javax.swing.*;
import java.awt.*;

public class PotoFluxTab extends LauncherTab {
    @Override
    protected void setPanel() {
        PANEL.setLayout(new BoxLayout(PANEL, BoxLayout.Y_AXIS));

        // button
        JButton downloadButton = new JButton("Download / Install PotoFlux");
        downloadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        PANEL.add(Box.createVerticalStrut(20));
        PANEL.add(downloadButton);

        Utils.buttonStyle(downloadButton);

        // progress bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        PANEL.add(progressBar);
        // will need to be set after
        progressBar.setVisible(false);
    }
}
