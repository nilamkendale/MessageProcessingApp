package messageprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * @author Nilam
 * It processed the messages and Log it to logfile
 */
public class SalesProcessing {

	static Logger logger = Logger.getLogger("MessageProcessingMain");
	static int appleTot = 0;
	static String appleValue = null;
	static int mangoTot = 0;
	static int totalSaleEachApple = 0;
	static String mangoValue = null;
	static int totalSaleEachmango = 0;
	static String prodPrice =  null ;
	static int quantity=0;

	/**
	 * @param salesList
	 * 
	 * This method takes the input messages as a List and 
	 * Logs details such as product , Number of sales and total Value every after 10th message
	 * After 50th message it should Log the system is Pausing and stop accepting and processing new messages
	 * 
	 */
	public boolean messagesProcessing(ArrayList<ProductDetails> salesList) {

		LoggerFile.setLogger(logger);
		
		int counter = 1;
		int counterTotal =0;
		ArrayList<ProductDetails> prodList=new ArrayList<ProductDetails>();
		Map<String,Object> map=new HashMap<String,Object>();  
		
		if(null != salesList){
		// Infinite For loop to get the messages continuously from the list and when condition successful break the loop
		outer: for(int i = 0;  ; i++){

			ArrayList<ProductDetails> salesMessageList=salesList;
			ProductDetails prodDetail=new ProductDetails();

			for(int j=0;j<salesMessageList.size();j++){
				
				prodDetail = salesMessageList.get(j);
				prodList.add(prodDetail);
				logger.info("Message   "+counter+" : "+prodDetail.getItem());
				if(counter == 10){
					counterTotal = counterTotal + 10;
					logger.info("Total "+counterTotal+" Messsages received---");
					map = processProdList(prodDetail,prodList,map);
					boolean flag = printReportToLogFile(map,counter,counterTotal,prodList);

					if(flag){
						counter = 1;
						prodList.clear();
						continue;
					}else{
						break outer;
					}
				}
				counter++;
			}
		}
		return true;
		}else
			return false;	
	}
	
	
	/**
	 * @param prodDetail, map, prodList
	 * 
	 * this method takes messages and calculate the price of each sale and quantity according to each products and returns map
	 * 
	 */
	public Map<String, Object> processProdList(ProductDetails prodDetail,ArrayList<ProductDetails> prodList, Map<String, Object> map) {

		ArrayList<ProductDetails> newl=new ArrayList<ProductDetails>();
		ArrayList<ProductDetails> newm=new ArrayList<ProductDetails>();

		for(int k=0;k<prodList.size();k++){
			ProductDetails prodDetailNew = new ProductDetails();
			prodDetail = prodList.get(k);
			if(prodDetail.getItem().contains("Apple")){

				if(prodDetail.getItem().contains("sales")){
					//get the price from message
					prodPrice = Utility.getAmountForProduct(prodDetail);
					quantity = Integer.parseInt(Utility.getQuantity(prodDetail));
					appleTot = appleTot + (Integer.parseInt(prodPrice) * quantity);
					totalSaleEachApple= totalSaleEachApple + quantity;
					newl.clear();
					prodDetailNew.setValue(Utility.currencyFormatter(appleTot));
					prodDetailNew.setItem("Apple");
					prodDetailNew.setNumberOfSale(totalSaleEachApple);
					newl.add(prodDetailNew);
				}else if(prodDetail.getItem().contains("Add")){
					prodPrice = Utility.getAmountForProduct(prodDetail);
					appleTot = appleTot + Integer.parseInt(prodPrice) ;
					newl.clear();
					prodDetailNew.setValue(Utility.currencyFormatter(appleTot));
					prodDetailNew.setItem("Apple");
					prodDetailNew.setNumberOfSale(totalSaleEachApple);
					newl.add(prodDetailNew);
				}
			}
			else if(prodDetail.getItem().contains("Mango")){

				prodPrice = Utility.getAmountForProduct(prodDetail);
				mangoTot = mangoTot + Integer.parseInt(prodPrice);
				totalSaleEachmango= totalSaleEachmango + 1;
				newm.clear();
				prodDetailNew.setItem("Mango");
				prodDetailNew.setNumberOfSale(totalSaleEachmango);
				prodDetailNew.setValue(Utility.currencyFormatter(mangoTot));
				newm.add(prodDetailNew);
			}

			map.put("Apple",newl);
			map.put("Mango",newm);
		}
		return map;
	}
	

	/**
	 * @param map, counter, counterTotal, prodList
	 * 
	 * this method logs details such as product , Number of sales and total Value every after 10th message
	 * After 50th message it should Log the system is Pausing and stop accepting and processing new messages and return boolean accordingly
	 * 
	 */
	private boolean printReportToLogFile(Map<String, Object> map, int counter, int counterTotal, ArrayList<ProductDetails> prodList) {
		ProductDetails listn = new ProductDetails();
		logger.info("Report :: ");
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();

			@SuppressWarnings("unchecked")
			ArrayList<ProductDetails> values = (ArrayList<ProductDetails>) entry.getValue();
			
			for(int list=0;list<values.size();list++){
				listn = (ProductDetails) values.get(list);
				int nos=listn.getNumberOfSale();
				String v=listn.getValue();
				logger.info(Utility.KEY+key+Utility.SALE + nos + Utility.VALUE + v);
			}
		}
		logger.info("::::::Getting next block of messages ::::::");
		if(counterTotal == 50){
			logger.info(Utility.STOPMESSAGE);
			System.out.println("");
			return false;
		}else{
			return true;
		}
	}
}
