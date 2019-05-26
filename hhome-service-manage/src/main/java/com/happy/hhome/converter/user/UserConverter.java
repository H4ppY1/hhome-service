package com.happy.hhome.converter.user;

import com.happy.hhome.bean.UserDO;
import com.happy.hhome.bean.UserDTO;
import com.happy.hhome.bean.UserQuery;
import com.happy.hhome.converter.BaseDoDtoConverter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter extends BaseDoDtoConverter<UserDO, UserDTO> {
    UserDO toDO(UserQuery userQuery);
}
