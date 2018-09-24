package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="compte_bancaire")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="type")
public abstract class CompteBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	@Column(name="solde")
	protected float solde = 0;
	
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

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

}
