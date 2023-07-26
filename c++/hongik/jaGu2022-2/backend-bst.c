#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "backend-bst.h"
#include "memory.h"

void print_name(struct record *);
void print_number(struct record *);

// comparison function for records
int compare(char key[3], struct record *);

// data
struct record * data = NULL; // Initially NULL.

/***********************
Address Book by binary search tree
**************************/

void init()
{
  init_pool();
}


void search(char name[3])  
{
  struct record *r; // Pointer to record being compared.
                    //data or left/right field of a node.
  int result;
  r=data;

  while (r!=NULL) {
    if ((result=compare(name,r))<0)
      r=r->left;
    else if (result==0) {
      print_name(r);
      printf(" : ");
      print_number(r);
      printf(" was found.\n");
      return;
    }
    else // case >0
      r=r->right;
  }
  printf("Couldn't find the name.\n");
}


void add(char *name, char *number)
{
  // Messages to print
  //  printf("Can't add.  The pool is empty!\n");
  //  printf("The name was successfully added!\n");
}


// The most complicated.
void delete(char name[3])
{
  // Messages to print
  //  printf("The name was deleted.\n");  
  //  printf("Couldn't find the name.\n");
}


/* Just a wrapper of strncmp().
Regard strncmp(a,b) as a-b.
Negative value if key is less than r.
​0​ if key and r are equal.
Positive value if key is greater than r. */
int compare(char key[3], struct record *r)
{
    return strncmp(key, r->name, 3);
}


void print_data(char * s, int n)
{
  int i;
  for (i=0; i<n; i++)
    putchar(s[i]);
}

void print_name(struct record *r)
{
  print_data(r->name, 3);
}

void print_number(struct record *r)
{
  print_data(r->number, 4);
}

void print_inorder(struct record *t)
{

}

void print_list()  
{
  print_inorder(data);
}


// returns the height of the BST.
int height(struct record *t)
{
  // dummy return.  Should return a valid height.
  return 0;
}

void print_height()  
{
  printf("The Address Book BST's height is %d.\n", height(data));
}
