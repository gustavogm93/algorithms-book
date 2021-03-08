package com.AlgorithmsBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class pagesRange0_75 {

	static int suma = 0;
	public static void main(String[] args) {

	}	

	/**
	 * Shuffle Barajada
	 * 
	 */
	public static void shuffle(int[] a)
	{
	 int N = a.length;
	 for (int i = 0; i < N; i++)
	 { 
		 Random ran = new Random();
	 int r = i + ran.nextInt(N-i);
	 int temp = a[i];
	 a[i] = a[r];
	 a[r] = temp;
	 }
	 
	 for(int k: a) {
		 System.out.format("%s, ", k);
	 }
	}
	
	
	/**
	 * Calculo de frecuencias de suma de lados en 5 tiradas de Dado 
	 * 
	 */
	public static void dadosX5() {
		int SIDES = 6;
		double[] dist = new double[5 * SIDES + 1];
		
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) 
				for(int k=1 ; k <= SIDES; k++)
					for(int m=1 ; m <= SIDES; m++)
						for(int n=1 ; n <= SIDES; n++)
				dist[i + j + k + m + n ] += 1.0;
				//System.out.format("i:%s & j:%s \n", i, j);
		
		}
		int index = 0;
		for(double a: dist)
		{
			System.out.println(a + " NUMERO " + index);
			index++;
		}
		System.out.println("-------");
		for (int k = 5; k <= 5 * SIDES; k++) {
			dist[k] /= 180.0;
		}

		for(double a: dist)
			{
			System.out.println(a + " ");
			}	
		}
	/**
	 * Suma de posiblidades reducidas a 6 por tiro
	 *  Lados : [1,2,3,4,5,6]
	 *  Valores: [0,0,2.. 6, 5...1]
	 */
	public static void dados() {
		int SIDES = 6; // Lados de Cuadrado
		double[] dist = new double[2 * SIDES + 1]; // 2 * Lados + 1 -> +1 porque el min lado del cuadrado = 1
													// y la suma deberia ser 1 + 1 =2
		for (int i = 1; i <= SIDES; i++) {          //Cada For Each es un lado 

			for (int j = 1; j <= SIDES; j++) {     //Primera suma es i:1 + j:1 es = 2 porque no existe el min es 1 x lado.
				dist[i + j] += 1.0;                //Se suma las posibilidades
			}
		}
		int index = 0;
		for (double a : dist) {                       
			System.out.println(a + " NUMERO " + index);  
			index++;
		}
		System.out.println("-------");
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
		}

		for (double a : dist) {
			System.out.println(a + " ");
		}

	}

	/**
	 *  Print in random Order
	 */
	public static void printInRandomOrder(int[]ar) {
	
		int size = ar.length;
		Random ran = new Random();
		for(int i = size; i>1; i--) {
			
			int random = ran.nextInt(i);
			
			int temp = ar[i - 1];
			ar[i - 1] = ar[random];
			ar[random] = temp;

			System.out.format(ar[i -1] + " ");
		} 
	}

	
	/**
	 * QuickSort logarithm method 
	 * 
	 * @param ar ->array
	 * @param lo ->start partition
	 * @param hi ->end partition
	 */
	public static void quicksort(int[]ar, int lo, int hi, String direction) {

		if(lo >= hi)
		return;
		
		System.out.println("Block " + direction);
		
		int key = getPartition(ar, lo, hi);
		System.out.format("Key index: %d, Key value %d \n", key, ar[key]);
		System.out.println("-------------------------------");
		quicksort(ar, lo, key - 1, "left");
		quicksort(ar, key + 1, hi, "right");
		
	}
	
	public static int getPartition(int[]ar, int lo, int r) {
		
		int pivot = ar[r];
		int i = lo - 1;
		System.out.println("-.-.-.-.-.-.--.-");
		printQuickSort(ar, -1,0, lo , r );
		System.out.println("-initial:-");
		
		
		for(int j=lo; j<r;j++) {
			
			if(ar[j] < pivot) {
				printQuickSort(ar, i + 1, j, lo, r);	
			i += 1;
			
			int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
			}
		}
		printQuickSort(ar, i+1, r, lo, r);
		int temp = ar[i + 1];
        ar[i + 1] = ar[r];
        ar[r] = temp;
        printQuickSort(ar, -1, 0,lo,r);
		return i + 1;
	}

	
	public static void printQuickSort(int []ar, int ind, int j, int lo, int r ) {
	
		StringBuilder stringB =  new StringBuilder();
		stringB.append(String.format("["));

		for(int i=lo; i<r +1 ; i++) {
		
			if(ind == -1) {
				stringB.append(String.format(" %d," , ar[i]));
			continue;	
			}
			
			if(ar[i] == ar[ind] && i == ar[j])
			 {
				stringB.append(String.format(" %d: %s," , ar[i], "$I/J"));
			}
			else if(ar[i] == ar[j]) {
				stringB.append(String.format(" %d: %s," , ar[i], "$J"));
			}
			
			else if(ar[i] == ar[ind]){ 
				stringB.append(String.format(" %d: %s," , ar[i], "$I"));
			}else {
				stringB.append(String.format(" %d," , ar[i]));
			}

		}
		
		String apprendResult = stringB.toString();
		String resultFinal = apprendResult.substring(0, apprendResult.length() -1) + "]"; 
			
		System.out.println(resultFinal);
	}
	
	/**
	 * middle number
	 */
	public static double e_1_1_34(double [] a) {
		
		int size = a.length;
		if(size % 2 != 0)
		return a[((size) / 2)];
		
		else
		return (a[(size / 2 ) - 1] + a[size / 2]) / 2;
	}

	
	/**
	 * Matrix Matrix product
	 */
	public static void e1_1_33Traspase(int [][] a) {
		int[][] b = new int[a[0].length][a.length];
		
		for(int i=0; i<a.length; i++) {
			
			for(int j=0; j<a[0].length; j++) {
	
				b[j][i] = a[i][j];
				
			}
		}
	
		for(int i=0; i<b.length; i++) {
			
			for(int j=0; j<b[0].length; j++) {
				System.out.print(b[i][j] + " ");
				
			}
			System.out.print("\n");
		}
	}

	/**
	 * vector product dot
	 * get angle of two vectors
	 * 3D z , x , y 
	 */
	public static void e1_1_33(int[] vector1, int[] vector2) {
		
		
		
		
	double result = getAngle(multiplyVectors(vector1, vector2), getVectorLength(vector1, vector2));
		
	System.out.print(result);
	}

	
	public static double getAngle(double vMultyple,double vLenght) {

		return Math.toDegrees(Math.acos(vMultyple / vLenght));
	}
	
	public static double multiplyVectors(int [] vector1, int [] vector2) {
		double result = 0;
		for(int i=0;i<vector1.length;i++) {

				result += vector1[i] * vector2[i];
		}
		return result;
	}
	public static double getVectorLength(int[] vector1, int[] vector2) {
		double resultV1 = 0;
		double resultV2	= 0;

		for(int i=0; i<vector1.length; i++) {
			resultV1 += Math.pow(vector1[i],2);
			resultV2 += Math.pow(vector2[i],2);
		}

		return Math.sqrt(resultV1) *  Math.sqrt(resultV2) ;
	}

	
/**
 * remove duplicates
 */
	public static void e1_1_28(int[] N) {
		int moves = 0;
		int repeteads = 0;
		List<Integer> listNew = new ArrayList<Integer>();
		for (int i = 0; i < N.length; i++) {

			listNew.add(N[i]);

			while (i + moves + 1 < N.length && N[i] == N[i + moves + 1]) {
				moves++;
				repeteads++;
			}

			i += moves;
			moves = 0;
		}
		for (int a : listNew) {
			System.out.println(a);
		}
	}
	
/**
* Binomial distribution recursive
 */
	public static double e1_1_27(int N, int k, double p) {
		
        double[][] b = new double[N+1][k+1];

        // base cases
        for (int i = 0; i <= N; i++) {
            b[i][0] = Math.pow(1.0 - p, i);
        }
        b[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) *b[i-1][j];                
            }
        }

        return b[N][k];
    }
	
/**
 * Sort three number in ascending order
 */
	public static void e1_1_26(int a, int b, int c) {
		int t;
		
	if (a < b) { t = a; a = b; b = t; }
	if (a < c) { t = a; a = c; c = t; }
	if (b < c) { t = b; b = c; c = t; }
	
	System.out.print("a: " + a + " b: " + b + " c: " + c);
	}
	

	/**
	 * Greatest common divisor worse way to implement
	 */
	public static int GreatestCommonDivisorRecursiveMethod(int p, int q)
	{
	 if (q == 0) return p;
	 
	 int r = p % q;

	 return GreatestCommonDivisorRecursiveMethod(q, r);
	}
	
/**
 * Greatest common divisor worse way to implement
 */
	public static int e1_1_24(int num1, int num2) {
		int max = 0;
		for (int i=1; i<20; i++) {
			
			if(num1 % i == 0 && num2 % i == 0)
			max = i;
		
		}
		return max;
	}

/**
 * Binary Search
 * Recursive method get position of key value in array
 * if not present return -1
 */
	public static int e1_1_23(int key, int[] a, int lo, int hi, int level) { // Index of key in a[], if present, is not smaller than
																			// lo// and not larger than hi.		
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid])
			return e1_1_23(key, a, lo, mid - 1, level);
		else if (key > a[mid])
			return e1_1_23(key, a, mid + 1, hi, level);
		else
			return mid;
	}

	/**
	 * method get position of key value in array
	 * if not present return -1
	 */
	public static int e1_1_22(int key, int[] a) { // Array must be sorted.
		int lo = 0;
		int hi = a.length - 1;
		
		while (lo <= hi) { // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			}
			else if (key > a[mid]) {
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * Order String array first name and then values
	 * @param results
	 */
	public static void e1_1_21(String[] results){
		int add = 0;
		String temp = "";
		String[] newArryString = new String[results.length + 1];
		for(int i=0; i<results.length; i++) {
			
			if(checkNumber(results[i])) {
			add += Integer.parseInt(results[i]);
			newArryString[i] = results[i];
			}else {	
				temp = newArryString[0];
				newArryString[0] = results[i];
				newArryString[i] = temp;
			}	
		}
		newArryString[newArryString.length - 1] =  String.valueOf(add / 2);
		
		for(String a: newArryString) {
			System.out.print(a + " ");
		}
	}
	
	public static boolean checkNumber(String s)
	{
		try { 
		Integer.parseInt(s); 
		return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * logarithm of N! (periodic number)
	 * 	
	 * @param n
	 * @return
	 */
	public static double e1_1_20(double n){
		if(n == 1.0) return 1;
		
		return Math.log(n)+e1_1_20(n-1);
	}

	/**
	 * periodic number
	 * 	
	 * @param n
	 * @return
	 */
	public static double e1_1_20Extra(double n){
		if(n == 0) return 1;
			
		return e1_1_20Extra(n-1) * n;
	}
	
	
	/**
	 * Fibonacci number
	 * 
	 */
	 public static void e1_1_19()
	 {
		 int x = 10;
		 int f = 0;
		 int g = 1;
		 int b[] = new int [x];

		 for(int i=0; i<x; i++) {
			 b[i] = f; 
			 f = f + g;
			 g = f - g;
		 }
		 
		 for(int i=0; i<b.length; i++) {
			 System.out.println(b[i]);
		 }
	 }
		/**
		 * Fibonacci number recursive
		 * 
		 */
	 public static long FibonacciRecursive(int N)
	 {
	 if (N == 0) return 0;
	 if (N == 1) return 1;
	 return FibonacciRecursive(N-1) + FibonacciRecursive(N-2);
	 }

	/**
	 * recursive with one path
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	
	public static int e1_1_18(int a, int b)
	{
				
	 if (b == 0) return 0;		 		
	 
	 if (b % 2 == 0) return e1_1_18(a+a, b/2);
	 
	 return e1_1_18(a*a, b/2) + a; 
	}
	
	/**
	 * Never get into the if;
	 */
	public static String e1_1_17(int n)
	{
		System.out.print(n);
	 String s = e1_1_17(n-3) + n + e1_1_17(n-2) + n;
	 
	 if (n <= 0) return "";
	 return s;
	}
	
	/**
	 * recursive function.
	 * @param n
	 * @return
	 */
	public static int e1_1_16(int n)
	{
	 if (n < 0) { 
	 
		 return n; 
	 }else if (n == 0) {
		 return n;
	 }

	 return e1_1_16(n-3) + n + e1_1_16(n-2) + n;
	}
	
	/**
	 * fill a new matrix b [] of size M with the numbers that if added together gives the matrix size a[]
	 * 
	 * @param a array
	 * @param m new array size
	 * @return b[]
	 */
	public static int[] e1_1_15(int[] a, int m) {
		int sum = 6900;//a.length;
		int[] b = new int[m];
		//SACAR EL MAXIMO DISPONIBLE;
		int add = 0;

		int temp = 0;
		int max = 0;
		
		Random nu = new Random();
		
		for(int i= 0; i<m; i++) {
			
			max = sum - add - ((m - i - 1) * 1);		
			
			temp = i != m -1 ? nu.nextInt(max) : max;
			
			add += temp;
			
			b[i] = temp;
			
		}

		return b;
	}
	
	
	/**
	 * get the base2 - logarithm of N 
	 */
	public static int e1_1_14(int N) {
		
		int x = 0;
		while(true) {
			x++;	
		if(x * x >= N) return x;
		}

	}
	
	/**
	 * Change row by column.
	 */
	public static void e1_1_13() {
	        //initialize matrices
			int x = 4;
			int y = 5;
	        int[][] array = new int[x][y];
	        int[][] transposed = new int[y][x];
	        Random rand = new Random(20);
	        //fill the matrices and print the first one
	        for (int i = 0; i < x; i++)
	        {
	            for (int j = 0; j < y; j++)
	            {
	                int tempInt = rand.nextInt(10);
	                array[i][j] = tempInt;
	                transposed[j][i] = tempInt;
	                System.out.print(array[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println("------------------------");
	        //print the transposed matrix
	        for (int i = 0; i < y; i++)
	        {
	            for (int j = 0; j< x; j++)
	            {
	                System.out.print(transposed[i][j] + " ");
	            }
	            System.out.println();
	        }
	}

	/**
	 * Basic pendulum
	 * 
	 */
	public static void e1_1_12() {
	
	int[] a = new int[10];
	for (int i = 0; i < a.length; i++) 
	 a[i] = (a.length - 1) - i;   //--> Se recorre llenando cada elemento con el tamaño del array - 1
								 //-->10 - 9 - 8 - 7 ..0
				
	for (int i = 0; i < a.length; i++) { //valor que esta en la posicion
	 a[i] = a[a[i]];			//--> a[ a[i] = 10 ]  ==  a[10] == 0
	 							// new array: a[0] = 0 ...
	}					        //--> a[ a[i:1= a[1] = 9 ] == a[9] == 1
								// new array: a[1] = 1 ...
								// --> a[ a[i:4= a[6] = 4 ] == a[4] == 4
								//-> a[ a[ i = 5] == a[5] == 5 
								/**
								 * A PARTIR DE LA MITAD RECORRE LOS NUMEROS YA MODIFICADOS.
								 *  a[a[i]] 
								 *  a[i] = 10;
								 *  a[10] 
								 *  Significa que voy a la posicion del valor que tiene a[i] 
								 *  
								 *  y a partir de la mitad ya vuelve a los valores que fueron tocados.
								 **/
	for (int i = 0; i < 10; i++)
		 System.out.println(a[i]); 	
	}
	/*
	for (int i = 0; i < 50; i++)
	 System.out.println(a[i]); 	
	*/
	/**
	 * Prints "*" or " " depending of boolean content double loop
	 */
	public static void e1_1_11() {
		boolean[][] boolean_TwoDimensional = {{ true, false, true, true },
											  {true, true, false, false },
											  { true, false, true, true  }};
		String s = "";
		String simbol = "";
		String row = "Row: ";
		String column =  " colum: ";
		
		for(int i=0; i<boolean_TwoDimensional.length; i++) {

			s += row + (i + 1) + "  ";
			
			for(int j=0; j < boolean_TwoDimensional[i].length;j++ ) {
	
				simbol = boolean_TwoDimensional[i][j] ? "*" : " "; 
				
				s += column + (j + 1) + "= " +simbol;
				
			}
			s += "\n"; 
		}

		System.out.println(s);
	}

	/**
	 * a) binaryRepresentantion two methods:
	 *  	conventional, BinaryRepresentation Java  
	 * b) get number of BinaryRepresentation upside down
	 * 
	 * c) get Raiz of any number.
	 * 
	 * d) get the binary of number positive best method
	 */
	public static void e1_1_8() {
		
	//a)
	int num = 10;
	double formatConventional = 1 * Math.pow(2,24);
	int BinaryRepresentation = num << 24;
	
	//b)
	int numEqual = BinaryRepresentation >> 24 & 0xFF;
	
	String stringBinary = String.valueOf(BinaryRepresentation);
	String stringConventional= String.valueOf(formatConventional);
	
	//c
	double raizCubica = Math.pow(formatConventional, (double) 1 / 24);
	
	System.out.println(raizCubica + "raiz");
	System.out.println(stringBinary);
	System.out.println(stringConventional);
	
	//d)
		String s = "";
		int N = 10;
		for (int n = N; n > 0; n /= 2) {
		 s = (n % 2) + s;
		}
		System.out.println("Binary Number of: " + N + " is: " + s);
	}
	/**
	 * iterate through double for loop and result is (i N loop * j N loop) / 2
	 * practice with small examples 
	 */
	public static void e1_1_7() {

	 int sum = 0;
	 for (int i = 1; i < 4; i++) {
	 for (int j = 0; j < i; j++) {
	 sum++;
	 System.out.println(sum + "i ");
	 }
	 }
	 System.out.print(sum);
	 
	 System.out.println((char) (1 + 'a'));
	}
	
	/**
	 * Next number is equal to actual number + before number;
	 */
	public static void e1_1_6() {

		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++)
		{
			
		System.out.print(f);
		 f = f + g;
		 g = f - g;
		}
	} // 1 - 1  + 2 + 3 + 5 + 7 + 11 
	/**
	 * Check if any number in array is 1 or 0;
	 */
	public static boolean e1_1_5(int[] num) {

		for (int i : num) {
			if (i != 0 && i != 1)
				return false;
		}

		return true;
	}

	/**
	 * First to do is write the core method then system.out.print in the main
	 */
	public static boolean e1_1_3(int[] num) {
		int first = num[0];

		for (int i : num) {

			if (i != first)
				return false;
		}
		return true;
	}

	/**
	 * Integer will be rounded if result is decimal
	 */
	public static void e1_1_1() {
		int a = 15;
		int b = 2;
		System.out.println(a / b);
		System.out.println(1.2 / 5000);
		System.out.println(1 + 2 + "3");

	}
	
	public static void printArray(int[] ar) {
		for(int i : ar) 
			System.out.println(i);
	}

}
