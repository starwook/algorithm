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
int kind ;
int arr[20];
int num[20];
char opr[20];
long long ans;
vector <int> vec;
vector <int> vecnum;
vector <int> vecopr;
int cal(int a,int b ,char c){
    if( c=='+'){
        return a+b;
    }
    else if(c =='-'){
        return a-b;
    }
    else {
        return a*b;
    }
}
void checking(){
    vecnum.clear();
    vecopr.clear();
    vecnum.push_back(num[1]);
    for(int i=1;i<=kind;i++){
        if(arr[i]){
            vecnum.pop_back();
            vecnum.push_back(cal(num[i],num[i+1],opr[i]));
            
        }
        else{
            vecnum.push_back(num[i+1]);
            vecopr.push_back(opr[i]);
        }
    }
    long long tmpnum = vecnum[0];
    // cout << tmpnum << " =1 \n";
    for(int i=1;i<vecnum.size();i++){
        tmpnum = cal(tmpnum,vecnum[i],vecopr[i-1]);
    }
    // for(int i=0;i<vecnum.size();i++){
    //     cout<<vecnum[i] <<" "<< (char)vecopr[i]<<" ";
    // }
    // cout << "\n";
    // cout << "\n";
    // cout << tmpnum << " =tmpnum \n";
    ans = max(ans,tmpnum);
}
void bf(int a){
    if(a>kind){
        checking();
        return;
    }
    arr[a]=1;
    bf(a+2);
    arr[a] =0;
    bf(a+1);
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    kind = n/2;
    char tmp;
    int tmpnum = 0;
    int numinx =1;
    int oprinx =1;
    for(int i=1;i<=n;i++){
        cin >>tmp;
        if(tmp >=48 && tmp<=57){
            tmpnum = tmpnum*10 + tmp-48;
        }
        else{
            num[numinx] =tmpnum;
            tmpnum =0;
            numinx++;
            opr[oprinx] =tmp;
            oprinx++;
        }
    }
    num[numinx] = tmpnum;
    if(n==1){
        cout<<num[1];
    }
    else{
        num[numinx] = tmpnum;
        // for (int i = 1; i <= numinx; i++)
        // {
        //     cout << num[i] << " ";
        // }
        // cout << "\n";
        // for (int i = 1; i < oprinx; i++)
        // {
        //     cout << opr[i] << " ";
        // }
        // cout << "\n";
        int tmpans = num[1];
        for (int i = 1; i < numinx; i++)
        {
            // cout << tmpans << " ";
            tmpans = cal(tmpans, num[i + 1], opr[i]);
        }
        ans = tmpans;
        bf(1);
        cout<<ans;
    }
    return 0;
}
