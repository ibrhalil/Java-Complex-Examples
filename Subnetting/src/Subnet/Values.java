package Subnet;

import java.util.Arrays;

public class Values 
{
	private String _ipDecimal;			//ip adres metinsel
	private String _ipBinary;			//ip adres ikilik sistem
	private int _cidr;					//CIDR metinsel
	private int[] _ipArry;				//ip adres sayisal dizi
	private String _maskBinary;			//subnet mask ikilik sistem
	private String _maskDecimal;		//subnet mask onluk  sistem
	private String _networkId;			//Network ID metinsel
	private String _broadcast;			//Broadcast  metinsel
	private int _magicNumber;			//Sihirli sayi
	private String _ipClass;			//ip sinifi
	private int _hostNumber;			//kullanýlabilir host sayýsý
	private String _type;				//verilen ip türü (network, broadcast, host)
	private String _hostMin;			//ilk host ip si
	private String _hostMax;			//son host ip si
	
	public Values() {
		set_ipDecimal("");
		set_ipBinary("");
		set_cidr(0);
		set_ipArry(new int[4]);
		set_maskBinary("");
		set_maskDecimal("");
		set_networkId("");
		set_broadcast("");
		set_magicNumber(0);
		set_ipClass("");
		set_hostNumber(0);
		set_type("");
		set_hostMin("");
		set_hostMax("");
	}
	
	public Values(String ip,int cidr)
	{
		set_ipDecimal(ip);
		set_cidr(cidr);
	}
	public String get_ipDecimal() {
		return _ipDecimal;
	}
	public void set_ipDecimal(String _ipDecimal) {
		this._ipDecimal = _ipDecimal;
	}
	public String get_ipBinary() {
		return _ipBinary;
	}
	public void set_ipBinary(String _ipBinary) {
		this._ipBinary = _ipBinary;
	}
	public int get_cidr() {
		return _cidr;
	}
	public void set_cidr(int _cidr) {
		this._cidr = _cidr;
	}
	public int[] get_ipArry() {
		return _ipArry;
	}
	public void set_ipArry(int[] _ipArry) {
		this._ipArry = _ipArry;
	}
	public String get_maskBinary() {
		return _maskBinary;
	}
	public void set_maskBinary(String _maskBinary) {
		this._maskBinary = _maskBinary;
	}
	public String get_maskDecimal() {
		return _maskDecimal;
	}
	public void set_maskDecimal(String _maskDecimal) {
		this._maskDecimal = _maskDecimal;
	}
	public String get_networkId() {
		return _networkId;
	}
	public void set_networkId(String _networkId) {
		this._networkId = _networkId;
	}
	public String get_broadcast() {
		return _broadcast;
	}
	public void set_broadcast(String _broadcast) {
		this._broadcast = _broadcast;
	}
	public int get_magicNumber() {
		return _magicNumber;
	}
	public void set_magicNumber(int _magicNumber) {
		this._magicNumber = _magicNumber;
	}
	public String get_ipClass() {
		return _ipClass;
	}
	public void set_ipClass(String _ipClass) {
		this._ipClass = _ipClass;
	}
	public int get_hostNumber() {
		return _hostNumber;
	}
	public void set_hostNumber(int _hostNumber) {
		this._hostNumber = _hostNumber;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String get_hostMin() {
		return _hostMin;
	}
	public void set_hostMin(String _hostMin) {
		this._hostMin = _hostMin;
	}
	public String get_hostMax() {
		return _hostMax;
	}
	public void set_hostMax(String _hostMax) {
		this._hostMax = _hostMax;
	}

	@Override
	public String toString() {
		return    "IP Adresi           : " + _ipDecimal + 
				"\nIP Binary           : " + _ipBinary +
				"\nSubnet Mask Binary  : " + _maskBinary + 
				"\nSubnet Mask Decimal : " + _maskDecimal + 
				"\nCIDR                : " + _cidr + 
				"\nSihirli Sayi        : " + _magicNumber	+ 
				"\nIP Dizi             : " + Arrays.toString(_ipArry) + 
				"\nNetwork ID          : " + _networkId + 
				"\nBroadcast           : " + _broadcast + 
				"\nIP Sýnýfý           : " + _ipClass + 
				"\nHost Sayýsý         : " + _hostNumber + 
				"\nÝlk Host            : " + _hostMin + 
				"\nSon Host            : " + _hostMax +
				"\nTürü                : " + _type;
		
	}
	
}
