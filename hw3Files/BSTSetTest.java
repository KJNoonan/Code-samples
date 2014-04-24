import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class BSTSetTest {
  private BSTSet set, emptyset, setOdd, setLeft;
  private BSTSet setB1, setB2, setB3, setB4;
  private String s = "90 30 100 10 80 20 40 60 50 70";
  private String sodd = "31 28 65 21 29 50 68 25 52 67 71";
  private String sleft = "5 4 3 2 1";
  private String sb1 = "40 20 60 10 30 50 70";
  private String sb2 = "40 30 20 10 60 70 50";
  private String sb3 = "40";
  private String sb4 = "40 20 60 10 30 50 70 5 15 25 35 45 55";

  @Before
  public void setUp() throws Exception {
    set = BSTSet.fromString(s);
    emptyset = new BSTSet();
    setOdd = BSTSet.fromString(sodd);
    setLeft = BSTSet.fromString(sleft);
    setB1 = BSTSet.fromString(sb1);
    setB2 = BSTSet.fromString(sb2);
    setB3 = BSTSet.fromString(sb3);
    setB4 = BSTSet.fromString(sb4);
  }

  @Test
  public void testSize() {
    assertEquals(0, emptyset.size());
    assertEquals(10, set.size());
  }

  @Test
  public void testHeight() {
    assertEquals(-1, emptyset.height());
    assertEquals(5, set.height());
  }

  @Test
  public void testSizeOdd() {
    assertEquals(0, emptyset.sizeOdd());
    assertEquals(0, set.sizeOdd());
    assertEquals(7, setOdd.sizeOdd());
  }

  @Test
  public void testSizeAtDepth() {
    assertEquals(0, setOdd.sizeAtDepth(-1));
    assertEquals(1, setOdd.sizeAtDepth(0));
    assertEquals(2, setOdd.sizeAtDepth(1));
    assertEquals(4, setOdd.sizeAtDepth(2));
    assertEquals(4, setOdd.sizeAtDepth(3));
    assertEquals(0, setOdd.sizeAtDepth(4));

    assertEquals(0, setLeft.sizeAtDepth(-1));
    assertEquals(1, setLeft.sizeAtDepth(0));
    assertEquals(1, setLeft.sizeAtDepth(1));
    assertEquals(1, setLeft.sizeAtDepth(2));
    assertEquals(1, setLeft.sizeAtDepth(3));
    assertEquals(1, setLeft.sizeAtDepth(4));
    assertEquals(0, setLeft.sizeAtDepth(5));
  }

  @Test
  public void testsizeLessThanDepth() {
    assertEquals(0, setOdd.sizeLessThanDepth(-1));
    assertEquals(0, setOdd.sizeLessThanDepth(0));
    assertEquals(1, setOdd.sizeLessThanDepth(1));
    assertEquals(3, setOdd.sizeLessThanDepth(2));
    assertEquals(7, setOdd.sizeLessThanDepth(3));
    assertEquals(11, setOdd.sizeLessThanDepth(4));

    assertEquals(0, setLeft.sizeLessThanDepth(-1));
    assertEquals(0, setLeft.sizeLessThanDepth(0));
    assertEquals(1, setLeft.sizeLessThanDepth(1));
    assertEquals(2, setLeft.sizeLessThanDepth(2));
    assertEquals(3, setLeft.sizeLessThanDepth(3));
    assertEquals(4, setLeft.sizeLessThanDepth(4));
    assertEquals(5, setLeft.sizeLessThanDepth(5));
  }

  @Test
  public void testsizeGreaterThanDepth() {
    assertEquals(0, emptyset.sizeGreaterThanDepth(-1));
    assertEquals(0, emptyset.sizeGreaterThanDepth(0));
    assertEquals(4, setLeft.sizeGreaterThanDepth(0));
    assertEquals(3, setLeft.sizeGreaterThanDepth(1));
    assertEquals(2, setLeft.sizeGreaterThanDepth(2));
    assertEquals(1, setLeft.sizeGreaterThanDepth(3));
    assertEquals(0, setLeft.sizeGreaterThanDepth(4));

    assertEquals(10, set.sizeGreaterThanDepth(-1));
    assertEquals(9, set.sizeGreaterThanDepth(0));
    assertEquals(7, set.sizeGreaterThanDepth(1));
    assertEquals(5, set.sizeGreaterThanDepth(2));
    assertEquals(3, set.sizeGreaterThanDepth(3));
    assertEquals(2, set.sizeGreaterThanDepth(4));
    assertEquals(0, set.sizeGreaterThanDepth(5));
  }

  @Test
  public void testIsPerfectlyBalancedS() {
    assertEquals(true, emptyset.isPerfectlyBalancedS());
    assertEquals(true, setB1.isPerfectlyBalancedS());
    assertEquals(false, setB2.isPerfectlyBalancedS());
    assertEquals(true, setB3.isPerfectlyBalancedS());
    assertEquals(false, set.isPerfectlyBalancedS());
  }

  @Test
  public void testIsPerfectlyBalancedH() {

    assertEquals(false, set.isPerfectlyBalancedH());
    assertEquals(true, setB1.isPerfectlyBalancedH());
    assertEquals(true, emptyset.isPerfectlyBalancedH());
    assertEquals(true, setB3.isPerfectlyBalancedH());
    assertEquals(false, setB2.isPerfectlyBalancedH());
    assertEquals(false, setB4.isPerfectlyBalancedH());
  }

  @Test
  public void testIsOddBalanced() {
    BSTSet s1 = BSTSet.fromString("41 21 61 10 30 50 70 5 15 25 35 45 55 63 73 66");
    BSTSet s2 = BSTSet.fromString("40 20 60 11 31 51 71");
    BSTSet s3 = BSTSet.fromString("40 20 60 11 31 51 70");
    BSTSet s4 = BSTSet.fromString("41 20 60 11 31 51 71");
    BSTSet s5 = BSTSet.fromString("40 20 10 30 60 50 71");
    BSTSet s6 = BSTSet.fromString("41 21 61");
    BSTSet s7 = BSTSet.fromString("40 20 60");
    assertEquals(true, emptyset.isOddBalanced());
    assertEquals(true, s1.isOddBalanced());
    assertEquals(true, s2.isOddBalanced());
    assertEquals(false, s3.isOddBalanced());
    assertEquals(true, s4.isOddBalanced());
    assertEquals(false, s5.isOddBalanced());
    assertEquals(true, s6.isOddBalanced());
    assertEquals(true, s7.isOddBalanced());
  }

  @Test
  public void testIsSemiBalanced() {
    BSTSet s1 = BSTSet.fromString("40 20 60 10 30 50 70 1 15 25 30 35");
    BSTSet s2 = BSTSet.fromString("40 20 60 10 30 50 70 1 15 25 30");
    BSTSet s3 = BSTSet.fromString("90 30 100 10 80 20 40 60 5 85 35 95 105 2 6 110 103 104 102 93 97 96 82 86 12 21 45 62 106 111 92 94 98 34 36");

    assertEquals(true, emptyset.isSemiBalancedI());
    assertEquals(true, s1.isSemiBalancedI());
    assertEquals(false, s2.isSemiBalancedI());
    assertEquals(true, s3.isSemiBalancedI());
  }

  @Test
  public void testRemoveOddSubtrees() {
    BSTSet s1 = BSTSet.fromString("41 20 10 30 60 50 70 75");
    BSTSet e1 = BSTSet.fromString("");
    BSTSet s2 = BSTSet.fromString("40 20 11 31 60 50 71 80");
    BSTSet e2 = BSTSet.fromString("40 20 60 50");
    s1.removeOddSubtrees();
    assertEquals(0, s1.size());
    assertEquals(e1.toString(), s1.toString());

    s2.removeOddSubtrees();
    assertEquals(4, s2.size());
    assertEquals(e2.toString(), s2.toString());
  }

  @Test
  public void testRemoveDepthGreaterThan() {
    BSTSet s1 = BSTSet.fromString("60 40 80 30 50 10 35 70 65 75 90");
    BSTSet e1 = BSTSet.fromString("60 40 80 30 50 70 90");
    BSTSet s2 = BSTSet.fromString("10 70 20 60 30 50 40");
    BSTSet e2 = BSTSet.fromString("10 70 20");
    BSTSet s3 = BSTSet.fromString("20 10 30");

    assertEquals(3, s1.height());
    s1.removeDepthGreaterThan(2);
    assertEquals(2, s1.height());
    assertEquals(e1.toString(), s1.toString());

    assertEquals(6, s2.height());

    s2.removeDepthGreaterThan(2);
    assertEquals(2, s2.height());
    assertEquals(e2.toString(), s2.toString());

    s3.removeDepthGreaterThan(-1);
    assertEquals(-1, s3.height());
    assertEquals(0, s3.size());
    assertEquals(emptyset.toString(), s3.toString());
  }

  @Test
  public void testRemoveLeaves() {
    BSTSet s1 = BSTSet.fromString("40 20 60 10 30 65");
    BSTSet e1 = BSTSet.fromString("40 20 60");
    BSTSet s2 = BSTSet.fromString("10 20 30 40 50");
    BSTSet e2 = BSTSet.fromString("10 20 30 40");
    BSTSet s3 = BSTSet.fromString("40");
    assertEquals(2, s1.height());
    s1.removeLeaves();
    assertEquals(1, s1.height());
    assertEquals(e1.toString(), s1.toString());
    s2.removeLeaves();
    assertEquals(3, s2.height());
    assertEquals(e2.toString(), s2.toString());
    s3.removeLeaves();
    assertEquals(emptyset.toString(), s3.toString());
  }

  @Test
  public void testRemoveSingles() {
    BSTSet s1 = BSTSet.fromString("5 40 20 60 10 30 50 70");
    BSTSet e1 = BSTSet.fromString("40 20 60 10 30 50 70");
    BSTSet s2 = BSTSet.fromString("20 10 70 30 80 50 40 60");
    BSTSet e2 = BSTSet.fromString("20 10 70 50 80 40 60");
    BSTSet s3 = BSTSet.fromString("40 20 60");
    BSTSet e3 = BSTSet.fromString("40 20 60");


    s1.removeSingles();
    assertEquals(e1.toString(), s1.toString());

    s2.removeSingles();
    assertEquals(e2.toString(), s2.toString());

    s3.removeSingles();
    assertEquals(e3.toString(), s3.toString());
  }

  @Test
  public void testAddZeroToSingles() {
    BSTSet s1 = BSTSet.fromString("10 50 20 40 30");
    int[] e1 = {10, 0, 50, 20, 0, 0, 40, 30, 0};

    s1.addZeroToSingles();
    assertEquals(9, s1.size());
    Iterator<Integer> it = s1.levelOrder().iterator();
    for(int i = 0; i < e1.length; i++) {
      assertEquals(true, it.hasNext());
      assertEquals(e1[i], (int) it.next());
    }
  }

  @Test
  public void testSizeAtHeight() {
    //    set.drawTree(); StdDraw.show(10000);
    assertEquals(4, set.sizeAtHeight(0));
    assertEquals(2, set.sizeAtHeight(1));
    assertEquals(1, set.sizeAtHeight(2));
    assertEquals(1, set.sizeAtHeight(3));
    assertEquals(1, set.sizeAtHeight(4));
    assertEquals(1, set.sizeAtHeight(5));
    assertEquals(0, set.sizeAtHeight(6));
  }

  @Test
  public void testSizeLessThanHeight() {
    //    set.drawTree(); StdDraw.show(5000);
    assertEquals(0, set.sizeLessThanHeight(0));
    assertEquals(4, set.sizeLessThanHeight(1));
    assertEquals(6, set.sizeLessThanHeight(2));
    assertEquals(7, set.sizeLessThanHeight(3));
    assertEquals(8, set.sizeLessThanHeight(4));
    assertEquals(9, set.sizeLessThanHeight(5));
    assertEquals(10, set.sizeLessThanHeight(6));
  }

  @Test
  public void testSizeGreaterThanHeight() {
    assertEquals(10, set.sizeGreaterThanHeight(-1));
    assertEquals(6, set.sizeGreaterThanHeight(0));
    assertEquals(4, set.sizeGreaterThanHeight(1));
    assertEquals(3, set.sizeGreaterThanHeight(2));
    assertEquals(2, set.sizeGreaterThanHeight(3));
    assertEquals(1, set.sizeGreaterThanHeight(4));
    assertEquals(0, set.sizeGreaterThanHeight(5));
    ;
  }

  @Test
  public void testRemoveHeight() {
    BSTSet s1 = BSTSet.fromString("40 20 10 30 60 50 70");
    BSTSet e1 = BSTSet.fromString("40 20 60");
    BSTSet s2 = BSTSet.fromString("40 20 10 30 60 50 70 80");
    BSTSet e2 = BSTSet.fromString("40 60 50");
    BSTSet s3 = BSTSet.fromString("20 10 30");

    s1.removeHeight(0);
    assertEquals(3, s1.size());
    assertEquals(e1.toString(), s1.toString());
    s2.removeHeight(1);
    assertEquals(3, s1.size());
    assertEquals(e2.toString(), s2.toString());
    s3.removeHeight(1);
    assertEquals(0, s3.size());
    assertEquals(emptyset.toString(), s3.toString());
  }

}
