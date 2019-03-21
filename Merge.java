import java.util.*;
import java.io.*;
public class Merge{
  public static int insertion = 100;

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
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


  public static void printArray(int data[]){
      int n = data.length;

      System.out.print("{");
      for (int i=0; i<n; ++i){
        if (i != n-1) System.out.print(data[i]+", ");
        else System.out.print(data[i]+"");
      }
      System.out.print("}");
      System.out.println();
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

  public static void mergesort(int[]data){
    mergesortOpt(data, 0, data.length);
  }

  private static void mergesortOpt(int[]data, int start, int end){
      if (start + 1>= end) return;

      if(end - start < 43){
        insertionSort(data,start,(start + end + 1)/2);
        insertionSort(data,(start + end + 1)/2,end);
      }else{
        mergesortOpt(data,start,(start + end + 1)/2);
        mergesortOpt(data,(start + end + 1)/2,end);
      }
      merge(data, start, end);
    }

    private static void merge(int[] data, int start, int end){
        int x = (end-start + 1)/2;
        int[] temp1 = new int[x];
        int[] temp2 = new int[end-start-x];
        for(int i = 0; i < temp1.length; i++){
          temp1[i] = data[start+i];
        }
        for(int i = 0; i < temp2.length; i++){
          temp2[i] = data[start+temp1.length + i];
        }

        for(int i = start, a = 0, b = 0; i < end; i++){
          if (a < temp1.length && b < temp2.length){
            if (temp1[a]>temp2[b]){
              data[i]=temp2[b];
              b++;
            }else{
              data[i]=temp1[a];
              a++;
            }
          }else{
            if (a < temp1.length){
              data[i]=temp1[a];
              a++;
            }else {
              data[i]=temp2[b];
              b++;
            }
          }
        }
    }


    public static void insertionSort(int[] data, int start, int end){
        int orig;
        for (int x = 1+start; x < end; x++){
          orig = data[x];
          for (int y = x; y > start && data[y] < data[y-1] ; y--){
              data[y] = data[y-1];
              data[y-1] = orig;
          }
        }
    }



}
