#include <stdio.h>
#include "rect.h"

/////////////////////////////////////////////////////////////////////

typedef struct Rect{
    int x, y;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, this->x,  this->y);
}

Rect* rect_new () {
    Rect* this = malloc(sizeof(Rect));
    return this;
}


void rect_drag(Rect* this, int dx, int dy) {
  this->x += dx;
  this->y += dy;
}
