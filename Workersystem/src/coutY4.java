public class coutY4 {
    double F;
    int contract ;
     public double coutY44(int y4,int contract)
     {  double sum;
         this.contract=contract;
          if(contract<6)
          {    F=1.2;
                sum=y4*F*contract;
          }else if(contract>6&&contract<=10)
          {
              F=1;
              sum=y4*F*contract;
          }
          else
          {      F=0.5;

              sum=y4*F*contract;
          }

          return  sum;
     }

}
