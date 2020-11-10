package com.appgate.test.functionaInterface;

import java.util.List;
import java.util.function.Predicate;
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
	@FunctionalInterface
	public interface ObjectExists {
		<T> boolean existsRow(List<T> t, Predicate<T> predicate);
	}
}
