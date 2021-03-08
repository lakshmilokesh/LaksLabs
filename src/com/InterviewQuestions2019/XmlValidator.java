package com.InterviewQuestions2019;

import java.util.Stack;

//Airbnb

/*
 * Your input will be an ASCII string, and you will output a boolean, which indicates whether the string is valid xml.

We simplify the xml format to only have content or tags.

Content
Text which can contain any ascii characters EXCEPT < and >

Tags
Tags come in two flavors. < and > must only appear as the start and end of a tag, and the tags cannot be empty. I.e <> and </> are invalid.

The start-tag and end-tag elements must be correctly nested, with none missing and none overlapping. For example, text <a> text</a>, <a>text<b>other text</b></a> are valid, <a>text<b>other text</a></b> is not.

The goal of this question is to simulate an xml validator. We will give you sample xml text and you should output wheter the text is valid xml or not.

###Example input/output

Input
	text
Output
	true
Input
	text<a>more text</a>
Output
	true
Input
	text</a>
Output
	false
Input
	<invalid<>text</invalid>
Output
	false
 *
 *
 *
 */

// Space complexity : 0(tags)
// Runtime complexity : 0(n)

public class XmlValidator {

    Stack<String> stack = new Stack<>();
    private static String VALID = "Valid";
    private static String INVALID = "Invalid";

    public String isValid(String text) {

        if (text == null || text.isEmpty()) {
            return VALID;
        } else {
            for (int i = 0; i < text.length();) {

                if (text.startsWith("</", i)) {
                    int j = text.indexOf('>', i + 2);
                    // i+2 == j  => Empty tag </>
                    //stack.empty() => no start tag
                    // !stack.pop().equals(text.substring(i + 2, j)) => no matching tags example <a> .... </b>
                    if (i + 2 == j || stack.isEmpty() || !stack.pop().equals(text.substring(i + 2, j))) {
                        return INVALID;
                    } else {
                        i = j + 1;
                    }
                } else if (text.startsWith("<", i)) {
                    int j = text.indexOf('>', i + 1);
                    //Empty tag
                    if (i + 1 == j) {
                        return INVALID;
                    } else {
                        //push the content within the tag
                        stack.push(text.substring(i + 1, j));
                        i = j;
                    }
                } else {
                    i++;
                }
            }
        }
        return stack.isEmpty() ? VALID : INVALID;
    }
}
