---

# Final Coding Part (15 points)
---
## Part 1: Iterators (8 points)
In this part of the PA, you need to implement two iterators, one for BST, one for heap. You should put your implementation in the files `BST.java` and `Heap.java` already provided for you in the starter code. The iterator for BST should return elements in ascending order (in-order traversal). The iterator for heap should return elements in descending order if given the Java default `compareTo()` as the comparator. Make sure that after you finish implementing the iterator, you will be able to traverse through the elements in the BST or heap with a for-each loop. You are free to use any methods provided in any of the starter code files, and declare constructors and instance variables as you see fit, but you cannot use any Java built-in data structures or functions, or change parts of the BST or heap that do not belong to the iterator implementations.

## Part 2: Get Overall Ranking (7 points)
Suppose you want to compile the product information from several different stores. Each store already ranked their product by price from high to low and put the sorted price in a singly linked list. You get `lists` from the stores as input, which is several lists of sorted price information. Your task is to create another singly linked list, containing all elements from the input, that is also sorted in descending order. You should complete this part in `getOverallRanking(ListNode lists)` in `Solution.java`, using one of the data structures provided in the starter code. The return value of `getOverallRanking()` should be the first node of the combined linked list. You can assume that both the input and output linked lists have a dummy node at the front. You are free to use any methods provided in any of the starter code files, but you cannot use any Java built-in data structures or functions, and you should not modify the `ListNode` class in `Solution.java`. You can submit additional files, but they are not necessary for completing this task.

## Testing
We provided you with `IteratorTest.java` and `SolutionTest.java` so you can test your implementation locally. Even though you are not allowed to use Java built-in data structures or functions in the implementation part, you are free to use those for testing. Here are the sanity tests you can see on Gradescope:

- heapIteratorSanityTest: The following integers are added to the heap in this order: 76, 10, 34, 55, 3. Then we iterate through all elements in the heap by calling `next()` repeatedly, and check if the numbers appear in this order: 76, 55, 34, 10, 3.
- BSTIteratorSanityTest: The following integers are added to the BST in this order: 76, 10, 34, 55, 3. Then we iterate through all elements in the BST by calling `next()` repeatedly, and check if the numbers appear in this order: 3, 10, 34, 55, 76.
- SolutionSanityTest: Suppose you have the price information from two stores, both sorted. One is {99, 80, 75}, the other is {88, 74, 63}. You expect to get {99, 88, 80, 75, 74, 63} as the combined output list.

## Submission
You only need to submit the following three files:
- BST.java
- Heap.java
- Solution.java

For other files that are needed for your code to compile, we will use those that are provided in your starter code, which means that you should not modify them. If you have additional files that you create in order for your code to work, submit them along with the above three files.

## Grading
Your submission will first be graded automatically. If you did not get points from the test cases, we will manually grade your submission to give you partial credit accordingly.
