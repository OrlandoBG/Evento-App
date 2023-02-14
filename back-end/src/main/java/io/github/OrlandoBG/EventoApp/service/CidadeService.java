package io.github.OrlandoBG.EventoApp.service;

import io.github.OrlandoBG.EventoApp.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    @Transactional(readOnly = true)
    public List<Cidade> findAll() {
        return repository.findAll();
    }

    @Transactional
    public CidadeDTO salvar(CidadeDTO dto) {
        Cidade cidade = dtoParaCidade(dto);
        repository.save(cidade);
        return new CidadeDTO(cidade);
    }

    public  Cidade dtoParaCidade(CidadeDTO dto){
        Cidade cidade = new Cidade();
        cidade.setId(dto.getId());
        cidade.setNome(dto.getNome());
        return cidade;
    }
}
