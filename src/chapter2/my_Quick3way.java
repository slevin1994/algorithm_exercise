package chapter2;
/******************************************************************************
 *  Compilation:  javac Quick3way.java
 *  Execution:    java Quick3way < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/23quicksort/tiny.txt
 *                http://algs4.cs.princeton.edu/23quicksort/words3.txt
 *   
 *  Sorts a sequence of strings from standard input using 3-way quicksort.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Quick3way < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *    
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *  
 *  % java Quick3way < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *  The {@code Quick3way} class provides static methods for sorting an
 *  array using quicksort with 3-way partitioning.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class my_Quick3way {

    // This class should not be instantiated.
    private my_Quick3way() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    //my
//    private static void sort(Comparable[] a, int lo, int hi) { 
//    	//lo~lt-1 	xiao
//    	//lt~i		xiangdeng
//    	//i+1~gt-1	daiding
//    	//gt~hi	da
//    	
//       if(lo>=hi) {
//    	   return;
//       }
//    	int N=a.length;
//       
//       int i=lo,lt=lo, gt=hi+1;
//       Comparable st=a[lo];
//       
//       while(i<gt){
//    	   while(a[i].compareTo(st)>0) {
//    		   exch(a,i,--gt);//�൱������
//    		   if(gt<=i) break;
//    		   
//    	   }
//    	   if(a[i].compareTo(st)<0) {
//    		   
//    		   exch(a,i++,lt++);
//    	   }else {
//    		   i++;
//    	   }
//    	       	   
//       }
//       
//       sort(a, lo, lt-1);
//       sort(a, gt, hi);
//
//    }
   //book
  private static void sort(Comparable[] a, int lo, int hi) { 
	  //lo~lt
	  //lt+1~i
	  //
	  //gt~hi
	if(hi<=lo) return;
	int lt=lo,i=lo+1,gt=hi;
	Comparable v=a[lo];
	while(i<=gt) {
		int cmp=a[i].compareTo(v);
		if(cmp<0)
			exch(a,i++,lt++);
		else if(cmp>0)
			exch(a,i,gt--);
		else
			i++;
	}
	sort(a,lo,lt-1);
	sort(a,gt+1,hi);

}
    



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }



    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; 3-way
     * quicksorts them; and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        my_Quick3way.sort(a);
        show(a);
    }

}

/******************************************************************************
 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
