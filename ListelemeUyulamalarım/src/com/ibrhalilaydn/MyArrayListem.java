package com.ibrhalilaydn;

public class MyArrayListem // ekle, indexe göre sil, degere göre sil, sondan sil, listele, indexe göre ekle, boyut metotlarý bulunmaktadýr.
{
	private int listeSay=0;
	private String[] dizi;
	public MyArrayListem() 
	{
		listeSay=0;
		dizi =new String[listeSay];
	}
	public void ekle(String deger)
	{
		listeSay++;
		diziBoyutlandirma();
		dizi[listeSay-1]=deger;
	}
	public void sil(int indexno)
	{
		if (indexno>listeSay) 
		{
			System.out.println("liste sýnýrlarý aþýldý");
			return;
		}
		for (int j = indexno; j < dizi.length-1; j++) 
		{
			dizi[j]=dizi[j+1];
		}
		dizi[dizi.length-1]=null;
		sonElemanSil();
	}
	public void sil(String deger)
	{
		boolean listedeVar=false;
		for (String list : dizi) 
		{
			if (deger.equals(list)) 
			{
				listedeVar=true;
			}
		}
		if (listedeVar==false) 
		{
			System.out.println("dizide '"+deger+"' bulunamadý." );
			return;
		}
		for (int i = 0; i < dizi.length; i++) 
		{
			if(deger.equals(dizi[i]))
			{
				for (int j = i; j < dizi.length-1; j++) 
				{
					dizi[j]=dizi[j+1];
				}
			}
		}
		dizi[dizi.length-1]=null;
		sonElemanSil();
		
	}
	public void arayaEkle(int index, String deger)
	{
		if (index>=listeSay) 
		{
			System.out.println("liste boyutunu aþtýnýz");
			return;
		}
		listeSay++;
		diziBoyutlandirma();
		for (int i = dizi.length-1; i >= 0 ; i--) 
		{
			if(i==index)
			{
				dizi[i]=deger;
				return;
			}
			else
			{
				dizi[i]=dizi[i-1];
			}
			
		}
	}
	public void listele()
	{
		int say=0;
		for (String deger : dizi) 
		{
			System.out.println(say+": "+deger);
			say++;
		}
		
	}
	public int boyut()
	{
		return listeSay;
	}
	public void sonElemanSil()
	{
		listeSay--;
		String[] kopyaDizi = new String[listeSay];
		for (int i = 0; i < kopyaDizi.length; i++) 
		{
			kopyaDizi[i]=dizi[i];
		}
		dizi =new String[listeSay];
		dizi=kopyaDizi;
	}
	private void diziBoyutlandirma()
	{
		String[] kopyaDizi = new String[listeSay];
		for (int i = 0; i < dizi.length; i++) 
		{
			kopyaDizi[i]=dizi[i];
		}
		dizi =new String[listeSay];
		dizi=kopyaDizi;
	}

}
