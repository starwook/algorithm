#include <stdio.h>
#include <iostream>
#include <string.h>
using namespace std;
int main(){
    char n;
    int count =0;
    int count2 = 0;
    while(1){
        scanf("%c",&n);
        if(n == '\n'){
            break;
        }
        count2 += n-48;
        count = count*10;
        count = count + n-48;
    }
    count = count+count2;
    cout <<count;
}
