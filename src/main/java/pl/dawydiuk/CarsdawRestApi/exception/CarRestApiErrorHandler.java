package pl.dawydiuk.CarsdawRestApi.exception;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class CarRestApiErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError()) {
            throw CarRestApiExceptionFactory.externalServiceCallException(response.getBody().toString());
        }
    }
}
