#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
#define leftIndex 7
#define rightIndex 3
int same[4];
char arr[5][9];
int rotateCnt;
using namespace std;
void check(){
    for(int i=0;i<=3;i++){
        same[i] =0;
    }
    for (int i = 2; i <= 3; i++)
    {
        if (arr[i - 1][rightIndex] == arr[i][leftIndex])
        {
            same[i-1] =1;
        }
        if(arr[i][rightIndex]==arr[i+1][leftIndex]){
            same[i] = 1;
        }
    }
}
void showArrIndex(int arrIndex){
    for(int i=1;i<=8;i++){
        cout<<arr[arrIndex][i];
    }
    cout<<"\n";
}
void rotate(int arrIndex){
    char tmp = arr[arrIndex][8];
    for(int i=7;i>=1;i--){
        arr[arrIndex][i+1] = arr[arrIndex][i];
    }
    arr[arrIndex][1] =tmp;
    
}
void rotateReverse(int arrIndex){
    char tmp = arr[arrIndex][1];
    for(int i=2;i<=8;i++){
        arr[arrIndex][i-1] = arr[arrIndex][i];
    }
    arr[arrIndex][8] = tmp;
}
void checkSame(int rotateNumber,int position,int rightLeft){
    if(rightLeft ==1){ //오른쪽일 경우
        if (rotateNumber <= 3)
        {
            if(!same[rotateNumber]){
                if (position == 1)
                {
                    rotate(rotateNumber + 1);
                }
                else
                {
                    rotateReverse(rotateNumber + 1);
                }
                checkSame(rotateNumber + 1, -position, rightLeft);
            }
        }
    }
    else{
        if (rotateNumber >=2)
        {
            if (!same[rotateNumber-1])
            {
                if (position == 1)
                {
                    rotate(rotateNumber -1);
                }
                else
                {
                    rotateReverse(rotateNumber -1);
                }
                checkSame(rotateNumber - 1, -position, rightLeft);
            }
        }
    }
}
int main()
{
    for(int i=1;i<=4;i++){
        for(int j=1;j<=8;j++){
            cin>>arr[i][j];
        }
    }
    cin >>rotateCnt;
    while(rotateCnt--){
        check();

        int rotateNumber;
        int position;
        cin>>rotateNumber>>position;
        if(position==1){
            rotate(rotateNumber);
        }
        if(position==-1){
            rotateReverse(rotateNumber);
        } 
        checkSame(rotateNumber,-position,1);
        checkSame(rotateNumber, -position, 0);
    }
    int ans =0;
    int increase =1;
    for(int i=1;i<=4;i++){
        // cout<<arr[i][1]-'0'<<"\n";
        ans+=((arr[i][1]-'0')*increase);
        increase *=2;
    }
    cout<<ans;
    

    return 0;
}
