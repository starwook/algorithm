#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
vector<int> in, post;
template <typename T>
class Tree;
template <typename T>
class TreeNode
{
    friend class Tree<T>;

public:
    T data;
    TreeNode *left;
    TreeNode *right;
    TreeNode(T data = 0, TreeNode *left = NULL, TreeNode *right = NULL)
    {
        this->data = data;
        this->left = left;
        this->right = right;
    }
};
template <typename T>
class Tree
{
public:
    TreeNode<T> *root;
    Tree(T data = 0)
    {
        root = new TreeNode<T>(data);
    }
    TreeNode<T>* getRoot(){
        return root;
    }
    void preorder(TreeNode<T>* current){
        if(current != NULL){
            
            visit(current);
            preorder(current->left);
            preorder(current->right);
        }
    }
    void visit(TreeNode<T>*current){
        if(current->data ==0){
            return;
        }
        cout <<current->data<<" ";
    }
};
Tree<int> tr(0);
void subtree(TreeNode<int>* current ,int is,int ie,int ps,int pe)
{
   
    if (is>ie || ps>pe)
    {
        return;
    }
    
    int tmp = post[pe];
    
    int nie = ie;
    int pie = pe;
    while (tmp != in[ie])
    {
        pe--;
        ie--;
    }
    current->left = new TreeNode<int>;
    current->right = new TreeNode<int>;
    subtree(current->left,is,ie-1,ps,pe-1);
    subtree(current->right,ie+1,nie,pe,pie-1);
    current->data =tmp;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        in.push_back(tmp);
    }
    for (int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        post.push_back(tmp);
    }
    subtree(tr.getRoot(),0,n-1,0,n-1);
    tr.preorder(tr.getRoot());
    return 0;
}
