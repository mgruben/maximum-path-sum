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
public class Node implements Comparable<Node> {
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
    
    public int getLeftNum() {
        return left.num;
    }
    
    public int getRightNum() {
        return right.num;
    }
    
    public int compareTo(Node other) {
        return Integer.valueOf(this.num).compareTo(other.num);
    }
    
    public String toString() {
        return Integer.toString(num);
    }
}
