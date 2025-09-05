package com.EventXpert.EventXpert.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.EventXpert.EventXpert.Dto.AuthRequest;
import com.EventXpert.EventXpert.entity.User;
import com.EventXpert.EventXpert.repository.UserRepository;
import com.EventXpert.EventXpert.config.JwtTokenUtil;
import java.util.Collections;
@RestController
@RequestMapping("/auth")
public class AuthController {    @Autowired
private AuthenticationManager authManager;
    @Autowired private JwtTokenUtil jwtUtil;
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()));

            final UserDetails userDetails =
                    new org.springframework.security.core.userdetails.User(
                            request.getUsername(), request.getPassword(),
                            Collections.emptyList());

            final String jwt = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(Collections.singletonMap("jwt", jwt));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
