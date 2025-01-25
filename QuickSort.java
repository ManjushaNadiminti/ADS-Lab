import java.util.*;
public class QuickSort {
	public static int partition(int[]a,int low,int high) {
		int pivot=a[low];
		int i = low+1;
		int j = high;
		while(i<=j) {
			while(i<=j && a[i]<=pivot)
				i++;
		    while(i<=j && a[j]>=pivot)
		    	j--;
		    if(i<j)
		    	interchange(a,i,j);
	    }
	    interchange(a,j,low);
	    return j;
    }
    public static void interchange(int[]a,int i,int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    public static void quicksort(int[]a,int low,int high) {
    	if(low < high) {
    		int j = partition(a,low,high);
    	    quicksort(a, low, j-1);
    	    quicksort(a, j+1, high);
    		}
    	}
        public static void main(String args[]) {
        	Scanner  scanner = new Scanner(System.in);
        	System.out.println("enter no.of elements:");
        	int n = scanner.nextInt();
        	int [] array = new int[n];
        	System.out.println("enter elements of array:");
        	for(int i = 0; i < n; i++) {
        		array[i] = scanner.nextInt();
        	}
        	quicksort(array,0,array.length-1);
        	System.out.println("sorted array:");
        	for(int num : array) {
        		System.out.print(num + "");
        	}
        	scanner.close();
        }
   }     
    
	 
