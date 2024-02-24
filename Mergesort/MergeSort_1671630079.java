import java.util.ArrayList;
import java.util.Scanner;
public class MergeSort{

    ArrayList< Integer > getInput(ArrayList < Integer > al) {
        System.out.println(" Welcome to merge sort program !");
        Scanner ic = new Scanner(System.in);
        System.out.println("Enter the number of elements you want in array: ");
        int num = ic.nextInt();
        System.out.println("Enter the  " + num + " elements you want : ");
        while  (num-- >0){
            al.add(ic.nextInt());
        }
        return al;


    }

    void getOutput (ArrayList < Integer > al) {
        System.out.println(" The Unsorted Elements are : "+ al);
        sort(al, 0, al.size() - 1);
        System.out.println("The sorted Element are:" + al);
    }
    
    void merge(ArrayList < Integer > al, int beg, int mid, int end) {
        ArrayList < Integer > sortedElements= new ArrayList < Integer > (); 
        int m = mid + 1;
        int d = beg;

        while (d <= mid && m <= end) {
            if (al.get(d) < al.get(m)) {
                sortedElements.add(al.get(d));
                d++;
            } else {
                sortedElements.add(al.get(m));
                m++;
            }
        }

        for (int k = d; k <= mid; k++) sortedElements.add(al.get(k));

        for (int k = 0; k < sortedElements.size(); k++) {
            al.set(beg + k, sortedElements.get(k));
        }
    }
    void sort(ArrayList < Integer > al, int beg, int end) {
        if (beg >= end) return;

        int mid = (beg + end) / 2;
        sort(al, beg, mid);
        sort(al, mid + 1, end);
        merge(al, beg, mid, end);
    }

    public static void main(String[] args) {
        MergeSort value = new MergeSort();
        ArrayList < Integer > al = new ArrayList < Integer > ();
        value.getInput(al);
        value.getOutput(al);



    }

}