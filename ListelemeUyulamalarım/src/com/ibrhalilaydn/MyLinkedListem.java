package com.ibrhalilaydn;

public class MyLinkedListem 
{
	private int listeSay;
	private Degisken ilkdeger;
	private Degisken sondeger;
	public MyLinkedListem() 
	{
		listeSay=0;
		ilkdeger=null;
		sondeger=null;
	}
	
	public void ekle(String deger)//sona ekleme yapýyor
	{
		Degisken yenideger = new Degisken(deger);
		if(listeSay==0)
		{
			ilkdeger=yenideger;
			sondeger=yenideger;
		}
		else
		{
			sondeger.klavuz=yenideger;
			sondeger=yenideger;
		}
		listeSay++;
	}
	public void sil(int indexno)
	{
		Degisken secilmisOnceki=null;
		Degisken secilmis=ilkdeger;
		int sayac=0;
		while(secilmis != null)
		{
			if(sayac==indexno)
			{
				if(secilmisOnceki==null)
				{
					ilkdeger=ilkdeger.klavuz;
					break;
				}
				else if(secilmis.klavuz==null)
				{
					secilmisOnceki.klavuz=null;
					sondeger=secilmisOnceki;
					break;
				}
				else
				{
					secilmisOnceki.klavuz=secilmis.klavuz;
					break;
				}
			}
			secilmisOnceki=secilmis;
			secilmis=secilmis.klavuz;
			sayac++;
		}
		listeSay--;
	}
	public void arayaEkle(int indexno, String deger)
	{
		Degisken yenideger = new Degisken(deger);
		Degisken secilmisOnceki=null;
		Degisken secilmis=ilkdeger;
		int sayac=0;
		while(secilmis != null)
		{
			if(sayac==indexno)
			{
				if(secilmisOnceki==null)
				{
					yenideger.klavuz=ilkdeger;
					ilkdeger=yenideger;
				}
				else
				{
					secilmisOnceki.klavuz=yenideger;
					yenideger.klavuz=secilmis;
					
				}
			}
			secilmisOnceki=secilmis;
			secilmis=secilmis.klavuz;
			sayac++;
		}
		listeSay++;
	}
	public void sil(String deger)
	{
		Degisken secilmisOnceki=null;
		Degisken secilmis=ilkdeger;
		while(secilmis != null)
		{
			if(secilmis.deger.equals(deger))
			{
				if(secilmisOnceki==null)
				{
					ilkdeger=ilkdeger.klavuz;
					break;
				}
				else if(secilmis.klavuz==null)
				{
					secilmisOnceki.klavuz=null;
					sondeger=secilmisOnceki;
					break;
				}
				else
				{
					secilmisOnceki.klavuz=secilmis.klavuz;
					break;
				}
			}
			secilmisOnceki=secilmis;
			secilmis=secilmis.klavuz;
		}
		listeSay--;
	}
	public int boyut()
	{
		return listeSay;
	}
	public void listele()
	{
		if(listeSay==0)
		{
			System.out.println("Liste Boþ");
			return;
		}
		Degisken secilmis=ilkdeger;
		int sayac=0;
		while(secilmis != null)
		{
			System.out.println(sayac+" "+secilmis.deger);
			secilmis=secilmis.klavuz;
			sayac++;
		}
	}
}
