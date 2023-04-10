package Model;

import java.time.LocalDateTime;

public class FranquiaDAO {

    private Franquia[] vetorFranquia = new Franquia[20];

    public FranquiaDAO(PessoaDAO pessoaDAO) 
    {
        Pessoa donoDeFranquia = pessoaDAO.buscaPessoaCadastrada("Edu28", "24");
        
        if(donoDeFranquia != null)
        {
            Franquia franquia = new Franquia("Unimed", "123456789-30", "Patos de Minas",
                    "Rua Principal - Centro", donoDeFranquia, LocalDateTime.now());
            
            adicionaFranquia(franquia);
        }
        
        Pessoa donoDeFranquia2 = pessoaDAO.buscaPessoaCadastrada("pp23", "lula13");
        
        if(donoDeFranquia2 != null)
        {
            Franquia franquia2 = new Franquia("Unimed", "123456789-30", "Patos de Minas",
                    "Rua Principal - Centro", donoDeFranquia2, LocalDateTime.now());
            
            adicionaFranquia(franquia2);
        }
    }

    public Franquia buscaFranquia(Franquia f)
    {
        for (Franquia franquia : vetorFranquia) {
            
            if(franquia != null && franquia.equals(f))
            {
                return franquia;
            }
        }
        return null;
    }
    
    public Franquia buscaFranquiaAtravesDaPessoaVinculada(Pessoa pessoaLogada)
    {
        for (Franquia franquia : vetorFranquia) {
            
           if(franquia != null && franquia.getPessoa().equals(pessoaLogada))
           {
               return franquia;
           }
        }
        return null;
    }
    
    
    public boolean adicionaFranquia(Franquia franquia) {
        int proxima = proximaPosilivreFranquia();
        if (proxima != -1) {
            vetorFranquia[proxima] = franquia;
            return true;
        } else {
            return false;
        }

    }

    private int proximaPosilivreFranquia() {
        for (int i = 0; i < vetorFranquia.length; i++) {
            if (vetorFranquia[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public void mostraTodasFranquias() {
        for (Franquia franquia : vetorFranquia) {

            if (franquia != null) {
                System.out.println(franquia);
            }
        }
    }
    
    
    
    
}
