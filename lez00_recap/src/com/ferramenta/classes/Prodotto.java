package com.ferramenta.classes;

public class Prodotto {

	private int id;
	private String nome;
	private String desc;
	private String cate;
	private float prez;
	private int quan;
	
	//Prodotto()
	public Prodotto() {
		
	}
	
	//Prodotto(String, String, Strin)
	public Prodotto(String nome, String desc, String cate) {
		this.nome = nome;
		this.desc = desc;
		this.cate = cate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public float getPrez() {
		return prez;
	}
	public void setPrez(float prez) {
		this.prez = prez;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", desc=" + desc + ", cate=" + cate + ", prez=" + prez
				+ ", quan=" + quan + "]";
	}
	
	
	
}
