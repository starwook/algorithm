#include <iostream>
using namespace std;
int main(){
    for(int i=0;i<9;i++){
        int a,b,c;
        cin >>a>>b>>c;
        cout << "goal per minute "<<a/(b+c)<<"\n";
    }


}