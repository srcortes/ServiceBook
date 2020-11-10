package com.appgate.test.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.stream.IntStream;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import com.appgate.test.constants.ConstantFileBook;
import com.appgate.test.exception.ManagerApiException;

/**
 * 
 * @author srcortes
 *
 */
public class IntegrationUtil {
	public static String generateKey() {
		StringBuffer strB = new StringBuffer("");
		strB.append(String.valueOf(System.currentTimeMillis()).substring(7));
		SecureRandom secRandom = new SecureRandom();
		int bValue = secRandom.nextInt(Integer.MAX_VALUE);
		bValue = (int) bValue / 100000;
		strB.append(Math.abs(bValue));
		return strB.toString();
	}
	public static String withOutSpaceAndUpperCase(String value) {
		return value.trim().toUpperCase();
	}	
}
