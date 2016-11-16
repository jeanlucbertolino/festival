package metier;

import java.time.LocalDate;
import java.util.Date;

import technique.DateException;


/**
 * Cette classe est d�finie dans le but de g�rer la programmation d'une sc�ne 
 * pour un groupe � une date pr�cise pour une dur�e estim�e.
 * {@docRoot} (chemin o� se trouve la documentation depuis l'origine du projet (src)
 */
public class Scene{

	@Override
	public String toString() {
		return "Scene [groupe=" + groupe + ", date=" + date + ", heure=" + heure + ", duree=" + duree + "]";
	}

	public	int			idscene;
	public String 		groupe;
	public String 		date;
	public String 		heure;
	public String 		duree;

	// Constructeur par d�faut
	public Scene(int �Id,String �groupe,String �date,String �heure,String �duree)  throws  DateException {
		super();
		// Contr�le de saisie de la date
//		String dateRaw = affTxtDate(�date);
		
//		if(dateRaw.isEmpty()) {
		if (�date==null) {
			throw new DateException();}

			else {
			
				this.groupe=�groupe;
				this.date=�date;
				this.heure=�heure;
				this.duree=�duree;		
			}
		}
		public String getGroupe() {
			return groupe;
		}
		public String getDate() {
			return date;
		}
		public void setGroupe(String groupe) {
			this.groupe = groupe;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public void setHeure(String heure) {
			this.heure = heure;
		}
		public void setDuree(String duree) {
			this.duree = duree;
		}
		public String getHeure() {
			return heure;
		}
		public String getDuree() {
			return duree;
		}
		public String affTxtDate(Date �date) {
			// Affichage de la date s�lectionn�e
			String dateRaw = �date.toString();
			return dateRaw;
		}
		public int getIdscene() {
			return idscene;
		}
		public void setIdscene(int idscene) {
			this.idscene = idscene;
		}
	}
