1- I had used the Selenium Tool + Eclipse IDE
2- I had added to the “Add External JAR”  those below JARs:
"selenium-java-4.1.3"
poi-bin-5.2.2-20220312

3- The JAVA version installed in my computre is:
java version "9.0.4"
Java(TM) SE Runtime Environment (build 9.0.4+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)


4- For Eclipse: I Used JRE System Library [JavaSE-1.8]
5- I used the Framwork DDT (Read Data From Excel) to separating the “data set” from the actual “test case” (code):
Color, Size, FirstName, LastName, Country, House number, Apartment, Town City, State country, PostCode, Phone and Address Email

5- You have to chabge the url path for the "chromedriver.exe" with your new location:

System.setProperty("webdriver.chrome.driver", "D:\\Selenuim\\Download\\chromedriver_win32\\chromedriver.exe");

6- You have to change the url path with your new excel location :
FileInputStream("C:\\Users\\jihene.abidli\\Desktop\\Shop\\ImportData.xlsx");

