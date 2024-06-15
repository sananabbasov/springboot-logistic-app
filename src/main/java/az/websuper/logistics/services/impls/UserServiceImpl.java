package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.auth.RegisterDto;
import az.websuper.logistics.payloads.ApiResponse;
import az.websuper.logistics.repositories.UserRepository;
import az.websuper.logistics.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import az.websuper.logistics.models.User;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ApiResponse register(RegisterDto registerDto) throws JsonProcessingException {
        User findUser = userRepository.findByEmail(registerDto.getEmail());
        if (findUser != null)
            return new ApiResponse("User already exist",false);

        User newUser = modelMapper.map(registerDto, User.class);
        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
        newUser.setPassword(encodedPassword);
        userRepository.save(newUser);
        return new ApiResponse("User is registered",true);
    }
}
