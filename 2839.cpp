#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int cnt;
    int n;
    bool find = true;
    int *cnt = new int;
    int arr[5];
    cin>>n;
    int *p = new int [n];
    int *p;
    while(n>=0){
        if(n%5 ==0){
            cnt +=n/5;
            break;
        }
        else{
            n -=3;
            cnt ++;
        }
       
        
        p = new int;
        if(n<0){
            find =false;
            cout <<"-1";
            break;
        }
    }
    if(find){
        cout <<cnt;
    }
    delete []p;
    
    return 0;
}
