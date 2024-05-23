package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.InversionistaDTO;
import com.app.InBestBackend.persistence.entity.Inversionista;

public class InversionistaMapper {
    public static Inversionista toEntinty(InversionistaDTO inversionistaDTO){
        Inversionista inversionista = new Inversionista();
        inversionista.setUsuario(inversionistaDTO.getUsuario());
        inversionista.setSolicitudes(inversionistaDTO.getSolicitudes());
        inversionista.setInversiones(inversionistaDTO.getInversiones());
        inversionista.setId_inversionista(inversionistaDTO.getId_inversionista());
        return inversionista;
    }

    public static InversionistaDTO toDTO(Inversionista inversionista){
        InversionistaDTO inversionistaDTO = new InversionistaDTO();
        inversionistaDTO.setUsuario(inversionista.getUsuario());
        inversionistaDTO.setSolicitudes(inversionista.getSolicitudes());
        inversionistaDTO.setInversiones(inversionista.getInversiones());
        inversionistaDTO.setId_inversionista(inversionista.getId_inversionista());
        return inversionistaDTO;
    }
}
