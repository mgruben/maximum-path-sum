
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
 * A triangle data structure, which adds nodes into a triangle from top to
 * bottom, and from left to right.
 * Nodes are stored in a 1D ArrayList, and "row" and "col" are stored to
 * allow newly-added Nodes to be assigned as the children of previously-added
 * Nodes.
 * @author Michael <GrubenM@GMail.com>
 */
public class Triangle {
    int row = 0;
    int col = 0;
    ArrayList<Node> l = new ArrayList<>();
    
    public void insert(int i) {
        Node n = new Node(i);
        l.add(n);
        if (row > 0 && col == 0) addAsLeft(n);
        else if (row > 0 && col == row) addAsRight(n);
        else if (row > 0 && col > 0) {
            addAsLeft(n);
            addAsRight(n);
        }
        updateLocation();
    }
    
    /**
     * Assuming that the node being added is to the left of some higher node,
     * retrieves that node and sets this node as its left child.
     */
    private void addAsLeft(Node n) {
        l.get(toIndex(row - 1, col)).setLeft(n);
    }
    
    /**
     * Assuming that the node being added is to the right of some higher node,
     * retrieves that node and sets this node as its right child.
     */
    private void addAsRight(Node n) {
        l.get(toIndex(row - 1, col - 1)).setRight(n);
    }
    
    /**
     * Moves the head for where the next Node would be inserted.
     * Primarily a bookkeeping method.
     */
    private void updateLocation() {
        if (row == col) {
            col = 0;
            row++;
        }
        else col++;
    }
    
    private int toIndex(int row, int col) {
        return row * (row+1) / 2 + col;
    }
    
    public Node getNode(int row, int col) {
        return l.get(toIndex(row, col));
    }
    
    /**
     * Returns the head position for where the next Node would be inserted.
     * Thus, for a full triangle of i rows, this method returns i + 1.
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Sets each node on the given row to be the sum of the rows below it,
     * then sets the left and right nodes to null (so as not to recurse
     * when higher rows are set).
     * The best use of this method is to start from the second to bottom row,
     * then iterate upwards to the top row.
     */
    public void setSums(int row) {
        for (int i = toIndex(row, 0); i <= toIndex(row, 0) + row; i++) {
            Node n = l.get(i);
            n.sumToNum(n.getBestSum());            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Triangle t = new Triangle();
        File f = new File("largeTriangle.txt"); // "Triangle.txt" for #18
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            t.insert(s.nextInt());
        }
        for (int r = t.getRow() - 2; r >= 0; r--) // Start at second-to-last row
            t.setSums(r);
        System.out.println(t.getNode(0, 0).getNum());
    }
    
}
