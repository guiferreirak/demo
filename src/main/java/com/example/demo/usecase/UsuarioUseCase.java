package com.example.demo.usecase;

import com.example.demo.repository.UsuarioDocument;
import com.example.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Log
public class UsuarioUseCase {

    private final UsuarioRepository repository;
    private final ProdutoUseCase produtoUseCase;

    public UsuarioDocument saveUsuario(UsuarioDocument usuario) throws InterruptedException, ExecutionException {

        usuario.setId(UUID.randomUUID().toString());
        UsuarioDocument usuarioDocument = repository.save(usuario);

        CompletableFuture<String> s = produtoUseCase.getProduto();

        if (!s.isDone()) {
            log.info("NÃO TERMINOU AINDA, RETORNANDO USUARIO");
            return usuarioDocument;
        }

        log.info("TERMINOU, RETORNANDO USUARIO");
        return usuarioDocument;

    }

}
