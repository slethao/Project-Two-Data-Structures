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
  /* getters and setters */
  public int getManyNodes()
  {
    return this.manyNodes;
  }
  public IntNode head()
  {
    return this.head;
  }
  public IntNode tail()
  {
    return this.tail;
  }
  public IntNode cursor()
  {
    return this.cursor;
  }
  public void setManyNodes(int givenAmount)
  {
    this.manyNodes = givenAmount;//
  }
  public void setHead(IntNode givenHead)
  {
    this.head = givenHead;//
  }
  public void setTail(IntNode givenTail)
  {
    this.tail = givenTail;//
  }
  public void setCursor(IntNode givenAddress)
  {
    this.cursor = givenAddress; //
  }
  
  public UnboundedInt add(UnboundedInt userInput) { //sommer.....i am so sorry.....i know this looks scary and awful.....i will fix it soon....but it works ! :3
      UnboundedInt intSum = new UnboundedInt("0"); //place holder value
      
      IntNode intSumTail = new IntNode(0,null);
      IntNode intSumHead = new IntNode(0,intSumTail);
      
      IntNode cursor1 = this.head;
      IntNode cursor2 = userInput.head;
      boolean cursor1Null = false;
      boolean cursor2Null = false;
      int carryOver = 0;
      int sum = 0;
      
      if(cursor1 == null){
        cursor1Null = true;
      } else if(cursor2 == null){
        cursor2Null = true;
      }
      
      if(this.manyNodes == 1){ // if inputed node is -1, 1234
        cursor1 = cursor1.getLink();
      }
      if(userInput.manyNodes == 1){
        cursor2 = cursor2.getLink();
      }

      while(cursor1Null == false || cursor2Null == false){
        int val1 = cursor1.getData();
        int val2 = cursor2.getData();
        
        if(cursor1Null == true){
            sum = carryOver + cursor2.getData();
        } else if(cursor2Null == true){
            sum = carryOver + cursor1.getData();
        } else{
            sum = carryOver + cursor1.getData() + cursor2.getData();
        }
        carryOver = 0;

        if(sum > 999){ 
            sum = sum - 1000;
            carryOver++;
        } 
        
        //adds sum to the end 
        IntNode newNode = intSumTail;
        newNode.addNodeAfter(sum);
        intSumTail = newNode.getLink();
        intSum.manyNodes++;
       
        
        if(cursor1.getLink() == null){
          cursor1Null = true;
        } if(cursor2.getLink() == null){
          cursor2Null = true;
        }

        if(cursor1Null == false){
          cursor1 = cursor1.getLink();
        } if(cursor2Null == false){
          cursor2 = cursor2.getLink();
        }
      } // end of while loop
      if(carryOver == 1){
        IntNode newNode = intSumTail;
        newNode.addNodeAfter(carryOver);
        intSumTail = newNode.getLink();
        intSum.manyNodes++;
      }
      intSum.head = intSumHead.getLink().getLink();
      intSum.tail = intSumTail;
      return intSum;
  }
  
  
  public void advance()
  {
    //
  }
  public void start()
  {
    //
  }
  public void addEnd()
  {
    //
  }
  
   public static void outPut(IntNode head){
      for(IntNode cursor = head; cursor != null; cursor = cursor.getLink()){
         System.out.println(cursor.getData());
      }
    }
  
  public String toString(){ // need to add an illegal state exception thing here
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
      } 
      else
      {
         returnString = cursor.getData() + returnString;
         
      
    }
    }
      return returnString;
    }
   
  
  

  public static void main(String[] args) {

    UnboundedInt meow = new UnboundedInt("100000000000"); 
    UnboundedInt meow1 = new UnboundedInt("2"); 
    UnboundedInt meow2 = new UnboundedInt("0");
   
    UnboundedInt meow4 = meow.add(meow1);
    System.out.println(meow4.toString());
  }

}
