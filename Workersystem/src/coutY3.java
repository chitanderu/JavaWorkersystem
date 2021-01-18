public class coutY3 {
   int newworker;
   double E;
    public double coutY33(int y3,int newworker)
    {      this.newworker=newworker;
           double sum=0;
         if(newworker>1&&newworker<=20)
         {   E=1;
             sum=y3*newworker*E*0.5;
         }else  if(newworker>20&&newworker<40)
            {  E=0.6;

                sum=y3*newworker*E*0.5;
            }
          else if(newworker>=41&&newworker<100)
            {
                E=0.3;
                sum=y3*newworker*E*0.5;
            }else
         {    E=0.15;

             sum=y3*newworker*E*0.5;
         }






        return sum;
    }



}
