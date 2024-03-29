package noseryoung.plj.city.region.dto;


import io.swagger.annotations.ApiModel;

@ApiModel(value="CityDTO")

public class CityDTO {
	
	private long id;
	private String name;
	private int population;
	
	
	
	
	
	public CityDTO() {
	}
	
	
	public CityDTO(long id, String name, int population) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
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
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	

}
