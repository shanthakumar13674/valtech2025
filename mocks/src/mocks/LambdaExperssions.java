package mocks;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 0 - 0 - 0
 * 1 - 1 - 1
 * 2 - 4 - 3
 * 3 - 9 - 5
 * 4 - 16 - 7
 * 5 - 25 - 9
 */
public class LambdaExperssions {
	
	public static final Function<Integer,Integer> SQUARER = (i) -> i * i;

	public static void main(String[] args) {
		List<Integer> nums = List.of(2, 3, 4, 5, 6, 7);
		traditional(nums);
		enhancedForEach(nums);
		usingstreamapi(nums);
		int sum = nums.stream().map(SQUARER).reduce(0,(i,j) -> i+j);
		System.out.println(sum);
		List<String> tokens = List.of("I dont know what to write".split(" "));
		sum = tokens.stream().map(s -> s.length()).reduce(0,(i,j) -> i+j);
		System.out.println(sum);
		Map<Object,List<String>> oddeventokens = tokens.stream()
				.collect(Collectors.groupingBy
						(i -> (i.length()%2 == 0) ? "even" : "odd"));
		System.out.println(oddeventokens);
	}
	
	private static void usingstreamapi(List<Integer> nums) {
		Stream<Integer> stream = nums.stream();
//		Function<Integer, Integer> squarer = new Function<Integer, Integer>() {
//			@Override
//			public Integer apply(Integer t) {
//				return t*t;
//			}
//			
//		};
		Function<Integer, Integer> squarer = (i) -> i * i;
//		BinaryOperator<Integer> summer = new BinaryOperator<Integer>() {
//			
//			@Override
//			public Integer apply(Integer t, Integer u) {
//				return t+u;
//			}
//		};
		BinaryOperator<Integer> summer = (i,j) -> i+j;
		Stream<Integer> streamofSquares = stream.map(squarer);
		System.out.println(streamofSquares.reduce(0, summer));
	}

	private static void enhancedForEach(List<Integer> nums) {
		int sum = 0;
		for(int i:nums)	{
			sum+= i*i;
		}
		System.out.println(sum);
	}

	private static void traditional(List<Integer> nums) {
		int sum = 0;
		for (Iterator iter = nums.iterator(); iter.hasNext();) {
			Integer i = (Integer) iter.next();
			sum += i*i;
		}
		System.out.println(sum);
	}

}
