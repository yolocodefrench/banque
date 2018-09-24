package dao;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Agence;
import entity.CompteBancaire;

public class Dao {
	public static void createCompte(CompteBancaire compte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(compte);
        tx.commit();
	}
	
	public static CompteBancaire getCompteBancaire(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		CompteBancaire compte = em.find(CompteBancaire.class, id);
		
		return compte;
	}
	
	public static void updateCompteBancaire(CompteBancaire compte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.merge(compte);
	}
	
	
	public static void deleteCompteBancaire(CompteBancaire compte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.remove(compte);
	}
	public static Collection<CompteBancaire> findAllComptes(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM compte_bancaire e");
		
		return query.getResultList();
	}
	public static Collection<CompteBancaire> findAllComptesByIdAgence(int idAgence){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM compte_bancaire e WHERE ");
		return query.getResultList();
	}
	public static void createAgence(Agence agence){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(agence);
        tx.commit();
	}
	public static Agence getAgence(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Agence agence = em.find(Agence.class, id);
		
		return agence;
	}
	public static void updateAgence(Agence agence) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.merge(agence);
	}
	public static void deleteAgece(Agence agence) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.remove(agence);
	}
	public static Collection<Agence> findAllAgences(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM agence e");
		
		return query.getResultList();
	}
	
}
