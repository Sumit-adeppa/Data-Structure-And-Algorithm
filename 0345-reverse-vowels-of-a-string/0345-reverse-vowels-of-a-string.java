class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        String vowels = "aeiouAEIOU";
        while (left < right) {
            if (!vowels.contains(arr[left] + "")) left++;
            else if (!vowels.contains(arr[right] + "")) right--;
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}