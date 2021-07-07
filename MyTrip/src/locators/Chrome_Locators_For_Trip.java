package locators;

public class Chrome_Locators_For_Trip {
	
	public String initial_pop_up = "//div[@data-cy='googleLogin']";
	public String from = "//*[@data-cy='fromCity']";
	public String to = "//*[@data-cy='toCity']";
	public String from_place= "//input[@placeholder='From']";
	public String to_place = "//input[@placeholder='To']";
//	public String place = "//*[@role='option']";
	public String place = "//div[@role='listbox']/div/ul/li[1]";

	public String departure = "//*[@id='departure']";
	public String dept_date = "//div[contains(@aria-label,'Sat Jul 10 2021')]";
	public String returns = "//*[@data-cy='returnDefaultText']";
	public String return_date = "//div[contains(@aria-label,'Sat Jul 17 2021')]";
//	public String travellers = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[5]/label/span";
	public String travellers = "//span[@data-cy='travellerText']";
	public String adlt_passanger = "//*[@data-cy='adults-2']";
	public String travel_apply = "//*[@data-cy='travellerApplyBtn']";
	public String search = "//p[@data-cy='submit']/a";
	public String price_tag = "//*[@class='listingCard']/div[2]/div[2]/p";

	//places
	public String to_destination = "Ahmedabad";
	
}
