package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="compte_epargne")
@DiscriminatorValue("compte_payanr")
public class ComptePayant extends CompteBancaire{
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
