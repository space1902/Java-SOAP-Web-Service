package Soapapi.soap.impl;

import Soapapi.soap.WSSecurityInterceptor;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.stereotype.Service;
import pe.joedayz.sumservice.schema.GetSumRequest;
import pe.joedayz.sumservice.schema.GetSumResponse;
import pe.joedayz.sumservice.wsdl.SumServicePort;

@Service
@SchemaValidation(type = SchemaValidation.SchemaValidationType.REQUEST)
@InInterceptors(classes = WSSecurityInterceptor.class)
public class SumServiceImpl implements SumServicePort {
    @Override
    public GetSumResponse getSum(GetSumRequest parameters) {
        GetSumResponse response = new GetSumResponse();
        response.setResult(parameters.getAddendOne() + parameters.getAddendTwo());
        return response;
    }
}
