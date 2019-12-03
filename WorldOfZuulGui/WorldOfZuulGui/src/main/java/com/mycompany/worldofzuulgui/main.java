/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worldofzuulgui;

import java.io.File;

/**
 *
 * @author mads
 */
public class main {

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir") + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1";
        File dir = new File(currentDir);

        for (File file : dir.listFiles()) {
            System.out.println("File: " + file.getName() + ". IsDirectory: " + file.isDirectory());
        }

        //System.out.println("Current dir: " + dir);
        App.load(args);
    }
}
