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
int arr[50][50];
int check[50][50];
int n,m,x,y,d;
int ans;
int lft(int a){
    if(a==0){
        return 3;
    }
    else {
        return a-1;
    }
}
bool checking(int a){
    if(a==0){
        if(x-1>=0 && !arr[x-1][y] && !check[x-1][y]){
            x = x-1;
        }
        else{
            return ;
        }
    }
    else if(a ==1){

    }
    else if(a==2){

    }
    else{

    }
}
void clean(int x,int y){
    if(!check[x][y]){
        ans++;
        check[x][y];
    }
    for(int i=0;i<4;i++){
        d = lft(d);
        if(checking(d)){
            return;
        }
    }
    
}
void start(){
    while(true){
        clean(x,y);
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m>>x>>y>>d;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >>arr[i][j];
        }
    }
    start();
    cout<<ans;

    return 0;
}
