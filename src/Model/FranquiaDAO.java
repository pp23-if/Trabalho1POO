package Model;

import java.time.LocalDateTime;

public class FranquiaDAO {

    private Franquia[] vetorFranquia = new Franquia[50];

    public FranquiaDAO(PessoaDAO pessoaDAO) 
    {
        Pessoa donoDeFranquia = pessoaDAO.buscaPessoaCadastrada("Edu28", "24");
        
        if(donoDeFranquia != null)
        {
            Franquia franquia = new Franquia("Unimed".toUpperCase(), "123456789-30", "Patos de Minas",
                    "Rua Principal - Centro", donoDeFranquia, LocalDateTime.now());
            
            adicionaFranquia(franquia);
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
    
    
    public boolean verificaSeFranquiaExiste(String nomeFranquia, String cnpj)
    {
        for (Franquia franquia : vetorFranquia) {
            
            if(franquia != null && franquia.getNomeFranquia().equals(nomeFranquia.toUpperCase()) ||
               franquia != null && franquia.getNomeFranquia().equals(nomeFranquia.toLowerCase()) || 
               franquia != null && franquia.getCnpj().equals(cnpj))
            {
               return true; 
            }
        }
        return false;
    }
    
   public boolean verificaDonosDeFranquia(Pessoa p)
   {
       for (Franquia franquia : vetorFranquia) {
           
           if(franquia != null && franquia.getPessoa().getCpf().equals(p.getCpf()))
           {
               return true;
           }
       }
        return false;
   }
        
}
