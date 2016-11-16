package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import scene.SceneServ;

public class Datas {
	
	public static void initScene2BdD(int id,String groupe,String datec,String heure,String duree) {
		
		
/**
 *  * * 
 * la méthode initGroupeBdD permet 
 * 1 - d'initialiser la combo box de sélection depuis la base de données de la table <b>Groupe</b>
 * 2 - de créer une instance de la classe <b>Groupe</b> pour chaque occurrence de la table Groupe
 * 3 - de renseigner l'arrayList <b>listeGroupe</b> permettant la gestion de la MAJ de la
 * 		programmation
 * 
 * 
 */
		Connection conn = SceneServ.connection;
		try {
			System.out.println("connexion =" + conn);
			
			Statement stmt = conn.createStatement();
			
			String reqSql = "insert into Scene2 values ('"+id+"','"+groupe+"','"+datec+"','"+heure+"','"+duree+"')";
					
			stmt.executeUpdate(reqSql);

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
public static String lastId() {

	String id = "";
	Connection conn = SceneServ.connection;
	
	try {
		Statement stmt = conn.createStatement();
		String reqSql = "select max(id) from Scene2";
		ResultSet result =stmt.executeQuery(reqSql);
		
		while( result.next() ){

			id = result.getString (1); 
//			String numduree = result.getString (2); 
			if(id == null) {
				id = "1";
			}

		}
		result.close();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return id;
}


public static ArrayList listScene() {

ArrayList<String> liste = new ArrayList<String>();
Connection conn = SceneServ.connection;


try {
	Statement stmt = conn.createStatement();
	String reqSql = "select * from Scene2 order by id";
	ResultSet result =stmt.executeQuery(reqSql);

	while( result.next() ){

		String id = result.getString (1); 
 		String groupe = result.getString (2);
		String datec = result.getString (3); 
 		String heure = result.getString (4);
 		String duree = result.getString (5);
 		
 		String listScene = id+"||"+groupe+"||"+datec+"||"+heure+"||"+duree;
 		
 		liste.add(listScene);

	}
	result.close();

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	System.out.println(liste);
return liste;
}


}
