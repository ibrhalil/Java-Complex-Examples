package Subnet;

import java.util.Scanner;

public class App
{

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		boolean dongu = true;

		System.out.println("************************************************");
		System.out.println("1 - IP/CIDR veya IP Mask");
		System.out.println("2 - Havuz Sayýsý Belirleme");
		System.out.println("3 - Rastgele IP Üret");
		System.out.println("4 - Rastgele Üret ve Hesapla");

		System.out.println("Çýkmak için \'q\' basýnýz.");
		System.out.println("************************************************\n");

		while(dongu)
		{
			System.out.print("Seçim : ");
			String ip = "";
			
			switch(new Scanner(System.in).nextLine())
			{
			case "1":
				System.out.println("Örnek : 192.168.1.1/24");
				System.out.println("veya");
				System.out.println("Örnek : 192.168.1.1 255.255.255.0\n");
				System.out.print("(IP/CIDR) veya (IP Mask) : ");
				String data = (new Scanner(System.in)).nextLine();
				System.out.println("*********************************************************");
				Subnetting veri = new Subnetting(data);
				System.out.println(veri.toString());
				System.out.println("*********************************************************");

				break;

			case "2":
				System.out.print("Bölünecek Havuz Sayýsý : ");
				int havuz = (new Scanner(System.in)).nextInt();
				System.out.println("CIDR Deðeri : " + (32 - ((int) Math.ceil(Math.log(havuz) / Math.log(2)))));
				break;
			case "3":
				for(int i = 0;i < 4;i++)
				{
					int rasgele = (int) (Math.random() * 256);
					ip += rasgele;
					if(i!=3)
						ip += ".";
				}
				ip += "/" + ((int) (Math.random() * 31) + 1);
				System.out.println("Üretilen IP : " + ip);
				break;
			case "4":
				for(int i = 0;i < 4;i++)
				{
					int rasgele = (int) (Math.random() * 256);
					ip += rasgele;
					if(i!=3)
						ip += ".";
				}
				ip += "/" + ((int) (Math.random() * 31) + 1);
				System.out.println("Üretilen IP : " + ip);
				System.out.println("*********************************************************");
				System.out.println(new Subnetting(ip).toString());
				System.out.println("*********************************************************");
				break;
			case "q":
				dongu = false;
				break;
			}
		}
	}

}
