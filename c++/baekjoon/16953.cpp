#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int a,b;
int cnt =0;
bool found = false;

void dps(int m){
    
    if(m ==a ){
        found =true;
        return;
    }
    else if( m<a){
        return;
    }
    string tmp = to_string(m);
    if(tmp[tmp.size()-1] == '1'){
        
        cnt ++;
        tmp = tmp.substr(0,tmp.size()-1);
        // cout <<tmp<<"\n";
        dps(stoi(tmp));
    }
    else if(m%2 ==0){
        cnt++;
        // cout <<m/2<<"\n";
        dps(m/2);
    }
    else{
        return;
    }

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>a>>b;
    dps(b);
    if(found){
        cout <<cnt+1;
    }
    else{
        cout <<"-1";
    }
    return 0;
}
