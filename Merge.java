import java.util.*;
import java.io.*;
public class Merge{

  public static void main(String[] args){
    int[] a = {1,4,8,2,5,8,9,17,0,18};
    int[] b = {3,5,9};
    mergesortH(a);
    System.out.println(Arrays.toString(a));
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

  private static void mergesortH(int[] data){
      int mid = data.length/2;
      int[] a = new int[mid];
      for(int i =0; i < mid; i++){
        a[i] = data[i];
      }
      int[]b = new int[data.length-mid];
      for(int x = 0; x < b.length; x++){
        for(int y = mid; y < data.length; y++){
          b[x]=data[y];
        }
      }
      mergesortH(a);
      mergesortH(b);
      data = merge(a,b);
  }
}
