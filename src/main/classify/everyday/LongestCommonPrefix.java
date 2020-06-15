package main.classify.everyday;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String first = strs[0];
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < first.length(); i++) {
			boolean append = true;
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || i < strs[j].length() && first.charAt(i) != strs[j].charAt(i)) {
					append = false;
					break;
				}
			}
			if (append && i == builder.length()) {
				builder.append(first.charAt(i));
			}

		}
		return builder.toString();

	}

}
