package day2;

public class Car implements Cloneable {
	
	private String make;
	private String model;
	private String variant;
	private int year;
	private int version;
	
	public Car() {}
	
	public Car(String make, String model, String variant, int year, int version) {
		this.make = make;
		this.model = model;
		this.variant = variant;
		this.year = year;
		this.version = version;
	}
	
	public static CarBuilder builder()	{
		return new CarBuilder(new Car());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
//		If Obj is a Car
		if(!(obj instanceof Car)) return false;
		Car car = (Car)obj;
//		compare Obj with this
		return year == car.year && version == car.version && make.equals(car.make) 
				&& model.equals(car.model) && variant.equals(car.variant);
	}
	
	@Override
	public int hashCode() {
		return (toString()+"Car").hashCode();
	}

	@Override
	public String toString() {
//		Honda City VX 2024 Version 7
//		return make+" "+model+" "+variant+" "+year+" Version "+version;
		return new StringBuilder()
				.append(make)
				.append(" ")
				.append(model)
				.append(" ")
				.append(variant)
				.append(" ")
				.append(year)
				.append(" Version ")
				.append(version)
				.toString();
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public static class CarBuilder	{
		private Car car;
		
		public CarBuilder(Car car) {
			this.car=car;
		}
		public Car build()	{
			return car;
		}
		public CarBuilder make(String make)	{
			car.setMake(make);
			return this;
		}
		public CarBuilder model(String model)	{
			car.setModel(model);
			return this;
		}
		public CarBuilder variant(String variant)	{
			car.setVariant(variant);
			return this;
		}
		public CarBuilder year(int year)	{
			car.setYear(year);
			return this;
		}
		public CarBuilder version(int version)	{
			car.setVersion(version);
			return this;
		}
	}

}





