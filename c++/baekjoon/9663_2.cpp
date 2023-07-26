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
int arr[16][16];
int ans;
void showChess(){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cout<<arr[i][j] <<" ";
        }
        cout<<"\n";
    }
}
void nQueen(int r,int c,int cnt){
    
    for(int i=1;i<=n;i++){
        if(arr[r][i]==1){ 
            return;
        }
        if(arr[i][c] ==1){
            return;
        }
    }
    int position =1;
    while(r+position<=n &&c+position<=n){
        if(arr[r+position][c+position]){
            return;
        }
        position++;
    }
    position =1;
    while (r + position <= n && c - position >=1 )
    {
        if (arr[r + position][c - position])
        {
            return;
        }
        position++;
    }
    position=1;
    while (r - position >= 1 && c + position <= n)
    {
        if (arr[r - position][c + position])
        {
            return;
        }
        position++;
    }
    position = 1;
    while (r - position >=1 && c - position >= 1)
    {
        if (arr[r - position][c - position])
        {
            return;
        }
        position++;
    }
    int tmpR =r;
    int tmpC =c;
    // cout << r << " " << c << "\n";
    arr[r][c] = 1;
    if (cnt+1 == n)
    {
        ans++;
        // cout<<"달성\n";
        // showChess();
        arr[r][c] = 0;
        return;
    }
    while(tmpR<=n){
        while(tmpC<n){
            nQueen(tmpR,tmpC+1,cnt+1);
            tmpC++;
        }
        tmpC =0;
        tmpR++;
    }
    arr[r][c]=0;
}
int main()
{
    cin>>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(!arr[i][j]){
                // cout<<"새로 진입\n";
                nQueen(i,j,0);
            }
        }
    }
    cout<<ans;

    return 0;
}
