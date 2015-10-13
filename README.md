Variable Length Encoding
========================

Introduction
------------

On a digital computer, all information is ultimately represented as a
sequence of binary digits, or {\\em bits}. Zeroes and ones. The field of
lossless data compression involves ways to minimize the number of bits
required to represent an input data collection without losing any of the
information.

Consider a long DNA chain stored in a file. DNA can be represented as a
sequence of four nucleobases: guanine (G), adenine (A), thymine (T), and
cytosine (C). The DNA chain is a sequence such as: ACTCGAA... Since
there are are four different nucleobases, on a computer we might use two
bits to represent each nucleobase as in the table below:

  --------------------- ---------------------------
  Symbol (Nucleobase)   Codeword (Representation)
  A                     00
  C                     01
  G                     01
  T                     11
  --------------------- ---------------------------

The above is an example of what is known as a *fixed length code*. Every
symbol (nucleobase) is encoded using a codeword (representation) of
length 2 bits. For example, the sequence ACTCGAA would be encoded with
the bits 00011101100000.

The drawback of fixed length codes is that they don't exploit the
relative frequencies of the symbols that are being encoded. Imagine that
in DNA the symbol A occurs 50% of the time, symbol C occurs 25% of the
time, symbol G occurs 15% of the time, and symbol T occurs 10% of the
time. A fixed length code would still use 2 bits for every symbol.

We could do better, however. Consider the following encoding of the DNA
symbols:

  --------------------- ---------------------------
  Symbol (Nucleobase)   Codeword (Representation)
  A                     1
  C                     01
  G                     001
  T                     000
  --------------------- ---------------------------

This code is referred to as a *variable length code*. Different symbols
have different length codewords. The basic idea behind variable length
coding is that if we assign short codewords to symbols that occur more
frequently, and longer codewords to symbols that occur less frequently,
we can arrive at an overall encoding that uses fewer expected bits than
if we just used fixed length coding. We have to be careful to choose
codewords that allow a unique decoding (there can never be uncertainty
as to which symbol occurred - we have to be sure where each symbol's
code ends), but that will not be a concern for this lab.

The example DNA chain above would be encoded as 1010000100111, using 13
bits instead of 14. This particular input works out to an average of
`13 / 7 = 1.86` bits per symbol, as opposed to `14 / 7 = 2` bits per
symbol for the fixed length code.

You likely are using variable length coding every day without even
knowing it. When you use a tool such as WinZip to generate a `.zip`
file, variable length coding is used to shrink your files. Every time
you take a picture with your iPhone, variable length coding is used to
generate your `.jpg` file.

In this lab, you will write a program that reads an input file full of
symbols, and computes a variable length code to represent the symbols.

### A Variable Length Coding Algorithm

The variable length coding algorithm we'll be interested in for this lab
is given by the following pseudocode:

>             For each symbol, create a leaf node that contains information
>                 for that symbol, in particular its name and frequency.
>
>             Put these nodes into a collection
>
>             While there remains more than one node in the collection
>                 Identify the node, n1, with the lowest frequency
>                 Identify the node, n2, with the second lowest frequency
>        
>                 Remove those nodes from the collection
>                 
>                 Create a new node with the following properties:
>                     1) its symbol name is arbitrary
>                     2) its frequency is equal to the combined frequency of n1 and n2
>                     3) its left child is n1
>                     4) its right child is n2
>          
>                 Add this node back into the collection
>         
>             At this point, the remaining node is the root of a binary tree that
>                 can be used to determine the codeword for each symbol. 
>
>             The codeword for a symbol is determined by following the path from 
>                 the root node to the leaf node representing that symbol.
>
>             The codeword starts out as the empty string.
>
>             Each time the path follows to the left child, a `0' is appended to the codeword.
>       
>             Each time the path follows to the right child, a `1' is appended to the codeword.
>         

### Example

The DNA example above is illustrated graphically below. Initially, four
leaf nodes are created and put into a collection. Each leaf node
contains a symbol name and its frequency.

![image 01](https://www.cs.rit.edu/~csci242/Labs/07/vlc-01.jpg)

After one iteration, the two least frequently occurring nodes have been
removed from the collection, and a new node replaces them. The new node
has an arbitrary name (not shown) and a frequency equal to the combined
frequency of the two replaced nodes. It also has a left reference to the
least frequently occurring node (corresponding to symbol T) and a right
reference to the second least frequently occurring node (corresponding
to symbol G).

![image 02](https://www.cs.rit.edu/~csci242/Labs/07/vlc-02.jpg)

Again the two least frequently occurring nodes in the collection are
combined. Note that leaf nodes for T and G are not part of the
collection anymore. Instead, their parent node is part of the
collection. Also note that when selecting nodes, ties in cumulative
frequency can be broken arbitrarily. In this case, the node that is the
parent of both G and T is chosen as the least frequently occurring node.
The leaf node for symbol C is chosen as the second least frequently
occurring node. These two nodes are removed from the collection, and a
new node replaces them.

![image 03](https://www.cs.rit.edu/~csci242/Labs/07/vlc-03.jpg)

Finally, the last two remaining nodes are combined, and all that remains
is a single node that is the root of a binary tree containing all of the
original symbol leaf nodes. Labels (0's and 1's) can be put along each
branch, and a path from root node to leaf can be followed to determine
the codeword for each symbol.

![image 04](https://www.cs.rit.edu/~csci242/Labs/07/vlc-04.jpg)

### Problem-Solving Session

1.  Using the described variable length coding algorithm, and the
    provided work sheet, draw the step-by-step construction of the
    codewords for the following input data:
    ![image 06](https://www.cs.rit.edu/~csci242/Labs/07/vlc-06.jpg)
2.  Write a class definition for your symbol object class. What
    `instance variables` do you need? Then write a constructor which
    takes as input parameters a symbol name (a character) and its
    frequency and returns a completely initialized symbol object.
3.  Describe how you will represent a single node. (i.e. what data
    structure or construct will you use?) Indicate specically where the
    cumulative frequency and symbol object list information will reside
    in the node structure.
4.  Given how the nodes are removed and replaced in the variable length
    coding algorithm, what data structure will you use to store the
    collection of nodes?
5.  Write code for a `compareTo` method which satisfies the specication
    for Comparable Objects (returns -1, 0, 1). Your function should be
    consistent with your choice of how to represent a node in question
    3.

### Implementation and Write-Up

Use the supplied
[`ArrayHeap.java`](https://www.cs.rit.edu/~csci242/Labs/07/ArrayHeap.java)
code to help you implement your solution. Also consider incorporating
your pseudocode from the problem-solving.

*NOTE: You do not need to modify the `ArrayHeap.java` file, nor will you
be submitting it. The heap data structure can contain objects other than
numbers as its nodes. The only thing you need to do in order to make it
work with more complicated objects is to provide an appropriate
` compareTo()` function that knows how to order the objects. This
function should be part of your submitted solution file ` VLC.java` - do
not add it to the existing `ArrayHeap.java file`.*

In addition to the functions you wrote in problem-solving, you will need
functions to:

1.  Read the input file and store the symbols and their frequencies.
2.  Take your symbol frequency information and build an initial heap.
3.  Display the appropriate output described below.

### REQUIREMENTS

Name your program ` VLC.java`. Your program should prompt the user for
the name of an input file containing the symbols from which you will
generate a code. Every character of the file (other than whitespace
beginning a line and a new line character at the end of a line that can
be removed) should be treated as a symbol.

The `compareTo()` function will order based on the following criteria:
first - frequency, second - number of characters in node, third -
ordinal value of the first character in the list.

For output, your program should generate a print display of all of the
symbols and their frequencies, as well as the codewords determined by
your program.

Additionally, it should compute and display the average codeword length
used by your variable length code, as well as the average codeword
length that would be required by a fixed length code applied to the
input symbols.

Here is an example of running the program (Note: This example does not
follow the required `compareTo()` specifications. Do not use these codes
as "answers".):

>             $ java VLC
>             Please enter symbol filename: ex1.txt
>
>             Variable Length Code Output
>             ----------------------------------------
>             Symbol:  T  Codeword:      000  Frequency:    10
>             Symbol:  G  Codeword:      001  Frequency:    15
>             Symbol:  C  Codeword:       01  Frequency:    25
>             Symbol:  A  Codeword:        1  Frequency:    50
>
>             Average VLC codeword length:  1.75 bits per symbol
>             Average Fixed length codeword length:  2.00 bits per symbol
>         

There are several things to note about the output:

1.  The exact codeword you generate for a given symbol may be different
    than the example above (it was generated without the correct
    ` compareTo()` method). Be sure to correctly implement the
    `compareTo()` in order to have a predictable ordering.
2.  You can format a print statement so that a given string (i.e. the
    codeword) or integer (i.e. the frequency) is displayed
    right-justified in a specified number of spaces. See Javadocs for
    `System.out.printf()`.
3.  The average vlc codeword length is computed by summing the total
    number of bits required to represent all of the symbols, and
    dividing by the total number of symbols represented.
4.  The average fixed length codeword length is computed using the
    following formula:

        avg_fixed_length_codeword = log(total_different_symbols, 2)

    You will need to import the `java.lang.Math` module to access the
    `log` function.

### Grading

The *individual* grade will be based on the following:

1.  *Functionality 75%*
    -   15% Reading the input file and generating a collection of
        symbols and frequencies.
    -   15% Creating a heap from the initial symbol and frequency
        information.
    -   30% Implementing the variable length coding algorithm to build a
        binary tree representing the codeword for each symbol.
    -   15% Generating output including the listing of all symbols and
        their associated frequency and codeword, as well as the average
        codeword length for both the variable length code as well as a
        fixed length code.

2.  *Style and Documentation 5%*
    Your program must conform to style and documentation guidelines for
    the course.

### Submission

Submit your `VLC.java` file to "try" with the following command:

>             try grd-242 lab7-1 VLC.java [other files]
>         

\

