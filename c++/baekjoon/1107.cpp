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
int zeroOneTime =false;
int startChannel =100;
int m;
int channelSize;
int notWorking[10];
string n;
int cnt;
int nToN;
int nowNumber;
void bruteforce(int number,int index){
    if(number>1000002){
        return;
    }
    cout<<number<<"\n";
    int tmp = nToN-number;
    if(tmp<0){
        tmp = -tmp;
    }
    tmp+= index;
    if(cnt>tmp){
        cout<<tmp<<":당첨";
        cnt = tmp;
    }
    for(int i=0;i<=9;i++){
        if(index ==0 &&i==0){
            continue;
        }
        if(!notWorking[i]){
            number *=10;
            number +=i;
            bruteforce(number,index+1);
            number -=i;
            number /=10;
        }
    }
}
int main()
{
    cin >>n>>m;
    channelSize = n.length();
    nToN = stoi(n);
    cout<<channelSize;
    if(m>0){
        for(int i=0;i<m;i++){
            int number;
            cin >>number;
            notWorking[number]=1;
        }
    }
    cnt = nToN-100;
    if(cnt<0){
        cnt = -cnt;
    }
    cnt = min(cnt,nToN+1);
    bruteforce(100,0);
    cout<<cnt;
    return 0;
}
