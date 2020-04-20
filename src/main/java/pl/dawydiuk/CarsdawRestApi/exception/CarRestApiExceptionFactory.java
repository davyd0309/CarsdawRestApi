package pl.dawydiuk.CarsdawRestApi.exception;

import java.util.Arrays;
import java.util.Optional;

public class CarRestApiExceptionFactory {

    public static CarRestApiException externalServiceCallException(String causeMessage) {
        String code = "00001";
        String message = "External service call exception: [%s]";
        return new CarRestApiException(buildError(code, message, causeMessage));
    }

    private static Error buildError(String code, String message, String... parameters) {
        return Error.builder()
                .code(code)
                .message(String.format(message, getValues(parameters)))
                .build();
    }

    private static Object[] getValues(String[] parameters) {
        return Arrays.stream(parameters)
                .map(param -> Optional.ofNullable(param).orElse("N/A"))
                .toArray();
    }
}
