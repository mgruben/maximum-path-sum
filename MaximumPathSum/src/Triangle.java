
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
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class Triangle {
    int row = 0;
    int col = 0;
    ArrayList<Node> l = new ArrayList<>();
    int[] sums;
    
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
    
    public int bestInRow(int row) {
        if (row == 0) return l.get(0).getNum();
        int max = -1;
        for (int i = toIndex(row, 0); i < toIndex(row, 0) + row; i++) {
            if (l.get(i).getNum() > max) max = l.get(i).getNum();
        }
        return max;
    }
    
    private void addAsLeft(Node n) {
        l.get(toIndex(row - 1, col)).setLeft(n);
    }
    
    private void addAsRight(Node n) {
        l.get(toIndex(row - 1, col - 1)).setRight(n);
    }
    
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
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Triangle t = new Triangle();
        File f = new File("Triangle.txt");
        Scanner s = new Scanner(f);
        int row = 0;
        int col = 0;
        while (s.hasNext()) {
            t.insert(s.nextInt());
        }
        System.out.println(t.getNode(0, 0).getBestSum());
    }
    
}
