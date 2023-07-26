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
int arr[101][101];
int maxNum;
#define blockSize 5
int check();
int main()
{
    for(int i=1;i<=10;i++){
        maxNum =0;
        memset(arr,0,sizeof(arr));
        for(int j=1;j<=blockSize;j++){
            for(int z=1;z<=blockSize;z++){
                cin>>arr[j][z];
            }
        }
        cout<<check()<<"\n";
    }
    
    return 0;
}
int check(){
    int tmpNum =0;
    int tmpNum2 =0;
    int tmpNum3 =0;
    int tmpNum4 =0;
    for(int i=1;i<=blockSize;i++){
        tmpNum = 0;
        tmpNum2 =0;
        for(int j=1;j<=blockSize;j++){
            if(i==j){
                
                tmpNum3+=arr[i][j];
                cout << tmpNum3 << ":대각선//";
            }
            if(i+j==blockSize+1){
                tmpNum4+=arr[i][j];
            }
            tmpNum +=arr[i][j];
            tmpNum2 +=arr[j][i];
        }
        cout<<tmpNum<<"   /"<< tmpNum2<<"   /"; 
        maxNum = max(tmpNum, maxNum);
        maxNum = max(tmpNum2,maxNum);
    }
    maxNum = max(tmpNum3, maxNum);
    maxNum = max(tmpNum4, maxNum);
    cout<<tmpNum3<<"   /"<<tmpNum4<<"\n";
    return maxNum;
}
