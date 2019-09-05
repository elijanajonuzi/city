package noseryoung.plj.city.region;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy ="region")
	private List<City> region; 
	

public Region() {
	
}



public Region(long id, String name) {
	super();
	this.id = id;
	this.name = name;
}



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


}



