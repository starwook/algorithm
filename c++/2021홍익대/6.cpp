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
string arr;
int cnt;
int change(char x){
    if(x=='-'){
        return 1;
    }
    else{
        return 10;
    }
}
int ans = 0;
int cla(int i, int tmp){
    if(i==cnt){
        return 0;
    }
    if(arr[i] =='+'){
        if(i+1<=cnt && arr[i+1] =='-'){
            tmp += max(11 +cla(i+2))

        }
 
    }
    else{

    }
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>arr;
    cnt = arr.length()-3;
    if(arr.length() ==1){
        ans = change(arr[0]);
    }
    else if(arr.length()==2){
        ans = 11;
    }
    else{
        ans = cla(0,0);
        
    }

    return 0;
}
