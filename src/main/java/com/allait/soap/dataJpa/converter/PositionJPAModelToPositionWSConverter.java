package com.allait.soap.dataJpa.converter;

import com.allait.soap.client.gen.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionJPAModelToPositionWSConverter implements Converter<com.allait.soap.dataJpa.model.Position, Position> {


    @Override
    public Position convert(com.allait.soap.dataJpa.model.Position position) {
        Position position1 = new Position();
        position1.setName(position.getName());
        return position1;
    }
}
