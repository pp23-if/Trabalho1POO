package Model;

import java.time.LocalDateTime;

public class FranquiaDAO {

    private Franquia[] vetorFranquia = new Franquia[20];

    public FranquiaDAO(PessoaDAO pessoaDAO) 
    {
        Pessoa donoDeFranquia = pessoaDAO.buscaPessoaCadastrada("capeta", "24");
        
        if(donoDeFranquia != null)
        {
            Franquia franquia = new Franquia("Unimed", "123456789-30", "Patos de Minas",
                    "Rua Principal - Centro", donoDeFranquia, LocalDateTime.now());
            
            adicionaFranquia(franquia);
        }
    }

    public Franquia buscaFranquia(String login, String senha)
    {
        for (Franquia franquia : vetorFranquia) {
            if(franquia != null && franquia.getPessoa().getLoginPessoa().equals(login) &&
                    franquia.getPessoa().getSenhaPessoa().equals(senha))
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
