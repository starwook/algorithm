#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int an[500001];
int am[500001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m;
    cin >>n;
    for(int i=0;i<n;i++){
        cin >>an[i];
    }
    sort(an,an+n);
    cin >>m;
    for(int i=0;i<m;i++){
        cin >>am[i];
    }

    for(int i=0;i<m;i++){
        int s = 0;
        int e = n-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(an[mid] == am[i]){
                cout <<"1 ";
                break;
            }
            else if(an[mid]>am[i]){
                e = mid -1;
            }
            else{
                s = mid+1;
            }
            if(s>e){
                cout <<"0 ";
                break;

            }

        }
    }


    return 0;
}
