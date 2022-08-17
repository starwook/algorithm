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
int arr[50001];
stack<int> st;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    int cnt =0;
    
    
    for(int i=1;i<=n;i++){
        int a,b;
        cin >>a>>b;
        if(st.empty()){
            st.push(b);
             cout<< b <<" 추가 and cnt = " <<cnt<<"\n";
        }
        else if(st.top()<b){
            st.push(b);
             cout << b << " 추가 and cnt = " << cnt << "\n";
        }
        else if(b<st.top()){
            while(b<st.top() && !st.empty()){
                 cout<<"Before : "<< st.top() <<" = st.top(), "<<b <<" = b\n";
                st.pop();
                cnt++;
                if(!st.empty()){
                    if(st.top() ==b){
                        break;
                    }
                     cout << "After : " << st.top() << " = st.top(), " << b << " = b\n";
                }
                else{
                     cout<<"After : stack Empty\n";
                    break;
                }
            }
            if(!st.empty()){
                if(st.top() ==b){
                    continue;
                }
                
            }
            st.push(b);

        
        }
    }
    while(!st.empty()){
        st.pop();
        cnt++;
    }
    
    cout <<cnt;


    return 0;
}
