package com.allait.soap.dataJpa.converter;

import com.allait.soap.dataJpa.model.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PositionResponseToJPAModelListConverter implements Converter<List<Position>, List<com.allait.soap.client.gen.Position>> {

    @Override
    public List<com.allait.soap.client.gen.Position> convert(List<Position> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list
                .stream()
                .map(positionM -> buildPositionResponse(positionM))
                .collect(Collectors.toList());
    }

    private com.allait.soap.client.gen.Position buildPositionResponse(Position posM){
        com.allait.soap.client.gen.Position position = new com.allait.soap.client.gen.Position();
        position.setName(posM.getName());
        return position;
    }

}
