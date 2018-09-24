package menu;



import java.util.Collection;

import dao.Dao;
import entity.Agence;
import entity.CompteBancaire;

public class Question {
	
	public static void MenuPrincipal() {
		System.out.println("Veuillez s�lectionner une action � ex�cuter");
		System.out.println("1 - Cr�diter un compte");
		System.out.println("2 - D�biter un compte");
		System.out.println("3 - Cr�er un compte");
		System.out.println("3 - Consulter un compte");
	}
	
	public static void askAgency() {
		System.out.println("Choisissez l'agence de vos besoins");
		Collection<Agence> agences = Dao.findAllAgences();
		for(Agence a : agences) {
			System.out.println(a);
		}
	}
	public static void askComptes(int idAgence) {
		System.out.println("Choisissez le compte que vous souhaitez manipuler");
		Collection<CompteBancaire> compte = Dao.findAllComptesByIdAgence(idAgence);
		for(CompteBancaire c : compte) {
			System.out.println(c);
		}
	}
}
