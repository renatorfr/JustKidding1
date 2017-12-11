package br.com.renatorfr.justkidding1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Character> sequence = new ArrayList<>(Arrays.asList('a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j'));

		printList(sequence);
		printList(Main.sequenceSizes(sequence));

		System.out.println("____________________________________________________________________");

		sequence = new ArrayList<>((Arrays.asList('a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'h', 'i', 'j', 'e')));

		printList(sequence);
		printList(Main.sequenceSizes(sequence));

		System.out.println("____________________________________________________________________");

		sequence = new ArrayList<>((Arrays.asList('z', 'z', 'c', 'b', 'z', 'c', 'h', 'f', 'i', 'h', 'i')));

		printList(sequence);
		printList(Main.sequenceSizes(sequence));

	}

	private static List<Integer> sequenceSizes(List<Character> sequence) {
		List<Integer> result = new ArrayList<>();

		while (sequence.size() > 0) {
			List<Character> subSequence = getSequence(sequence);

			if (subSequence != null) {
				result.add(subSequence.size());
				sequence = sequence.subList(subSequence.size(), sequence.size());
			}
		}

		return result;
	}

	private static List<Character> getSequence(List<Character> sequence) {
		int lastIndexSeq = 0;

		for (int index = 0; index < sequence.size(); index++) {
			char currentChar = sequence.get(index);

			int lastIndexChar = sequence.lastIndexOf(currentChar);

			lastIndexSeq = lastIndexChar > lastIndexSeq ? lastIndexChar : lastIndexSeq;

			if (index == lastIndexSeq) {
				return sequence.subList(0, lastIndexSeq + 1);
			}
		}

		return null;
	}

	private static void printList(List<?> list) {
		for (Object i : list) {
			System.out.print(i + " | ");
		}

		System.out.println();
	}
}
