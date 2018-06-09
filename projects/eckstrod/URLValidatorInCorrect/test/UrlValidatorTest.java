

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
	   System.out.println("Test: " + testName);
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.println("Should be Invalid/False:\n");
	   System.out.println(urlVal.isValid("3ht://256.256.256.256:-1/.."));
	   System.out.println(urlVal.isValid("http:/.1.2.3.4/..//file?action=view"));
	   System.out.println(urlVal.isValid("h3t://255.255.255.255:65a/$23"));
	   System.out.println(urlVal.isValid("http/aaa:65a/test1/file?action=view"));
	   System.out.println(urlVal.isValid("http:/.1.2.3.4:65636"));

	   
	   System.out.println("Should be Valid/True:\n");
	   System.out.println(urlVal.isValid("http://www.google.com:80/test1?action=view"));
	   System.out.println(urlVal.isValid("ftp://go.com/test1/file?action=edit&mode=up"));
	   System.out.println(urlVal.isValid("h3t://www.google.com:65535?action=view"));
	   System.out.println(urlVal.isValid("ftp://www.google.com:0"));
	   System.out.println(urlVal.isValid("h3t://0.0.0.0:80/test1?action=edit&mode=up"));
	   
   }
   
   
   public void testYourFirstPartition()
   {
	   //You can use this function to implement your First Partition testing
	   String testName = "Partitioned - Scheme";
	   System.out.println("Test: " + testName);

   }
   
   public void testYourSecondPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - Authority";
	   System.out.println("Test: " + testName);

   }
   
   public void testYourThirdPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - Port";
	   System.out.println("Test: " + testName);
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] testPort = {":80", ":0", "", ":-1", ":65363", ":65a"};  
	   String[] portValidity = {"Valid", "Valid", "Valid", "Invalid", "Invalid", "Invalid"}; 
	   //String[] expectedURLValidity = {"?", "?", "?", "?", "?", "?"};
	   int i;
	   
	   for(i = 0; i < testPort.length; i++)
	   {
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("3ht://256.256.256.256" + testPort[i] + "/..") + "URL Should be: " + "?");
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("http:/.1.2.3.4" + testPort[i] + "/..//file?action=view"));
		   System.out.print("Port is " + portValidity[i] + ": " + urlVal.isValid("h3t://255.255.255.255" + testPort[i] + "/$23") +"\n");
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("http/aaa" + testPort[i] + "/test1/file?action=view"));
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("http:/.1.2.3.4" + testPort[i]));
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("http://www.google.com" + testPort[i] + "/test1?action=view"));
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("ftp://go.com" + testPort[i] + "/test1/file?action=edit&mode=up"));
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("h3t://www.google.com" + testPort[i] + "?action=view"));
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("ftp://www.google.com" + testPort[i]));
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("h3t://0.0.0.0" + testPort[i] + "/test1?action=edit&mode=up"));
	   }

   }
   
   public void testYourFourthPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - Path";
	   System.out.println("Test: " + testName);

   }
   
   
   public void testYourFifthPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - Query";
	   System.out.println("Test: " + testName);

   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   System.out.println("Test: random change");

   }
   


}
