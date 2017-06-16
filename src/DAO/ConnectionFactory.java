package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
		private static String url="jdbc:mysql://localhost/bd_farmacia";
		private static String user="root";
		private static String senha="";
		
		//fim das variáveis e início dos construtores
		public ConnectionFactory(){}
		//Início dos métodos
		public static Connection getConnection(){
			try{
				return DriverManager.getConnection(url,user,senha);
			}
			catch(SQLException e){
				System.out.println("Falha na conexão!");
				throw new RuntimeException(e);
			}
		}


}
