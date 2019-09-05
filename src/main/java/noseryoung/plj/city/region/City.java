package noseryoung.plj.city.region;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * City Class 
 * @author Elijana
 *
 */
@Entity
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_city")
	private long id_city;
	
	@Column(name= "name")
	private String name;
	
	@Column(name="population")
	private int population;
	
	 @ManyToOne(
	          fetch = FetchType.EAGER,
	          optional = false
	  )
	  @JoinColumn(
	          name = "region_id",
	          nullable = false
	  )
	 @JsonIgnore
	private Region region;
	
	public City() {
	}
	
	

	public City(long id, String name, int population) {
		super();
		this.id_city = id;
		this.name = name;
		this.population = population;
	}
	



	public long getId() {
		return id_city;
	}

	public void setId(long id) {
		this.id_city = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}



	@Override
	public String toString() {
		return "City [id=" + id_city + ", name=" + name + ", population=" + population + "]";
	}
	
	
	

}
