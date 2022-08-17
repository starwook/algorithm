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
int l,c;
char arr[16];
int ans;
vector<char> vec;
bool checkae(){
    bool mo =false;
    bool ja =false;
    int cnt= 0;
    for(int i=0;i<vec.size();i++){
        if (vec[i] == 'a' || vec[i] == 'e' || vec[i] == 'i' || vec[i] == 'o' || vec[i] == 'u')
        {
            mo =true;
        }
        else{
            cnt++;
        }
    }
    if(cnt >=2){
        ja = true;
    }
    if(mo&&ja){
        return true;
    }
    else{
        return false;
    }
}
void bt(int a){
    if(vec.size() ==l){
       
        if(checkae()){
            for (int i = 0; i < vec.size(); i++)
            {
                cout << vec[i];
            }
            cout << "\n";
        }
        else{
            return;
        }
    
    }
    for(int i=a;i<=c;i++){
        vec.push_back(arr[i]);
        bt(i+1);
        vec.pop_back();
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>l>>c;
     for (int i = 1; i <= c; i++)
     {
         cin >>arr[i];
     }
    sort(arr,arr+c+1);
    for(int i=1;i<=c-l+1;i++){
        vec.push_back(arr[i]);
        bt(i+1);
        vec.pop_back();
    }
    return 0;
}
