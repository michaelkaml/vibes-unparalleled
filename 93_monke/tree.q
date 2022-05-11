Big Bird :: Raven (Ruiwen) Tang, Jun Hong Wang, Michael Kamela
APCS pd6
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent: 0.5 hrs


DISCO
------------------------------------------------
* In a pre order traversal, each node is processed before its left child is processed. After the left child is processed (and all of its children/grandchildren/etc. are processed), the right child (and its children/grandchildren/etc.) are processed. At each node, the same order is followed: current, left, right.
* In a post order traversal, each node is processed after its children (and their children/grandchildren/etc.). At each node, the same processing order is followed: left, right, current.
* In an in order traversal, each node is processed in between its children (and their children/grandchildren/etc.). At each node, the same processing order is followed: left, current, right.
* First node in a pre order traversal is root
* Last node in a post order traversal is root
* First node in a post traversal is "leftmost" node (as many lefts as you can take from the root)
================================================


QCC
------------------------------------------------
* Is a tree uniquely determined, given at least two of the three following: pre order traversal, in order traversal, post order traversal?
* A linked list, when thought of as a tree, can also be traversed. This traversal seems to fall under a pre order traversal, since nodes are processed before their children, espeically if its a singly linked list.
* When referring to a "tour" of a tree, are we considering processing each node or visiting each node? 
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
Down

Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.
A graph which may be traversed through a closed/open tour.
Not sure about any other definitions?

Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
Not sure about this one

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
Not sure about this one

Is a perfect tree complete? 
Yes, a perfect tree is complete, as it fulfills the requirement of every level being fulfilled in and does not even need the exception for the bottom. 

Is a complete tree balanced? 
Yes, a complete is balanced, because only the bottom level may not be completely filled in, which means there is at most a difference of 1 between left and right subtrees of all nodes.

Is the Man Who Is Tall Happy?
Not necessarily

What must be true of perfect trees but not others?
The total number of nodes is 2^(# of levels + 1)
================================================


C'EST POSSIBLE?
------------------------------------------------
Pre order: EGDKINLOW
In order: EKDNIOLWG

			E
				\G
			D/		\I
		K/		N/		\L
					O/		\W
Here is the tree that we determined, where each level is represented by a new line, and left/right childness is indicated by left/right tabs.
E must be the root as it is the first node in the pre order traversal. It cannot have any left children, as E is also the first node in the in order traversal. 
Therefore, G must be its right child, following the pre order traversal.
We see DK are in reverse orders in pre order and in order, so K should be the left child of D, with D being the left child of G.
IN are also in reverse orders in pre order and in order, so N should be the left child of I, with I being the right child of G.
OL are also in reverse orders in pre order and in order, so O should be the left child of L, with L being the right child of I.
W is the last in pre order traversal, so it should be the rightmost node.

Seems possible!
================================================


