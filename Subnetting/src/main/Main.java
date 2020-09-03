package main;

import java.util.Scanner;

public class Main 
{
	static Subnetting Veri=null;
	static Scanner oku=null;
	public static void main(String[] args) 
	{
		
		oku= new Scanner(System.in);
		
		System.out.println("************************");
		System.out.println("1 - IP Adres ve CIDR");
		System.out.println("2 - IP Adres ve Subnet Mask");
		System.out.println("Çýkmak için \'q\' basýnýz.");
		System.out.println("************************\n");
		
		boolean dongu=true;	
		
		while (dongu) 
		{
			System.out.print("Seçiminiz : ");
			String girdi = oku.nextLine();
			switch (girdi) {
			case "1":
				secim1();
				break;
			case "2":
				secim2();
				break;
			case "q":
				dongu = false;
				break;
			default:
				
				break;
			}
		}
		System.out.println("Program Sonlandýrýldý...");
	
	}
	static void secim1()
	{
		System.out.println("Örnek : 192.168.1.1/24\n");
		System.out.print("IP Adres/CIDR : ");
		Veri = new Subnetting(oku.nextLine());
		islem();
	}
	static void secim2()
	{
		System.out.println("Örnek : 192.168.1.1\n255.255.255.0");
		System.out.print("IP Adres : ");
		String ip = oku.nextLine();
		System.out.print("Subnet Mask : ");
		int subnetMask = oku.nextInt();
		Veri = new Subnetting(ip, subnetMask);
		islem();
	}
	static void islem()
	{
		System.out.println("\n************************");
		System.out.println("IP Adresiniz     : "+Veri.getIP());
		System.out.println("CIDR Degeri      : "+Veri.getCIDR());
		//Veri.listele(Veri.getDizi_ip());
		System.out.println("Subnet Mask      : "+Veri.getSubnet_Mask());
		System.out.println("Sihirli Sayý     : "+Veri.getSihirliSayi());
		System.out.println("Network ID       : "+Veri.getNetworkID());
		System.out.println("Subnet           : "+Veri.getSubnet());
		System.out.println("IP Ýkilik Sistem : "+Veri.getBnryIP());
		System.out.println("************************");
		
	}

}
