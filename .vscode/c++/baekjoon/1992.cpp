#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
char arr[65][65];
void quad(char x,char y,int s){
    if(s==1){
        cout << arr[x][y];
        return;
    }
    int tmp = '0';
    if(arr[x][y] =='1'){
        tmp = '1';
    }
    for(int i=x;i<x+s;i++){
        for(int j =y;j<y+s;j++){
            if(arr[i][j] !=tmp){
                cout <<"(";
                quad(x,y,s/2);
                quad(x,y+s/2,s/2);
                quad(x+s/2,y,s/2);
                quad(x+s/2,y+s/2,s/2);
                cout <<")";
                return;
            }
        }
    }
    cout <<tmp-48;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >>arr[i][j];
        }
    }
    
    quad(0,0,n);
    


    return 0;
}
