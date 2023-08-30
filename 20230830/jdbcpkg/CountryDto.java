package jdbcpkg;

public class CountryDto {
	String code;
	String name;
	String population;
	
	public CountryDto() {
	}

	public CountryDto(String code, String name, String population) {
		super();
		this.code = code;
		this.name = name;
		this.population = population;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "CountryDto [code=" + code + ", name=" + name + ", population=" + population + "]";
	}
}
