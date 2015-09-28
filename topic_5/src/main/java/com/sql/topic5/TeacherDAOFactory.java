package com.sql.topic5;

import java.sql.SQLException;

public class TeacherDAOFactory {
	
    public static TeacherDAO getTeacherDAO(String type) { 
        if (type.equalsIgnoreCase("mysql")){
			try {
				return new TeacherDB(ConnectionManager.getInstance().getConnection());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
        }
		else {
        	return null;
        }
    }
}