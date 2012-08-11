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

package com.enderville.enderinstaller.util;

import java.io.File;
import java.util.*;

public class CollisionCheck {

    /**
     * This can be used to check for file collisions between optional/required
     * mods.
     */
    public static void main(String[] args) {
        String dirstr = "./mods/extra";

        File dir = new File(dirstr);

        Map<String, String> parentMap = new HashMap<String, String>();
        for (File moddir : dir.listFiles()) {
            if (!moddir.isDirectory()) {
                continue;
            }
            String parent = moddir.getName();
            System.out.println(parent);

            Queue<File> queue = new LinkedList<File>();
            queue.addAll(Arrays.asList(moddir.listFiles()));

            while (!queue.isEmpty()) {
                File f = queue.poll();
                if (f.getName().startsWith(".")) {
                    continue;
                }
                if (f.isDirectory()) {
                    queue.addAll(Arrays.asList(f.listFiles()));
                } else {
                    String child = f.getPath().substring(moddir.getPath().length());
                    if (!parentMap.containsKey(child)) {
                        parentMap.put(child, parent);
                    } else {
                        String other = parentMap.get(child);
                        System.err.printf("\tTried to add %s to %s but it already belonged to %s\n", child, parent, other);
                    }
                }
            }
        }
    }
}
