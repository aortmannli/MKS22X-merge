import java.util.*;
import java.io.*;
public class Merge{

  public static void main(String[] args){
    int[] a = {1,4,8};
    int[] b = {3,5,9};
    int[] array = merge(a,b);
    System.out.println(Arrays.toString(array));
  }
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){

  }

/*
mergesort(data,lo,hi):
  if lo >= hi :
    return
  mergesort left side
  mergesort right side
  merge
  */
  private static int[] merge(int[]a, int[]b){
    int[] out = new int[a.length+ b.length];
    int a_idx= 0;
    int b_idx= 0;
    for(int i = 0; i < out.length; i++){
      if(a_idx == a.length) out[i]=b[b_idx++];
      else if (b_idx == b.length) out[i]=a[a_idx++];
      else if (a[a_idx]<b[b_idx]) out[i] = a[a_idx++];
      else out[i]=b[b_idx++];
    }
    return out;
  }

  private static void mergesortH(int[] og, int a, int b){

  }
}
