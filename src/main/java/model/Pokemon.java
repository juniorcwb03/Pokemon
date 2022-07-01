package model;



public class Pokemon {
	
	int num;
	String name;
	String tipo;
	String pre_evolution;
	String next_evolution;
	
	
	public Pokemon( ) {
		
	}
	public Pokemon(String nome ) {
		this.name = nome;
	}
	
	public Pokemon(int num ) {
		this.num = num;
	}
	
	public Pokemon( int num, String name, String tipo, String pre_evolution, String next_evolution ) {
		this.setNum(num);
		this.setName(name);
		this.setTipo(tipo);
		this.setPre_evolution(pre_evolution);
		this.setNext_evolution(next_evolution);
	}
	
	public Pokemon(String name, String tipo, String pre_evolution, String next_evolution ) {
		this.setName(name);
		this.setTipo(tipo);
		this.setPre_evolution(pre_evolution);
		this.setNext_evolution(next_evolution);
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPre_evolution() {
		return pre_evolution;
	}
	public void setPre_evolution(String pre_evolution) {
		this.pre_evolution = pre_evolution;
	}
	public String getNext_evolution() {
		return next_evolution;
	}
	public void setNext_evolution(String next_evolution) {
		this.next_evolution = next_evolution;
	}
	

}
