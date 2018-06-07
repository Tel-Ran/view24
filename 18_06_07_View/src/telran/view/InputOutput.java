package telran.view;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.*;

public interface InputOutput {
	String getString( String prompt);
	void display(Object object);
	default void displayLine(Object obj) {
		
	}
	default <R> R getObject(String prompt,String wrongPrompt, Function<String,R> mapper) {
		//TODO
		//endless loop until a  mapper returns object
		//mapper throws RunTimeException in a case of wrong input
		//displaying wrongPrompt in a case mapper throws exception
		return null;
	}
	default String getString(String prompt, Predicate<String> predicate) {
		//TODO applying getObject for returning a string matching a predicate
		return null;
	}
	default String getString(String prompt, Set<String> options) {
		//TODO returning string if it exists in options
		return null;
	}
	default Integer getInteger(String prompt) {
		//TODO applying getObjecty for returning integer number
		return 0;
	}
	default Integer getInteger(String prompt, Integer minValue,Integer maxValue) {
		//TODO integer number in a given range [minValue-maxValue]
		return 0;
	}


	default Number getNumber(String prompt,Predicate<Number>predicate) {
		//TODO any number matching a given predicate
		return 0;
	}

	default LocalDate getDate(String prompt) {
		//TODO any LocalDate object
		return null;
	}
	default LocalDate getDate(String prompt,LocalDate from,
			LocalDate to) {
		//TODO date in a range [from-to) from - inclusive, to-exclusive
		return null;
	}

}
