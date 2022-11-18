#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
char arr[9][9];
int needLength;
int ans;
using namespace std;
string str;
void vecCal(string s);
int main()
{
    
    for(int t=1;t<=10;t++){
        ans =0;
        cin >>needLength;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                cin>>arr[i][j];
            }
        }
        for(int i=1;i<=8;i++){
            str.clear();
            for(int j=1;j<=8;j++){
                str.push_back(arr[i][j]);
            }
            vecCal(str);
            str.clear();
            for(int j=1;j<=8;j++){
                str.push_back(arr[j][i]);
            }
            vecCal(str);
        }
        cout<<"#"<<t<<" "<<ans<<"\n";
    }
    return 0;
}
void vecCal(string s){
    string tmp;
    for(int i=0;i<=s.size()-needLength;i++){
        tmp = s.substr(i, needLength);
        bool uYungWoo =true;
        for(int j=0;j<tmp.size()/2;j++){
            if(tmp[j] != tmp[tmp.size()-j-1]){
                uYungWoo = false;
                break;
            }
        }
        if(uYungWoo){
            ans++;
        }
    }
}