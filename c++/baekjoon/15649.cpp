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
int n,m;
int numberArr[10];
vector<int> vec;
void bruteForce(int index){
    if(index ==m){
        for(int i=0;i<vec.size();i++){
            cout<<vec[i]<<" ";
        }
        cout<<"\n";
        return;
    }
    for(int i =1;i<=n;i++){
        if(numberArr[i]){
            continue;
        }
        numberArr[i] =1;
        vec.push_back(i);
        bruteForce(index+1);
        vec.pop_back();
        numberArr[i] = 0;
    }
}
int main()
{
    cin >>n>>m;
    bruteForce(0);
    

    return 0;
}
