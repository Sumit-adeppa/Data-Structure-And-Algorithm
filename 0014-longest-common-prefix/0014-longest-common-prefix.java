/*
    strs = ["flower", "flow", "flight"]
    strs is not null, length = 3. Passes the guard check.
    pref    = "flower"
    prefLen = 6

    i = 1, s = "flow"
    While check 1:
    prefLen > s.length()? 6 > 4? YES. Shrink.
    prefLen = 5
    pref    = "flowe"
    While check 2:
    prefLen > s.length()? 5 > 4? YES. Shrink.
    prefLen = 4
    pref    = "flow"
    While check 3:
    prefLen > s.length()? 4 > 4? No.
    pref.equals(s.substring(0, 4))? "flow".equals("flow")? YES. Condition is false. Exit while.
    State after i=1:
    pref = "flow", prefLen = 4

    i = 2, s = "flight"
    While check 1:
    prefLen > s.length()? 4 > 6? No.
    pref.equals(s.substring(0, 4))? "flow".equals("flig")? No. Not equal, so condition is true. Shrink.
    prefLen = 3
    pref    = "flo"
    While check 2:
    prefLen > s.length()? 3 > 6? No.
    pref.equals(s.substring(0, 3))? "flo".equals("fli")? No. Shrink.
    prefLen = 2
    pref    = "fl"
    While check 3:
    prefLen > s.length()? 2 > 6? No.
    pref.equals(s.substring(0, 2))? "fl".equals("fl")? YES. Condition is false. Exit while.
    State after i=2:
    pref = "fl", prefLen = 2

    Loop ends. return "fl". Correct.

    Two things to track precisely in this trace:
    First, the while condition has two parts joined by OR.
        prefLen > s.length()  ||  !pref.equals(s.substring(0, prefLen))
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String pref = strs[0];
        int prefLen = pref.length();

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (prefLen > s.length() || !pref.equals(s.substring(0, prefLen))) {
                prefLen--;
                if (prefLen == 0) {
                    return "";
                }
                pref = pref.substring(0, prefLen);
            }
        }

        return pref;        
    }
}