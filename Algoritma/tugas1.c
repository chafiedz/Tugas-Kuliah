// Nama : Mochammad Chafiedz Afrilian
// NIM  : 2902731800

#include <stdio.h>

int main()
{
    int a, b, c;
    int penjumlahan, pengurangan, perkalian;
    float mean, pembagian;

    // input langsung 3 nilai
    printf("Masukkan 3 nilai : ");
    scanf("%d %d %d", &a, &b, &c);

    // operasi aritmatika
    penjumlahan = a + b + c;
    pengurangan = a - b - c;
    perkalian = a * b * c;

    if (b != 0 && c != 0)
    {
        pembagian = (float)a / b / c;
    }
    else
    {
        printf("Error: tidak bisa dibagi nol!\n");
        return 1;
    }

    mean = penjumlahan / 3.0;

    // output
    printf("\nHasil penjumlahan = %d\n", penjumlahan);
    printf("Hasil pengurangan = %d\n", pengurangan);
    printf("Hasil perkalian   = %d\n", perkalian);
    printf("Hasil pembagian   = %.2f\n", pembagian);
    printf("Hasil mean        = %.2f\n", mean);

    return 0;
}
