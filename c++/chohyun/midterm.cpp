#include <iostream>

using namespace std;

class MyIntArray
{
    int *ptr;
    int size;
    int last;
    static int numOfInstances;

public:
    MyIntArray();
    MyIntArray(int a);
    MyIntArray(MyIntArray &mia);
    ~MyIntArray();

    bool push(int n);
    bool pop(int &n);
};
int MyIntArray::numOfInstances =0;
MyIntArray::MyIntArray()
{
    numOfInstances = numOfInstances + 1;
    this->last = -1;
    this->size =3;
    this ->ptr = new int[size];
    cout<<"객체 생성(size = "<< size;
    cout << ", last = " << last << ")";
    cout<<": 객체수 = "<<numOfInstances<<endl;
}
MyIntArray::MyIntArray(int a)
{
    numOfInstances = numOfInstances + 1;
    this->size = a;
    this->last =-1;
    this->ptr = new int[size];
    cout << "객체 생성(size = " << size;
    cout << ", last = " << last <<")";
    cout << ": 객체수 = " << numOfInstances<<endl;
}
MyIntArray::MyIntArray(MyIntArray &mia)
{
    numOfInstances = numOfInstances + 1;
    this->last =mia.last;
    this->size = mia.size;
    this->ptr = new int[size];
    for(int i=0;i<=last;i++){
        ptr[i] = mia.ptr[i];
    }
    cout << "객체 복사 생성(size = " << size;
    cout << ", last = " << last << ")";
    cout << ": 객체수 = " << numOfInstances<<endl;
}
MyIntArray::~MyIntArray(){
    
    delete []ptr;
    numOfInstances = numOfInstances-1;
    cout<<"객체 소멸: 객체 수  = "<<numOfInstances<<endl;
}
bool MyIntArray::push(int n){
    if(this->last<this->size-1){
        ptr[last+1]= n;
        last = last+1;
        cout<<n<<" push 됨(size ="<<size <<", last = "<<last<<")"<<endl;
        return true;
    }
    else{
        cout<< "배열이 꽉 참"<<endl;
        return false;
    }
}
bool MyIntArray::pop(int &n){
    if(last ==-1){
        return false;
    }
    else{
        n = ptr[last];
        last = last - 1;
        return true;
    }
}
int main()
{
    MyIntArray a;
    a.push(10);
    a.push(20);
    MyIntArray b(5);
    b.push(30);
    b.push(40);
    b.push(50);

    MyIntArray c(a);
    c.push(60);
    c.push(70);

    int n;
    a.pop(n);
    cout << "a에서 pop한 값 = " << n << endl;
    b.pop(n);
    cout << "b에서 pop한 값 = " << n << endl;
    c.pop(n);
    cout << "c에서 pop한 값 = " << n << endl;
}