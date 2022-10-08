package org.pircbotx.output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class WordWrapUtil {

	/**
	 * Turns a (long) text into a list of lines with a maximum length. This will wrap around words if possible,
	 * when a single word does not fit into a line it will be split forcefully.<br>
	 * The prefix and suffix will be added to each line - the suffix is typically the newline sequence. <br>
	 * <br>
	 * This implementation is based on the principle of counting String length based on {@link String#codePointCount(int, int) code points}
	 * rather than {@link String#length() characters}, the difference being {@link Character#isSurrogate(char) surrogates}
	 * which represent a single code point with two chars.<br>
	 * Although even when using the regular String length, this function will prevent splitting words between surrogate units,
	 * which would otherwise turn a character into two broken parts.
	 * @param text text to split
	 * @param maxLength maximum length of either the entire line or just the core (without prefix/suffix)
	 * @param prefix text before each line
	 * @param suffix text after each line, typically \n
	 * @param textLengthOnly false will take maxLength to include prefix and suffix
	 * @param codePointLength true uses number of code points for all length measurements
	 * @return
	 */
	public static List<String> wrap(String text, int maxLength, String prefix, String suffix, boolean textLengthOnly, boolean codePointLength) {
		List<String> result = new ArrayList<>();
		
		final String space = " ";
		final int prefixLength = length(prefix, codePointLength);
		final int suffixLength = length(suffix, codePointLength);
		final int spaceLength = length(space, codePointLength);
		final int weight = textLengthOnly ? 0 : prefixLength+suffixLength;
		
		ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(space)));
		int lengthInBin = length(words.get(0), codePointLength)+weight;// space only between words
		int passed = 1;
		
		// the principle create so called bins or lines which will be filled word by word
		// when the bin is to full, a new one is created and the current word will be added to that
		// if a single word overflows an entire bin, its trail will be pushed back into the word list
		while (!words.isEmpty()) {
			boolean last = passed+1 >= words.size();
			int l = last ? maxLength : length(words.get(passed), codePointLength);
			lengthInBin += l+spaceLength;
			if (last || lengthInBin > maxLength) {// space included there
				StringJoiner sj = new StringJoiner(space, prefix, suffix);
				for (int i=0;i<passed;i++) sj.add(words.remove(0));
				if (last && !words.isEmpty()) sj.add(words.remove(0));
				String joined = sj.toString();
				// this might still be too long in case a single word is longer than the max length
				// in which case we have to forcibly cut the string and put the remainder into the word list
				int lineLength = length(joined, codePointLength);
				if (textLengthOnly) lineLength -= (prefixLength+suffixLength);
				if (lineLength > maxLength) {
					String keep = substring(joined, 0, prefixLength+maxLength-weight, codePointLength)+suffix;
					String push = substring(joined, length(keep, codePointLength)-suffixLength, length(joined, codePointLength)-suffixLength, codePointLength);
					result.add(keep);
					words.add(0, push);
					lengthInBin = length(push, codePointLength)+weight;
				} else {
					result.add(joined);
					lengthInBin = l+weight;// space only between words
				}
				passed = 0;
			}
			passed++;
		}
		return result;
	}
	
	/**
	 * Support for code point based character counting, and for regular length this
	 * will also prevent splitting between surrogate pairs.
	 * @param s
	 * @param beginIndex
	 * @param endIndex
	 * @param codePointLength
	 * @return
	 */
	public static String substring(String s, int beginIndex, int endIndex, boolean codePointLength) {
		if (codePointLength) {
			int errorIndex = beginIndex;
			try {
				int start = s.offsetByCodePoints(0, beginIndex);
				errorIndex = endIndex;
				int end = s.offsetByCodePoints(0, endIndex);
				return s.substring(start, end);
			} catch (IndexOutOfBoundsException e) {
				throw new IndexOutOfBoundsException(errorIndex+" with String codepoint length "+length(s, true));
			}
		} else {
			int startOffset = Character.isLowSurrogate(s.charAt(beginIndex)) ? 1 : 0;
			int endOffset = Character.isHighSurrogate(s.charAt(endIndex-1)) ? -1 : 0;
			return s.substring(beginIndex+startOffset, endIndex+endOffset);
		}
	}
	
	/**
	 * Convenience method for code point based String length. Difference to regular
	 * length occurs when the String contains surrogates.
	 * @param s
	 * @param codePointLength
	 * @return
	 * @see Character#isSurrogate(char)
	 */
	public static int length(String s, boolean codePointLength) {
		return codePointLength ? s.codePointCount(0, s.length()) : s.length();
	}
	
}
