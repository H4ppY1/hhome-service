package com.happy.hhome.converter;

import org.mapstruct.Mapper;


public interface BaseDoDtoConverter<DoT, DtoT> {
    DoT toDO(DtoT arg0);

    DtoT toDTO(DoT arg0);
}
