/**
 * Interface for MySQL connection
 * @file IMySQLConnection.java
 * @author (SDV)[phibao37]
 * Copyright (C) 2017 SDV, All Rights Reserved.
 */
package api.connect.mysql;

import api.connect.IConnection;

/**
 * Interface for MySQL connection
 * 
 * @author phibao37
 *
 * @date 2017-01-08 phibao37 created
 */
public interface IMySQLConnection extends IConnection {

	@Override
	IMySQLConnectConfig getConfig();

}
