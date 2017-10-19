//TC:O(nlogk) and SC:O(n)
public class Solution{
	 public ListNode mergeKLists(ListNode[] lists) 
    {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
       if(lists==null||lists.length==0) return null;
       PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
           public int compare(ListNode l1, ListNode l2) {
               return l1.val-l2.val;
           }
       });
     for(ListNode node:lists){
         if(node!=null)
         q.offer(node);
     }
      while(!q.isEmpty()){
          ListNode temp = q.poll();
          cur.next = temp;
          if(temp.next!=null)
              q.offer(temp.next);
          cur=cur.next;
      }
        return dummy.next;
    }
}