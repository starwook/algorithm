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
string farm[49];
int n;
int ans;
void farmPlus(){
    for(int i=0;i<n;i++){
        ans += farm[i][n/2]-'0';
        for(int j=0;j<=i;j++){
            ans+= farm[i][n/2+j]-'0';
            ans+= farm[i][n/2-j]-'0';
        }
    }
}
int main()
{

    int t;
    cin>>t;
    for(int i=1;i<=t;i++){
        ans =  0;
        cin>>n;
        for(int j=0;j<n;j++){
            cin >>farm[j];
        }
        farmPlus();
        cout<<"#"<<i<<" "<<ans<<"\n";
    }

    return 0;
}
