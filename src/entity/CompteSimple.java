package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="compte_epargne")
@DiscriminatorValue("compte_simple")
public class CompteSimple extends CompteBancaire{
	
	public CompteSimple() {
		super();
	}
	@Column(name="decouvert")
	private int decouvert=0;	
}
