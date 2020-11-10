package com.appgate.test.functionaInterface;

import java.util.stream.IntStream;

import org.beanio.BeanReader;

/**
 * 
 * @author srcortes
 *
 */
public interface ControlBook {
	@FunctionalInterface
	interface ControlString{
		String withOutSpace(String value);
	}
	@FunctionalInterface
	interface ControlKey{
		String generateNumber();
	}	
}
