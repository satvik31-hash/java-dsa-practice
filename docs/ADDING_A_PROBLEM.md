# Adding a problem

The point of the structure is that a solution can be checked without a human reading
console output. Keep to these four rules and `mvn test` stays meaningful.

## 1. One class per problem, no I/O

The class is `final` with a private constructor, and the solution is a `static` method that
takes its input as arguments and returns a result. No `Scanner`, no `System.out` inside the
solution — printing belongs in a `main` or an `*App` class, if anywhere.

```java
package com.satvik.dsa.strings;

/**
 * <h2>Valid Palindrome</h2>
 *
 * <p>Return whether a string reads the same forwards and backwards, ignoring case and
 * anything that is not a letter or digit.
 *
 * <p><b>Approach:</b> two pointers walking in from both ends, skipping characters that
 * do not count. Comparing against a reversed copy would also work but allocates a second
 * string.
 *
 * <p>Time: O(n) &nbsp;|&nbsp; Space: O(1)
 */
public final class ValidPalindrome {

    private ValidPalindrome() {
    }

    public static boolean isPalindrome(String input) {
        // ...
    }
}
```

## 2. The javadoc carries the interview answer

State the problem, name each approach you implemented, say why you'd pick one over the
other, and give time and space complexity. When you revisit this in six months, that block
is the whole point of having written it down.

If you solved it more than one way, keep both as separate methods (`bruteForce`,
`usingHashMap`) and have the tests assert they agree. Being able to show the naive solution
and the improvement is worth more in an interview than only having the fast one.

## 3. A test class beside it, mirroring the package

`src/test/java/com/satvik/dsa/strings/ValidPalindromeTest.java`. Cover:

- the normal case from the problem statement
- the empty or single-element input
- the boundary values (first, last, largest, smallest)
- whatever input should be rejected, with `assertThrows`

Name the methods after the behaviour, and add `@DisplayName` with a readable sentence.

```java
@Test
@DisplayName("ignores punctuation and casing")
void ignoresPunctuationAndCasing() {
    assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
}
```

## 4. Update the index

Add a row to the table in [README.md](../README.md) and tick the roadmap item if the topic
is now started. One commit per problem, with a message saying what was solved and how:

```
Solve Valid Palindrome with two pointers
```

## Package map

| Package | Holds |
|---|---|
| `com.satvik.dsa.<topic>` | Algorithm practice, one class per problem |
| `com.satvik.fundamentals.<area>` | Language exercises, not algorithms |
| `com.satvik.projects.<name>` | Multi-class builds with an `*App` entry point |
