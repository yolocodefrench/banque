package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="agence")
public class Agence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="adresse")
	private String adresse;
	
	public Agence(String code, String adresse) {
		this.setCode(code);
		this.setAdresse(adresse);
	}

    @OneToMany
    @JoinColumn(name = "fk_compte_bancaire")
    private Set<CompteBancaire> items = new HashSet<CompteBancaire>();

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
