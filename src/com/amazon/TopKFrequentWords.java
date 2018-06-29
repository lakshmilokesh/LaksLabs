package com.amazon;


import java.util.*;

/*
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the
 * word with the lower alphabetical order comes first.
 *
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 *
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] input = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        List<String> answer = topKFrequentpq(input,2);
    }
    /*
     *  Time Complexity: O(N \log{N})O(NlogN), where NN is the length of words. We count the frequency of each word in
     *  O(N)O(N) time, then we sort the given words in O(N \log{N})O(NlogN) time.
     *
     * Space Complexity: O(N)O(N), the space used to store our candidates.
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1) != count.get(w2) ?
                count.get(w2) - count.get(w1) : w1.compareTo(w2));

        return candidates.subList(0, k);
    }

    /*
     * Complexity Analysis
     *
     * Time Complexity: O(N \log{k})O(Nlogk), where NN is the length of words. We count the frequency of each word in
     * O(N)O(N) time, then we add NN words to the heap, each in O(\log {k})O(logk) time. Finally, we pop from the heap
     * up to kk times. As k \leq Nk≤N, this is O(N \log{k})O(Nlogk) in total.
     * In Python, we improve this to O(N + k \log {N})O(N+klogN): our heapq.heapify operation and counting operations
     * are O(N)O(N), and each of kk heapq.heappop operations are O(\log {N})O(logN).
     *
     * Space Complexity: O(N)O(N), the space used to store our count.
     */
    public static List<String> topKFrequentpq(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
