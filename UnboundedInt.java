public class UnboundedInt {

  private int manyNodes; //impliment it in constructor
  private IntNode head;
  private IntNode tail;
  private IntNode cursor; // idk what to do with this. might be helpful?

  public UnboundedInt(String userString) {

    if(userString.length() <= 3){
    
      this.tail = new IntNode(Integer.parseInt(userString),null); // temporarily 
      this.head = new IntNode(-1,tail); //make it negative 1 so that to string can know the differnce between 1000 and 1. 
      manyNodes++;
    } 
    else
    {
      //sets them both to 0
      this.tail = new IntNode(0,null);
      this.head = new IntNode(0,tail);
    
      int length = userString.length();

      // Iterate backwards in steps of 3
      for (int i = length; i > 0; i -= 3) {
        int start = Math.max(i - 3, 0); // prevents index out of bounds excpetion
        String substring = userString.substring(start, i);
        
        IntNode newNode = tail;
        newNode.addNodeAfter(Integer.parseInt(substring));
        manyNodes++;
        tail = newNode.getLink();
    }
      while(tail.getData() == 0)
      { //accounts for when the user inputs something like "00000012312300000123123" --> shortens it to "12312300000123123"
        IntNode cursor = head;
        while(cursor.getLink().getLink() != null){
          cursor = cursor.getLink();
        } if(cursor.getLink().getData() == 0){
          cursor.removeNodeAfter();
          tail=cursor;
        }
      }
      head = head.getLink().getLink();// erases the 0's;
    }
    }
    
  // public UnboundedInt add (UnboundedInt userInput){
  //     UnboundedInt 
      
  
  // }
  
  
  
  
  public String toString(){
    String returnString = "";
    IntNode cursor;
  
    for (cursor = head; cursor != null; cursor = cursor.getLink()) {
      if(cursor.getLink() != null){
         if(cursor.getLink().getLink() == null && head.getData()==-1){
            returnString = returnString +  tail.getData();
            cursor = cursor.getLink();
         } else{
         if(cursor.getData() <= 9){
            returnString = "," + "00" + cursor.getData() + returnString;
         } else if (cursor.getData() <= 99){
            returnString = "," +"0" + cursor.getData() + returnString;
         } else{
            returnString =  "," + cursor.getData() + returnString;
         }
         }
      } else{
         returnString = cursor.getData() + returnString;
         
      
    }
    }
      return returnString;
    }
   
  
  

  public static void main(String[] args) {

    UnboundedInt meow = new UnboundedInt("0123456"); 
    UnboundedInt meow1 = new UnboundedInt("00000234523452345234500001234123400002300012341234000"); //ASK ABOUT THIS
    UnboundedInt meow2 = new UnboundedInt("0");;
    System.out.println(meow.toString()); 
    System.out.println(meow1.toString());
    System.out.println(meow2.toString());
  }

}