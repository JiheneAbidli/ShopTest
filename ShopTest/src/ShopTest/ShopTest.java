package ShopTest;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenuim\\Download\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open the url "hhtp://shop.demoqa.com/"
		driver.get("https://shop.demoqa.com");

		// Choose any item and select it
		WebElement Article = driver.findElement(By.xpath("//a[normalize-space()='Tokyo Talkies']"));
		Article.click();
		
		// Path of the excel file
		FileInputStream fs = new FileInputStream("C:\\Users\\jihene.abidli\\Desktop\\Shop\\ImportData.xlsx");

		try (// Creating a workbook
				XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Choose Color
			System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
			String Color1 = sheet.getRow(1).getCell(0).getStringCellValue();

			WebElement Color = driver.findElement(By.xpath("//select[@id='color']"));
			Color.click();
			Color.sendKeys(Color1);

			// Choose Size
			System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
			String Size1 = sheet.getRow(1).getCell(1).getStringCellValue();

			WebElement Size = driver.findElement(By.xpath("//select[@id='size']"));
			Size.click();
			Size.sendKeys(Size1);

			// Add to cart
			WebElement AddtoCart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
			AddtoCart.click();

			// Check that there is a displayed message appears "Tokyo Talkies� has been
			// added to your cart."

			WebElement text = driver
					.findElement(By.xpath("//*[text()=' �Tokyo Talkies� has been added to your cart.	']"));

			if (text.isDisplayed()) {
				System.out.println("Element has been added to the cart");
			}

			else {
				System.out.println("Element not found");
				driver.quit();
			}

			// Click on "View cart" button
			WebElement ViewCart = driver.findElement(By.xpath("//a[@class='button wc-forward']"));
			ViewCart.click();

			// Click on "Proceed to checkout" button
			WebElement ProceedCheckout = driver
					.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
			ProceedCheckout.click();

			// BILLING DETAILS
			/////////////////////// Fill in all required fields ////////////////////////////

			// FirstName
			System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
			String FirstName1 = sheet.getRow(1).getCell(2).getStringCellValue();

			// Enter the First Name
			WebElement FirstName = driver.findElement(By.xpath("//input[@id='billing_first_name']"));
			FirstName.sendKeys(FirstName1);

			// LastName
			System.out.println(sheet.getRow(1).getCell(3).toString());
			String LastName1 = sheet.getRow(1).getCell(3).getStringCellValue();

			// Enter the Last Name
			WebElement LastName = driver.findElement(By.xpath("//input[@id='billing_last_name']"));
			LastName.sendKeys(LastName1);

			// Country
			System.out.println(sheet.getRow(1).getCell(4).toString());
			String Country1 = sheet.getRow(1).getCell(4).getStringCellValue();

			// Enter the Country
			WebElement Country = driver.findElement(By.xpath("//b[@role='presentation']"));
			Country.click();

			WebElement Combo = driver.findElement(By.xpath("//input[@role='combobox']"));
			Combo.sendKeys(Country1);
			Combo.sendKeys(Keys.TAB);
			Thread.sleep(2000);

			// House number and street number
			System.out.println(sheet.getRow(1).getCell(5).toString());
			String HouseNbr1 = sheet.getRow(1).getCell(5).getStringCellValue();

			// Enter the House Number
			WebElement HouseNbr = driver.findElement(By.xpath("//input[@id='billing_address_1']"));
			HouseNbr.click();
			HouseNbr.sendKeys(HouseNbr1);
			HouseNbr.sendKeys(Keys.TAB);
			Thread.sleep(2000);

			// Apartment, suite, unit
			System.out.println(sheet.getRow(1).getCell(6).toString());
			String Apartment1 = sheet.getRow(1).getCell(6).getStringCellValue();

			// Enter the apartment description
			WebElement Apartment = driver.findElement(By.xpath("//input[@id='billing_address_2']"));
			Apartment.sendKeys(Apartment1);

			// Town City
			System.out.println(sheet.getRow(1).getCell(7).toString());
			String TownCity1 = sheet.getRow(1).getCell(7).getStringCellValue();

			// Enter the Town City
			WebElement TownCity = driver.findElement(By.xpath("//input[@id='billing_city']"));
			TownCity.sendKeys(TownCity1);

			// State country
			System.out.println(sheet.getRow(1).getCell(8).toString());
			String StateCountry1 = sheet.getRow(1).getCell(8).getStringCellValue();

			// Enter The State Country
			WebElement StateCtry = driver.findElement(By.xpath("//input[@id='billing_state']"));
			StateCtry.sendKeys(StateCountry1);

			// PostCode
			System.out.println(sheet.getRow(1).getCell(9).toString());
			String PostCode1 = sheet.getRow(1).getCell(9).getStringCellValue();

			// Enter the Post Code
			WebElement PostCode = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
			PostCode.sendKeys(PostCode1);

			// Phone
			System.out.println(sheet.getRow(1).getCell(10).toString());
			String Phone1 = sheet.getRow(1).getCell(10).getStringCellValue();

			// Enter the Phone
			WebElement Phone = driver.findElement(By.xpath("//input[@id='billing_phone']"));
			Phone.sendKeys(Phone1);

			// Email address
			System.out.println(sheet.getRow(1).getCell(11).toString());
			String EmailAddr1 = sheet.getRow(1).getCell(11).getStringCellValue();

			// Enter the Email Address
			WebElement EmailAddr = driver.findElement(By.xpath("//input[@id='billing_email']"));
			EmailAddr.sendKeys(EmailAddr1);
			Thread.sleep(2000);

			// CheckBox of "I have read and agree to the website"
			// Scrolling down the page till the element is found

			WebElement FindLabel = driver.findElement(By.xpath("//label[@for='payment_method_cod']"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", FindLabel);
			Thread.sleep(2000);

			WebElement CheckBox = driver
					.findElement(By.xpath("//span[contains(text(),'I have read and agree to the website ')]"));
			CheckBox.click();

			// Click on "Place order" button
			WebElement PlaceOrder = driver.findElement(By.xpath("//button[@id='place_order']"));
			PlaceOrder.click();

			// Check that the order has been well done "thank you-order-received"
			WebElement Pay = driver.findElement(By.xpath("//p[normalize-space()='Pay with cash upon delivery.']"));
			js.executeScript("arguments[0].scrollIntoView();", Pay);
			Thread.sleep(3000);

			WebElement Order = driver.findElement(By.xpath("//p[@class='woocommerce-thankyou-order-received']"));

			if (Order.isDisplayed()) {
				System.out.println("Order well received");
			}

			else {
				System.out.println("Order not found");
				driver.quit();
			}

		}

	}
}
