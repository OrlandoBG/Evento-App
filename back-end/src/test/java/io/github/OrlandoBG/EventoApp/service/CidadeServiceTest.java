package io.github.OrlandoBG.EventoApp.service;

import io.github.OrlandoBG.EventoApp.controller.dto.CidadeDTO;
import io.github.OrlandoBG.EventoApp.model.entity.Cidade;
import io.github.OrlandoBG.EventoApp.model.repository.CidadeRepository;
import io.github.OrlandoBG.EventoApp.factory.CidadeFactory;
import io.github.OrlandoBG.EventoApp.model.service.CidadeService;
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

    private Cidade cidade;
    private Cidade cidadeSemId;
    private CidadeDTO cidadeDTO;
    private CidadeDTO cidadeDTOResposta;
    private List<CidadeDTO> cidadesDTO;
    private List<Cidade> cidades;



    @BeforeEach
    void setUp() throws Exception{
        cidadeDTO = CidadeFactory.CriarCidadeDto();
        cidadeDTOResposta = CidadeFactory.CriarCidadeDto();
        cidadeSemId = CidadeFactory.criarCidadeSemId();
        cidade = CidadeFactory.criarCidade();
        cidadesDTO = CidadeFactory.criarListaDeCidadesDTO();
        cidades = CidadeFactory.criarListaDeCidades();
        Mockito.when(repository.save(cidadeSemId)).thenReturn(cidade);
        Mockito.when(repository.findAll()).thenReturn(cidades);
    }

    @Test
    public void salvarDeveriaRetornarCidadeDTO(){

        CidadeDTO dto = service.salvar(cidadeDTO);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(cidadeDTOResposta, dto);

        Mockito.verify(repository).save(cidadeSemId);
    }

    @Test
    public void ObterTodosDeveriaRetornarListaDeTodosOsRegistros(){
        List<CidadeDTO> dto = service.obterTodos();

        Assertions.assertEquals(cidadesDTO, dto);

        Mockito.verify(repository).findAll();

    }

}
