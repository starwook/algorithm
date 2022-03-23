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
int n,m;
string s,news;
int cnt=0;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m;
    int g =0;
    for(int i=0;i<m;i++){
        char tmp;
        cin >>tmp;
        s.push_back(tmp);
    }
    for(int i=0;i<m-2*n;i++){
        int g =0;
        if(s[i] == 'I'){
            while(s[i+1] =='O' && s[i+2] =='I'){
                g++;
                if(g==n){
                    g--;
                    cnt++;
                }
                i = i+2;
            }
        }
    }
    cout<<cnt;


    return 0;
}
