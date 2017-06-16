package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
		private static String url="jdbc:mysql://localhost/bd_farmacia";
		private static String user="root";
		private static String senha="";
		
		//fim das vari�veis e in�cio dos construtores
		public ConnectionFactory(){}
		//In�cio dos m�todos
		public static Connection getConnection(){
			try{
				return DriverManager.getConnection(url,user,senha);
			}
			catch(SQLException e){
				System.out.println("Falha na conex�o!");
				throw new RuntimeException(e);
			}
		}


}
