//Given two 1d vectors, implement an iterator to return their elements alternately.

//For example, given two 1d vectors:

//v1 = [1, 2]
//v2 = [3, 4, 5, 6]
//By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

//Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

//Clarification for the follow up question - Update (2015-09-18):
//The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

//[1,2,3]
//[4,5,6,7]
//[8,9]
//It should return [1,4,8,2,5,9,3,6,7].



public class ZigzagIterator {
	Iterator<Integer> a,b,temp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
       	a = v1.iterator();
       	b = v2.iterator();
    }

    public int next() {
        if(a.hasNext()){
	        temp = a;
	        a = b;
	        b = temp;
        }
        return b.next();
    }

    public boolean hasNext() {
        return a.hasNext()||b.hasNext();
    }
}


//Follow up (for K lists)
public class ZigzagIterator {
    Queue<Iterator> list = new LinkedList<>();

    public ZigzagIterator(List<List<Integer>> lists) {
        for(List<Integer> a:lists){
            if(!a.isEmpty()) list.offer(a.iterator());
        }
    }

    public int next() {
        Iterator<Integer> a = list.poll();
        int n = a.next();
        if(a.hasNext()) list.offer(a);
        return n;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */