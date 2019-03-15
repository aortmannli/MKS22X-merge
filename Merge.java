public class Merge{

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
      if(a == a.length);
      if (a[a_idx]<b[b_idx]){
        out[i] = a[a_idx++];
      }else{
        out[i]=b[b_idx++];
      }
    }

  }

  private static void mergesortH(int[] og, int a, int b){

  }
}
