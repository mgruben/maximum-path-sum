#include <iostream>
using namespace std;

struct node {
    int data;
    struct node* left;
    struct node* right;
};

int main() {
    node n;
    n.data = 3;
    cout << n.data << endl;
    return 0;
}
