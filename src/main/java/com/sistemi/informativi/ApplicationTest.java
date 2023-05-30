package com.sistemi.informativi;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
	/*
	 * TDD(Test Driven Developer)
	 * 
	 * in un metodo annotato con @before 
	 * è possibile inserire una porzione di codice
	 * che si intende essere propedeutica  per l'esecuzione di tutti
	 * i test eseguiti all'interno di una classe
	 * 
	 * poiché all'interno di questa classe vogliamo  eseguire,
	 * per ogni metodo annotato con @Test, il test di una operazione crud e poiché
	 * per ogni operazione crud è propedeutica l'inizializzazione di una connessione,
	 * inserendo il codice di inizializzazione della connessione 
	 */
	@Before
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		final String dbDriver="com.mysql.cj.jdbc.Driver";
		final String dbUrl="jdbc:mysql://localhost:3306/sistemi";
		final String dbUser="root";
		final String dbPass="";
		
		Class.forName(dbDriver);
		return DriverManager.getConnection(dbUrl, dbUser, dbPass);
	}
	/*
	@Test
	public void addCompany() throws ClassNotFoundException, SQLException {
		String sqlInsert="insert into company(vat_number, business_name, address_location, employee_number) values(?,?,?,?)";
		PreparedStatement ps= getConnection().prepareStatement(sqlInsert);
		ps.setString(1, "10293551001");
		ps.setString(2, "companyX");
		ps.setString(3, "addressX");
		ps.setInt(4, 56);
		
		
		int nRows=ps.executeUpdate();
		/*
		 * invocando il metodo assetequals passiamo in input 2 argomenti:
		 * il primo argomento è una variabile e il secondo argomento è il valore che ci aspettiamo
		 * che quella variabile assuma
		 
		assertEquals(nRows, 1);
	}
	
	@Test
	public void updateCompany() throws ClassNotFoundException, SQLException {
		String sqlUpdate="update company set business_name=?, address_location=?, employee_number=? where vat_number=?";
		PreparedStatement ps= getConnection().prepareStatement(sqlUpdate);
		ps.setString(1, "company1");
		ps.setString(2, "address1");
		ps.setInt(3, 100);
		ps.setString(4, "10287780");
		
		int nRows=ps.executeUpdate();
		/*
		 * invocando il metodo assetequals passiamo in input 2 argomenti:
		 * il primo argomento è una variabile e il secondo argomento è il valore che ci aspettiamo
		 * che quella variabile assuma
		 
		assertEquals(nRows, 1);
	}
	@Test
	public void deleteCompany() throws ClassNotFoundException, SQLException {
		String sqlDelete="delete from company where vat_number=?";
		PreparedStatement ps= getConnection().prepareStatement(sqlDelete);
		ps.setString(1, "10287782");
		
		int nRows= ps.executeUpdate();
		assertEquals(nRows, 1);
		
	}
	*/
	@Test
	public void findCompaniesByEmployeesNumberGreterThan() throws ClassNotFoundException, SQLException {
		String sqlRead="select count(*) from company where employee_number>?";
		PreparedStatement ps= getConnection().prepareStatement(sqlRead);
		ps.setInt(1, 52);
		ResultSet rs= ps.executeQuery();
		
		int count=0;
		while(rs.next()) {
			count= rs.getInt(1);
		}
		assertEquals(count, 3);
	}
}
