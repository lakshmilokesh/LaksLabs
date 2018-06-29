package com.AmazonLessFrequent;

public class MonotoneIncreasingDigits {

//    Intuition
//
//    One initial thought that comes to mind is we can always have a candidate answer of d999...9 (a digit 0 <= d <= 9
// followed by some number of nines.) For example if N = 432543654, we could always have an answer of at least 399999999.
//
//    We can do better. For example, when the number is 123454321, we could have a candidate of 123449999. It seems
// like a decent strategy is to take a monotone increasing prefix of N, then decrease the number before the "cliff" (the index where adjacent digits decrease for the first time) if it exists, and replace the rest of the characters with 9s.
//
//    When does that strategy fail? If N = 333222, then our strategy would give us the candidate answer of 332999 -
// but this isn't monotone increasing. However, since we are looking at all indexes before the original first occurrence of a cliff, the only place where a cliff could exist, is next to where we just decremented a digit.
//
//    Thus, we can repair our strategy, by successfully morphing our answer 332999 -> 329999 -> 299999 with a linear
// scan.

    public int monotoneIncreasingDigits(int N) {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] <= S[i]) i++;
        while (0 < i && i < S.length && S[i-1] > S[i]) S[--i]--;
        for (int j = i+1; j < S.length; ++j) S[j] = '9';

        return Integer.parseInt(String.valueOf(S));
    }
}
