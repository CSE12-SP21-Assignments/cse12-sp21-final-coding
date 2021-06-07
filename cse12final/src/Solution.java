import java.util.Comparator;

public class Solution {
	
	private class KeyComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode self, ListNode other) {
			int val = -1;
			if(self != null) val = self.val;
			
			int otherVal = -1;
			if(other != null) otherVal = other.val;
			
			if(val > otherVal) return 1;
			if(val < otherVal) return -1;
			return 0;
		}
	}
	
	public ListNode getOverallRanking(ListNode[] lists) {
		// TODO: finish this method
		return null;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}