package com.example.demo.entrypoints;

import com.example.demo.repository.UsuarioDocument;
import com.example.demo.usecase.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDocument saveUsuario(@RequestBody UsuarioDocument usuario) throws InterruptedException, ExecutionException {
        return useCase.saveUsuario(usuario);
    }

}
