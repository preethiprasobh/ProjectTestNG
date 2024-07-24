package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	static Faker faker;
	public static String getFirstName()
	{
		faker=new Faker();
		String firstname=faker.name().firstName();
		return firstname;
	}
	public static String getLastName()
	{
		faker=new Faker();
		String lastname=faker.name().lastName();
		return lastname;
	}
	public static String getProductSubCategory()
	{
		faker=new Faker();
		String subcategory=faker.commerce().productName();
		return subcategory;
	}
	public static String getNews()
	{

		faker=new Faker();
		String news=faker.lorem().paragraph();
		return news;
	}

}
