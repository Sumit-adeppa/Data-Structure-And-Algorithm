class Solution {
    public String removeOccurrences(String str1, String str2) {
        while (str1.contains(str2)) {
			int index = str1.indexOf(str2);
			str1 = str1.substring(0, index) + str1.substring(index + str2.length());
		}

        return str1;

    }
}