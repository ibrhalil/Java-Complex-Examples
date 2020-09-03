package Subnet;

class Paket
{
	String veri1;
	String veri2;
	String veri3;
}

public class Subnetting extends Values
{
	private String _data;

	public Subnetting(String data)
	{
		this.set_data(data);

		Paket veri = parcala(data.trim());
		set_ipDecimal(veri.veri1);
		if(veri.veri3 == "cidr")
		{
			this.set_cidr(Integer.valueOf(veri.veri2));
		}else if(veri.veri3 == "mask")
		{
			this.set_maskDecimal(veri.veri2.trim());
			this.set_cidr(maskTocidr(get_maskDecimal()));
		}

		this.set_magicNumber(macNum(get_cidr()));

		this.set_maskBinary(cidrToMaskBin(get_cidr()));

		this.set_ipBinary(parcala());

		this.set_maskDecimal(subnetMaskDecimal(get_maskBinary()));

		this.set_networkId(subnetMaskDecimal(binaryKarsilastirma(get_ipBinary(), get_maskBinary())));

		this.set_ipArry(ipAyikla(get_networkId()));
		
		this.set_broadcast(broadcast(get_ipArry(),get_magicNumber(),get_cidr()));

		this.set_hostMin(ilkHost(get_ipArry()));
		
		this.set_hostMax(sonHost(ipAyikla(broadcast(get_ipArry(), get_magicNumber(), get_cidr()))));
		
		this.set_hostNumber((int) Math.pow(2, (32-get_cidr()))-2);
		
		this.set_ipClass(ipClassBulma(ipAyikla(get_ipDecimal()), get_cidr()));
		
		this.set_type(ip_tipi());
		
		this.set_ipArry(ipAyikla(get_ipDecimal()));

	}
	
	public String broadcast(int[] network, int sihirliNo, int cidr)
	{
		int[] broadcast = {network[0],network[1],network[2],network[3]};
		sihirliNo-=1;
		if(cidr>0 && cidr<8)
		{
			//ilk oktet
			broadcast[0]+=sihirliNo;
			broadcast[1]+=255;
			broadcast[2]+=255;
			broadcast[3]+=255;
			
		}
		else if(cidr>=8 && cidr<16)
		{
			//ikinci oktet
			broadcast[1]+=sihirliNo;
			broadcast[2]+=255;
			broadcast[3]+=255;
		}
		else if(cidr>=16 && cidr<24)
		{
			//üçüncü oktet
			broadcast[2]+=sihirliNo;
			broadcast[3]+=255;
		}
		else if(cidr>=24)
		{
			//4. oktet
			broadcast[3]+=sihirliNo;
		}
		return broadcast[0]+"."+broadcast[1]+"."+broadcast[2]+"."+broadcast[3];
	}
	
	public String ip_tipi()
	{
		if(get_ipDecimal().equals(get_networkId()))
		{
			return "Network IP";
		}
		else if(get_ipDecimal().equals(get_broadcast()))
		{
			return "Broadcast IP";
		}
		else
		{
			return "Host IP";
		}
		
	}
	
	public String ipClassBulma(int[] ip,int cidr)
	{
		String durum="";
		int ilkOktet=ip[0];
		int ikinciOktet=ip[1];
		
		if((ilkOktet>=1 && ilkOktet<=126)&&cidr>=8)
		{
			durum="A Class IP ";
		}
		else if(ilkOktet>=128 && ilkOktet<=191 && cidr>=16)
		{
			durum="B Class IP ";
		}
		else if(ilkOktet>=192 && ilkOktet<=223 && cidr>=24)
		{
			durum="C Class IP ";
		}
		else if(ilkOktet>=224 && ilkOktet<=239)
		{
			durum="D Class IP (Multicast) ";
		}
		else if(ilkOktet>=240 && ilkOktet<=254)
		{
			durum="E Class IP ";
		}
		else
		{
			durum="Classless IP ";
		}
		
		if(ilkOktet==10)
		{
			durum+="Private Adres";
		}
		else if(ilkOktet==172 && ikinciOktet>=16 &&ikinciOktet<=31 )
		{
			durum+="Private Adres";
		}
		else if(ilkOktet==192 && ikinciOktet==168)
		{
			durum+="Private Adres";
		}
		else
		{
			if(ilkOktet!=255)
				durum+="Public Adres";
		}
		return durum;
	}
	
	public String ilkHost(int[] dizi)
	{
		String host = dizi[0] + "." + dizi[1] + "." + dizi[2] + "." + (dizi[3] + 1);
		return host;
	}
	
	public String sonHost(int[] dizi)
	{
		String host = dizi[0] + "." + dizi[1] + "." + dizi[2] + "." + (dizi[3] - 1);
		return host;
	}

	public String binaryKarsilastirma(String data1,String data2)
	{
		String networkStart = "";
		for(int i = 0;i < data1.length();i++)
		{
			if(data1.charAt(i) == data2.charAt(i) && data1.charAt(i) != '.' && data2.charAt(i) == '1')
			{
				networkStart += "1";
			}else if(data1.charAt(i) == '.' && data2.charAt(i) == '.')
			{
				networkStart += ".";
			}else
			{
				networkStart += "0";
			}
		}
		return networkStart;
	}

	public int[] ipAyikla(String ip)
	{
		int[] dizi = new int[4];
		int say = 0;
		int tmp = 0;
		for(int i = 0;i < ip.length();i++)
		{
			if(ip.charAt(i) == '.')
			{
				dizi[say] = Integer.valueOf(ip.substring(tmp, i));
				say++;
				tmp = i + 1;
			}
		}
		dizi[3] = Integer.valueOf(ip.substring(tmp, ip.length()));
		return dizi;
	}

	public String subnetMaskDecimal(String binary)
	{
		String mask = "";
		int indexTmp = 0;
		for(int i = 0;i < binary.length();i++)
		{
			if(binary.charAt(i) == '.')
			{
				String blok = binary.substring(indexTmp, i);
				mask += binToDec(blok);
				mask += ".";
				indexTmp = i + 1;
			}
			if(i + 1 == binary.length())
			{
				String blok = binary.substring(indexTmp, i + 1);
				mask += binToDec(blok);
			}
		}
		return mask;
	}

	public int macNum(int cidr)
	{
		int sifirSay = (32-cidr) % 8 ;
		return (int) Math.pow(2, (sifirSay == 0 ? 8 : sifirSay));
	}

	public String cidrToMaskBin(int cidr)
	{
		String mask = "";
		for(int i = 0;i < 32;i++)
		{
			if(i % 8 == 0 && i != 0)
			{
				mask += ".";
			}
			if(i < cidr)
			{
				mask += "1";
			}else
			{
				mask += "0";
			}

		}
		return mask;
	}

	public int maskTocidr(String mask)
	{
		int tmp = 0;
		String deger="";
		int cidr=0;
		for(int i = 0;i < mask.length();i++)
		{
			if(mask.charAt(i) == '.')
			{
				deger+=decToBin(Integer.valueOf(mask.substring(tmp, i)));
				tmp=i+1;
			}
			if(i + 1 == mask.length())
			{
				deger+=decToBin(Integer.valueOf(mask.substring(tmp, mask.length())));
			}

		}
		for(int i = 0;i < deger.length();i++)
		{
			if(deger.charAt(i)=='1')
			{
				cidr++;
			}
		}
		return cidr;
	}
	
	public String parcala()
	{
		String ip = get_ipDecimal();
		String mask = "";
		String maskFull = "";
		int tmp = 0;
		for(int i = 0;i < ip.length();i++)
		{
			if(ip.charAt(i) == '.')
			{
				mask = ip.substring(tmp, i);
				tmp = i + 1;
				maskFull += decToBin(Integer.valueOf(mask)) + ".";
			}
			if(i + 1 == ip.length())
			{
				mask = ip.substring(tmp, ip.length());
				maskFull += decToBin(Integer.valueOf(mask));
			}

		}
		return maskFull;
	}

	public Paket parcala(String data)
	{
		Paket sonuc = new Paket();
		for(int i = 0;i < data.length();i++)
		{
			if(data.charAt(i) == '/')
			{
				sonuc.veri1 = data.substring(0, i);
				sonuc.veri2 = data.substring((i + 1), data.length());
				sonuc.veri3 = "cidr";
				break;
			}else if(data.charAt(i) == ' ')
			{
				sonuc.veri1 = data.substring(0, i);
				sonuc.veri2 = data.substring((i + 1), data.length());
				sonuc.veri3 = "mask";
				break;
			}else if(data.charAt(i) == '0' || data.charAt(i) == '1' || data.charAt(i) == '2' || data.charAt(i) == '3'
					|| data.charAt(i) == '4' || data.charAt(i) == '5' || data.charAt(i) == '6' || data.charAt(i) == '7'
					|| data.charAt(i) == '8' || data.charAt(i) == '9' || data.charAt(i) == '.')
			{
				continue;
			}else
			{
				System.err
						.println("Parçalama Ýþlemi Sýrasýnda Hatalý Karakter Berlirlendi..!\nProgram Sonlandýrýldý...");
				System.exit(0);
			}
		}
		return sonuc;
	}

	public int binToDec(String bin)
	{
		return Integer.parseInt(bin, 2);
	}

	public String decToBin(int dec)
	{
		String sonuc = Integer.toBinaryString(dec);
		String tmp = "";
		for(int i = 0;i < 8 - sonuc.length();i++)
		{
			tmp += "0";
		}
		return(tmp + sonuc);
	}

	public String get_data()
	{
		return _data;
	}

	public void set_data(String _data)
	{
		this._data = _data;
	}
}
