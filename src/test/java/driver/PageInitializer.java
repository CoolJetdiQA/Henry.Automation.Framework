package driver;

import pages.CommonPage;
import pages.MyAccountPage;

public class PageInitializer extends Driver {

	public static CommonPage cp;
	public static MyAccountPage myAPage;

	public static void initialize() {
		cp = new CommonPage();
		myAPage = new MyAccountPage();
	}
}
