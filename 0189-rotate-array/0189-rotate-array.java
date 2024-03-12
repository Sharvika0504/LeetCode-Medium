class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        //custome linkedList
        class Node{
            int data;
            Node next;

            Node(int d){
                data = d;
                next = null;
            }
        }
        //Populate the linkedlist with the elements of the array
        Node head = new Node(nums[0]);
        Node current = head;
        Node last = null;
        Node previous = head;
        for(int i = 1; i < nums.length; i ++){
            current.next = new Node(nums[i]);
            current = current.next;
        }  
        //put the current element in the last 
        last = current;
        //get the new head position
        int rotateSteps = nums.length - k;
        Node newLast = head;
        for(int i = 1; i < rotateSteps; i++){
            newLast= newLast.next;
        }
        //Just change the head and last element of the linkedList
        if(rotateSteps > 0){
          last.next = head; //make the list circular temp
          head = newLast.next;
          newLast.next = null;
        }
        //convert back to array
        current = head;
        for(int i = 0 ; i < nums.length; i++){
            nums[i] = current.data;
            current = current.next;
        }
    }
}