package noseryoung.plj.city.region;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import noseryoung.plj.city.region.dto.CityDTO;
import noseryoung.plj.city.region.dto.CityMapper;



/**
 * Web Layer 
 * 
 * @author Elijana
 *
 */
@RestController
@RequestMapping("/city")
public class RegionController {
	
	
	

	private RegionService regionService;
	private CityMapper cityMapper;
	@Autowired
	public RegionController(RegionService regionService) {
		this.regionService = regionService;
	}
	/**
	 * 
	 * @param city is the city that u want to add
	 * @return ResponseEntity with the name of the city that was added
	 */
	//eghnuj
	
	@PostMapping("/addCity")
	public @ResponseBody ResponseEntity<String> addCity(@RequestBody CityDTO city){
		regionService.addCity(cityMapper.fromDTO(city));
		return new ResponseEntity<>(city.getName(),HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param id 
	 * @return ResponseEntity gives the city that was requested
	 */
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Optional<City>> getCity(@PathVariable long id ){
		Optional<City> city=regionService.getCityFromDB(id);
		return new ResponseEntity<>(city,HttpStatus.OK);
	}
	/**
	 * 
	 * @return ResponseEntity with all cities 
	 */
	@GetMapping("/listCity")
	public @ResponseBody ResponseEntity<List<City>> getAllCities(){
			return new ResponseEntity<>(regionService.getAllCities(),HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return ResponseEntity with Population of requested city
	 */
	@GetMapping("/{id}/population")
	public @ResponseBody ResponseEntity<Integer> getCityPopulation(@PathVariable long id){
		Optional<City> city=regionService.getCityPopulationById(id);
		int population=0;
		
		if(city.isPresent()) {
			population=city.get().getPopulation();
		}
		return new ResponseEntity<>(population,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return ResponseEntity with Name of requested city
	 */
	@GetMapping("/{id}/name")
	public @ResponseBody ResponseEntity<String> getCityName(@PathVariable long id){
		String name="";
		Optional<City> city=regionService.getCityNameById(id);
		if(city.isPresent()) {
			name=city.get().getName();
		}
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	/**
	 * 
	 * @param population 
	 * @return ResponseEntity with all cities that have same population or more
	 */
	
	@GetMapping("/where/{population}")
	public @ResponseBody ResponseEntity<List<City>> getCitiesByPopulation(@PathVariable int population){
		return new ResponseEntity<>(regionService.gettAllCitiesByPopulation(population),HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param city is what i need to change
	 * @param idToChange 
	 * @return ResponseEntity with OK
	 */
	
	@PutMapping("/update/{idToChange}")
	public @ResponseBody ResponseEntity<String> updateCity(@RequestBody CityDTO city, @PathVariable long idToChange){
		regionService.updateCity(idToChange, cityMapper.fromDTO(city));
			return new ResponseEntity<> ("OK",HttpStatus.OK);	
	}
	
	/**
	 * 
	 * @param idCity Id that want to be deleted
	 * @return 
	 */
	
	@DeleteMapping("/delete/{idCity}")
	public @ResponseBody ResponseEntity<String> deleteCity(@PathVariable long idCity){
		regionService.deleteCity(idCity);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/listCity/{idToList}")
	public @ResponseBody ResponseEntity<List<City>> getAllCitiesInRegion(@PathVariable long idToList){
			return new ResponseEntity<>(regionService.getAllCitiesInRegion(idToList),HttpStatus.OK);
	}
	
	@GetMapping("/listbyRegion/{idRegion}")
		public @ResponseBody ResponseEntity<List<City>> getAllCitiesInRegionID(@PathVariable long idRegion){
			return new ResponseEntity<>(regionService.getAllCitiesInRegionID(idRegion),HttpStatus.OK);
	}
	@GetMapping("/listAll")
	public @ResponseBody ResponseEntity<List<City>> listAllCities(){
		return new ResponseEntity<>(regionService.getAllCitiesWithRegion(),HttpStatus.OK);
		
}
	
	
	
	
	
	
	
	


	
}
