#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
int n;
int m;
int arr[101];
int ans;
int tmp;
using namespace std;
vector<int> vec;
void show(){
    for(int i=0;i<vec.size();i++){
        cout<<vec[i]<<" ";
    }
    cout<<"\n";
}
void bruteForce(int index,int cnt,int tmp){
    if(cnt ==3){
        if(ans<tmp){

            ans = tmp;
        }
        return;
    }
    for(int i=index;i<=n;i++){
        if(tmp+arr[index]<=m){
            vec.push_back(arr[index]);
            bruteForce(i+1, cnt + 1, tmp + arr[index]);
            vec.pop_back();
        }
    }
}
using namespace std;
int main()
{
    cin >>n>>m;
    ans =0;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    bruteForce(1, 0, 0);
    cout<<ans;


    return 0;
}
