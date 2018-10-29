package messageprocessing;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nilam
 * It has the methods and fields which can reuse
 */

public class Utility {

	public static String STOPMESSAGE = "It reaches to the maximum 50 message capacity.. couldn't accept more message ........";
	public static String KEY = " Item : ";
	public static String SALE = " |||| Number of Sale : ";
	public static String VALUE = " |||| Value : "; 
	public static String FILE= "D:/Nilam/JP morgan test/LogFile.log";
	public static String MESSAGE1 = "20 sales of Apples at 10p each";
	public static String MESSAGE2 = "Mango at 30p";
	public static String MESSAGE3 = "Add 20p Apples";
	public static String MESSAGE4 = "Add Apples";	
	
	/**
	 * @param total(pence)
	 * It will take the total price in pence and convert into pound
	 */
	public static String currencyFormatter(int total) {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.UK); 
		return n.format(total / 100.0);
	}
	
	
	/**
	 * @param prodDetail
	 * @return prodPrice
	 * It will calculate price according to the message string
	 */
	public static String getQuantity(ProductDetails prodDetail) {
		String prodPrice = null;
		Pattern p = Pattern.compile("\\d\\d");
		Matcher m  = p.matcher(prodDetail.getItem());

		if (m.find()) {
			prodPrice=m.group();
			prodPrice = prodPrice.replaceAll("[^0-9]", "");
		}
		return prodPrice;
	}
	

	/**
	 * @param prodDetail
	 * @return prodPrice
	 * It will search price from the message string for particular product
	 */
	public static String getAmountForProduct(ProductDetails prodDetail) {

		String prodPrice = null;
		Pattern p = Pattern.compile("-?\\d+p");
		Matcher m  = p.matcher(prodDetail.getItem());

		while (m.find()) {
			prodPrice=m.group();
			prodPrice = prodPrice.replaceAll("[^0-9]", "");
		}
		return prodPrice;
	}
}
