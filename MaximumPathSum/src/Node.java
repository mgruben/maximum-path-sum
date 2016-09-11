/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A Node data structure.
 * This data structure has the added ability to sever its children Nodes
 * after having calculated which of them combine with itself to yield the
 * largest sum.
 * @author Michael <GrubenM@GMail.com>
 */
public class Node {
    private int num;
    private Node left;
    private Node right;
    
    public Node(int num) {
        this.num = num;
        left = null;
        right = null;
    }
    
    public void setLeft(Node n) {
        left = n;
    }
    
    public void setRight(Node n) {
        right = n;
    }
    
    public int getNum() {
        return num;
    }
    
    private void setNum(int num) {
        this.num = num;
    }
    
    /**
     * Sets the Node's num field to the sum of its children, recursively,
     * then severs its relationship to its children.
     * This method is best used iteratively in a bottom-up approach,
     * by setting the num field for each Node in the second-to-last row of the
     * triangle first, then moving up one row and repeating until every Node
     * in the triangle has had its sums calculated.
     */
    public void sumToNum(int num) {
        setNum(getBestSum());
        left = null;
        right = null;
    }
    
    /**
     * Recursive method for determining the best sum of the given node.
     * This method is computationally prohibitive for high Nodes in large
     * triangles.
     * Accordingly, its best use is to return the sum for the second-to-last
     * row, which can then be assigned as the num for that Node using setNum(). 
     */
    public int getBestSum() {
        if (left == null && right == null) return num;
        else return num + Math.max(left.getBestSum(), right.getBestSum());
    }
    
    public String toString() {
        return Integer.toString(num);
    }
}
