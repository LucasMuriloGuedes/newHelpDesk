package com.lucasmurilo.newhelpdesk.domain.enums;

public enum Status {
    ABERTA(1),
    ANDAMENTO(2),
    CONCLUIDA(3);

    private Integer cod;

    Status(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public static Status toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Status x: Status.values()){
            if(x.getCod() == cod){
                return x;
            }
        }

        throw new IllegalArgumentException("Codigo não encontrado! Cod: " + cod);
    }
}
