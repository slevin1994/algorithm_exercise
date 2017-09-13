package chapter2;

import java.util.Comparator;

import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//1
public class my_Selection {
	
// 1
	public static void sort(Comparable[] a) {
		
		int N=a.length;
		for (int i=0;i<N;i++) {
			int min=i;
			for (int j=i+1;j<N;j++) {
				if(less(a[j],a[min]))
					min=j;
				exch(a,min,i);
			}
		}
	}
	
	/***************************************************************************
	    *  Helper sorting functions.
	    ***************************************************************************/
	    
	    // is v < w ?
	    private static boolean less(Comparable v, Comparable w) {
	        return v.compareTo(w) < 0;
	    }

	    // is v < w ?
	    private static boolean less(Comparator comparator, Object v, Object w) {
	        return comparator.compare(v, w) < 0;
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

	    // is the array a[] sorted?
	    private static boolean isSorted(Comparable[] a) {
	        return isSorted(a, 0, a.length - 1);
	    }
	        
	    // is the array sorted from a[lo] to a[hi]
	    private static boolean isSorted(Comparable[] a, int lo, int hi) {
	        for (int i = lo + 1; i <= hi; i++)
	            if (less(a[i], a[i-1])) return false;
	        return true;
	    }

	    // is the array a[] sorted?
	    private static boolean isSorted(Object[] a, Comparator comparator) {
	        return isSorted(a, comparator, 0, a.length - 1);
	    }

	    // is the array sorted from a[lo] to a[hi]
	    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
	        for (int i = lo + 1; i <= hi; i++)
	            if (less(comparator, a[i], a[i-1])) return false;
	        return true;
	    }



	    // print array to standard output
	    private static void show(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            StdOut.println(a[i]);
	        }
	    }

	    /**
	     * Reads in a sequence of strings from standard input; selection sorts them; 
	     * and prints them to standard output in ascending order. 
	     *
	     * @param args the command-line arguments
	     */
	    public static void main(String[] args) {
	        String[] a = StdIn.readAllStrings();
//	    	String[] a=In.readStrings(args[0]);
//	    	String[] a= {"o","j","g","t","d","s","a"};
	        my_Selection.sort(a);
	        show(a);
	    }

}
