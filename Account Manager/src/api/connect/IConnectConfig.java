/**
 * Interface for connection configuration
 * @file IConnectConfig.java
 * @author (SDV)[phibao37]
 * Copyright (C) 2017 SDV, All Rights Reserved.
 */
package api.connect;

/**
 * Interface for connection configuration
 * 
 * @author phibao37
 *
 * @date 2017-01-08 phibao37 created
 */
public interface IConnectConfig {

	/**
	 * Get the database host name
	 * 
	 * @return host name, example: <code>localhost</code>
	 */
	String getHost();

	/**
	 * Get the database listening port of the host
	 * 
	 * @return listening port
	 */
	int getPort();

	/**
	 * Get the database name to working on
	 * 
	 * @return working database name
	 */
	String getDatabase();

	/**
	 * Get the user name to login to database server
	 * 
	 * @return user name
	 */
	String getUsername();

	/**
	 * Get the password to login to database server
	 * 
	 * @return user password
	 */
	String getPassword();
}
