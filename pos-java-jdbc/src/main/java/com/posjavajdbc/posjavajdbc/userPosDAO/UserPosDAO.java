package com.posjavajdbc.posjavajdbc.userPosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.posjavajdbc.posjavajdbc.conexaojdbc.SingleConnection;
import com.posjavajdbc.posjavajdbc.model.UserPosJava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar( UserPosJava userposjava ) {		
		
		try {
			
			String sql = "insert into userposjava(id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			
			connection.commit();//Salvando no banco
			
		} catch (SQLException e) {
			try {
				connection.rollback();//rollback() é importante pra reverter a operação de gravação de dado no banco
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
}
