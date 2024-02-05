1.Verifying login page
package testcases_Nm;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



import com.aventstack.extentreports.Status;
import
com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositories.LoginPageFactory_NM;
public class verifyLoginpageobjects_Nm {
public String username=&quot;au810020205051&quot;;
public String password=&quot;698166&quot;;//698166
public String
fetchUrl=&quot;https://portal.naanmudhalvan.tn.gov.in/login&quot;;
public String actualUrl;
public String actualTitle;
public String actualPageHeadr1Text;
public String actualPageHeadr2Text;
public boolean actualUsernameTextboxIsEnabled;
public boolean actualPasswordTextboxIsEnabled;
public boolean actualCaptchaTextboxIsEnabled;
public String actualCaptchaValue;
public String actualForgetUsernameLink;
public String actualForgetPasswordLink;
public String expectedTitle=&quot;Naan Mudhalvan&quot;;
public String expectedPageHeadr1Text=&quot;Login to&quot;;
public String expectedPageHeadr2Text=&quot;NAAN MUDHALVAN&quot;;
public boolean expectedUsernameTextboxIsEnabled=true;


public boolean expectedPasswordTextboxIsEnabled=true;
public boolean expectedCaptchaTextboxIsEnabled=true;
public String expectedCaptchaValue=&quot;&quot;;
public String expectedForgetUsernameLink=
&quot;https://portal.naanmudhalvan.tn.gov.in/forgot-username&quot;;
public String expectedForgetPasswordLink=
&quot;https://portal.naanmudhalvan.tn.gov.in/forgot-password&quot;;
public List&lt;String&gt; languages=new ArrayList&lt;String&gt;();
WebDriver driver;
ExtentSparkReporter sparkReporter;
ExtentReports extent;
ExtentTest testcase;
@BeforeClass
public void launchBrowser()
{
sparkReporter=new
ExtentSparkReporter(&quot;ReportOfLoginPageELEMENTS.html&quot;);
extent=new ExtentReports();
extent.attachReporter(sparkReporter);
testcase=extent.createTest(&quot;launch the browser&quot;);
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().window().maximize();


driver.manage().timeouts().implicitlyWait(Duration.ofSecon
ds(60));
testcase.log(Status.INFO,&quot;suscessfully launched&quot;);
testcase=extent.createTest(&quot;Navigate to Naan Mudhalvan
Website&quot;);
driver.get(fetchUrl);
testcase.log(Status.PASS,&quot;sucessfully navigated&quot;);
}
@Test
public void pageTitleandUrl()
{
// verify whether he page contain url is equal to which we
gave to fetch it or not?
testcase= extent.createTest(&quot;verify the page contain url
is equal to which we gave to fetch it or not?&quot;);
actualUrl= driver.getCurrentUrl();
if(actualUrl.equals(fetchUrl))
{
testcase.log(Status.PASS, &quot;expected url and actual url is
equal&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;expected url and actual url is
not equal&quot;);
}


//verify the actual page title is equal to expected page
title?
testcase=extent.createTest(&quot;verify the actual page title
is equal to expected page title&quot;);
actualTitle=driver.getTitle();
if(actualTitle.equals(expectedTitle))
{
testcase.log(Status.PASS, &quot;expected title and actual title
is equal&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;expected title and actual title
is not equal&quot;);
}
}
@Test(dependsOnMethods = {&quot;pageTitleandUrl&quot;})
public void loginPageEelements_Nm() {
LoginPageFactory_NM loginPage
=PageFactory.initElements(driver,pomRepositories.LoginPage
Factory_NM.class);
// verify whether the page headers is correct or not?
testcase= extent.createTest(&quot;verify the page header1&quot;);
actualPageHeadr1Text=loginPage.nm_PageHeader1.getText();
if(actualPageHeadr1Text.equals(expectedPageHeadr1Text))
{


testcase.log(Status.PASS, &quot;Page header1 is matched, test
case is passed&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;Page header1 is not matched,
test case is failed&quot;);
extent.createTest(&quot;verify the page header2&quot;);
actualPageHeadr2Text=loginPage.nm_PageHeader2.getText();
Assert.assertEquals(actualPageHeadr2Text,
expectedPageHeadr2Text, &quot;page header2 is not matched, test
caese is failed&quot;);
}
actualPageHeadr2Text=loginPage.nm_PageHeader2.getText();
if(actualPageHeadr2Text.equals(expectedPageHeadr2Text))
{
testcase.log(Status.PASS, &quot;Page header2 is matched, test
case is passed&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;Page header2 is not matched,
test case is failed&quot;);
}
//verify whether username,password and captchaTextBox is
enabled or not:


testcase= extent.createTest(&quot;verify the username textbox
whether its is enabled or not&quot;);
actualUsernameTextboxIsEnabled=
loginPage.nm_UsernameTextbox.isEnabled();
if(actualUsernameTextboxIsEnabled==expectedUsernameTextbox
IsEnabled)
{
testcase.log(Status.PASS, &quot;Username Textbox is enabled&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;Username Textbox is not
enabled&quot;);
}
testcase= extent.createTest(&quot;verify the Password textbox
whether its is enabled or not&quot;);
actualPasswordTextboxIsEnabled=
loginPage.nm_PasswordTextbox.isEnabled();
if(actualPasswordTextboxIsEnabled==expectedPasswordTextbox
IsEnabled)
{
testcase.log(Status.PASS, &quot;Password Textbox is enabled&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;Password Textbox is not
enabled&quot;);



}
testcase= extent.createTest(&quot;verify the captcha textbox
whether its is enabled or not&quot;);
actualCaptchaTextboxIsEnabled=
loginPage.nm_CaptchaTextbox.isEnabled();
System.out.println(&quot;Is captcha textBox is enabled:
&quot;+actualCaptchaTextboxIsEnabled);
if(actualCaptchaTextboxIsEnabled==expectedCaptchaTextboxIs
Enabled)
{
testcase.log(Status.PASS, &quot;captcha Textbox is enabled&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;captcha Textbox is not
enabled&quot;);
}
//verify can we get captcha value through the script.if it
is yes, then it is a error
testcase=extent.createTest(&quot;verify can we get captcha
value through the script&quot;);
actualCaptchaValue= loginPage.nm_captchaValue.getText();
System.out.println(&quot;is captcha value is captured:
&quot;+&quot;actualCaptchaValue&quot;);
testcase.log(Status.FAIL,
&quot;we can get captcha value through the script.so it is
error&quot;);


//verify whether the forget username &amp;password link will
present in the login page
testcase=extent.createTest(&quot;verify whether the forget
username &amp;password link will present in the login page&quot;);
testcase.log(Status.INFO, &quot;click on the forget username
link&quot;);
loginPage.nm_ForgetUsernameLink.click();
testcase.log(Status.INFO, &quot;after click forget username
link, then get current url&quot;);
actualForgetUsernameLink= driver.getCurrentUrl();
if(actualForgetUsernameLink.equals(expectedForgetUsernameL
ink))
{
testcase.log(Status.PASS, &quot;forget username link presented
and its valid&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;forget username link not
presented and its not valid&quot;);
}
driver.navigate().back();
testcase.log(Status.INFO, &quot;click on the forget password
link&quot;);
loginPage.nm_ForgetPasswordLink.click();
testcase.log(Status.INFO, &quot;after click forget password
link, then get current url&quot;);


actualForgetPasswordLink= driver.getCurrentUrl();
if(actualForgetPasswordLink.equals(expectedForgetPasswordL
ink))
{
testcase.log(Status.PASS, &quot;forget password link presented
and its valid&quot;);
}
else
{
testcase.log(Status.FAIL, &quot;forget password link not
presented and its not valid&quot;);
}
driver.navigate().back();
testcase=extent.createTest(&quot;verify whether the users can
change webPage language or not?&quot;);
Select s1=new Select(loginPage.nm_SelectLanguage);
List&lt;WebElement&gt; availableLanguages=s1.getOptions();
for (WebElement language : availableLanguages) {
languages.add(language.getText());
}
System.out.println(&quot;available languages is &quot; +languages);
testcase.log(Status.INFO, &quot;select the comfortable
language&quot;);
s1.selectByVisibleText(&quot;தமிழ்&quot;);
testcase.log(Status.PASS, &quot;language changed &quot;);



}
@AfterClass
public void closeBrowser() {
driver.manage().timeouts().implicitlyWait(Duration.ofSecon
ds(50));
driver.quit();
extent.flush();
}
}













2.Verifying Login with multiple users
package testcases_Nm;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



import com.aventstack.extentreports.Status;
importcom.aventstack.extentreports.reporter.ExtentSparkReo
rter;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositories.LoginPageFactory_NM;
public class LoginWithMultipleData_Nm {
public
StringfetchUrl=&quot;https://portal.naanmudhalvan.tn.gov.in/log
in&quot;;
public String captchaValue;
publicStringExpectedDashboardUrl=&quot;https://portal.naanmudha
lvan.tn.gov.in/students/dashboard&quot;;
public String ActualDashboardUrl;
public String ToastMsgInvalidUsername;
WebDriver driver;
ExtentSparkReporter sparkReporter;
ExtentReports extent;
ExtentTest testcase;
@BeforeSuite
public void launchBrowser()
{
sparkReporter=new
ExtentSparkReporter(&quot;ReportOfLoginWithInvalidData.html&quot;);
extent=new ExtentReports();
extent.attachReporter(sparkReporter);



WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSecon
ds(60));
testcase=extent.createTest(&quot;Navigate to Naan Mudhalvan
Website&quot;);
driver.get(fetchUrl);
testcase.log(Status.PASS,&quot;sucessfully navigated to naam
mudhalvan login page&quot;);
}
@Test(dataProvider = &quot;loginData&quot;, dataProviderClass =
testcases_Nm.DataUtils.class)
public void logIN(String Username, String Password, String
ExpectedResult) throws InterruptedException {
System.out.println(&quot;USERNAME &quot; + Username +&quot; PASSWORD &quot;
+Password +&quot; ExpectedResult &quot; + ExpectedResult);
LoginPageFactory_NM login=
PageFactory.initElements(driver,pomRepositories.LoginPageF
actory_NM.class );
testcase=extent.createTest(&quot;enter negative data in
username text box&quot;);
login.nm_UsernameTextbox.clear();
login.nm_UsernameTextbox.sendKeys(Username);
testcase.log(Status.INFO, &quot;username entered&quot;);
testcase=extent.createTest(&quot;enter negative data in
password text box&quot;);
login.nm_PasswordTextbox.clear();
login.nm_PasswordTextbox.sendKeys(Password);
testcase.log(Status.INFO, &quot;password entered&quot;);
captchaValue=login.nm_captchaValue.getText();
testcase=extent.createTest(&quot;pass captcha value into the
captcha text box&quot;);
testcase.log(Status.INFO, &quot;captcha value is &quot;
+captchaValue);
//Thread.sleep(5000);
//login.nm_CaptchaTextbox.clear(); //not working
login.nm_CaptchaTextbox.sendKeys(Keys.chord(Keys.CONTROL,&quot;
a&quot;,Keys.DELETE));
//Thread.sleep(5000);
login.nm_CaptchaTextbox.sendKeys(captchaValue);
testcase.log(Status.INFO, &quot;captcha value entered&quot;);
testcase=extent.createTest(&quot;click the login button&quot;);
login.nm_LoginBtn.click();
//WebDriverWait wait1=new WebDriverWait(driver,
Duration.ofSeconds(30));
//wait1.until(ExpectedConditions.urlContains(ExpectedDashb
oardUrl));
//driver.manage().timeouts().implicitlyWait(Duration.ofSec
onds(15));
Thread.sleep(3000);
ActualDashboardUrl=driver.getCurrentUrl();
if(ActualDashboardUrl.equals(ExpectedDashboardUrl))
{


testcase.log(Status.PASS, &quot;enterd data is valid data so
login passed&quot;);
System.out.println(&quot;enterd data is valid data so login
passed &quot; +&quot; current url is &quot; +ActualDashboardUrl);
}
else
{
WebDriverWait wait=new WebDriverWait(driver,
Duration.ofSeconds(20));
WebElement warning=
wait.until(ExpectedConditions.visibilityOf(login.nm_ToastM
sgInvalidUsernam));
ToastMsgInvalidUsername=warning.getText();
//ToastMsgInvalidUsername=login.nm_ToastMsgInvalidUsernam.
getText();
testcase.log(Status.FAIL, ToastMsgInvalidUsername +&quot; -
enterd data is invalid data so login failed-&quot;);
System.out.println(ToastMsgInvalidUsername +&quot; current url
is &quot; +ActualDashboardUrl);
}
extent.flush();
}
}