package testng;

import java.util.ArrayList;

import messageprocessing.MessageProcessingMain;
import messageprocessing.ProductDetails;
import messageprocessing.SalesProcessing;
import messageprocessing.Utility;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Nilam
 * Test cases using TestNG
 */
public class TestApp {

	@Test
	public void testProcessngPass(){
		SalesProcessing salesProcessing = new SalesProcessing();
		ArrayList<ProductDetails> sales = MessageProcessingMain.getListOfMessages();
		Assert.assertTrue(salesProcessing.messagesProcessing(sales),"Problem occured while reporting logs.");
	}
	
	@Test
	public void testProcessngFail(){
		SalesProcessing salesProcessing = new SalesProcessing();
		ArrayList<ProductDetails> sales = null;
		Assert.assertEquals(salesProcessing.messagesProcessing(sales), false);
	}
	
	@Test
	public void testQuantity(){
		ProductDetails prodDetail=new ProductDetails(Utility.MESSAGE1);
		String result=Utility.getQuantity(prodDetail);
		Assert.assertEquals(result, "20", "Expected quantity does not match with Actual");
	}
	
	@Test
	public void testAmountForProductPass(){
		ProductDetails prodDetail=new ProductDetails(Utility.MESSAGE2);
		String result=Utility.getAmountForProduct(prodDetail);
		Assert.assertEquals(result, "30", "Expected amount does not match with Actual amount");
	}
	
	@Test
	public void testAmountForProductFail(){
		ProductDetails prodDetail=new ProductDetails(Utility.MESSAGE4);
		String result=Utility.getAmountForProduct(prodDetail);
		Assert.assertNotEquals(result, "30", "Expected amount does not match with Actual amount");
	}
	
	@Test
	public void testListOfMessages(){
		ArrayList<ProductDetails> messagesList = MessageProcessingMain.getListOfMessages();
		Assert.assertNotNull(messagesList);
	}
	
	@Test
	public void testCurrencyFormatter(){
		String actual = Utility.currencyFormatter(1000);
		Assert.assertEquals(actual, "£10.00");
		}
	
}
