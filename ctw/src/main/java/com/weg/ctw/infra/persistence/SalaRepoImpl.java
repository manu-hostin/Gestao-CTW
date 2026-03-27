package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Sala;
import com.weg.ctw.domain.repository.ISalaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SalaRepoImpl implements ISalaRepo {

    // Injetamos a interface do JPA aqui (Composição)
    private final JpaSalaRepo jpa;

    @Override
    public Sala salvar(Sala sala) {
        return jpa.save(sala);
    }

    @Override
    public Optional<Sala> buscarPorId(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Sala> listarTodas() {
        return jpa.findAll();
    }

    @Override
    public void deletar(Integer id) {
        jpa.deleteById(id);
    }
}