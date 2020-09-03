package main;

public class Subnetting 
{
	private String Data;
	private String IP;
	private int[] Dizi_ip;
	private int CIDR;
	private String Subnet_Mask="";
	private String Subnet="";
	private int SihirliSayi;
	private int Host;
	private String NetworkID="";
	private String BnryIP="";
	
	public Subnetting(String Data) {
		setData(Data);
		parcala();
	}
	public Subnetting(String Data,int CIDR) {
		setData(Data);
		setCIDR(CIDR);
	}
	
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getCIDR() {
		return CIDR;
	}
	public void setCIDR(int cIDR) {
		CIDR = cIDR;
	}
	public String getSubnet_Mask() {
		return Subnet_Mask;
	}
	public void setSubnet_Mask(String subnet_Mask) {
		Subnet_Mask = subnet_Mask;
	}
	public String getSubnet() {
		return Subnet;
	}
	public void setSubnet(String subnet) {
		Subnet = subnet;
	}
	public int getSihirliSayi() {
		return SihirliSayi;
	}
	public void setSihirliSayi(int sihirliSayi) {
		SihirliSayi = sihirliSayi;
	}
	public int getHost() {
		return Host;
	}
	public void setHost(int host) {
		Host = host;
	}
	public String getBnryIP() {
		return BnryIP;
	}
	public void setBnryIP(String bnryIP) {
		BnryIP = bnryIP;
	}
	public String getNetworkID() {
		return NetworkID;
	}
	public void setNetworkID(String networkID) {
		NetworkID = networkID;
	}
	public int[] getDizi_ip() {
		return Dizi_ip;
	}
	
	public void parcala() 
	{
		int indexTmp=0;
		int diziSay=0;
		setBnryIP("");
		Dizi_ip = new int[4];
		
		for (int i = 0; i < getData().length(); i++) 
		{
			if(getData().charAt(i)=='/')
			{
				int parca=Integer.valueOf(getData().substring(indexTmp, i));
				Dizi_ip[3]=parca;
				String sekizeTmmla="";
				for (int j = 0; j < 8 - Integer.toBinaryString(parca).length(); j++) {
					sekizeTmmla+="0";
				}
				setBnryIP(getBnryIP() +(sekizeTmmla + Integer.toBinaryString(parca)));
				IP = getData().substring(0, i);
				CIDR = Integer.valueOf(getData().substring((i+1),getData().length()));
				break;
			}
			else if(getData().charAt(i)=='.')
			{
				int parca = Integer.valueOf(getData().substring(indexTmp, i));
				Dizi_ip[diziSay]=parca;
				String sekizeTmmla="";
				for (int j = 0; j < 8 - Integer.toBinaryString(parca).length(); j++) {
					sekizeTmmla+="0";
				}
				setBnryIP(getBnryIP() + (sekizeTmmla + Integer.toBinaryString(parca)));
				setBnryIP(getBnryIP() + ".");
				indexTmp=i+1;
				diziSay++;
			}
			else if(getData().charAt(i)=='0'||getData().charAt(i)=='1'||getData().charAt(i)=='2'||getData().charAt(i)=='3'||getData().charAt(i)=='4'||getData().charAt(i)=='5'||getData().charAt(i)=='6'||getData().charAt(i)=='7'||getData().charAt(i)=='8'||getData().charAt(i)=='9')
			{
				
			}
			else
			{
				System.err.println("Parçalama Ýþlemi Sýrasýnda Hatalý Karakter Berlirlendi..!\nProgram Sonlandýrýldý...");
				System.exit(0);
			}
		}
		if(CIDR>32)
		{
			System.err.println("Geçersiz CIDR Deðeri "+getCIDR()+"\nProgram Sonlandýrýldý...");
			System.exit(0);
		}
		subnet();
		subnetMask();
		setHost((int) Math.pow(2, 32-CIDR)-2);
		SihirliSay();
		bKarsilastirma();
		
	}
	public void bKarsilastirma()
	{
		int ektot=0;
		int tmpCIDR = CIDR;
		for (int i = 0; i < BnryIP.length(); i++) {
			
			if(BnryIP.charAt(i)=='.')
			{
				setNetworkID(getNetworkID() + ektot + ".");
				ektot=0;
				//tmpCIDR++;
				//continue;
			}
			else if(i<=tmpCIDR && BnryIP.charAt(i)=='1')
			{
				int mod = i%8;
				ektot+=Math.pow(2, 8-mod-1);
			}
			else if(i>tmpCIDR)
			{
				ektot=0;
			}
			

		}
		setNetworkID(getNetworkID() + ektot);
		/*if(CIDR>0 || CIDR<8)
		{
			//ilk oktet
			setNetworkID(Integer.toBinaryString(Dizi_ip[0]));
		}
		else if(CIDR>=8 || CIDR<16)
		{
			//ikinci oktet
		}
		else if(CIDR>=16 || CIDR<24)
		{
			//üçüncü oktet
		}
		else if(CIDR>=16)
		{
			//4. oktet
			
		}*/
	}
	public void SihirliSay()
	{
		switch (CIDR % 8) {
		case 0:
			SihirliSayi=256;
			break;
		case 1:
			SihirliSayi=128;
			break;
		case 2:
			SihirliSayi=64;
			break;
		case 3:
			SihirliSayi=32;
			break;
		case 4:
			SihirliSayi=16;
			break;
		case 5:
			SihirliSayi=8;
			break;
		case 6:
			SihirliSayi=4;
			break;
		case 7:
			SihirliSayi=2;
			break;
		}
	}
	
	public void subnet() {
		setSubnet("");
		for (int i = 0; i < 32; i++) {
			if(i%8==0 && i!=0)
			{
				setSubnet(getSubnet()+".");
			}
			if(i<CIDR) {
				setSubnet(getSubnet()+"1");
			}
			else
			{
				setSubnet(getSubnet()+"0");
			}
			
		}
	}
	public void subnetMask() {
		int indexTmp=0;
		for (int i = 0; i < getSubnet().length(); i++) {
			if(getSubnet().charAt(i)=='.')
			{
				String blok = getSubnet().substring(indexTmp, i);
				Subnet_Mask+=Integer.parseInt(blok, 2);
				Subnet_Mask+=".";
				indexTmp=i+1;
			}
			if(i+1==getSubnet().length())
			{
				String blok = getSubnet().substring(indexTmp, i+1);
				Subnet_Mask+=Integer.parseInt(blok, 2);
			}
		}
	}
	
	public void listele(String[] dizi) 
	{
		for (int i = 0; i < dizi.length; i++) {
			System.out.println(dizi[i]);
		}
	}
	
	public void listele(int[] dizi) 
	{
		for (int i = 0; i < dizi.length; i++) {
			System.out.println(dizi[i]);
		}
	}
	
}
