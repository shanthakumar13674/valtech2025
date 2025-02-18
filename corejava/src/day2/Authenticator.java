package day2;

import java.util.Random;

public class Authenticator {
	
	public long authenticate(String name, String pass)	{
		if("scott".equals(name) && "tiger".equals(pass))	{
			return new Random().nextLong();
		}
		throw new RuntimeException("Only Scott is allowed");
	}

}
