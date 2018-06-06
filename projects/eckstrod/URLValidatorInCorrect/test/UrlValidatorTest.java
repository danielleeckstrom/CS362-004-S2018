

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase 
{


   public UrlValidatorTest(String testName) 
   {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   //You can use this function to implement your manual testing
	   String testName = "Manual";
	   System.out.print("Test: " + testName +"\n");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.print("Should be Invalid:\n");
	   System.out.print(urlVal.isValid("3ht://256.256.256.256:-/..") +"\n");
	   
	   System.out.print("Should be Valid:\n");
	   System.out.print(urlVal.isValid("http://www.google.com:80/test1?action=view") +"\n");
	   
   }
   
   
   public void testYourFirstPartition()
   {
	   //You can use this function to implement your First Partition testing
	   String testName = "Partitioned - ";
	   System.out.print("Test: " + testName +"\n");

   }
   
   public void testYourSecondPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - ";
	   System.out.print("Test: " + testName +"\n");

   }
   
   public void testYourThirdPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - ";
	   System.out.print("Test: " + testName +"\n");

   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   System.out.print("Test: random change \n");

   }
   


}
