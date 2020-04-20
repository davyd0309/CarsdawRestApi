package pl.dawydiuk.CarsdawRestApi.exception;

import java.util.List;
import java.util.stream.Collectors;

public class CarRestApiException extends RuntimeException {

    private static final String ERROR_TO_STRING_PATTERN = "Error[code='%s',message='%s']";
    private final List<Error> errorList;

    public CarRestApiException(List<Error> errorList) {
        super(createMessage(errorList));
        this.errorList = errorList;
    }

    public CarRestApiException(Error error) {
        this(List.of(error));
    }


    private static String createMessage(List<Error> errorList) {
        return errorList.stream()
                .map(error -> String.format(ERROR_TO_STRING_PATTERN, error.getCode(), error.getMessage()))
                .collect(Collectors.joining(";"));
    }


}
