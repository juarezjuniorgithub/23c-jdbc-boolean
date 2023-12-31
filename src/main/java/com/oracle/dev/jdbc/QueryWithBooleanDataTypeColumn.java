/*
  Copyright (c) 2022, 2023, Oracle and/or its affiliates.
  This software is dual-licensed to you under the Universal Permissive License
  (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License
  2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose
  either license.
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
     https://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.oracle.dev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class QueryWithBooleanDataTypeColumn {

	public static void main(String[] args) {

		OracleDataSource ods = null;
		Connection conn = null;

		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin@[hostname]:[port]/[DB service/name]");
			
                        ods.setUser("[Username]");
                        ods.setPassword("[Password]");
						
			conn = ods.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM HQ_EMPLOYEE WHERE ACTIVE");						
			//PreparedStatement stmt = conn.prepareStatement("SELECT * FROM HQ_EMPLOYEE WHERE ACTIVE = ?");	
			//stmt.setBoolean(1, true);
					
			ResultSet rslt = stmt.executeQuery();
			StringBuilder sb = new StringBuilder();
			while (rslt.next()) {
				sb.append(rslt.getInt(1)).append("|").append(rslt.getString(2)).append("|").append(rslt.getString(3))
						.append("|").append(rslt.getBoolean(4)).append("\n");

			}

			System.out.println(sb.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
