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
int bill[10001];
int dpBill[10001];
int maxMoney;
// void bruteForce(int money,int count){
//     if(count==n){
//         maxMoney = max(maxMoney,money);
//         return;
//     }
//     for(int i=1;i<=n;i++){
//         if(count+i<=n){
//             bruteForce(bill[i],count+i)
//         }
//     }
// }
int main()
{
    cin>>n;
    for(int i=1;i<=n;i++){
        cin>>bill[i];
    }
    dpBill[1] = bill[1];
    for(int i=2;i<=n;i++){
        for(int j=1;j<=i-1;j++){
            dpBill[i] = max(bill[i],max(dpBill[i],dpBill[j]+dpBill[i-j]));
        }
    }
    cout<<dpBill[n];
    

    return 0;
}
