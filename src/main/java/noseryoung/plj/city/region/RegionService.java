package noseryoung.plj.city.region;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * Service Layer
 * 
 * @author Elijana
 *
 */

@Service 
public class RegionService{

	private Region region=new Region();
	
	private CityRepository cityrepository;
	
	@Autowired
	public RegionService(CityRepository cityrepository) {
		this.cityrepository=cityrepository;
	}

	
	public City getCityName(String name) {
		return cityrepository.findByName(name);
	}
	
	
	
	protected void addCity(City city) {
	long id= city.getId();
	String name= city.getName();
	int population= city.getPopulation();
	City newCity=new City(id,name,population);
	cityrepository.save(newCity);
	}
	
	public void deleteCity(long id) {
		cityrepository.deleteById(id);
	}
	
	protected Optional<City> getCityFromDB(long id){
		return cityrepository.findById(id);
	}
	
	protected Optional<City> getCityPopulationById(long id) {
		return cityrepository.findById(id);
	}
	protected Optional<City> getCityNameById(long id) {
		return cityrepository.findById(id);
	}
	public List<City> getAllCities(){
		return cityrepository.findAll();
	}
	protected List<City> getAllCitiesInRegion(long id){
		return cityrepository.selectCityWithRegion(id);
	}
	protected List<City> getAllCitiesInRegionID(long id){
		return cityrepository.selectCityWithRegionID(id);
	}
	
	protected List<City> gettAllCitiesByPopulation(int population){
		return  cityrepository.selectCityWithPopulation(population);
	}
	public List<City> getAllCitiesWithRegion(){
		return cityrepository.findAll();
	}
	
	

protected void updateCity(long idToChange,City city) {
	cityrepository.save(new City(idToChange,city.getName(),city.getPopulation()));
}



	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}



	
}
