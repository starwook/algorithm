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
#define minus '-'
#define plus '+'
string str;
int ans;
bool ifMinus =false;
int main()
{
    cin>>str;
    int tmp =0;
    for(int i=0;i<=str.length();i++){
        if(str[i] ==minus||str[i]==plus||i==str.length()){
            if(ifMinus){
                ans -=tmp;
            
                tmp =0;
            }
            else{
                ans +=tmp;
                
                tmp =0;
            }
        }
        else{
            tmp =tmp*10+ (str[i] -'0');
            
        }
        if(str[i] ==minus){
            ifMinus =true;
        }
    }
    cout<<ans;
    return 0;
}
