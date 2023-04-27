import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

class Programmer extends Employee{
        int bonus=10000;
        public static void main(String args[]){
          Programmer p=new Programmer();
          System.out.println("Programmer salary is:"+p.salary);
          System.out.println("Bonus of Programmer is:"+p.bonus);
        
          for(int i=0;i< p.Names.size();i++)
          {
          System.out.println(p.Names.get(i));
          }
       }
       }