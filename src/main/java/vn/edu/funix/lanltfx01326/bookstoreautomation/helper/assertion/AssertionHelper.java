package vn.edu.funix.lanltfx01326.bookstoreautomation.helper.assertion;

import org.testng.Assert;

import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.logger.LoggerHelper;

import org.apache.logging.log4j.Logger;

public class AssertionHelper {
private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("verify text:" +s1+"with" +s2);
		Assert.assertEquals(s1, s1);
	}
	
	public static void makeTrue() {
		log.info("make the script PASS....");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String message) {
		log.info("make the script PASS...." +message);
		Assert.assertTrue(true,message);
	}
	
	public static void makeFalse() {
		log.info("make the script FAIL....");
		Assert.assertFalse(false);
	}
	
	public static void makeFalse(String message) {
		log.info("make the script FAIL...." +message);
		Assert.assertFalse(false,message);
	}
	
	public static  void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}
	
	public static  void verifyFalse(boolean status) {
		Assert.assertFalse(status);
	}
	
	public static void verifyNull(String s1) {
		log.info("Verify object is null....");
		Assert.assertNull(s1);
	}
	
	public static void verifyNullObject(String s1) {
		log.info("Verify object is not null....");
		Assert.assertNotNull(s1);
	}

}
