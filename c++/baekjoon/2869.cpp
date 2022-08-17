#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int a,b,v;
    cin >>a>>b>>v;
    if(v-a <=0){
        cout <<"1";
    }
    else{

        cout << (v - a) / b + 1;
    }
    
    
    
    return 0;
}
