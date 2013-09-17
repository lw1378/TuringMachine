
/**
 *
 * @author Lai Wang, 0488605
 */
abstract public class Run_Model extends API_List{
    
    public Run_Model() {
        super();
    }
    
    //method to run at the beginning of the program
    abstract protected void init() throws Exception;
    //while loop with a boolean value after init()
   // abstract protected void setup(boolean condition);
}
