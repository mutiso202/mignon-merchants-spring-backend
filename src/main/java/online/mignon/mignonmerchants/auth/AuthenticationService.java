package online.mignon.mignonmerchants.auth;


import lombok.RequiredArgsConstructor;

import online.mignon.mignonmerchants.config.JWTService;
import online.mignon.mignonmerchants.user.Role;
import online.mignon.mignonmerchants.user.User;
import online.mignon.mignonmerchants.user.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;


    private final AuthenticationProvider authenticationManager;
    public AuthenticationResponse register(RegisterRequest request)  {

        var user= User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);


        var jwtToken=jwtService.generateToken(user);


        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .credits(0.00)
                .email(request.getEmail())
                .build();


    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

         var user=repository.findByEmail(request.getEmail())
                 .orElseThrow();

        var jwtToken=jwtService.generateToken(user);


        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .email(request.getEmail())
                .build();
    }
}
