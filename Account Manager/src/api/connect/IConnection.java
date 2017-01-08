/**
 * Interface for all database connection
 * @file IConnection.java
 * @author (SDV)[phibao37]
 * Copyright (C) 2017 SDV, All Rights Reserved.
 */
package api.connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface for all database connection
 * 
 * @author phibao37
 *
 * @date 2017-01-08 phibao37 created
 */
public interface IConnection {

	/**
	 * Get configuration for connection
	 * 
	 * @return configuration
	 */
	IConnectConfig getConfig();

	/**
	 * Initialize new SQL connection and setup all necessary data to working with the database
	 * 
	 * @return created SQL connection
	 * @throws SQLException
	 *             exception related to database connection
	 */
	Connection createConnection() throws SQLException;

	/**
	 * Get the SQL connection created from {@link #createConnection()}
	 * 
	 * @return SQL connection, maybe {@code null} if not call {@link #createConnection()} before, or called with
	 *         exception
	 */
	Connection getConnection();

	/**
	 * Check if database specified in {@link IConnectConfig#getDatabase()} exist in given connection
	 * 
	 * @param con
	 *            connection to check
	 * @return the database exist or not
	 */
	default boolean checkDatabaseExist(Connection con) throws SQLException
	{
		String dbName = getConfig().getDatabase();

		try (ResultSet resultSet = con.getMetaData().getCatalogs()) {
			while (resultSet.next()) {

				String databaseName = resultSet.getString(1);
				if (databaseName.equals(dbName)) {
					return true;
				}
			}
		}
		return false;
	}
}
