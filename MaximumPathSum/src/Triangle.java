
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
    Node top;
    int row = 0;
    int col = 0;
    ArrayList<Node> l = new ArrayList<>();
    
    public void insert(int i) {
        l.add(new Node(i));
        if (row > 0 && col == 0) {
            
        }
        updateLocation();
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
    }
    
}
