# java-dsa-practice

[![CI](https://github.com/satvik31-hash/java-dsa-practice/actions/workflows/ci.yml/badge.svg)](https://github.com/satvik31-hash/java-dsa-practice/actions/workflows/ci.yml)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/projects/jdk/21/)

Data structures, algorithms and core Java, worked through one problem at a time.

Every solution is a plain static method with no console I/O, documented with its approach
and complexity, and covered by JUnit tests. Nothing here reads from `Scanner`, so the whole
repository is verifiable with a single command.

```bash
mvn test
```

## Layout

```
src/main/java/com/satvik/
├── dsa/                     # algorithm practice, by topic
│   ├── arrays/
│   ├── matrix/
│   └── recursion/
├── fundamentals/            # core language exercises
│   ├── basics/
│   └── concurrency/
└── projects/                # small OOP builds
    ├── bank/
    ├── familytree/
    └── library/

src/test/java/com/satvik/    # mirrors the tree above
```

## Problem index

### Arrays

| Problem | Approaches | Time | Space | Source |
|---|---|---|---|---|
| Missing number in `1..n` | Sum formula, XOR | O(n) | O(1) | [`MissingNumber`](src/main/java/com/satvik/dsa/arrays/MissingNumber.java) |
| Two Sum | Brute force, hash map | O(n²) / O(n) | O(1) / O(n) | [`TwoSum`](src/main/java/com/satvik/dsa/arrays/TwoSum.java) |
| Rotate array left by k | Reversal algorithm | O(n) | O(1) | [`RotateArray`](src/main/java/com/satvik/dsa/arrays/RotateArray.java) |
| Segregate 0s and 1s | Counting, two pointers | O(n) | O(1) | [`SegregateBinaryArray`](src/main/java/com/satvik/dsa/arrays/SegregateBinaryArray.java) |
| Element-wise sum / product / min / max | Single pass | O(n) | O(1) | [`ArrayOperations`](src/main/java/com/satvik/dsa/arrays/ArrayOperations.java) |

### Matrix

| Problem | Approach | Time | Space | Source |
|---|---|---|---|---|
| Sliding puzzle move | Locate blank, bounds-check, swap | O(n²) | O(1) | [`SlidingPuzzle`](src/main/java/com/satvik/dsa/matrix/SlidingPuzzle.java) |

### Recursion

| Problem | Approach | Time | Space | Source |
|---|---|---|---|---|
| Ancestors of a person | Depth-first walk up the parent edges, visited set guards cycles | O(V + E) | O(V) | [`FamilyTree.ancestorsOf`](src/main/java/com/satvik/projects/familytree/FamilyTree.java) |

### Core Java

| Topic | Source |
|---|---|
| Largest of three | [`MaxOfThree`](src/main/java/com/satvik/fundamentals/basics/MaxOfThree.java) |
| Reverse the digits of a number | [`ReverseNumber`](src/main/java/com/satvik/fundamentals/basics/ReverseNumber.java) |
| Count occurrences of a digit | [`DigitOccurrence`](src/main/java/com/satvik/fundamentals/basics/DigitOccurrence.java) |
| Fibonacci series | [`Fibonacci`](src/main/java/com/satvik/fundamentals/basics/Fibonacci.java) |
| Primality test | [`PrimeNumber`](src/main/java/com/satvik/fundamentals/basics/PrimeNumber.java) |
| Armstrong number | [`Armstrong`](src/main/java/com/satvik/fundamentals/basics/Armstrong.java) |
| Swapping values | [`Swap`](src/main/java/com/satvik/fundamentals/basics/Swap.java) |
| Switch expressions | [`DayOfWeek`](src/main/java/com/satvik/fundamentals/basics/DayOfWeek.java) |
| Declaring a package | [`Calculator`](src/main/java/com/satvik/fundamentals/basics/Calculator.java) |
| Threads via `Runnable` | [`RunnableDemo`](src/main/java/com/satvik/fundamentals/concurrency/RunnableDemo.java) |

### OOP builds

| Build | What it exercises | Source |
|---|---|---|
| Bank accounts | Abstract classes, inheritance, custom checked exceptions | [`projects/bank`](src/main/java/com/satvik/projects/bank) |
| Library catalogue | Encapsulation, package-private state changes, exceptions | [`projects/library`](src/main/java/com/satvik/projects/library) |
| Family tree | Adjacency maps, recursion, logic split from the CLI | [`projects/familytree`](src/main/java/com/satvik/projects/familytree) |

Each build has a `*App` class with a `main` method you can run directly.

## Roadmap

Topics still to cover, each landing under `src/main/java/com/satvik/dsa/`:

- [ ] `strings` — palindromes, anagrams, substring search
- [ ] `searching` — binary search and its variants
- [ ] `sorting` — bubble, insertion, merge, quick
- [ ] `recursion` — subsets, permutations, N-Queens
- [ ] `linkedlist` — reversal, cycle detection, merge
- [ ] `stack` / `queue` — monotonic stack, next greater element
- [ ] `tree` — traversals, height, lowest common ancestor
- [ ] `graph` — BFS, DFS, topological sort
- [ ] `dp` — knapsack, longest common subsequence

## Adding a problem

See [docs/ADDING_A_PROBLEM.md](docs/ADDING_A_PROBLEM.md). In short: one class per problem
holding a pure static method, a javadoc block naming the approach and complexity, and a
test class covering the normal case plus the edges.

## Running

```bash
mvn test                                              # run every test
mvn -Dtest=TwoSumTest test                            # run one test class
mvn compile exec:java -Dexec.mainClass=com.satvik.projects.bank.BankApp
```

Requires JDK 21 or newer.
