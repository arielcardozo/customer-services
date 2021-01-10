package com.allait.soap;

import com.allait.soap.client.gen.*;
import com.allait.soap.dataJpa.converter.PositionJPAModelToPositionWSConverter;
import com.allait.soap.dataJpa.converter.PositionResponseToJPAModelListConverter;
import com.allait.soap.dataJpa.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Optional;

@Endpoint
public class PositionEndpoint {

    private static final String NAMESPACE_URI = "http://www.allait.com/soap/gen";

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    public PositionEndpoint(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Autowired
    private PositionJPAModelToPositionWSConverter positionResponseToJPAModelConverter;

    @Autowired
    private PositionResponseToJPAModelListConverter positionResponseToJPAModelListConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPositionsRequest")
    @ResponsePayload
    public GetAllPositionsResponse getPositions(@RequestPayload GetAllPositionsRequest request) {
        GetAllPositionsResponse response = new GetAllPositionsResponse();


        List<Position> list = positionResponseToJPAModelListConverter.convert(positionRepository.findAll());
        response.setPositions(list);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPositionByIDRequest")
    @ResponsePayload
    public GetPositionByIDResponse getPositionById(@RequestPayload GetPositionByIDRequest request) {
        GetPositionByIDResponse response = new GetPositionByIDResponse();
        Optional<com.allait.soap.dataJpa.model.Position> pos = positionRepository.findById(request.getId());
        if(!pos.isPresent()){
            return null;
        }else{
            response.setPosition(positionResponseToJPAModelConverter.convert(pos.get()));
        }

        return response;
    }
}
