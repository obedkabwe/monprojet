package com.obedkabwe.Domain.enums;

public enum Estadopagamento {

	PENDETE(1,"pendete"), 
	QUITADO(1,"quitado"),
	CANCELADO(3,"cancelado");
	
	
	private Integer cod;
	private String descricao;
	
	
	 private Estadopagamento(int cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao; 
		 }
			
		
		
		public int getCod() {
			return cod;
		}

		public String getDescricao() {
			return descricao;
		}

		public static Estadopagamento toEnum(Integer cod) {
			
			if (cod == null) {
				return null;
			}
			for (Estadopagamento x : Estadopagamento.values()) {
				if (cod.equals(x.getCod())) {
				return x;
				}
		
		
		}
			return null;
		
		
		
		
		
		
		
		
		
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
