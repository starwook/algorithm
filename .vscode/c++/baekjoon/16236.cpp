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
int arr[21][21];
int n;
int sX,sY,sS;
int cnt;
void bfs(int x,int y){

    cout  <<x<<y;

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    sS=2;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>arr[i][j];
            if(arr[i][j] ==9){
                sX =i;
                sY =j;
            }
        }
    }
    bfs(sX,sY);

    

    return 0;
}
