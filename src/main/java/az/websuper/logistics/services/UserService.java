package az.websuper.logistics.services;

import az.websuper.logistics.dtos.auth.RegisterDto;
import az.websuper.logistics.payloads.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
    ApiResponse register(RegisterDto registerDto) throws JsonProcessingException;
}
