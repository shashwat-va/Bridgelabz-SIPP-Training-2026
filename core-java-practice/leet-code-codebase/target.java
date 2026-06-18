/*find the target element in the array */
import.java.util.*;
public class target {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();    
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println("Enter the target element:");
        int target = sc.nextInt();

        int index = -1;
        for(int i=0;i<size;i++){
            if(arr[i]==target){
                index=i;
                break;
            }

        }
        if(index != -1){
            System.out.println("Target element found at index: " + index);
        } else {
            System.out.println("Target element not found in the array.");
        }
}