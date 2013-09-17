
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author 13aby_Jerry
 */
public class API_List {
    
    private String type_Integer = "class java.lang.Integer";
    private String type_Double = "class java.lang.Double";
    private String type_Long = "class java.lang.Long";
    private String type_Float = "class java.lang.Float";
    private String type_String = "class java.lang.String";
    private int heapLength;
    
    public API_List() {
        
    }
    
    //basic operation
    
    /**
     * print the on the screen and return the output
     * @param currentString
     * @return output the string
     */
    protected String print(Object currentString) {
        System.out.println(currentString);
        return currentString.toString();
    }
    
    protected void print() {
        System.out.println();
    }
    
    /**
     * add two elements together
     * If both are numbers, then add the two numbers
     * If at least one string is provided, then concatenate two elements as one string
     * @param element 1
     * @param element 2
     * @return result which add two elements
     */
    protected Object add(Object e1, Object e2) {
        
        if (e1.getClass().toString().equals(type_Integer)&&
                e2.getClass().toString().equals(type_Integer)) {
            int result = (int)e1 + (int)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Long)&&
                e2.getClass().toString().equals(type_Long)) {
            long result = (long)e1 + (long)e2;
            return result;
        } else if ((e1.getClass().toString().equals(type_Integer)&&
                e2.getClass().toString().equals(type_Long))||
                (e1.getClass().toString().equals(type_Long)&&
                e2.getClass().toString().equals(type_Integer))) {
            long result = (long)e1 + (long)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Float)&&
                e2.getClass().toString().equals(type_Float)) {
            float result = (float)e1 + (float)e2;
            return result;
        } else if (((e1.getClass().toString().equals(type_Integer)||
                e1.getClass().toString().equals(type_Long))&&
                e2.getClass().toString().equals(type_Float))||
                (e1.getClass().toString().equals(type_Float)&&
                (e2.getClass().toString().equals(type_Integer)||
                e2.getClass().toString().equals(type_Long)))) {
            float result = (float)e1 + (float)e2;
            return result;
        }
        else if (e1.getClass().toString().equals(type_Double)&&
                e2.getClass().toString().equals(type_Double)) {
            double result = (double)e1 + (double)e2;
            return result;
        } else if (((e1.getClass().toString().equals(type_Integer)||
                e1.getClass().toString().equals(type_Long)||
                e1.getClass().toString().equals(type_Float))&&
                e2.getClass().toString().equals(type_Double))||
                (e1.getClass().toString().equals(type_Double)&&
                (e2.getClass().toString().equals(type_Integer)||
                e2.getClass().toString().equals(type_Long)||
                e2.getClass().toString().equals(type_Float)))) {
            double result = (double)e1 + (double)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_String)&&
                e2.getClass().toString().equals(type_String)) {
            String result = (String)e1 + (String)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_String)&&
                !e2.getClass().toString().equals(type_String)) {
            String result = (String)e1 + e2;
            return result;
        } else if (!e1.getClass().toString().equals(type_String)&&
                e2.getClass().toString().equals(type_String)) {
            String result = e1 + (String)e2;
            return result;
        } else {
            return "error";
        }
    }
    
    /**
     * minus two elements
     * If e1 and e2 are both numbers, then just do e1 - e2
     * If one of them is string, then cast another element to string
     * and if e1.toString() contains e2.toString(), then remove that part in e1
     * @param e1
     * @param e2
     * @return result
     */
    protected Object minus(Object e1, Object e2) {
        
        if (e1.getClass().toString().equals(type_Integer)&&
                e2.getClass().toString().equals(type_Integer)) {
            int result = (int)e1 - (int)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Long)&&
                e2.getClass().toString().equals(type_Long)) {
            long result = (long)e1 - (long)e2;
            return result;
        } else if ((e1.getClass().toString().equals(type_Integer)&&
                e2.getClass().toString().equals(type_Long))||
                (e1.getClass().toString().equals(type_Long)&&
                e2.getClass().toString().equals(type_Integer))) {
            long result = (long)e1 - (long)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Float)&&
                e2.getClass().toString().equals(type_Float)) {
            float result = (float)e1 - (float)e2;
            return result;
        } else if (((e1.getClass().toString().equals(type_Integer)||
                e1.getClass().toString().equals(type_Long))&&
                e2.getClass().toString().equals(type_Float))||
                (e1.getClass().toString().equals(type_Float)&&
                (e2.getClass().toString().equals(type_Integer)||
                e2.getClass().toString().equals(type_Long)))) {
            float result = (float)e1 - (float)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Double)&&
                e2.getClass().toString().equals(type_Double)) {
            double result = (double)e1 - (double)e2;
            return result;
        } else if (((e1.getClass().toString().equals(type_Integer)||
                e1.getClass().toString().equals(type_Long)||
                e1.getClass().toString().equals(type_Float))&&
                e2.getClass().toString().equals(type_Double))||
                (e1.getClass().toString().equals(type_Double)&&
                (e2.getClass().toString().equals(type_Integer)||
                e2.getClass().toString().equals(type_Long)||
                e2.getClass().toString().equals(type_Float)))) {
            double result = (double)e1 - (double)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_String)||
                e2.getClass().toString().equals(type_String)) {
            String result = e1.toString().replaceAll(e2.toString(), "");
            return result;
        } else {
            return "error";
        }
    }
    
   /**
    * multiply two elements
    * as it does not make sense to multiply two strings, so it requires that
    * two elements must be numbers
    * @param e1
    * @param e2
    * @return result
    */ 
    protected Object multiply(Object e1, Object e2) {
        
        if (e1.getClass().toString().equals(type_Integer)&&
                e2.getClass().toString().equals(type_Integer)) {
            int result = (int)e1 * (int)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Long)&&
                e2.getClass().toString().equals(type_Long)) {
            long result = (long)e1 * (long)e2;
            return result;
        } else if ((e1.getClass().toString().equals(type_Integer)&&
                e2.getClass().toString().equals(type_Long))||
                (e1.getClass().toString().equals(type_Long)&&
                e2.getClass().toString().equals(type_Integer))) {
            long result = (long)e1 * (long)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Float)&&
                e2.getClass().toString().equals(type_Float)) {
            float result = (float)e1 * (float)e2;
            return result;
        } else if (((e1.getClass().toString().equals(type_Integer)||
                e1.getClass().toString().equals(type_Long))&&
                e2.getClass().toString().equals(type_Float))||
                (e1.getClass().toString().equals(type_Float)&&
                (e2.getClass().toString().equals(type_Integer)||
                e2.getClass().toString().equals(type_Long)))) {
            float result = (float)e1 * (float)e2;
            return result;
        } else if (e1.getClass().toString().equals(type_Double)&&
                e2.getClass().toString().equals(type_Double)) {
            double result = (double)e1 * (double)e2;
            return result;
        } else if (((e1.getClass().toString().equals(type_Integer)||
                e1.getClass().toString().equals(type_Long)||
                e1.getClass().toString().equals(type_Float))&&
                e2.getClass().toString().equals(type_Double))||
                (e1.getClass().toString().equals(type_Double)&&
                (e2.getClass().toString().equals(type_Integer)||
                e2.getClass().toString().equals(type_Long)||
                e2.getClass().toString().equals(type_Float)))) {
            double result = (double)e1 * (double)e2;
            return result;
        } else {
            return "error";
        }
    }
    
    /**
     * divide two elements
     * should first check whether e2 = 0, if it is 0, then print out the warning
     * and return "INFINITY"
     * divide cannot be used for strings
     * @param e1
     * @param e2
     * @return 
     */
    protected Object divide(Object e1, Object e2) {
        
        if ((double)e2 != 0) {
            if (e1.getClass().toString().equals(type_Integer)&&
                    e2.getClass().toString().equals(type_Integer)) {
                int result = (int)e1 / (int)e2;
                return result;
            } else if (e1.getClass().toString().equals(type_Long)&&
                    e2.getClass().toString().equals(type_Long)) {
                long result = (long)e1 / (long)e2;
                return result;
            } else if ((e1.getClass().toString().equals(type_Integer)&&
                    e2.getClass().toString().equals(type_Long))||
                    (e1.getClass().toString().equals(type_Long)&&
                    e2.getClass().toString().equals(type_Integer))) {
                long result = (long)e1 / (long)e2;
                return result;
            } else if (e1.getClass().toString().equals(type_Float)&&
                    e2.getClass().toString().equals(type_Float)) {
                float result = (float)e1 / (float)e2;
                return result;
            } else if (((e1.getClass().toString().equals(type_Integer)||
                    e1.getClass().toString().equals(type_Long))&&
                    e2.getClass().toString().equals(type_Float))||
                    (e1.getClass().toString().equals(type_Float)&&
                    (e2.getClass().toString().equals(type_Integer)||
                    e2.getClass().toString().equals(type_Long)))) {
                float result = (float)e1 / (float)e2;
                return result;
            } else if (e1.getClass().toString().equals(type_Double)&&
                    e2.getClass().toString().equals(type_Double)) {
                double result = (double)e1 / (double)e2;
                return result;
            } else if (((e1.getClass().toString().equals(type_Integer)||
                    e1.getClass().toString().equals(type_Long)||
                    e1.getClass().toString().equals(type_Float))&&
                    e2.getClass().toString().equals(type_Double))||
                    (e1.getClass().toString().equals(type_Double)&&
                    (e2.getClass().toString().equals(type_Integer)||
                    e2.getClass().toString().equals(type_Long)||
                    e2.getClass().toString().equals(type_Float)))) {
                double result = (double)e1 / (double)e2;
                return result;
            } else {
                return "error";
            }
        } else {
            System.out.println("e2 cannot be 0!");
            return "INFINITY";
        }
    }
    
    //Basic sorting methods
    /**
     * selection sort
     * for numbers compare their values
     * for other objects compare their hashCode
     * @param currentArray
     * @return array
     */
    protected Object[] selectionSort(Object[] currentArray) {
        
        if (currentArray.getClass().toString().equals(type_Integer)) {
            for (int i = 0;i < currentArray.length - 1;i ++) {
                int tmp = i;
                for (int j = i + 1;j < currentArray.length;j ++) {
                    if ((int)currentArray[j] < (int)currentArray[tmp]) {
                        tmp = j;
                    }
                }
                int tmpSort = (int)currentArray[i];
                currentArray[i] = currentArray[tmp];
                currentArray[tmp] = tmpSort;
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Long)) {
            for (int i = 0;i < currentArray.length - 1;i ++) {
                int tmp = i;
                for (int j = i + 1;j < currentArray.length;j ++) {
                    if ((long)currentArray[j] < (long)currentArray[tmp]) {
                        tmp = j;
                    }
                }
                long tmpSort = (long)currentArray[i];
                currentArray[i] = currentArray[tmp];
                currentArray[tmp] = tmpSort;
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Float)) {
            for (int i = 0;i < currentArray.length - 1;i ++) {
                int tmp = i;
                for (int j = i + 1;j < currentArray.length;j ++) {
                    if ((float)currentArray[j] < (float)currentArray[tmp]) {
                        tmp = j;
                    }
                }
                float tmpSort = (float)currentArray[i];
                currentArray[i] = currentArray[tmp];
                currentArray[tmp] = tmpSort;
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Double)) {
            for (int i = 0;i < currentArray.length - 1;i ++) {
                int tmp = i;
                for (int j = i + 1;j < currentArray.length;j ++) {
                    if ((double)currentArray[j] < (double)currentArray[tmp]) {
                        tmp = j;
                    }
                }
                double tmpSort = (double)currentArray[i];
                currentArray[i] = currentArray[tmp];
                currentArray[tmp] = tmpSort;
            }
            return currentArray;
        } else {
            for (int i = 0;i < currentArray.length - 1;i ++) {
                int tmp = i;
                for (int j = i + 1;j < currentArray.length;j ++) {
                    if (currentArray[j].hashCode() < currentArray[tmp].hashCode()) {
                        tmp = j;
                    }
                }
                Object tmpSort = currentArray[i];
                currentArray[i] = currentArray[tmp];
                currentArray[tmp] = tmpSort;
            }
            return currentArray;
        }
    }
    
    /**
     * bubble sort
     * for numbers compare their values
     * for other objects compare their hashCode
     * @param currentArray
     * @return array
     */
    protected Object[] bubbleSort(Object[] currentArray) {
        
        if (currentArray.getClass().toString().equals(type_Integer)) {
            int count;
            do {
                count = 0;
                int sum = currentArray.length;
                for (int i = 0;i < sum - 1;i ++) {
                    if ((int)currentArray[i] > (int)currentArray[i+1]) {
                        int temp = (int)currentArray[i];
                        currentArray[i] = currentArray[i+1];
                        currentArray[i+1] = temp;
                        count ++;
                    }
                }
            }while(count != 0);
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Long)) {
            int count;
            do {
                count = 0;
                int sum = currentArray.length;
                for (int i = 0;i < sum - 1;i ++) {
                    if ((long)currentArray[i] > (long)currentArray[i+1]) {
                        long temp = (long)currentArray[i];
                        currentArray[i] = currentArray[i+1];
                        currentArray[i+1] = temp;
                        count ++;
                    }
                }
            }while(count != 0);
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Float)) {
            int count;
            do {
                count = 0;
                int sum = currentArray.length;
                for (int i = 0;i < sum - 1;i ++) {
                    if ((float)currentArray[i] > (float)currentArray[i+1]) {
                        float temp = (float)currentArray[i];
                        currentArray[i] = currentArray[i+1];
                        currentArray[i+1] = temp;
                        count ++;
                    }
                }
            }while(count != 0);
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Double)) {
            int count;
            do {
                count = 0;
                int sum = currentArray.length;
                for (int i = 0;i < sum - 1;i ++) {
                    if ((double)currentArray[i] > (double)currentArray[i+1]) {
                        double temp = (double)currentArray[i];
                        currentArray[i] = currentArray[i+1];
                        currentArray[i+1] = temp;
                        count ++;
                    }
                }
            }while(count != 0);
            return currentArray;
        } else {
            int count;
            do {
                count = 0;
                int sum = currentArray.length;
                for (int i = 0;i < sum - 1;i ++) {
                    if (currentArray[i].hashCode() > currentArray[i+1].hashCode()) {
                        Object temp = currentArray[i];
                        currentArray[i] = currentArray[i+1];
                        currentArray[i+1] = temp;
                        count ++;
                    }
                }
            }while(count != 0);
            return currentArray;
        }
    }
    
    /**
     * insertion sort
     * @param currentArray
     * @return array
     */
    protected Object[] insertionSort(Object[] currentArray) {
        if (currentArray.getClass().toString().equals(type_Integer)) {
            for (int i = 1;i < currentArray.length;i ++) {
                int key = (int)currentArray[i];
                int j = i - 1;
                while((j >= 0)&&((int)currentArray[j] > key)) {
                    currentArray[j+1] = currentArray[j];
                    j -- ;
                }
                currentArray[j+1] = key;
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Long)) {
            for (int i = 1;i < currentArray.length;i ++) {
                long key = (long)currentArray[i];
                int j = i - 1;
                while((j >= 0)&&((long)currentArray[j] > key)) {
                    currentArray[j+1] = currentArray[j];
                    j -- ;
                }
                currentArray[j+1] = key;
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Float)) {
            for (int i = 1;i < currentArray.length;i ++) {
                float key = (float)currentArray[i];
                int j = i - 1;
                while((j >= 0)&&((float)currentArray[j] > key)) {
                    currentArray[j+1] = currentArray[j];
                    j -- ;
                }
                currentArray[j+1] = key;
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Double)) {
            for (int i = 1;i < currentArray.length;i ++) {
                double key = (double)currentArray[i];
                int j = i - 1;
                while((j >= 0)&&((double)currentArray[j] > key)) {
                    currentArray[j+1] = currentArray[j];
                    j -- ;
                }
                currentArray[j+1] = key;
            }
            return currentArray;
        } else {
            for (int i = 1;i < currentArray.length;i ++) {
                int key = currentArray[i].hashCode();
                int j = i - 1;
                while((j >= 0)&&(currentArray[j].hashCode() > key)) {
                    currentArray[j+1] = currentArray[j];
                    j -- ;
                }
                currentArray[j+1] = key;
            }
            return currentArray;
        }
    }
    
    /**
     * quick sort
     * @param currentArray
     * @return array
     */
    protected Object[] quickSort(Object[] currentArray) {
        if (currentArray.getClass().toString().equals(type_Integer)) {
            List<Integer> sortList = new LinkedList<>();
            List<Integer> resultList = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                sortList.add((int)currentArray[i]);
            }
            resultList = quickSortOperator_Integer(sortList);
            for (int i = 0;i < resultList.size();i ++) {
                currentArray[i] = resultList.get(i);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Long)) {
            List<Long> sortList = new LinkedList<>();
            List<Long> resultList = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                sortList.add((long)currentArray[i]);
            }
            resultList = quickSortOperator_Long(sortList);
            for (int i = 0;i < resultList.size();i ++) {
                currentArray[i] = resultList.get(i);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Float)) {
            List<Float> sortList = new LinkedList<>();
            List<Float> resultList = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                sortList.add((float)currentArray[i]);
            }
            resultList = quickSortOperator_Float(sortList);
            for (int i = 0;i < resultList.size();i ++) {
                currentArray[i] = resultList.get(i);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Double)) {
            List<Double> sortList = new LinkedList<>();
            List<Double> resultList = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                sortList.add((double)currentArray[i]);
            }
            resultList = quickSortOperator_Double(sortList);
            for (int i = 0;i < resultList.size();i ++) {
                currentArray[i] = resultList.get(i);
            }
            return currentArray;
        } else {
            List<Object> sortList = new LinkedList<>();
            List<Object> resultList = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                sortList.add(currentArray[i]);
            }
            resultList = quickSortOperator_Object(sortList);
            for (int i = 0;i < resultList.size();i ++) {
                currentArray[i] = resultList.get(i);
            }
            return currentArray;
        }
    }
    
    /**
     * quick sort operator for integer
     * @param currentList
     * @return 
     */
    private List<Integer> quickSortOperator_Integer(List<Integer> currentList) {
        if (currentList.size() > 1) {
            int pivot = currentList.get(0);
            List<Integer> less = new LinkedList<>();
            List<Integer> greater = new LinkedList<>();
            for (int i = 1;i < currentList.size();i ++) {
                if (currentList.get(i) <= pivot) {
                    less.add(currentList.get(i));
                }
                else {
                    greater.add(currentList.get(i));
                }
            }
            List<Integer> newList = new LinkedList<>();
            newList.addAll(quickSortOperator_Integer(less));
            newList.add(pivot);
            newList.addAll(quickSortOperator_Integer(greater));
            return newList;
        }
        else {
            return currentList;
        }
    }
    
    /**
     * quick sort operator for long
     * @param currentList
     * @return 
     */
    private List<Long> quickSortOperator_Long(List<Long> currentList) {
        if (currentList.size() > 1) {
            long pivot = currentList.get(0);
            List<Long> less = new LinkedList<>();
            List<Long> greater = new LinkedList<>();
            for (int i = 1;i < currentList.size();i ++) {
                if (currentList.get(i) <= pivot) {
                    less.add(currentList.get(i));
                }
                else {
                    greater.add(currentList.get(i));
                }
            }
            List<Long> newList = new LinkedList<>();
            newList.addAll(quickSortOperator_Long(less));
            newList.add(pivot);
            newList.addAll(quickSortOperator_Long(greater));
            return newList;
        }
        else {
            return currentList;
        }
    }
    
    /**
     * quick sort operator for float
     * @param currentList
     * @return 
     */
    private List<Float> quickSortOperator_Float(List<Float> currentList) {
        if (currentList.size() > 1) {
            float pivot = currentList.get(0);
            List<Float> less = new LinkedList<>();
            List<Float> greater = new LinkedList<>();
            for (int i = 1;i < currentList.size();i ++) {
                if (currentList.get(i) <= pivot) {
                    less.add(currentList.get(i));
                }
                else {
                    greater.add(currentList.get(i));
                }
            }
            List<Float> newList = new LinkedList<>();
            newList.addAll(quickSortOperator_Float(less));
            newList.add(pivot);
            newList.addAll(quickSortOperator_Float(greater));
            return newList;
        }
        else {
            return currentList;
        }
    }
    
    /**
     * quick sort operator for double
     * @param currentList
     * @return 
     */
    private List<Double> quickSortOperator_Double(List<Double> currentList) {
        if (currentList.size() > 1) {
            double pivot = currentList.get(0);
            List<Double> less = new LinkedList<>();
            List<Double> greater = new LinkedList<>();
            for (int i = 1;i < currentList.size();i ++) {
                if (currentList.get(i) <= pivot) {
                    less.add(currentList.get(i));
                }
                else {
                    greater.add(currentList.get(i));
                }
            }
            List<Double> newList = new LinkedList<>();
            newList.addAll(quickSortOperator_Double(less));
            newList.add(pivot);
            newList.addAll(quickSortOperator_Double(greater));
            return newList;
        }
        else {
            return currentList;
        }
    }
    
    /**
     * quick sort operator for other types
     * @param currentList
     * @return 
     */
    private List<Object> quickSortOperator_Object(List<Object> currentList) {
        if (currentList.size() > 1) {
            int pivot = currentList.get(0).hashCode();
            List<Object> less = new LinkedList<>();
            List<Object> greater = new LinkedList<>();
            for (int i = 1;i < currentList.size();i ++) {
                if (currentList.get(i).hashCode() <= pivot) {
                    less.add(currentList.get(i));
                }
                else {
                    greater.add(currentList.get(i));
                }
            }
            List<Object> newList = new LinkedList<>();
            newList.addAll(quickSortOperator_Object(less));
            newList.add(pivot);
            newList.addAll(quickSortOperator_Object(greater));
            return newList;
        }
        else {
            return currentList;
        }
    }
    
    /**
     * merge sort
     * @param currentArray
     * @return array
     */
    protected Object[] mergeSort(Object[] currentArray) {
        if (currentArray.getClass().toString().equals(type_Integer)) {
            List<Integer> mergeList = new LinkedList<>();
            List<Integer> result = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                mergeList.add((int)currentArray[i]);
            }
            result = mergeSortOperator_Integer(mergeList);
            for (int i = 0;i < result.size();i ++) {         
                currentArray[i] = result.get(i);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Long)) {
            List<Long> mergeList = new LinkedList<>();
            List<Long> result = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                mergeList.add((long)currentArray[i]);
            }
            result = mergeSortOperator_Long(mergeList);
            for (int i = 0;i < result.size();i ++) {
                currentArray[i] = result.get(i);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Float)) {
            List<Float> mergeList = new LinkedList<>();
            List<Float> result = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                mergeList.add((float)currentArray[i]);
            }
            result = mergeSortOperator_Float(mergeList);
            for (int i = 0;i < result.size();i ++) {
                currentArray[i] = result.get(i);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Double)) {
            List<Double> mergeList = new LinkedList<>();
            List<Double> result = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                mergeList.add((double)currentArray[i]);
            }
            result = mergeSortOperator_Double(mergeList);
            for (int i = 0;i < result.size();i ++) {
                currentArray[i] = result.get(i);
            }
            return currentArray;
        } else {
            List<Object> mergeList = new LinkedList<>();
            List<Object> result = new LinkedList<>();
            for (int i = 0;i < currentArray.length;i ++) {
                mergeList.add(currentArray[i]);
            }
            result = mergeSortOperator_Object(mergeList);
            for (int i = 0;i < result.size();i ++) {
                currentArray[i] = result.get(i);
            }
            return currentArray;
        }
    }
    
    /**
     * merge sort operator for integer
     * @param currentList
     * @return 
     */
    private List<Integer> mergeSortOperator_Integer(List<Integer> currentList) {
        if (currentList.size() > 1) {
            int middleSize = currentList.size()/2;
            List<Integer> left = new LinkedList<>();
            List<Integer> right = new LinkedList<>();
            for (int i = 0;i < middleSize;i ++) {
                left.add(currentList.get(i));
            }
            for (int j = middleSize;j < currentList.size();j ++) {
                right.add(currentList.get(j));
            }
            left = mergeSortOperator_Integer(left);
            right = mergeSortOperator_Integer(right);
            return currentMergeSort_Integer(left, right);
            
        }
        else {
            return currentList;
        }
    }
    
    private List<Integer> currentMergeSort_Integer(List<Integer> left, List<Integer> right) {
        List<Integer> result = new LinkedList<>();
        while ((left.size() > 0)||(right.size() > 0)) {
            if ((left.size() > 0)&&(right.size() > 0)) {
                if (left.get(0) <= right.get(0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
            else {
                if ((left.size() > 0)&&(right.size() <= 0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                if ((left.size() <= 0)&&(right.size() > 0)) {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
        }
        return result;
    }
    
    /**
     * merge sort for long
     * @param currentList
     * @return 
     */
    private List<Long> mergeSortOperator_Long(List<Long> currentList) {
        if (currentList.size() > 1) {
            int middleSize = currentList.size()/2;
            List<Long> left = new LinkedList<>();
            List<Long> right = new LinkedList<>();
            for (int i = 0;i < middleSize;i ++) {
                left.add(currentList.get(i));
            }
            for (int j = middleSize;j < currentList.size();j ++) {
                right.add(currentList.get(j));
            }
            left = mergeSortOperator_Long(left);
            right = mergeSortOperator_Long(right);
            return currentMergeSort_Long(left, right);
            
        }
        else {
            return currentList;
        }
    }
    
    private List<Long> currentMergeSort_Long(List<Long> left, List<Long> right) {
        List<Long> result = new LinkedList<>();
        while ((left.size() > 0)||(right.size() > 0)) {
            if ((left.size() > 0)&&(right.size() > 0)) {
                if (left.get(0) <= right.get(0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
            else {
                if ((left.size() > 0)&&(right.size() <= 0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                if ((left.size() <= 0)&&(right.size() > 0)) {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
        }
        return result;
    }
    
    /**
     * merge sort for float
     * @param currentList
     * @return 
     */
    private List<Float> mergeSortOperator_Float(List<Float> currentList) {
        if (currentList.size() > 1) {
            int middleSize = currentList.size()/2;
            List<Float> left = new LinkedList<>();
            List<Float> right = new LinkedList<>();
            for (int i = 0;i < middleSize;i ++) {
                left.add(currentList.get(i));
            }
            for (int j = middleSize;j < currentList.size();j ++) {
                right.add(currentList.get(j));
            }
            left = mergeSortOperator_Float(left);
            right = mergeSortOperator_Float(right);
            return currentMergeSort_Float(left, right);
            
        }
        else {
            return currentList;
        }
    }
    
    private List<Float> currentMergeSort_Float(List<Float> left, List<Float> right) {
        List<Float> result = new LinkedList<>();
        while ((left.size() > 0)||(right.size() > 0)) {
            if ((left.size() > 0)&&(right.size() > 0)) {
                if (left.get(0) <= right.get(0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
            else {
                if ((left.size() > 0)&&(right.size() <= 0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                if ((left.size() <= 0)&&(right.size() > 0)) {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
        }
        return result;
    }
    
    /**
     * merge sort for double
     * @param currentList
     * @return 
     */
    private List<Double> mergeSortOperator_Double(List<Double> currentList) {
        if (currentList.size() > 1) {
            int middleSize = currentList.size()/2;
            List<Double> left = new LinkedList<>();
            List<Double> right = new LinkedList<>();
            for (int i = 0;i < middleSize;i ++) {
                left.add(currentList.get(i));
            }
            for (int j = middleSize;j < currentList.size();j ++) {
                right.add(currentList.get(j));
            }
            left = mergeSortOperator_Double(left);
            right = mergeSortOperator_Double(right);
            return currentMergeSort_Double(left, right);
            
        }
        else {
            return currentList;
        }
    }
    
    private List<Double> currentMergeSort_Double(List<Double> left, List<Double> right) {
        List<Double> result = new LinkedList<>();
        while ((left.size() > 0)||(right.size() > 0)) {
            if ((left.size() > 0)&&(right.size() > 0)) {
                if (left.get(0) <= right.get(0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
            else {
                if ((left.size() > 0)&&(right.size() <= 0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                if ((left.size() <= 0)&&(right.size() > 0)) {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
        }
        return result;
    }
    
    /**
     * merge sort for other types
     * @param currentList
     * @return 
     */
    private List<Object> mergeSortOperator_Object(List<Object> currentList) {
        if (currentList.size() > 1) {
            int middleSize = currentList.size()/2;
            List<Object> left = new LinkedList<>();
            List<Object> right = new LinkedList<>();
            for (int i = 0;i < middleSize;i ++) {
                left.add(currentList.get(i));
            }
            for (int j = middleSize;j < currentList.size();j ++) {
                right.add(currentList.get(j));
            }
            left = mergeSortOperator_Object(left);
            right = mergeSortOperator_Object(right);
            return currentMergeSort_Object(left, right);
            
        }
        else {
            return currentList;
        }
    }
    
    private List<Object> currentMergeSort_Object(List<Object> left, List<Object> right) {
        List<Object> result = new LinkedList<>();
        while ((left.size() > 0)||(right.size() > 0)) {
            if ((left.size() > 0)&&(right.size() > 0)) {
                if (left.get(0).hashCode() <= right.get(0).hashCode()) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
            else {
                if ((left.size() > 0)&&(right.size() <= 0)) {
                    result.add(left.get(0));
                    left.remove(0);
                }
                if ((left.size() <= 0)&&(right.size() > 0)) {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
        }
        return result;
    }
    
    /**
     * heap sort
     * @param currentArray
     * @return array
     */
    protected Object[] heapSort(Object[] currentArray) {
        if (currentArray.getClass().toString().equals(type_Integer)) {
            buildMaxHeap(currentArray);
            for (int i = currentArray.length - 1;i >= 1;i --) {
                int temp = (int)currentArray[0];
                currentArray[0] = currentArray[i];
                currentArray[i] = temp;
                heapLength --;
                maxHeapify(0, currentArray);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Long)) {
            buildMaxHeap(currentArray);
            for (int i = currentArray.length - 1;i >= 1;i --) {
                long temp = (long)currentArray[0];
                currentArray[0] = currentArray[i];
                currentArray[i] = temp;
                heapLength --;
                maxHeapify(0, currentArray);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Float)) {
            buildMaxHeap(currentArray);
            for (int i = currentArray.length - 1;i >= 1;i --) {
                float temp = (float)currentArray[0];
                currentArray[0] = currentArray[i];
                currentArray[i] = temp;
                heapLength --;
                maxHeapify(0, currentArray);
            }
            return currentArray;
        } else if (currentArray.getClass().toString().equals(type_Double)) {
            buildMaxHeap(currentArray);
            for (int i = currentArray.length - 1;i >= 1;i --) {
                double temp = (double)currentArray[0];
                currentArray[0] = currentArray[i];
                currentArray[i] = temp;
                heapLength --;
                maxHeapify(0, currentArray);
            }
            return currentArray;
        } else {
            buildMaxHeap(currentArray);
            for (int i = currentArray.length - 1;i >= 1;i --) {
                Object temp = currentArray[0];
                currentArray[0] = currentArray[i];
                currentArray[i] = temp;
                heapLength --;
                maxHeapify(0, currentArray);
            }
            return currentArray;
        }
    }
    
    /**
     * build up the heap tree
     * @param currentArray 
     */
    private void buildMaxHeap(Object[] currentArray) {
        heapLength = currentArray.length;
        int begin = currentArray.length/2 - 1;
        for (int i = begin;i >= 0;i --) {
            maxHeapify(i, currentArray);
        }
    }
    
    private int leftChild(int node) {
        int heapLeft = 2 * (node + 1) - 1;
        return heapLeft;
    }
    
    private int rightChild(int node) {
        int heapRight = 2 * (node + 1);
        return heapRight;
    }
    
    /**
     * sort the tree
     * @param node
     * @param currentArray 
     */
    private void maxHeapify(int node,Object[] currentArray) {
        int left = leftChild(node);
        int right = rightChild(node);
        if (currentArray.getClass().toString().equals(type_Integer)) {
            int largest;
            if ((left < heapLength)&&((int)currentArray[left] > (int)currentArray[node])) {
                largest = left;
            }
            else {
                largest = node;
            }
            if ((right < heapLength)&&((int)currentArray[right] > (int)currentArray[largest])) {
                largest = right;
            }
            if (largest != node) {
                int tmp = (int)currentArray[node];
                currentArray[node] = currentArray[largest];
                currentArray[largest] = tmp;
                maxHeapify(largest, currentArray);
            }
        } else if (currentArray.getClass().toString().equals(type_Long)) {
            int largest;
            if ((left < heapLength)&&((long)currentArray[left] > (long)currentArray[node])) {
                largest = left;
            }
            else {
                largest = node;
            }
            if ((right < heapLength)&&((long)currentArray[right] > (long)currentArray[largest])) {
                largest = right;
            }
            if (largest != node) {
                long tmp = (long)currentArray[node];
                currentArray[node] = currentArray[largest];
                currentArray[largest] = tmp;
                maxHeapify(largest, currentArray);
            }
        } else if (currentArray.getClass().toString().equals(type_Float)) {
            int largest;
            if ((left < heapLength)&&((float)currentArray[left] > (float)currentArray[node])) {
                largest = left;
            }
            else {
                largest = node;
            }
            if ((right < heapLength)&&((float)currentArray[right] > (float)currentArray[largest])) {
                largest = right;
            }
            if (largest != node) {
                float tmp = (float)currentArray[node];
                currentArray[node] = currentArray[largest];
                currentArray[largest] = tmp;
                maxHeapify(largest, currentArray);
            }
        } else if (currentArray.getClass().toString().equals(type_Double)) {
            int largest;
            if ((left < heapLength)&&((double)currentArray[left] > (double)currentArray[node])) {
                largest = left;
            }
            else {
                largest = node;
            }
            if ((right < heapLength)&&((double)currentArray[right] > (double)currentArray[largest])) {
                largest = right;
            }
            if (largest != node) {
                double tmp = (double)currentArray[node];
                currentArray[node] = currentArray[largest];
                currentArray[largest] = tmp;
                maxHeapify(largest, currentArray);
            }
        } else {
            int largest;
            if ((left < heapLength)&&(currentArray[left].hashCode() > currentArray[node].hashCode())) {
                largest = left;
            }
            else {
                largest = node;
            }
            if ((right < heapLength)&&(currentArray[right].hashCode() > currentArray[largest].hashCode())) {
                largest = right;
            }
            if (largest != node) {
                Object tmp = currentArray[node];
                currentArray[node] = currentArray[largest];
                currentArray[largest] = tmp;
                maxHeapify(largest, currentArray);
            }
        }
    }
    
    /**
     * calculate the Fibonacci number
     * @param number
     * @return integer result
     */
    protected int fib(int number) {
        if (number == 1) {
            return 1;
        } else if (number == 2) {
            return 1;
        } else if (number > 2) {
            return fib(number - 1) + fib(number - 2);
        } else {
            return 0;
        }
    }
    
    /**
     * calculate the power with the base
     * @param base
     * @param powerNum
     * @return 
     */
    protected double power(double base, int powerNum) {
        
        if (powerNum > 0) {    
            for (int i = 0;i < powerNum;i ++) {
                base = base * base;
            } 
        } else if (powerNum == 0) {
            return 1;
        } else {
            for (int i = 0;i < powerNum;i ++) {
                base = base * base;
            }
            base = 1/base;
        }
        return base;
    }
    
    //abs function
    protected int abs(int a) {
        return Math.abs(a);
    }
    
    protected long abs(long a) {
        return Math.abs(a);
    }
    
    protected float abs(float a) {
        return Math.abs(a);
    }
    
    protected double abs(double a) {
        return Math.abs(a);
    }
    
    //basic trangle function
    
    protected double sin(double a) {
        return Math.sin(a);
    }
    
    protected double arcsin(double e) {
        return Math.asin(e);
    }
    
    protected double sinh(double x) {
        return Math.sinh(x);
    }
    
    protected double cos(double a) {
        return Math.cos(a);
    }
    
    protected double arccos(double e) {
        return Math.acos(e);
    }
    
    protected double cosh(double x) {
        return Math.cosh(x);
    }
    
    protected double tan(double a) {
        return Math.tan(a);
    }
    
    protected double arctan(double e) {
        return Math.atan(e);
    }
    
    protected double tanh(double x) {
        return Math.tanh(x);
    }
    
    protected double cot(double a) {
        return Math.cos(a)/Math.sin(a);
    }
    
    protected String number2String(Object o) {
        return o.toString();
    }
    
    protected int string2Int(String s) {
        return Integer.parseInt(s);
    }
    
    protected double string2Double(String s) {
        return Double.parseDouble(s);
    }
    
    protected float string2Float(String s) {
        return Float.parseFloat(s);
    }
    
    protected long string2Long(String s) {
        return Long.parseLong(s);
    }
    
    protected char[] string2Array(String s) {
        return s.toCharArray();
    }
    
    protected String char2String(char s) {
        return String.valueOf(s);
    }
    //basic file operation
    /**
     * open a file, if it does not exist, then create one
     * @param fileName
     * @return file
     * @throws IOException 
     */
    protected File openfile(String fileName) throws IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();
        }
        System.out.println("file open successfully");
        return f;
    }
    
    /**
     * read the whole file and write it as a string
     * @param f
     * @return file string
     * @throws FileNotFoundException 
     */
    protected String readfile(File f) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String fileLine = "";
        String temp = "";
        for (int i = 1;(temp = br.readLine()) != null;i ++) {
            fileLine = fileLine + temp + System.getProperty("line.separator");
        }
        return fileLine;
    }
    
    /**
     * read the part of the file
     * @param f
     * @param start_index
     * @param end_index
     * @return string
     * @throws FileNotFoundException 
     */
    protected String readfile(File f, int start_index, int end_index) throws FileNotFoundException, IOException {
        
        if (!f.exists()) {
            System.out.println("File does not exist !");
            return "-1";
        }
        String result = readfile(f);
        if (start_index < 0) {
            System.out.println("start_index cannot be less than 0!");
            return "-1";
        }
        if (end_index >= result.length()) {
            System.out.println("end_index cannot be larger than the maximum length !");
            return "-1";
        }
        if (start_index > end_index) {
            System.out.println("start_index cannot be larger than end_index");
            return "-1";
        }
        result.substring(start_index, end_index);
        return result;
    }
    
    /**
     * write content into file, and if writeFromStart is true, then write the content from the start
     * @param f
     * @param content
     * @param writeFromStart
     * @throws FileNotFoundException 
     */
    protected void writefile(File f, String content, boolean writeFromStart) throws FileNotFoundException, IOException {
        
        if (f.exists()) {  
            if (writeFromStart) {
                PrintWriter pw = new PrintWriter(f);
                pw.println(content);
                pw.flush();
                pw.close();
            } else {
                String original = readfile(f);
                PrintWriter pw = new PrintWriter(f);
                pw.println(original + content);
                pw.flush();
                pw.close();
            }
            System.out.println("file write successfully!");
        } else {
            System.out.println("file does not exist!");
        }
        
    }
    
    /**
     * Scan the file
     * @param f
     * @return
     * @throws FileNotFoundException 
     */
    protected Scanner scanFile(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        return sc;
    }
    
    protected Scanner scanFile(String s) {
        Scanner sc = new Scanner(s);
        return sc;
    }
    
    /**
     * print the data to a file
     * @param f
     * @return
     * @throws FileNotFoundException 
     */
    protected PrintWriter printFile(File f) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(f);
        return pw;
    }
} 
