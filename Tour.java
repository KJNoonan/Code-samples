/*@author Kevin Noonan
 * An object that houses a singly linked list. Points are added into
 * the object by two heuristics. One that adds it to the nearest point the other calculates
 * the smallest distance added to the entire list.
 * */
public class Tour {

	private Node first;
	private int sz;
	private double dist;
	
/*
 * Constructor - initializes an empty tour
 * */
	public Tour() {
		first = null;
		sz = 0;
		dist = 0;
	}

/*
 * Constructor -  initializes the tour object quick without implementing the two given heuristics
 * @parem 4 Point2D points
 * */
	public Tour(Point2D a, Point2D b, Point2D c, Point2D d) {
		Node astop, bstop, cstop, dstop;
		astop = new Node(a);
		bstop = new Node(b);
		cstop = new Node(c);
		dstop = new Node(d);
		first = astop;
		astop.next = bstop;
		bstop.next = cstop;
		cstop.next = dstop;
		dstop.next = first;
		sz = 4;
	}
/*
 *Prints the tour to the standard output
 **/
	public void show() {
		Node curr = first;
		System.out.println("Size is: " + sz);
		for (int i = 0; i < sz; i++) {
			System.out.println(curr.stop);
			curr = curr.next;
		}
	}
/*
 * Draws each point to the tour and connects it to the next point*/
	public void draw() {
		Node curr = first;
		do {
			curr.stop.draw();
			curr.stop.drawTo(curr.next.stop);
			curr = curr.next;
		} while (curr != first);
	}
/*
 * @returns the size of the linked list\
 * */
	public int size() {
		return sz;
	}
/*
 * @returns the distance of the tour
 * */
	public double distance() {
		return dist;
	}
/*
 * Employs the nearest point heuristic
 * @param Point2D point
 * */
	public void insertNearest(Point2D p) {
		Node tmp = new Node(p);

		if (sz == 0) {
			first = tmp;
			tmp.next = first;
			sz++;
			return;
		} else {
			double lowd = p.distanceTo(first.stop);
			Node lowpt = first;
			Node curr = first.next;
			while (curr != first) {
				double d = p.distanceTo(curr.stop);
				if (lowd > d) {

					lowd = d;
					lowpt = curr;
				}
				curr = curr.next;
			}
			// adjust the distance
			dist -= lowpt.stop.distanceTo(lowpt.next.stop);
			dist += (p.distanceTo(lowpt.stop) + p.distanceTo(lowpt.next.stop));

			tmp.next = lowpt.next;
			lowpt.next = tmp;
			sz++;
			return;
		}
	}
	/*
	 * Employs the smallest distance heuristic
	 * @param Point2D point
	 * */
	public void insertSmallest(Point2D p) {
		Node tmp = new Node(p);

		if (sz == 0) {
			first = tmp;
			tmp.next = first;
			sz++;
			return;
		} else {
			double lowd = p.distanceTo(first.stop)+p.distanceTo(first.next.stop);
			Node lowpt = first;
			Node curr = first.next;
			int i = 0;
			while (curr.next != first) {
				i++;
				double d = (p.distanceTo(curr.stop)+p.distanceTo(curr.next.stop));
				if (lowd > d) {
					lowd = d;
					lowpt = curr;
				}
				curr = curr.next;
			}
			// adjust the distance
			dist -= lowpt.stop.distanceTo(lowpt.next.stop);
			dist += lowd;

			tmp.next = lowpt.next;
			lowpt.next = tmp;
			sz++;
			return;
		}
	}
/*Node class sets up nodes to be used in a linked list*/
	private class Node {
		private Point2D stop;
		private Node next;

		/*
		 * Node constructor initializes a value and a null address
		 * @param Point2D point*/
		private Node(Point2D x) {
			stop = x;
			next = null;
		}
	}
}