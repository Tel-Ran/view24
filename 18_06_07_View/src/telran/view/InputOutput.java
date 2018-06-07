package telran.view;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.*;

public interface InputOutput {
	String getString( String prompt);
	void display(Object object);
	default void displayLine(Object obj) {
		String line=obj.toString()+"\n";
		display(line);
	}
	default <R> R getObject(String prompt,String wrongPrompt, Function<String,R> mapper) {
		
		//endless loop until a  mapper returns object
		//mapper throws RunTimeException in a case of wrong input
		//displaying wrongPrompt in a case mapper throws exception
		do {
			String str=getString(prompt);
			try {
				R res=mapper.apply(str);
				return res;
			} catch (Exception e) {
				displayLine(wrongPrompt);
			}
		}while(true);
		
	}
	default String getString(String prompt, Predicate<String> predicate) {
		
		return getObject(prompt,"string doesn't match the predicate",
				x->{
					if(!predicate.test(x))
						throw new RuntimeException();
					return x;
				}) ;
	}
	default String getString(String prompt, Set<String> options) {
		return getObject(prompt,"wrong option",
				x->{
					if(!options.contains(x))
						throw new RuntimeException();
					return x;
				});
	}
	default Integer getInteger(String prompt) {
		return getObject(prompt,"it's not an integer number",Integer::parseInt);
	}
	default Integer getInteger(String prompt, Integer minValue,Integer maxValue) {
		return getObject(prompt,
				String.format("it's not an integer in the range [%d-%d]", minValue,maxValue),
				x->{
					int number=Integer.parseInt(x);
					if(number<minValue||number>maxValue)
						throw new RuntimeException();
					return number;
				});
	}


	default Number getNumber(String prompt,Predicate<Number>predicate) {
		return getObject(prompt,"it's not a number matching the predicate",
				x->{
					Number number=Double.parseDouble(x);
					if(!predicate.test(number))
						throw new RuntimeException();
					return number;
				}) ;
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
