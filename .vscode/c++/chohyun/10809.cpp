#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[26];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    string s;
    for(int i=0;i<26;i++){
        arr[i] = i;
    }
    int *p;
    p = arr;
    for(int i=0;i<26;i++){
        cout << p<<" ";
        p++;
    }
    cin >>s;
    for(int i=0;i<s.length();i++){
        if(arr[s[i]-97] ==-1){
            arr[s[i] - 97] = i;
        }
    }
    for(int i=0;i<26;i++){
        cout <<arr[i] <<" ";
    }
    return 0;
}

// #include <iostream>
// #include <vector>
// #include <algorithm>
// #include <stack>
// #include <queue>
// #include <math.h>
// #include <cstring>
// #include <tuple>
// using namespace std;
// int arr[26];
// int main()
// {
//     cin.tie(NULL);
//     ios::sync_with_stdio(false);
//     string s;
//     for (int i = 0; i < 26; i++)
//     {
//         arr[i] = -1;
//     }
//     cin >> s;
//     for (int i = 0; i < 26; i++)
//     {
//         int tmp = i + 97;
//         for (int j = 0; j < s.length(); j++)
//         {
//             if (s[j] == tmp)
//             {
//                 arr[i] = j;
//                 break;
//             }
//         }
//     }
//     for (int i = 0; i < 26; i++)
//     {
//         cout << arr[i] << " ";
//     }
//     return 0;
// }
