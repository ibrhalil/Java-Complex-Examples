package com.ibrhalilaydn;

public class ControlPaneli 
{
	public static void main(String[] args) 
	{
		/*
		MyArrayListem pazarListesi = new MyArrayListem();
		pazarListesi.ekle("elma");
		pazarListesi.ekle("armut");
		pazarListesi.ekle("karpuz");
		pazarListesi.ekle("kiraz");	
		pazarListesi.ekle("muz");
		pazarListesi.ekle("limon");
		pazarListesi.ekle("biber");
		pazarListesi.ekle("patates");
		pazarListesi.listele();
		System.out.println("listedeki eleman say�s� : "+pazarListesi.boyut());
		System.out.println("---------------------");
		
		pazarListesi.sil("biber");
		pazarListesi.sil(4);
		System.out.println("listeden biber ve 4. indexde bulunan �r�n silindi....");
		pazarListesi.listele();
		System.out.println("listeye �r�n eklendi");
		pazarListesi.arayaEkle(1, "ayva");
		pazarListesi.listele();
		*/
		/*
		MyArrayListem bilgisayarParcalari = new MyArrayListem();
		bilgisayarParcalari.ekle("Anakart");
		bilgisayarParcalari.ekle("ekran kart�");
		bilgisayarParcalari.arayaEkle(1, "i�lemci");
		bilgisayarParcalari.ekle("peynir");
		bilgisayarParcalari.sonElemanSil();
		bilgisayarParcalari.arayaEkle(0, "patates");
		bilgisayarParcalari.listele();
		*/
		MyLinkedListem sinifListesi = new MyLinkedListem();
		sinifListesi.ekle("Mehmet");
		sinifListesi.ekle("Halil");
		sinifListesi.ekle("Behl�l");
		sinifListesi.ekle("�brahim");
		sinifListesi.sil(3);
		sinifListesi.arayaEkle(3, "Yoda");
		sinifListesi.listele();
		
		
	}
	
	
}
