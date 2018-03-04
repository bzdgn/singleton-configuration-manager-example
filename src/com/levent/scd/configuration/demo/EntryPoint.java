package com.levent.scd.configuration.demo;

import java.util.Date;

import com.levent.scd.configuration.ConfigManager;

/*
 * A primitive demo for using the ConfigManager class
 * 
 * Levent Divilioglu - March, 2018
 */
public class EntryPoint {

	public static void main(String[] args) {
		System.out.println("Application started at [" +  new Date() + "]");
		System.out.println();
		System.out.println("\tConfiguration");
		System.out.println("\t*************");
		System.out.println("\tDB Host        : " + ConfigManager.config().DB_HOST);
		System.out.println("\tDB Port        : " + ConfigManager.config().DB_PORT);
		System.out.println("\tDB Name        : " + ConfigManager.config().DB_DB_NAME);
		System.out.println("\tDB User        : " + ConfigManager.config().DB_USER);
		System.out.println("\tDB Pass        : " + ConfigManager.config().DB_PASSWORD);
	}

}
