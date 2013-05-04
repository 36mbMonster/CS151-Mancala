public class Controller implements Runnable
{
   private MancalaModel model;

   public Controller(MancalaModel paramModel)
   {
      this.model = paramModel;
   }

   public void run()
   {
      try
      {
         Thread.sleep(1000L);

         //this.model.solve(0, 0);
      }
      catch (Exception localException)
      {
      }
   }
}
