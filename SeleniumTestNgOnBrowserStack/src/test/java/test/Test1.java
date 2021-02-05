package test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTests;
import pages.HomePage;

public class Test1 extends BaseTests {
	public static HomePage homePage;
	private static String title;

	@Test(priority = 1)
	public void test1() {
		title = getTitle("Test1");
		Assert.assertTrue(title.contains("Test0"), "the title contains not Test0");
	}

	@Test(priority = 2)
	public void test2() {
		title = getTitle("Test2");
		Assert.assertTrue(title.contains("Test2"), "the title contains not Test4");

	}

	@Test(priority = 3)
	public void test3() {
		getTitle("Test3");
		throw new SkipException("test-case skipped");

	}

	@Test(priority = 4)
	public void test4() {
		title = getTitle("Test4");

		Assert.assertTrue(title.contains("Test4"), "the title contains not Test4");

	}

	public static String getTitle(String keyword) {
		googlePage.sendKeyWord(keyword);
		homePage = googlePage.clickSearchBtn();
		return homePage.getTitle();

	}
}
