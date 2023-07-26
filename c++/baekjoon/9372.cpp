#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1001][1001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int t;
    cin >>t;
    int n,m;
    while(t--){
        cin >>n>>m;
       
        int count = 0;
        vector<int> c;
        vector<int>::iterator it;
        for(int i=1;i<n;i++){
            c.push_back(i);
        }
       
        int u,v;
        for(int i=0;i<m;i++){
            
            cin >>u;
            for(it = c.begin();it!=c.end();){
                
                if(*it ==u ){
                    it = c.erase(it);
                    count ++;
                }
                else{
                    it++;
                }
            }
            
            cin >>v;
            for(it =c.begin();it!=c.end();){
                if(*it ==v ){
                    it = c.erase(it);
                    count ++;
                }
                else{
                    it++;
                }
            }
            
        }
        
        cout << count <<"\n";

    }
    

    return 0;
}
