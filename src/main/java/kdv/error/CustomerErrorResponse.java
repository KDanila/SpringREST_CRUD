package kdv.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
