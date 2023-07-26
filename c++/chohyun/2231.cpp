#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
    int count;
    cin >> count;
    for(int i=0;i<=count;i++){
        int tmp = i;
        int count2 = 0;
        while(tmp/10 !=0){
            int tmp2 = tmp/10;
            count2 += tmp - tmp2*10;
            tmp = tmp2;
        }
        count2 += tmp;
        if(i+count2 ==count){
            cout <<i;
            break;
        }
        if(i ==count-1){
            cout <<"0";
            break;
        }
    }
}

