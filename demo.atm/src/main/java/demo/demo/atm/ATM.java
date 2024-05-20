package demo.demo.atm;


public class ATM implements Runnable{
	

	    protected static final int[] currDenom = { 1000, 500, 100 };

	    protected static int[] currNo = {1,4,2,2,10};

	    protected  int[] count = { 0, 0, 0, 0 ,0};

	    protected static int total = 0;

	    protected  int amount=0;

	    public ATM(int amount){
	        this.amount=amount;
	    }

	    public static void calcTotal(){       
	        for(int i = 0; i < currDenom.length; i++){
	            total=total+currDenom[i]*currNo[i];
	        }
	    }
	    
	    public  synchronized  void  withdrawCash() {
	        if(amount<=total){
	            for (int i = 0; i < currDenom.length; i++) {
	                if (currDenom[i] <= amount) {
	                    int noteCount = amount / currDenom[i];
	                    if(currNo[i]>0){ 
	                        count[i] = noteCount>=currNo[i]?currNo[i]:noteCount;
	                        currNo[i] =  noteCount>=currNo[i]?0:currNo[i]- noteCount;
	                        total=total-(count[i]*currDenom[i]);
	                        amount = amount -(count[i]*currDenom[i]);
	                    }                
	                }
	            }
	            displayNotes();
	            displayLeftNotes();

	        }
	        else { 
	            System.out.println("Unable to dispense cash at this moment for this big amount");
	        }

	    }
	    
	  //to display notes
	    private void displayNotes(){
	        for (int i = 0; i < count.length; i++) {
	            if (count[i] != 0) {
	                System.out.println(currDenom[i] + " * " + count[i] + " = " + (currDenom[i] * count[i]));
	            }
	        }
	    }

	    
	  //Display left notes.
	     private void displayLeftNotes(){
	        for(int i = 0; i < currDenom.length; i++){
	            System.out.println("Notes of "+currDenom[i]+" left are "+currNo[i]);
	        }

	    }
	
	@Override
	public void run() {
		
        withdrawCash();
		
	}

}
