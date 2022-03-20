#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Perimetro) (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int  (* perimetro) (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("\nRetangulo de tamanho (%d,%d) na posicao (%d,%d), area %d e perimetro %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

int rect_perimetro(Rect* this) {
    Figure* sup = (Figure*) this;
    return (this->h * 2) + (this->w * 2);
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Perimetro) rect_perimetro,
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("\nElipse de tamanho (%d,%d) na posicao (%d,%d), area %d e perimetro %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

int ellipse_perimetro(Ellipse* this) {
    Figure* sup = (Figure*) this;
    return (this->h * 2) + (this->w * 2);
}


Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Perimetro) ellipse_perimetro
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}
///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w;
} Circle;

void circle_print(Circle* this) {
    Figure *sup = (Figure*) this;
    printf("\nCirculo de raio %d na posicao (%d,%d), area %d e perimetro %d.\n", this->w, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int circle_area(Circle* this) {
    Figure* sup = (Figure*) this;
    return 3.14 * (this->w * this->w);
}

int circle_perimetro(Circle* this) {
    Figure* sup = (Figure*) this;
    return 2 * 3.14 * this->w;
}

Figure_vtable circle_vtable = {
    (Figure_Print) circle_print,
    (Figure_Area) circle_area,
    (Figure_Perimetro) circle_perimetro
};

Circle* circle_new (int x, int y, int w) {
    Circle* this = malloc(sizeof(Circle));
    Figure* sup = (Figure*) this;
    sup->vtable = &circle_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) circle_new(50, 50, 100),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) circle_new(100, 200, 35),
    };

    ///

    for (int i=0; i<6; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (int i=0; i<6; i++) {
        free(figs[i]);
    }
}
