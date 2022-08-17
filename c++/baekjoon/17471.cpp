#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int mount[11];
int arr[11][11];
int check(int i,int j){
    
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>mount[i];
    }
    int check=0;
    for(int i=1;i<=n;i++){
        int tmp;
        cin >>tmp;
        if(tmp ==0){
            check++;
            arr[i][0] =-1;

        }
        for(int j=0;j<tmp;j++){
            int g;
            cin >>g;
            arr[i][g] =1;
        }
    }
    if(check>1){
        cout <<"-1";
    }
    else if(check == 1){
        int one =0;
        int two = 0;
        for(int i=1;i<=n;i++){
            if(arr[i][0] ==-1){
                one = mount[i];
            }
            else{
                two +=mount[i];
            }
        }
        cout << abs(two -one);        
    }
    else{
        int one = 0;
        int two = 0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(arr[i][j] ==1){

                }
            }
        }
    }

    return 0;
}
