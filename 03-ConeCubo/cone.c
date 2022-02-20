#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int radius, height;
    int w, h;
} Rect;

void print(Rect *r) {
    printf("Raio: %d\nAltura: %d\nPos(%d,%d)\n",r->radius, r->height, r->w, r->h);
}

void main() {
    Rect r1 = {7, 5, 10, 10};
    print(&r1);
}
