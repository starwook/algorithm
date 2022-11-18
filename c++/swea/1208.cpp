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
int blockArr[101];
#define blockSize 11
int dump;
int diff;
int maxIndex = 1;
int minIndex = 1;
void show();
int dumping()
{
    for (int i = 1; i <= blockSize; i++)
    {
        if(blockArr[maxIndex]< blockArr[i]){
            maxIndex =i;
        }
        if(blockArr[minIndex]> blockArr[i]){
            minIndex =i;
        }
    }
    blockArr[maxIndex]--;
    blockArr[minIndex]++;
    for (int i = 1; i <= blockSize; i++)
    {
        if (blockArr[maxIndex] < blockArr[i])
        {
            maxIndex = i;
        }
        if (blockArr[minIndex] > blockArr[i])
        {
            minIndex = i;
        }
    }
    diff = blockArr[maxIndex] - blockArr[minIndex];
    return diff;
}
int main()
{
    for(int i=1;i<=10;i++){
        cin>>dump;
        memset(blockArr,0,sizeof(blockArr));
        for(int j=1;j<=blockSize;j++){
            cin>>blockArr[j];
        }
        minIndex =1;
        maxIndex =1;
        for(int dumpI=0;dumpI<dump;dumpI++){
            diff = dumping();
            // show();
            if(diff==0 ||diff==1){
                break;
            }
        }
        cout<<"#"<<i<<" "<<diff<<"\n";
    }
    return 0;
}
void show(){
    for(int i=1;i<=blockSize;i++){
        cout<<blockArr[i]<<" ";
    }
    cout<<"\n";
}