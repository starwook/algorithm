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
int arr[81];
vector<int> vec;
int bestFirstNum;
bool tmp;
bool tmpFound;
bool checkIfBad(int a, int b)
{
    if (a == b)
    {
        return true;
    }
    if((b-a)%2 ==0){
        return true;
    }
    for (int i = a; i <= (a + b) / 2; i++) //1+4
    {
        if (arr[i] != arr[i+(b-a)/2+1])
        {
            return true;
            continue;
        }
        else
        {
            //cout<<a<<" : "<<b<<"\n";
            
        }
    }
    //cout << "탈락\n";
    return false;
}
void show()
{
    for (int i = 1; i <= n; i++)
    {
        cout << arr[i] << "";
    }
    cout << endl;
}
void backTracking(int a)
{
    if (a == n+1)
    {
        //cout << "bbb\n";
        tmpFound = true;
        show();
        return;
    }
    tmp = true;
    for (int i = 1; i <= 3; i++)
    {
        arr[a] = i;
        //show();
        for (int j = 1; j <= a; j++)
        {
            if (!checkIfBad(j, a))
            {
                tmp = false;
                break;
            }
        }
        if (tmp)
        {
            //cout << "ㅗ\n";
            backTracking(a + 1);
            arr[a] = 0;
            if(tmpFound){
                return;
            }
        }
        tmp =true;
    }
    // for(int j=a;j<=n;j++){
    // }
    return;
}

int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    tmpFound =false;
    backTracking(1);
    

    return 0;
}
