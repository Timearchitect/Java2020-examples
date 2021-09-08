package bransleJamfor;

public class Bil {
	private String name= "";
	private float fuelConsumption;
	private float carbonEmission;

	
	public Bil(String _name , float _fuelConsumption ,float _carbonEmission ) {
		this.name = _name;
		this.fuelConsumption= _fuelConsumption;
		this.carbonEmission= _carbonEmission;
	}
	
	public float getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(float fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCarbonEmission() {
		return carbonEmission;
	}

	public void setCarbonEmission(float carbonEmission) {
		this.carbonEmission = carbonEmission;
	}

	
	
}
