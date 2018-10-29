package messageprocessing;

import java.util.ArrayList;


/**
 * @author Nilam
 * Main class which creates a list of messages and send for processing
 *  
 */
public class MessageProcessingMain {

	public static void main(String a[]){

		SalesProcessing salesProcessing = new SalesProcessing();
		ArrayList<ProductDetails> sales = MessageProcessingMain.getListOfMessages();
		try{
			salesProcessing.messagesProcessing(sales);
		}catch(NullPointerException | IndexOutOfBoundsException e){
			e.getStackTrace();
		}catch(Exception e){
			e.getStackTrace();
		}
	}

	/**
	 * This method returns the list of different messages
	 * 
	 * 
	 */
	public static ArrayList<ProductDetails> getListOfMessages(){

		ProductDetails prodApple=new ProductDetails(Utility.MESSAGE1);
		ProductDetails prodMango=new ProductDetails(Utility.MESSAGE2);
		ProductDetails prodOrange=new ProductDetails(Utility.MESSAGE3);

		ArrayList<ProductDetails> salesList= new ArrayList<ProductDetails>();
		salesList.add(prodApple);
		salesList.add(prodMango);
		salesList.add(prodOrange);

		return salesList;

	}
}

