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
string a,b,c;
int arr[201][201];
int c_inx;
int flag =false;
int dpham(int x,int y){
    if(x+y == c.size()){
        // cout << x << ":x, " << y << ":y\n";
        return true;
    }
    if(x>=a.size() && y>=b.size()){
        return true;
    }
    if(arr[x][y]!=0){
        return arr[x][y];
    }
    if(a[x] ==c[x+y] &&x<a.size()){
        arr[x][y] = dpham(x+1,y);
    }
    if(b[y] ==c[x+y] &&y<b.size()){
        arr[x][y] = dpham(x,y+1);
    }
    return arr[x][y];

    
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>a>>b>>c;
        memset(arr,0,sizeof(arr));
        flag = dpham(0,0);
        cout<<"Data set "<< i<<": ";
        if(flag){
            cout<<"yes\n";
        }
        else{
            cout<<"no\n";
        }
        flag = false;
        
    }
    
    
    
    return 0;
}
