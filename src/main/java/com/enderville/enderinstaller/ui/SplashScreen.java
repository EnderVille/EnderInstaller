/**
 * EnderInstaller - Installer for the EnderPack Modpack.
 * Copyright (C) 2012, EnderVille.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.enderville.enderinstaller.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JWindow;

public class SplashScreen extends JWindow implements Runnable {
	private static final long serialVersionUID = 0L;
	private static Image bg = Toolkit.getDefaultToolkit().getImage(SplashScreen.class.getResource("/enderpack.png"));

	ImageIcon icon = new ImageIcon(bg);

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg,0,0,this);
	}

	public void run() {
		showSplash();
	}


	public void showSplash() {
		try {
			com.sun.awt.AWTUtilities.setWindowOpaque(this, false);
			setSize(this.icon.getIconWidth(), this.icon.getIconHeight());
			setLocationRelativeTo(null);
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}
}