//Team Aca-Amazing
//Yedoh Kang & Connie Lei
//HW04 -- Where In the Array Is Carmen San Numero?  Or San Diego?
//2016-02-05

public class MissingNum{

    public static int factorialWay(int[] array){
	int arraySum = 0;
	long numFac = 1;
	long arrayFac = 1;
	for(int n = 0; n < array.length; n ++){
	    arraySum += array[n];
	    numFac *= (n + 1);
	    arrayFac *= array[n];
	}
	int n = (int) ((array.length + 1.) * array.length / 2.);
	int missingNum = (int)(numFac * (arraySum - n) / (arrayFac - numFac));
	return missingNum;
	//missing number = n!(sum of array - sum of n numbers)/(product of numbers in array - n!)
    }

    public static int squaresWay(int[] array){
	int difference = (int) ((array.length + 1.) * array.length / 2);
	int sumN = 0;
	int sumArray = 0;
	for(int n = 0; n < array.length; n ++){
	    sumN += ((n + 1) * (n +1));
	    sumArray += (array[n] * array[n]);
	    difference -= array[n];
	}
	return (int)((sumN - sumArray + difference * difference) / (2 * difference));
    }

    public static int findDuplicate (int[] arr)
    {
	int duplicate = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0) {
            	arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];	
            }
            else {
		duplicate = Math.abs(arr[i]);
	        break;
            }
        }   
        return duplicate;      
    } 
	
    public static int findWay (int[] arr)
    {
	int n = arr.length;
	int expectedSum = (int) n * (n+1) / 2; // what the sum is SUPPOSED to be 
	int actualSum = 0; // what the sum is right now
	for (int i : arr) 
	{
	    actualSum += i;
	}
	int missingNum = expectedSum - (actualSum - findDuplicate(arr));
	return missingNum;
    }

    public static void main(String[] args){
	int[] carmen = {2,1,2,4};
	System.out.println(factorialWay(carmen));
	System.out.println(squaresWay(carmen));
        //System.out.println(findWay(carmen));

	int[] TomatoCale={6,3,5,4,5,2};
	System.out.println(factorialWay(TomatoCale));
	System.out.println(squaresWay(TomatoCale));
        //System.out.println(findWay(TomatoCale));

	int[] peanutButter={4,1,4,3,2};
        System.out.println(factorialWay(peanutButter));
	System.out.println(squaresWay(peanutButter));
        //System.out.println(findWay(peanutButter));  

	int[] boo = {5, 5, 2, 3, 1};
        System.out.println(factorialWay(boo));
	System.out.println(squaresWay(boo));
        //System.out.println(findWay(boo));

	int[] carrots = {5, 3, 2, 4, 5};
        System.out.println(factorialWay(carrots));
	System.out.println(squaresWay(carrots));
        //System.out.println(findWay(carrots));

	int[] thorough={2,5,7,9,1,4,12,16,17,6,3,11,10,13,16,14};
	System.out.println(factorialWay(thorough));
	System.out.println(squaresWay(thorough));
        //System.out.println(findWay(thorough));
	
    }
}
