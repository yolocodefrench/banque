import java.util.ArrayList;


public class Menu {
 
    public static void main(String[] args) {
        Dao dao = Dao.getInstance();
      
      	
 
        Question.MenuPrincipal();
    }
 
}
class Question {
    
    public static void MenuPrincipal() {
        System.out.println("Veuillez selectionner une action a executer");
        System.out.println("1 - Crediter un compte");
        System.out.println("2 - Debiter un compte");
        System.out.println("3 - Creer un compte");
        System.out.println("3 - Consulter un compte");
    }
    
    public static void askAgency(Dao daoInstance) {
        System.out.println("Choisissez l'agence de vos besoins");
        ArrayList<Agence> agences = daoInstance.findAllAgences();
        for(Agence a : agences) {
            System.out.println(a);
        }
    }
    public static void askComptes(Dao daoInstance, int idAgence) {
        System.out.println("Choisissez le compte que vous souhaitez manipuler");
        ArrayList<CompteBancaire> compte = daoInstance.findAllComptesByIdAgence(idAgence);
        for(CompteBancaire c : compte) {
            System.out.println(c);
        }
    }
}
class CompteSimple extends CompteBancaire{
    
    public CompteSimple() {
        super();
    }
    private int decouvert=0;    
}
class ComptePayant extends CompteBancaire{
    public ComptePayant() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void versement( float montant) {
        montant-=5;
        this.solde += montant;
    }
    public void retrait( float montant) {
        montant-=5;
        this.solde -= montant;
    }
}
class CompteEpargne {
    public CompteEpargne() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    private int tauxInteret;
    
    public void calculInteret(){
        
    }
}
abstract class CompteBancaire {
 
    protected int id;
    protected float solde = 0;
    protected int idAgence;
    public CompteBancaire() {
    }
    
    public void versement( float montant) {
        this.solde += montant;
    }
    public void retrait( float montant) {
        this.solde -= montant;
    }
    
    public String toString(){
        return "Le montant du compte est "+this.solde;
    }
 
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setIdAgence(int idAgence){
        this.idAgence = idAgence;
    }
    public int getIdAgence(){
        return this.idAgence;
    }
 
    public float getSolde() {
        return solde;
    }
 
    public void setSolde(float solde) {
        this.solde = solde;
    }
 
}
class Agence {
    
    private int id;
 
    private String code;
    private String adresse;
    
    public Agence(String code, String adresse) {
        this.setCode(code);
        this.setAdresse(adresse);
    }
 
    private ArrayList<CompteBancaire> items = new ArrayList<>();
 
    public int getId() {
        return id;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getAdresse() {
        return adresse;
    }
 
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
class Dao {
 
    private ArrayList<Agence> agences = new ArrayList<>();
    private ArrayList<CompteBancaire> comptes = new ArrayList<>();
    private static Dao dao= null;
 
    public Dao(){}
 
    public static Dao getInstance(){
        if(dao == null){
            dao = new Dao();
        }
        return dao;
    }
 
    public void createCompte(CompteBancaire compte) {
        int size = this.comptes.size();
        if(size == 0){
            compte.setId(1);
        }
        int index = this.comptes.get(size-1).getId();
        compte.setId(index+1);
 
        this.comptes.add(compte);
    }
 
    public CompteBancaire getCompteBancaire(int id) {
        for (CompteBancaire compte : this.comptes) {
            if(compte.getId() == id){
                return compte;
            }
        }
        return (null);
    }
    
    public void updateCompteBancaire(CompteBancaire compte) {
        this.comptes.set(compte.getId(), compte);
    }
    
    public void deleteCompteBancaire(CompteBancaire compte) {
        this.comptes.remove(compte.getId());
    }
    public ArrayList<CompteBancaire> findAllComptes(){
        ArrayList<CompteBancaire> comptes = new ArrayList<>();
        for (CompteBancaire compte : this.comptes) {
                comptes.add(compte);
        }
        return comptes;
    }
    public ArrayList<CompteBancaire> findAllComptesByIdAgence(int idAgence){
        ArrayList<CompteBancaire> comptes = new ArrayList<>();
        for (CompteBancaire compte : this.comptes) {
            if(compte.getIdAgence() == idAgence){
                comptes.add(compte);
            }
        }
        return comptes;
    }
    public void createAgence(Agence agence){
        this.agences.add(agence);
    }
    public Agence getAgence(int id) {
        for (Agence agence : this.agences) {
            if(agence.getId() == id){
                return agence;
            }
        }
        return (null);
    }
    public void updateAgence(Agence agence) {
        this.agences.set(agence.getId(), agence);
    }
    public void deleteAgence(Agence agence) {
        this.agences.remove(agence.getId());
    }
    public ArrayList<Agence> findAllAgences(){
        ArrayList<Agence> agences = new ArrayList<>();
        for (Agence agence : this.agences) {
            agences.add(agence);
        }
        return agences;
    }
    
}
 


