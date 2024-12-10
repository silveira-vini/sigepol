package silveira.vinicius.sigepol.domain.policial;

import silveira.vinicius.sigepol.domain.dadosFuncionais.DadosFuncionais;
import silveira.vinicius.sigepol.domain.endereco.Endereco;
import silveira.vinicius.sigepol.domain.formacao.Formacao;

import java.util.Date;

public class Policial {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private Date nascimento;
    private String nomeMae;
    private String nomePai;
    private Endereco endereco;
    private DadosFuncionais dadosFuncionais;
    private Formacao formacao;
    private boolean ativo;


}
