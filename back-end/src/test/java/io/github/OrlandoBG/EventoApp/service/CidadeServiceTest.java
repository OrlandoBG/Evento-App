package io.github.OrlandoBG.EventoApp.service;

import io.github.OrlandoBG.EventoApp.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.repository.CidadeRepository;
import io.github.OrlandoBG.EventoApp.factory.CidadeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class CidadeServiceTest {

    @InjectMocks
    private CidadeService service;

    @Mock
    private CidadeRepository repository;

    Cidade cidade;
    CidadeDTO cidadeDTO;
    List<CidadeDTO> cidadesDTO;
    List<Cidade> cidades;



    @BeforeEach
    void setUp() throws Exception{
        cidadeDTO = CidadeFactory.CriarCidadeDto();
        cidade = CidadeFactory.criarCidade();
        cidadesDTO = CidadeFactory.criarListaDeCidadesDTO();
        cidades = CidadeFactory.criarListaDeCidades();
        Mockito.when(repository.save(cidade)).thenReturn(cidade);
        Mockito.when(repository.findAll()).thenReturn(cidades);
    }

    @Test
    public void salvarDeveriaRetornarCidadeDTO(){

        CidadeDTO c = service.salvar( cidadeDTO);

        Assertions.assertEquals( cidadeDTO, c);

        Mockito.verify(repository).save(cidade);
    }

    @Test
    public void ObterTodosDeveriaRetornarListaDeTodosOsRegistros(){
        List<CidadeDTO> c = service.obterTodos();

        Assertions.assertEquals(cidadesDTO, c);

        Mockito.verify(repository).findAll();

    }

}
