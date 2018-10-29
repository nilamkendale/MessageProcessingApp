# MessageApplication
___________________________________________________________________________________________________________________________________
Problem statement :--->
-----------------------------------------------------------------------------------------------------------------------------------

It is a small Message Processing Application which handles a list of messagess 
and log the report detailing the number of sales of each product and their total value.

Requirements in detail :
> All sales must be recorded
> All messages must be processed
> After every 10th message received your application should log a report detailing the number of sales of each product 
  and their total value.
> After 50 messages your application should log that it is pausing, stop accepting new messages
  and log a report of the adjustments that have been made to each sale type while the application was running.


Messages :
A message notifying you of a sale could be one of the following types
> Message Type 1 – contains the details of 1 sale E.g apple at 10p
> Message Type 2 – contains the details of a sale and the number of occurrences of that sale. E.g 20 sales of apples at 10p each.
> Message Type 3 – contains the details of a sale and an adjustment operation to be applied to all stored sales of this product type. 
  Operations can be add, subtract,or multiply 
  e.g Add 20p apples would instruct your application to add 20p to each sale of apples you have recorded.
  
=====================================================================================================================================

Solution ::--->
------------------------------------------------------------------------------------------------------------------------------------
> Created POJO which contains variable like Item (ie. Messages like 20 sales of apples at 10p each), Value, Number of sales.
> First, created the List of Items and set it in the ArrayList
> Took 1 Infinite outer Loop and 1 inner loop with items, so that list gets same values one by one until 50 messages 
  condition doesn't satisfy it.
  So runtime it will decide when to keep running the loop and when to break the Loop
> This code handles 3 types of messages ie. 20 sales of apples at 10p each, Mango at 30p, Add 20p Apples.
> One by one these messages will get add in new List and it will check for count 10.
> When it will receive 10th message it will read all messages and do the calculation accordingly 
  and Log the report in Log File on specified location
> Utility file to have static fields and method which can reuse in application
=====================================================================================================================================

TestNG ::--->
------------------------------------------------------------------------------------------------------------------------------------
> Created TestApp file to do Unit testing.
> It has 7 test methods which will help to test the application method without dependency.
> It has Pass and Fail init test as well.

=====================================================================================================================================

Different Approach :--->
-----------------------------------------------------------------------------------------------------------------------------------
We can develop same application with File reading approach but I choose to develop it with different stlye.
In File Reading approach, will need to create 1 file with all messages and one by one we can read and do process.
 
=====================================================================================================================================

How to Run --->
You need Eclipse or any IDE and Java 7 and checkout the code and have to run MessageProcessingMain file.
Emailable report shows you how many testcases passed and failed 
Note: Make sure you have file path ready which is in Logger file to create Log File.


