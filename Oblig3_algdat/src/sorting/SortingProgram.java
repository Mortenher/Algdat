package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingProgram {
	
	
	static int casenumber;
	public static final int 
	MAX_SEQUENTIAL = 100000,
	MAX_N = 100000000;
	static int n;
	
	
	public static void insertionSort(int A[])
    {
	// Innstikksortering av array med heltall

	int n = A.length;
	int key;

	for (int i = 1; i < n; i++)
	{
	    // A er sortert t.o.m. indeks i-1
	    key = A[i];
	    int j = i;
	    // Setter element nummer i på riktig plass
	    // blant de i-1 første elementene
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
		
	// Quicksort av array med heltall

	int indexofpartition;
	
	if (max - min  > 0)
	{
	    // Partisjonerer array
	    indexofpartition = findPartition(A, min, max);

	    // Sorterer venstre del
	    quickSort(A, min, indexofpartition - 1);

	    // Sorterer høyre del
	    quickSort(A, indexofpartition + 1, max);
	    
	    
	  
	}
    }
	
	
	private static int findPartition (int[] A, int min, int max)
    {
	int left, right;
	int temp, partitionelement;

	// Bruker *første* element til å dele opp
	partitionelement = A[min]; 

	left = min;
	right = max;
   
	// Gjør selve partisjoneringen
	while (left < right)
	{
	    // Finn et element som er større enn part.elementet
	    while (A[left] <= partitionelement && left < right)
		left++;

	    // Finn et element som er mindre enn part.elementet
	    while (A[right] > partitionelement)
		right--;

	    // Bytt om de to hvis ikke ferdig
	    if (left < right)
	    {
		temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	    }
	}
	

	// Sett part.elementet mellom partisjoneringene
	temp = A[min];
	A[min] = A[right];
	A[right] = temp;
	
	// Returner indeksen til part.elementet
	return right;
    }
	
    public static void mergeSort (int[] A, int min, int max)
    {

	// Flettesortering av array med heltall

	if (min==max)
	    return; 

	int[] temp;
	int index1, left, right;
	int size = max - min + 1;
	int mid = (min + max) / 2;

	temp = new int[size];
      
	// Flettesorterer de to halvdelene av arrayen
	mergeSort(A, min, mid); 
	mergeSort(A, mid + 1,max);

	// Kopierer array over i temp.array
	for (index1 = 0; index1 < size; index1++)
	    temp[index1] = A[min + index1];
      
	// Fletter sammen de to sorterte halvdelene over i A
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
    	  // declare and initialize bucket[]
    	  List<Integer>[] bucket = new ArrayList[RADIX];
    	  for (int i = 0; i < bucket.length; i++) {
    	    bucket[i] = new ArrayList<Integer>();
    	  }
    	 
    	  // sort
    	  boolean maxLength = false;
    	  int tmp = -1, placement = 1;
    	  while (!maxLength) {
    	    maxLength = true;
    	    // split input between lists
    	    for (Integer i : input) {
    	      tmp = i / placement;
    	      bucket[tmp % RADIX].add(i);
    	      if (maxLength && tmp > 0) {
    	        maxLength = false;
    	      }
    	    }
    	    // empty lists into input array
    	    int a = 0;
    	    for (int b = 0; b < RADIX; b++) {
    	      for (Integer i : bucket[b]) {
    	        input[a++] = i;
    	      }
    	      bucket[b].clear();
    	    }
    	    // move to next digit
    	    placement *= RADIX;
    	  }
    	} 
    
    
    
	public static void main(String[] args) {
		
		
		int A[];
    	
    	long time = 0;
    	Random r = new Random();
    	
		
		BufferedReader inn = new BufferedReader( new InputStreamReader(System.in) );
    	inn = new BufferedReader( new InputStreamReader(System.in) );
    	
        try {
        	System.out.println("Test av sorteringsmetoder");
        	System.out.print("Hvor stor vil du at arrayen med tall skal v�re? : ");
        	n = Integer.parseInt( inn.readLine() );
        	System.out.println("Hvilken metode vil du pr�ve? \nNr 1: Insertion Sort. \n"
        			+ "Nr 2: Quick Sort. \n"
        			+ "Nr 3: Merge Sort. \n"
        			+ "Nr 4: Radix Sort.");
        	casenumber = Integer.parseInt( inn.readLine() );
        	
        }
        catch( Exception e ) {
        	System.err.println(e) ;
        }
		
       
        A = new int[n];
       
        switch(casenumber){
        	case 1: 
		        	if (n <= MAX_SEQUENTIAL)
		        	{
		
		        	    for (int i = 0; i < n; i++)
		        	    	A[i] = r.nextInt(n);
		        	    time = System.currentTimeMillis();
		        	    double B; 	
		        	    insertionSort(A);
		
		        	    time = System.currentTimeMillis() - time;
		        	    B = (time/(n*n));
		        	    System.out.printf("Insertion sort\t: %6.3f s\n", time/1000.0); 
		        	    System.out.println("Insertion sort\t: " + B);
		        	}
		        	else
		        	    System.out.println("O(n^2) sorting too slow for large n");
        			break;
        	case 2: 
	        		for (int i = 0; i < n; i++)
	            	    A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	            	double C;
	
	            	quickSort(A, 0, n-1);
	                
	            	
	            	time = System.currentTimeMillis() - time;
	            	C = (time/(n*Math.log(n)));
	            	System.out.printf("Quicksort\t: %6.3f s\n", time/1000.0);
	            	System.out.println("Quicksort\t: " + C);
        			break;
        	case 3: 
	        		for (int i = 0; i < n; i++)
	            	    A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	            	double D;
	            	mergeSort(A, 0, n-1);
	                
	            	time = System.currentTimeMillis() - time;
	            	D = (time/(n*Math.log(n)));
	            	System.out.printf("Merge sort\t: %6.3f s\n", time/1000.0);
	                System.out.println("Merge sort\t: " + D);
        			break;
        	case 4: 
	        		for (int i = 0; i < n; i++)
	            	   A[i] = r.nextInt(n);
	            	time = System.currentTimeMillis();
	            	double E;
	            	radixSort(A);
	                
	            	time = System.currentTimeMillis() - time;
	            	E = (time/n);
	            	System.out.printf("RadixSort\t: %6.3f s\n", time/1000.0);
        			System.out.println("RadixSort\t: " + E);
        			break;
        	default: System.out.println("Velg en gylding funksjon");
        			break;
    	}
        
        
        
        
    	
        /*try
    	{
    	   //  if (args.length != 1)
    		//  throw new IOException("Please provide one integer");
    	  //   n = Integer.parseInt(args[0]);
    	     if (n < 0 || n > MAX_N)
    		  throw new IOException("Illegal value of n: " + n +
                                          ". Use  0 < " + n + " < " + MAX_N);
           	}
            catch (Exception e)
    	{
    	    System.err.println(e);
    	    System.exit(1);
    	}*/
        
        
	}
}       
	
