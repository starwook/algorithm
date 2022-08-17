#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int a,b,c;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>a>>b>>c;
    if(a%c ==0){
        cout << '0';
    }
    cout << pow(a%c,b)%c;
     
    return 0;
}
