package Model;

import java.time.LocalDateTime;

public class UnidadeFranquiaDAO {
    
    private UnidadeFranquia[] vetorUnidadeFranquia = new UnidadeFranquia[50];
    
    public UnidadeFranquiaDAO(PessoaDAO pessoaDAO, FranquiaDAO franquiaDAO) {
        Pessoa donoUnidadeFranquia = pessoaDAO.buscaPessoaCadastrada("rgd", "30");
        
        if (donoUnidadeFranquia != null) {
            Franquia franquiaCadastrada = franquiaDAO.buscaFranquiaPorCnpj("123456789-30");
            
            if (franquiaCadastrada != null) {
                UnidadeFranquia unidadeFranquia = new UnidadeFranquia(franquiaCadastrada, "Rio de Janeiro",
                        "Avenida Brasil - 580", donoUnidadeFranquia, LocalDateTime.now());
                
                adicionaUnidadeFranquia(unidadeFranquia);
            }
        }
        
    }
    
    private int proximaPosilivreUnidadeFranquia() {
        for (int i = 0; i < vetorUnidadeFranquia.length; i++) {
            if (vetorUnidadeFranquia[i] == null) {
                return i;
            }
            
        }
        return -1;
    }
    
    public boolean adicionaUnidadeFranquia(UnidadeFranquia unidadeFranquia) {
        int proxima = proximaPosilivreUnidadeFranquia();
        if (proxima != -1) {
            vetorUnidadeFranquia[proxima] = unidadeFranquia;
            return true;
        } else {
            return false;
        }
        
    }
    
    public UnidadeFranquia MostraTodasUnidadesDeFranquia() {
        for (UnidadeFranquia unidadeFranquia : vetorUnidadeFranquia) {
            
            if (unidadeFranquia != null) {
                System.out.println(unidadeFranquia + "\n");
            }
        }
        return null;
    }
    
    public UnidadeFranquia buscaUnidadeFranquiaAtravesDaPessoaVinculada(Pessoa pessoa) {
        for (UnidadeFranquia unidadeFranquia : vetorUnidadeFranquia) {
            
            if (unidadeFranquia != null && unidadeFranquia.getPessoa().equals(pessoa)) {
                return unidadeFranquia;
            }
        }
        return null;
    }
    
    public UnidadeFranquia buscaUnidadeFranquiaAtravesDaFranquiaVinculada(Franquia franquia) {
        for (UnidadeFranquia unidadeFranquia : vetorUnidadeFranquia) {
            
            if (unidadeFranquia != null && unidadeFranquia.getFranquia().equals(franquia)) {
                System.out.println(unidadeFranquia + "\n");
            }
        }
        return null;
    }
    
    public boolean verificaSeDonoUnidadeFranquiaExiste(Pessoa pessoa) {
        for (UnidadeFranquia unidadeFranquia : vetorUnidadeFranquia) {
            
            if (unidadeFranquia != null
                    && unidadeFranquia.getPessoa().getCpf().equals(pessoa.getCpf())) {
                return true;
            }
        }
        return false;
    }
    
    public UnidadeFranquia buscaUnidadeDeFranquia(UnidadeFranquia uniFran)
    {
        for (UnidadeFranquia unidadeFranquia : vetorUnidadeFranquia) {
            
            if(unidadeFranquia != null && unidadeFranquia.equals(uniFran))
            {
                return unidadeFranquia;
            }
        }
        return null;
    }
    
    
    
}
