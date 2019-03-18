import java.util.*;
import java.io.*;
public class Merge{

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tmerge/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }



  private static int[] merge(int[]a, int[]b){
    int[] out = new int[a.length+ b.length];
    int a_idx= 0;
    int b_idx= 0;
    for(int i = 0; i < out.length; i++){
      if(a_idx >= a.length) out[i]=b[b_idx++];
      else if (b_idx >= b.length) out[i]=a[a_idx++];
      else if (a[a_idx]<=b[b_idx]) out[i] = a[a_idx++];
      else out[i]=b[b_idx++];
    }
    return out;
  }

  private static int[] mergesortH(int[] data){
      int n = data.length;
      if (n <= 1) return data;
      int mid = n/2;
      int[] a = new int[mid];
      for(int i =0; i < a.length; i++){
        a[i] = data[i];
      }
      int[]b = new int[n-mid];
      for (int i = 0; i < b.length; i++){
          b[i] = data[i + mid];
      }

      return merge(mergesortH(a),mergesortH(b));
  }

  private static void mergesort(int[] data){
    int [] hold = mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i]=hold[i];
    }
  }


  private static int[] mergeO(int a, int b, int lo, int hi){
    int[] out = new int[a+b];

  }

  private static void mergesortO(int[]data, int[]temp, int lo, int hi){
    if(lo < hi){
      int n = hi-lo;
      if (n <= 1) return data;
      int mid = n/2+start;
    }
  }

}
