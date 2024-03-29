package io.github.OrlandoBG.EventoApp.model.service;

import io.github.OrlandoBG.EventoApp.controller.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.repository.CidadeRepository;
import io.github.OrlandoBG.EventoApp.model.service.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    @Transactional(readOnly = true)
    public List<CidadeDTO> obterTodos() {
        List<Cidade> listaDeCidades = repository.findAll();
        return listaDeCidades.stream().map(cidade -> new CidadeDTO(cidade)).collect(Collectors.toList());
    }

    @Transactional
    public CidadeDTO salvar(CidadeDTO dto) {
        try {
            dto.setId(null);
            Cidade cidade = dtoParaCidade(dto);
            cidade = repository.save(cidade);
            return new CidadeDTO(cidade);
        }catch (DataIntegrityViolationException e){
        throw new DatabaseException("Cidade já cadastrada");
        }
    }

    public  Cidade dtoParaCidade(CidadeDTO dto){
        Cidade cidade = new Cidade();
        cidade.setId(dto.getId());
        cidade.setNome(dto.getNome());
        return cidade;
    }
}
