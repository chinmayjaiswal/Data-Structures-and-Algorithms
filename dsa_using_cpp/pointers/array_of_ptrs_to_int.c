#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

void test_function(void);

int main(void){
    int n0, n1, n2, n3, n4;
    int* arr[5] = {&n0, &n1, &n2, &n3, &n4};
    int i;
    int n;
    int k;
    int** pp = NULL;

    pp = arr;

    for(i = 0; i < 5; ++i){
        *pp[i] = (i+1) * 100;
    }

    for(i = 0; i < 5; ++i){
        n = *(*pp+i);
        printf("invalid: : n = %d\n", n);//works on other compilers
        printf("valid: n = %d\n", *pp[i]);//this is valid output
    }

    test_function();
    exit(0);
}

void test_function(){
    int n0, n1, n2, n3, n4;
    int **pp;
    int i;
    int n;

    puts("In test_function()");
    pp = malloc(5 * sizeof(int*));

    pp[0] = &n0;
    pp[1] = &n1;
    pp[2] = &n2;
    pp[3] = &n3;
    pp[4] = &n4;

    for(i = 0; i < 5; i++){
        *pp[i] = (i+1) * 1000;
    }

    for(i = 0; i < 5; i++){
        n = *(*pp + i);
        printf("invalid n=%d\n",n);
        printf("valid: n=%d\n",*pp[i]);

    }

    free(pp);
    pp = NULL;
}