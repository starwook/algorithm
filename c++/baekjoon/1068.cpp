#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
using namespace std;
int n;
int target;
vector<int> vec[50];
int root;
int leaf;
int dfs(int r){
    if(r==target){
        return -1;
    }
    if(!vec[r].size()){
        leaf++;
        return 0;
    }
    for(int i=0;i<vec[r].size();i++){
        int tmp = dfs(vec[r][i]);
        if(tmp==-1&& vec[r].size()==1){ //삭제하고 난 후에 리프노드가 된다면
            leaf++;
        }
    }
    return 0;

}
int main()
{

    cin>>n;
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        if(a ==-1){
            root = i;
        }
        else{
            vec[a].push_back(i);
        }
    }

    cin>>target;
    dfs(root);
    cout<<leaf;

    return 0;
}
