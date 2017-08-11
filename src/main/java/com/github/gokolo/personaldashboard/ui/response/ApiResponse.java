package com.github.gokolo.personaldashboard.ui.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private Object payload;
}
