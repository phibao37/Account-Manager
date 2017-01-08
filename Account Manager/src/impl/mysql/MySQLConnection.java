/**
 * Implementation for MySQL connection
 * @file MySQLConnection.java
 * @author (SDV)[phibao37]
 * Copyright (C) 2017 SDV, All Rights Reserved.
 */
package impl.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import api.connect.mysql.IMySQLConnectConfig;
import api.connect.mysql.IMySQLConnection;

/**
 * Connection to MySQL database
 * 
 * @author phibao37
 *
 * @date 2017-01-08 phibao37 created
 */
public class MySQLConnection implements IMySQLConnection {

	private IMySQLConnectConfig	config;
	private Connection			connection;

	/**
	 * Create new MySQL connection
	 * 
	 * @param config
	 *            connection configuration
	 * @throws Exception
	 *             can not establish new connection
	 */
	public MySQLConnection(IMySQLConnectConfig config) throws Exception
	{
		// The newInstance() call is a work around for some
		// broken Java implementations
		Class.forName("com.mysql.jdbc.Driver").newInstance(); //$NON-NLS-1$

		this.config = config;
		this.connection = createConnection();
	}

	@Override
	public IMySQLConnectConfig getConfig()
	{
		return config;
	}

	@SuppressWarnings("nls")
	@Override
	public Connection createConnection() throws SQLException
	{
		// Connect to server
		Properties info = new Properties();
		info.put("user", config.getUsername());
		info.put("password", config.getPassword());
		info.put("useSSL", Boolean.toString(config.useSSL()));
		Connection con = DriverManager
				.getConnection(String.format("jdbc:mysql://%s:%d", config.getHost(), config.getPort()), info);

		// Check if database exist
		if (checkDatabaseExist(con)) {
			return con;
		}

		// Initialize data

		return con;
	}

	@Override
	public Connection getConnection()
	{
		return connection;
	}

}
