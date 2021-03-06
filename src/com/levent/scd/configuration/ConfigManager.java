package com.levent.scd.configuration;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * A simple Configuration Manager class based on Gang-Of-Four Singleton Design Pattern.
 * 
 * Levent Divilioglu - March, 2018
 */
public class ConfigManager {
	
	private static final ConfigManager instance = new ConfigManager();
	
	// Resource Directory - Log file also will be here
	public final String RESOURCE_DIRECTORY;
	public final String LOG4J_PROPERTIES;			// You can wrap LOG4J properties file within this class
	
	// Database Config Parameters
	public final String DB_HOST;
	public final String DB_PORT;
	public final String DB_DB_NAME;
	public final String DB_USER;
	public final String DB_PASSWORD;
	
	
	private ConfigManager() {
		Config config = new Config(Config.CONFIG_FILE_NAME);
		
		// RESOURCE AND LOG
		RESOURCE_DIRECTORY					= Config.RESOURCE_DIR;
		LOG4J_PROPERTIES					= RESOURCE_DIRECTORY + "/log4j.properties";	// log4j will be in the resource folder
		
		// Database Config Parameters
		DB_HOST						= config.getProperty("db.host");
		DB_PORT						= config.getProperty("db.port");
		DB_DB_NAME					= config.getProperty("db.db_name");
		DB_USER						= config.getProperty("db.user");
		DB_PASSWORD					= config.getProperty("db.password");
	}
	
	public static ConfigManager config() {
		return instance;
	}
	
	/*
	 * Reads the properties file in the base directory.
	 * 
	 * If an environmental variable is defined, then the properties file
	 * will be expected in the value of the environmental variable. Otherwise,
	 * properties file will be expected to be in the base directory.
	 * 
	 * If you are going to use a tool like maven, it should also be the
	 * src/main/resources
	 * folder.
	 * 
	 * Levent Divilioglu - March, 2018
	 * 
	 */
	private static class Config {
		
		private static final String 			CONFIG_FILE_NAME = "main_config.properties";
		private static final String 			RESOURCE_DIR;
		private Properties 						configFile;
		
		static {
			String envVal = System.getenv("DEMO_ENV");
			System.out.print("\tRESOURCE_DIR SET TO: ");
			if(envVal == null) {
				RESOURCE_DIR = ".";
				System.out.print("\tDefault Value = Working dir of jar\n");
			} else {
				RESOURCE_DIR = envVal;
				System.out.print("\tEnvironment Parameter = " + RESOURCE_DIR + "\n");
			}
			System.out.printf("\n");
		}

		private Config(String configFileName) {
			configFile = new java.util.Properties();

			try (FileInputStream fileInputStream = new FileInputStream(RESOURCE_DIR + "//" + configFileName)) {
				configFile.load(fileInputStream);
			} catch (Exception eta) {
				System.out.println("\tError;");
				System.out.println("\t******");
				System.out.println("\tCannot find \"" + configFileName +  "\" in \"" + RESOURCE_DIR + "\"");
				System.out.println("\tExiting program.");
				System.exit(1);
			}
		}

		private String getProperty(String key) {
			return this.configFile.getProperty(key);
		}
	}

}

