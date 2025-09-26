// Nama : Mochammad Chafiedz Afrilian
// NIM  : 2902731800

#include <stdio.h>
int main()
{
    int x[5];
    int *ptr;
    int i, max, min, total_pointer = 0;
    float mean;

    ptr = x;

    // 1. Meminta user memasukkan 5 buah nilai
    printf("Masukkan 5 nilai:\n");
    for (i = 0; i < 5; i++)
    {
        printf("Nilai ke-%d: ", i + 1);
        scanf("%d", (ptr + i));      // simpan langsung via pointer
        total_pointer += *(ptr + i); // sum dari pointer yang di input
    }
    printf("\nHasil input:\n");
    mean = (float)total_pointer / 5; // hitung mean dari hasil sum

    for (i = 0; i < 5; i++)
    {
        printf("Nilai ke-%d = %d\n", i + 1, *(ptr + i)); // akses via pointer
    }

    // 2. Mencari nilai maksimum dengan pointer
    max = *ptr; // inisialisasi dengan nilai pertama
    min = *ptr;
    for (i = 1; i < 5; i++)
    {
        if (*(ptr + i) > max)
        {
            max = *(ptr + i);
        }
        if (*(ptr + i) < min)
        {
            min = *(ptr + i);
        }
    }
    // 3. Menampilkan nilai maksimum
    printf("\nNilai maksimum adalah: %d\n", max);
    printf("Nilai minimum adalah: %d\n", min);
    printf("Nilai mean adalah: %.2f\n", mean);

    return 0;
}
