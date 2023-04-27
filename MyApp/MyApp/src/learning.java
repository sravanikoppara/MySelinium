public class learning {
        public static void main(String[] args){
      //String Concatenation
      String str1 = "Rock";
      String str2 = "Star";
      //Method 1 : Using concat
      String str3 = str1.concat(str2);
      System.out.println(str3);
      //Method 2 : Using "+" operator
      String str4 = str1 + str2;
      System.out.println(str4);
     System.out.println(str4.compareTo(str3));
     System.out.println("equals method:"+str4.equals(str3));
     System.out.println((str1 == str1)+"=============="+(str3 == str4));
    

      }
      }
    