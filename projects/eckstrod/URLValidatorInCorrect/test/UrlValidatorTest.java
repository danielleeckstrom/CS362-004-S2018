

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
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] testScheme = {"http://", "ftp://", "h3t://", "http:/", "http:", "http"};  
	   String[] schemeValidity = {"Valid", "Valid", "Valid", "Invalid", "Invalid", "Invalid"}; 
	   //String[] expectedURLValidity = {"?", "?", "?", "?", "?", "?"};
	   int i;
	   
	   for(i = 0; i < testScheme.length; i++)
	   {
		   System.out.println("Testing Scheme: " + testScheme[i]);
		   System.out.println("Scheme is " + schemeValidity[i] + ": " + urlVal.isValid(testScheme[i] + "google.com"));
		   System.out.println("Scheme is " + schemeValidity[i] + ": " + urlVal.isValid(testScheme[i] + "google.com:80"));
		   System.out.println("Scheme is " + schemeValidity[i] + ": " + urlVal.isValid(testScheme[i] + "google.com/test1"));
		   System.out.println("Scheme is " + schemeValidity[i] + ": " + urlVal.isValid(testScheme[i] + "google.com?action=view"));
		   System.out.println("Scheme is " + schemeValidity[i] + ": " + urlVal.isValid(testScheme[i] + "google.com:80/test1/?action=view"));
	   }

   }
   
   public void testYourSecondPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - Authority";

	   System.out.println("Test: " + testName);
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] testAuthority= {"google.com", "oregonstate.edu", "wikipedia.org", "256.256.256.256", "http:", "http"};  
	   String[] authorityValidity = {"Valid", "Valid", "Valid", "Invalid", "Invalid", "Invalid"}; 
	   //String[] expectedURLValidity = {"?", "?", "?", "?", "?", "?"};
	   int i;
	   
	   for(i = 0; i < testAuthority.length; i++)
	   {
		   System.out.println("Testing Authority: " + testAuthority[i]);
		   System.out.println("Authority is " + authorityValidity[i] + ": " + urlVal.isValid("http://" + testAuthority[i]));
		   System.out.println("Authority is " + authorityValidity[i] + ": " + urlVal.isValid("http://" + testAuthority[i] + ":80"));
		   System.out.println("Authority is " + authorityValidity[i] + ": " + urlVal.isValid("http://" + testAuthority[i] + "/test1"));
		   System.out.println("Authority is " + authorityValidity[i] + ": " + urlVal.isValid("http://" + testAuthority[i] + "?action=view"));
		   System.out.println("Authority is " + authorityValidity[i] + ": " + urlVal.isValid("http://" + testAuthority[i] + ":80/test1/?action=view"));
	   }

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
		   System.out.println("Test Port: " + testPort[i]);
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("3ht://256.256.256.256" + testPort[i] + "/..") + "URL Should be: " + "?");
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("http:/.1.2.3.4" + testPort[i] + "/..//file?action=view"));
		   System.out.println("Port is " + portValidity[i] + ": " + urlVal.isValid("h3t://255.255.255.255" + testPort[i] + "/$23"));
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
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] testPath= {"", "/test1", "/test1/test2", "/...", "/#", "/test1/#"};  
	   String[] pathValidity = {"Valid", "Valid", "Valid", "Invalid", "Invalid", "Invalid"}; 
	   //String[] expectedURLValidity = {"?", "?", "?", "?", "?", "?"};
	   int i;
	   
	   for(i = 0; i < testPath.length; i++)
	   {
		   System.out.println("Testing Path: " + testPath[i]);
		   System.out.println("Path is " + pathValidity[i] + ": " + urlVal.isValid("http://google.com" + testPath[i]));
		   System.out.println("Path is " + pathValidity[i] + ": " + urlVal.isValid("http://google.com:80" + testPath[i] + ":80"));
		   System.out.println("Path is " + pathValidity[i] + ": " + urlVal.isValid("http://google.com" + testPath[i] + "?action=view"));
		   System.out.println("Path is " + pathValidity[i] + ": " + urlVal.isValid("http://google.com:80" + testPath[i] + "?action=view"));
	   }

   }
   
   
   public void testYourFifthPartition()
   {
	   //You can use this function to implement your Second Partition testing	   
	   String testName = "Partitioned - Query";
	   System.out.println("Test: " + testName);
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String[] testQuery= {"", "?action=view", "?action=edit&mode=up"};  
	   String[] queryValidity = {"Valid", "Valid", "Valid"}; 
	   //String[] expectedURLValidity = {"?", "?", "?", "?", "?", "?"};
	   int i;
	   
	   for(i = 0; i < testQuery.length; i++)
	   {
		   System.out.println("Testing Query: " + testQuery[i]);
		   System.out.println("Query is " + queryValidity[i] + ": " + urlVal.isValid("http://google.com" + testQuery[i]));
		   System.out.println("Query is " + queryValidity[i] + ": " + urlVal.isValid("http://google.com:80" + testQuery[i]));
		   System.out.println("Query is " + queryValidity[i] + ": " + urlVal.isValid("http://google.com/test1" + testQuery[i]));
		   System.out.println("Query is " + queryValidity[i] + ": " + urlVal.isValid("http://google.com:80/test1" + testQuery[i]));
	   }


   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   System.out.println("Test: random change");

   }
