package com.example.demo.usecase;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

@Component
@Log
public class ProdutoUseCase {

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> getProduto() throws InterruptedException {

        sleep(3000);
        for (int i = 0; i < 1000; i++) {
            log.info("Valor de i: " + i);
        }

        return CompletableFuture.completedFuture("Bla");
    }

}
