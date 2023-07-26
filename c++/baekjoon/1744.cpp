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
int arr[100];
int gob[100];
vector<int> minusvec,plusvec;
int one =0;
int zero =0;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=1;i<=n;i++){
        int ns;
        cin>>ns;
        if(ns==1){
            one++;

        }
        else if(ns ==0){
            zero++;

        }
        else if(ns>0){
            plusvec.push_back(ns);
        }
        else{
            minusvec.push_back(ns);
        }       
    }
    long long tmp =0;
    
    tmp += one;
    if(zero >0 && minusvec.size()%2 ==1){
        minusvec.push_back(0);
    }
    else{
        minusvec.push_back(1);
        }
    if(plusvec.size()%2 ==1){
        plusvec.push_back(1);
    }
    sort(minusvec.begin(), minusvec.end());
    sort(plusvec.begin(), plusvec.end(), greater<int>());
    int pi,mi;
    for(pi=0;pi<plusvec.size();pi = pi+2){
        // cout << tmp << " pi\n";
        tmp +=plusvec[pi] *plusvec[pi+1];
    }
    for(mi=0;mi<minusvec.size();mi =mi+2){
        // cout<<tmp<<"\n";
        tmp += minusvec[mi] * minusvec[mi +1];
    }
    cout<< tmp;
    return 0;
}
