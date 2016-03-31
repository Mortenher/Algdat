package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingProgram {
	
	/*
	 * Sorteringsalgoritmene har jeg ikke laget selv, tenkte jeg skulle gjøre dette senere.
	 */
	
	
	static int casenumber;
	public static final int 
	MAX_SEQUENTIAL = 100000;
	static int n;
	
	
	public static void insertionSort(int A[])
    {
	
	int n = A.length;
	int key;

	for (int i = 1; i < n; i++)
	{  
	    key = A[i];
	    int j = i;
	   
	    while (j > 0 && A[j-1] > key)
	    {
	    	A[j] = A[j-1];
	    	j--;
	    }
	    A[j] = key;
	}
    }
	
	public static void quickSort(int A[], int min, int max)
    {

	int indexofpartition;
	
	if (max - min  > 0)
	{
	    indexofpartition = findPartition(A, min, max);

	    quickSort(A, min, indexofpartition - 1);

	    quickSort(A, indexofpartition + 1, max);
	    
	}
    }
	
	
	private static int findPartition (int[] A, int min, int max)
    {
	int left, right;
	int temp, partitionelement;

	partitionelement = A[min]; 

	left = min;
	right = max;
   
	while (left < right)
	{
	    while (A[left] <= partitionelement && left < right)
		left++;

	    while (A[right] > partitionelement)
		right--;

	    if (left < right)
	    {
		temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	    }
	}
	
	temp = A[min];
	A[min] = A[right];
	A[right] = temp;
	
	return right;
    }
	
    public static void mergeSort (int[] A, int min, int max)
    {

	if (min==max)
	    return; 

	int[] temp;
	int index1, left, right;
	int size = max - min + 1;
	int mid = (min + max) / 2;

	temp = new int[size];
      
	mergeSort(A, min, mid); 
	mergeSort(A, mid + 1,max);

	for (index1 = 0; index1 < size; index1++)
	    temp[index1] = A[min + index1];
      
	left = 0;
	right = mid - min + 1;
	for (index1 = 0; index1 < size; index1++)
	{
	    if (right <= max - min)
		if (left <= mid - min)
		    if (temp[left] > temp[right])
			A[index1 + min] = temp[right++];
		    else
			A[index1 + min] = temp[left++];
		else
		    A[index1 + min] = temp[right++];
	    else
		A[index1 + min] = temp[left++];
	}
    }
	

    public static void radixSort(int[] input) {
    	  final int RADIX = 10;
    	  List<Integer>[] bucket = new ArrayList[RADIX];
    	  for (int i = 0; i < bucket.length; i++) {
    	    bucket[i] = new ArrayList<Integer>();
    	  }
    	 
    	  boolean maxLength = false;
    	  int tmp = -1, placement = 1;
    	  while (!maxLength) {
    	    maxLength = true;
    	    for (Integer i : input) {
    	      tmp = i / placement;
    	      bucket[tmp % RADIX].add(i);
    	      if (maxLength && tmp > 0) {
    	        maxLength = false;
    	      }
    	    }
    	    int a = 0;
    	    for (int b = 0; b < RADIX; b++) {
    	      for (Integer i : bucket[b]) {
    	        input[a++] = i;
    	      }
    	      bucket[b].clear();
    	    }
    	    placement *= RADIX;
    	  }
    	} 
    
    
    
	public static void main(String[] args) {
		
		
		int A[];
    	
    	long time = 0;
    	Random r = new Random();
    	String test_case = null;
    	String y = "y";
    	
		//Leser input fra bruker
		BufferedReader inn = new BufferedReader( new InputStreamReader(System.in) );
    	inn = new BufferedReader( new InputStreamReader(System.in) );
    	
        try {
        	System.out.println("Test av sorteringsmetoder");
        	System.out.print("Hvor stor vil du at arrayen med tall skal være? : ");
        	n = Integer.parseInt( inn.readLine() );
        	System.out.println("Hvilken metode vil du prøve? \nNr 1: Insertion Sort. \n"
        			+ "Nr 2: Quick Sort. \n"
        			+ "Nr 3: Merge Sort. \n"
        			+ "Nr 4: Radix Sort.");
        	casenumber = Integer.parseInt( inn.readLine() );
        	System.out.println("Vil du teste kjøringstid(y) eller arbeidsmengden(n)? Velg y eller n");
        	test_case = inn.readLine();
        	
        	
        }
        catch( Exception e ) {
        	System.err.println(e) ;
        }
		
       
        A = new int[n];
       //Switch case som velger hvilken type sortering som skal kjøres, og om man skal regne ut kjøringstid eller arbeidsmengde.
        switch(casenumber){
        	case 1: 
        		if(test_case.equals(y))
        		{
		        	if (n <= MAX_SEQUENTIAL)
		        	{
		        	    for (int i = 0; i < n; i++)
		        	    	A[i] = r.nextInt(n);
		        	    time = System.currentTimeMillis();
		        	    insertionSort(A);
		
		        	    time = System.currentTimeMillis() - time;
		        	    System.out.printf("Insertion sort\t: %6.3f s\n", time/1000.0); 
		        	}

		        	else
		        	    System.out.println("O(n^2) sorting too slow for large n");
        		}
        		else{
        			if(n <= MAX_SEQUENTIAL){
        				for (int i = 0; i < n; i++)
        			
	        	    	A[i] = r.nextInt(n);
	        	    time = System.currentTimeMillis();
	        	    double B; 	
	        	    
	        	    for(int i = 0; i < 5; i++){
	        	    	insertionSort(A);
	        	    }
	
	        	    time = System.currentTimeMillis() - time;
	        	    B = (double)(time/(n*n));
	        	    System.out.println("Insertion sort\t: " + B);
        			}
        			else
        				System.out.println("O(n^2) sorting too slow for large n");
        		}

        			break;
        	case 2: 
        		if(test_case.equals(y))
        		{
        			for (int i = 0; i < n; i++)
	            	    A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	
	            	quickSort(A, 0, n-1);
	                
	            	
	            	time = System.currentTimeMillis() - time;
	            	System.out.printf("Quicksort\t: %6.3f s\n", time/1000.0);
        		}
        		else{
        			for (int i = 0; i < n; i++)
	            	    A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	            	double C;
	
	            	for(int i = 0; i < 5; i++){
	            		quickSort(A, 0, n-1);
	        	    }
	            	
	                
	            	time = System.currentTimeMillis() - time;
	            	C = (double)(time/(n*(Math.log(n)/Math.log(2))));
	            	System.out.println("Quicksort\t: " + C);
        		}
	        		
        			break;
        	case 3: 
        		if(test_case.equals(y))
        		{
	        		for (int i = 0; i < n; i++)
	            	    A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	            	mergeSort(A, 0, n-1);
	                
	            	time = System.currentTimeMillis() - time;
	            	System.out.printf("Merge sort\t: %6.3f s\n", time/1000.0);
	                
	            }
        		else{
        			for (int i = 0; i < n; i++)
	            	    A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	            	double D;
	            	
	            	for(int i = 0; i < 5; i++){
	            		mergeSort(A, 0, n-1);
	        	    }
	            	
	                
	            	time = System.currentTimeMillis() - time;
	            	D = (double)(time/(Math.log(n)/Math.log(2)));
	                System.out.println("Merge sort\t: " + D);
        		}
        			break;
        	case 4: 
        		if(test_case.equals(y))
        		{
	        		for (int i = 0; i < n; i++)
	            	   A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	            	radixSort(A);
	                
	            	time = System.currentTimeMillis() - time;
	            	System.out.printf("RadixSort\t: %6.3f s\n", time/1000.0);
        		}
        		else{
        			
        			for (int i = 0; i < n; i++)
 	            	   A[i] = r.nextInt(n);
 	            	time = System.currentTimeMillis();
 	            	double E;
 	            	
 	            	for(int i = 0; i < 5; i++){
 	            		radixSort(A);
	        	    }
 	                
 	            	time = System.currentTimeMillis() - time;
 	            	E = (double)(time/n);
         			System.out.println("RadixSort\t: " + E);
        		}
        			break;
        	default: System.out.println("Velg en gyldig funksjon");
        			break;
    	}   
	}
}       
	
