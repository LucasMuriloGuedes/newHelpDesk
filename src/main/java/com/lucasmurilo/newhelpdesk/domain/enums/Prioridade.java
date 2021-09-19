package com.lucasmurilo.newhelpdesk.domain.enums;

public enum Prioridade {
    BAIXA(1),
    MEDIA(2),
    ALTA(3);

    private Integer cod;

    Prioridade(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public static Prioridade toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Prioridade x: Prioridade.values()){
            if(cod == x.getCod()){
                return x;
            }
        }
        throw new IllegalArgumentException("Codigo não encontrado!"+ cod);
    }
}
