/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hendar
 */
public class AlgoritmaPencarian {

    int[] himpunana = new int[7];

    void isiHimpunan() {
        himpunana[0] = 1;
        himpunana[1] = 3;
        himpunana[2] = 4;
        himpunana[3] = 5;
        himpunana[4] = 7;
        himpunana[5] = 9;
        himpunana[6] = 9;

    }

    void tampilkanHimpunan() {
        System.out.println("Himpunan Nilai : ");
        for (int i = 0; i < himpunana.length; i++) {
            System.out.println("index ke - " + i + ". " + himpunana[i]);
        }
    }

    /*Penjelasannya :
     
     disini kita punya method yg namanya pencarianSequential dan berparameter 'x' 
     dan X bertype data integer */
    public void pencarianSequential(int x) {

        /* didalam method terdapat variable hasil bertipe data String dan nilanya "" */
        String hasil = "";
        /* dan disini juga terdapat variable ketemu bertipe data boolean dan nilainya false*/
        boolean ketemu = false;

        /*selanjutnya dibawah terdapat penulangan/ for dimana pengulangan ini berulang selama
         i kurang dari panjang array himpunan*/
        for (int i = 0; i < himpunana.length; i++) {

            /*didalam pengulangan terdapat kondisi jika himpunan index ke i sama dengan nilai parameter 
             yang di inputkan misalkan ,maka nilai ketemu menjadi true dan nilai hasil menjadi hasil di tambah index ke-i */
            if (himpunana[i] == x) {
                ketemu = true;
                hasil = hasil + " " + i;
            }
        }
        /* dan setelah pengulangan terdapat kondisi apabila ketemu bernilai true maka tampilkan
         System.out.println("Data Anda di Index ke " + hasil); jika tidak maka tampilkan
         System.out.println("Data Tidak Ditemukan"); */
        if (ketemu == true) {
            System.out.println("Data Anda di Index ke " + hasil);
        } else {
            System.out.println("Data Tidak Ditemukan");
        }
    }

    void pencarianBinary(int x) {
        int awal, akhir, tengah;
        boolean ketemu;
        awal = 0;
        tengah = 0;
        akhir = himpunana.length - 1;
        ketemu = false;

        while (awal < akhir && ketemu == false) {
            tengah = (akhir + awal) / 2;
            if (himpunana[tengah] == x) {
                ketemu = true;
            } else if (x > himpunana[akhir]) {
                System.out.println("Data '" + x + "' Tidak Ditemukan");
                ketemu = true;
            } else {
                if (x < himpunana[tengah]) {
                    awal = tengah;
                    for (int i = 0; i <= awal; i++) {
                        if (himpunana[i] == x) {
                            System.out.println("Nilai kanan = " + himpunana[i + 1]);
                            ketemu = true;
                        }
                    }
                } else {
                    akhir = akhir;
                    for (int i = tengah; i < akhir; i++) {
                        if (himpunana[i] == x) {
                            System.out.println("Nilai kiri = " + himpunana[i - 1]);
                            ketemu = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        AlgoritmaPencarian ap = new AlgoritmaPencarian();
        ap.isiHimpunan();
        ap.tampilkanHimpunan();
        System.out.println("");
        /*method pencarianSequential(1) jadi nilai parameter x = 1 */
        ap.pencarianBinary(1);
        ap.pencarianBinary(5);
        ap.pencarianBinary(9);

        System.out.println("");
        ap.pencarianSequential(1);
        ap.pencarianSequential(5);
        ap.pencarianSequential(9);


    }
}
