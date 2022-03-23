#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int cnt[1002][1001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    string lcs;
    string a;
    string b;
    cin >>a>>b;
    int n =0;
    int start =0;
    for(int i =1;i<=a.length();i++){
        for(int j=1;j<=b.length();j++){
            if(a[i-1] ==b[j-1]){
                cnt[i][j] = cnt[i-1][j-1]+1;
            }
            else{
                cnt[i][j] = max(cnt[i][j-1],cnt[i-1][j]);
            }

        }
        
    }
    // for(int i=0;i<=a.length();i++){
    //     for(int j=1;j<=b.length();j++){
    //         cout <<cnt[i][j]<<" ";
    //     }
    //     cout <<"\n";
    // }
    cout <<cnt[a.length()][b.length()];
    return 0;
}
