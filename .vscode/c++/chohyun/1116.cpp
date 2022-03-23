#include <iostream>
#include <string>
using namespace std;
class Point{
    int x,y;
    public:
    void set(int x,int y){this->x = x;this->y=y;}
    void showPoint(){
        cout<<"("<<x<<","<<y<<")"<<endl;
    }
};
class ColorPoint:public Point{
    string color;
    //int x,y;
    public:
    void setColor(string color){
        this->color =color;
    }
    void showColorPoint();
};
void ColorPoint::showColorPoint(){
    cout<<color <<":";
    showPoint();
}
int main(){
   ColorPoint cp;
   Point* pBase =&cp; //(업)부모 포인터에 자식의 주소 
   pBase->set(3,4);
   pBase->showPoint();

   ColorPoint* pDer = (ColorPoint*)pBase; //(다운)자식 포인터에 부모의 주소
   pDer->setColor("RED");
   pDer->showColorPoint();


}