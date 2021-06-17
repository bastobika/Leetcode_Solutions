package Easy;

/* At a lemonade stand, each lemonade costs $5. 
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  
 * You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 * Note that you don't have any change in hand at first.
 * Return true if and only if you can provide every customer with correct change.
*/

public class LC860_LemonadeChange {

	public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5)
                fives++;
            else if(bills[i] == 10){
                if(fives > 0){
                    tens++;
                    fives--;
                }else
                    return false;
            }
            else{
                if(fives < 1 && tens < 1)
                    return false;
                else{
                    if(tens >= 1)
                        tens--;
                    else
                        fives -= 2;
                    if(fives > 0)
                        fives--;
                    else
                        return false;
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
