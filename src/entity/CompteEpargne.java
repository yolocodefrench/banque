package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="compte_epargne")
@DiscriminatorValue("compte_epargne")
public class CompteEpargne {
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Column(name="taux_interet")
	private int tauxInteret;
	
	public void calculInteret(){
		
	}
}
