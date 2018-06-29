package com.googleMF;

/*
 * TinyURL is a URL shortening service where you enter a URL
 * such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your
 * encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the
 * tiny URL can be decoded to the original URL.
 *
 * Performance Analysis
 * The number of URLs that can be encoded is limited by the range of \text{int}int, since \text{hashCode}hashCode
 * uses integer calculations.
 *
 * The average length of the encoded URL isn't directly related to the incoming \text{longURL}longURL length.
 *
 * The \text{hashCode()}hashCode() doesn't generate unique codes for different string. This property of getting the
 * same code for two different inputs is called collision. Thus, as the number of encoded URLs increases, the
 * probability of collisions increases, which leads to failure.
 *
 * The following figure demonstrates the mapping of different objects to the same hashcode and the increasing
 * probability of collisions with increasing number of objects.
 *
 *
 *
 * AMAZON/ FB/ UBER
 */

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURL {
    Map<Integer, String> map = new HashMap<>();

    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

}
