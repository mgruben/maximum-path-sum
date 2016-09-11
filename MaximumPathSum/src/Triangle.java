
import java.util.ArrayList;

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
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class Triangle {
    Node top;
    ArrayList<Node> l = new ArrayList<>();
    
    public void insert(Node n, int row, int col) {
        l.add(toIndex(row, col), n);
    }
    
    public void insert(Node n) {
        l.add(n);
    }
    
    public void insert(int i) {
        l.add(new Node(i));
        
    }
    
    private int toIndex(int row, int col) {
        return row * (row+1) / 2 + col;
    }
    
    public Node getNode(int row, int col) {
        return l.get(toIndex(row, col));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.insert(new Node(2));
        t.insert(new Node(3));
        t.insert(new Node(4), 1, 1);
        System.out.println(t.getNode(1, 1));
    }
    
}
