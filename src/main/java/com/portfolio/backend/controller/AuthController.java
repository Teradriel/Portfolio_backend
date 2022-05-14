package com.portfolio.backend.controller;

import com.portfolio.backend.model.Cursos;
import com.portfolio.backend.model.ERole;
import com.portfolio.backend.model.Estudios;
import com.portfolio.backend.model.Experiencias;
import com.portfolio.backend.model.Idiomas;
import com.portfolio.backend.model.Intereses;
import com.portfolio.backend.model.Mensajes;
import com.portfolio.backend.model.Role;
import com.portfolio.backend.model.Skills;
import com.portfolio.backend.model.User;
import com.portfolio.backend.model.Usuarios;
import com.portfolio.backend.payload.request.LoginRequest;
import com.portfolio.backend.payload.request.SignUpRequest;
import com.portfolio.backend.payload.response.JwtResponse;
import com.portfolio.backend.payload.response.MessageResponse;
import com.portfolio.backend.repository.CursosRepository;
import com.portfolio.backend.repository.EstudiosRepository;
import com.portfolio.backend.repository.ExperienciasRepository;
import com.portfolio.backend.repository.IdiomasRepository;
import com.portfolio.backend.repository.InteresesRepository;
import com.portfolio.backend.repository.MensajesRepository;
import com.portfolio.backend.repository.RoleRepository;
import com.portfolio.backend.repository.SkillsRepository;
import com.portfolio.backend.repository.UserRepository;
import com.portfolio.backend.repository.UsuariosRepository;
import com.portfolio.backend.security.jwt.JwtUtils;
import com.portfolio.backend.security.services.UserDetailsImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UsuariosRepository usuarioRepository;
    @Autowired
    CursosRepository cursoRepository;
    @Autowired
    EstudiosRepository estudioRepository;
    @Autowired
    ExperienciasRepository expRepository;
    @Autowired
    IdiomasRepository idiomaRepository;
    @Autowired
    InteresesRepository interesRepository;
    @Autowired
    MensajesRepository mensRepository;
    @Autowired
    SkillsRepository skillRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getNewuser())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: ¡El nombre de usuario ya está en uso!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getNewemail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: ¡El e-mail ya está en uso!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getNewuser(),
                signUpRequest.getNewemail(),
                encoder.encode(signUpRequest.getNewpassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol especificado."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol especificado."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol especificado."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol especificado."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);   
        Long id = user.getId();
        Set<Cursos> curso = new HashSet<>();
        curso.add(null);
        Set<Estudios> estudio = new HashSet<>();
        estudio.add(null);
        Set<Experiencias> exp = new HashSet<>();
        exp.add(null);
        Set<Idiomas> idioma = new HashSet<>();
        idioma.add(null);
        Set<Intereses> interes = new HashSet<>();
        interes.add(null);
        Set<Mensajes> mens = new HashSet<>();
        mens.add(null);
        Set<Skills> skill = new HashSet<>();
        skill.add(null);
        Usuarios usuarioN = new Usuarios(id, "", "", "", "", "", "", "", "", "", "", "", null, null, null, null, null, null, null, null);
        usuarioN.setUser(user);
        usuarioN.setCurso(curso);
        usuarioN.setEstudio(estudio);
        usuarioN.setExp(exp);
        usuarioN.setIdioma(idioma);
        usuarioN.setInteres(interes);
        usuarioN.setMens(mens);
        usuarioN.setSkill(skill);
        userRepository.save(user);
//        usuarioRepository.save(usuarioN);
        cursoRepository.saveAll(curso);
        estudioRepository.saveAll(estudio);
        expRepository.saveAll(exp);
        idiomaRepository.saveAll(idioma);
        interesRepository.saveAll(interes);
        mensRepository.saveAll(mens);
        skillRepository.saveAll(skill);
        return ResponseEntity.ok(new MessageResponse("¡Usuario creado correctamente!"));
    }

}
