/******************************************************************************
 * READ ME
 * Implementation of MergeSort with debug print statements
 * and prints out the recursive depth.
 * Allows for input numbers from command line or use of sample numbers 
 ******************************************************************************/

import java.util.ArrayList;

public class MergeSort {

    static boolean debug = true;

    public static void main(String[] args) {

	ArrayList<Integer> nums = new ArrayList<Integer>();
	nums.add(7);
	nums.add(11);
	nums.add(9);
	nums.add(18);
	nums.add(12);
	nums.add(14);
	nums.add(3);
	nums.add(11);

	boolean useInput = false;
	ArrayList<Integer> inputNums = new ArrayList<Integer>();
        for (int i = 0; i < args.length; i++) {
	    if (args[i].equals("--no-debug")) {
		debug = false;
	    } else {
		try {
		    int num = Integer.parseInt(args[i]);
		    inputNums.add(num);
		    useInput = true;
		} catch (NumberFormatException ex) {
		    useInput = false;
		    System.out.println("Unable to process input numbers.  \n" +
				       "Defaulting to sample numbers.");
		}
	    }
	}

	if (useInput) {
	    nums = inputNums;
	}

	System.out.println("Original: " + nums);
	nums = mergeSort(nums, "");
	System.out.println("Sorted: " + nums);

    }

    public static void printDebug(String test) {
	/***************************************
	 * If debug statements are not desired
         * pass in as arguement to command line
         * --no-debug
	 ***************************************/
	if (debug) {
	    System.out.println(test);
	}
	
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list, String depth) {

	if (list.size() == 1) {
	    printDebug(depth + " BASE CASE: " + list);
	    return list;
	}

	else {

	    int mid = list.size() / 2;

	    ArrayList<Integer> alpha = new ArrayList<Integer>();
	    for (int i = 0; i < mid; i++) {
		alpha.add(list.get(i));
	    }
	    printDebug(depth + " alpha: " + alpha);

	    alpha = mergeSort(alpha, depth + " |");
	    printDebug(depth + " sorted alpha: " + alpha);

	    ArrayList<Integer> omega = new ArrayList<Integer>();
	    for (int i = mid; i <= list.size(); i++) {
	        omega.add(list.get(i));
	    }
	    printDebug(depth + " omega: " + omega);

	    omega = mergeSort(omega, depth + " |");
	    printDebug(depth + " sorted omega: " + omega);

	    ArrayList<Integer> output = merge(alpha, omega);
	    printDebug(depth + " sorted output: " + output);

	    return output;

	}

    }

    public static ArrayList<Integer> merge(ArrayList<Integer> alpha, ArrayList<Integer> omega) {

	int i = 0;
	int j = 0;

	ArrayList<Integer> merged = new ArrayList<Integer>();

	while (i < alpha.size() && j < omega.size()) {
	    if (alpha.get(i) <= omega.get(j)) {
		merged.add(alpha.get(i));
		i++;
	    } else {
		merged.add(omega.get(j));
		j++;
	    }
	}

	if (i < alpha.size()) {
	    for (int r = i; r < alpha.size(); r++) {
		merged.add(alpha.get(r));
	    }
	} else {
	    for (int r = j; r < omega.size(); r++) {
		merged.add(omega.get(r));
	    }
	}

	return merged;

    }

}
