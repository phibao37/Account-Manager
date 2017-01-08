/**
 * Interface for MySQL connection configuration
 * @file IMySQLConnectConfig.java
 * @author (SDV)[phibao37]
 * Copyright (C) 2017 SDV, All Rights Reserved.
 */
package api.connect.mysql;

import api.connect.IConnectConfig;

/**
 * Configuration for MySQL
 * 
 * @author phibao37
 *
 * @date 2017-01-08 phibao37 created
 */
public interface IMySQLConnectConfig extends IConnectConfig {

	/**
	 * Connect to server use SSL connection
	 * 
	 * @return use SSL or not
	 */
	boolean useSSL();
}
